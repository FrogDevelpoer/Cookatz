package cookatz.mall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cookatz.common.dao.SuperDao;
import cookatz.employee.bean.Employee;
import cookatz.mall.cart.CocazShoppingInfo;
import cookatz.product.bean.Product;
import cookatz.product.dao.ProductDao;

public class MallDao extends SuperDao {

	
	public List<CocazShoppingInfo> SelectAll(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select * from cocazshoppinginfos ";
		
		List<CocazShoppingInfo> lists = new ArrayList<CocazShoppingInfo>();
		
		try {
			conn = super.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CocazShoppingInfo bean = new CocazShoppingInfo();
				
				bean.setImg(rs.getString("img"));
				bean.setPname(rs.getString("pname"));
				bean.setPnum(rs.getInt("pnum"));
				bean.setPrice(rs.getInt("price"));
				bean.setQty(rs.getInt("qty"));
				
				bean.setEid(rs.getString("eid"));
				bean.setInputdate(rs.getString("inputdate"));
			
				lists.add(bean);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {pstmt.close();}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		return lists;
	}

	
	public List<CocazShoppingInfo> GetCocazShoppingInfo(String id) {
		// 로그인한 사람(id)의 이전 wishlist를 조회합니다.
		
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select * from cocazshoppinginfos " ;
		sql += " where eid = ? " ;  
		
		List<CocazShoppingInfo> lists = new ArrayList<CocazShoppingInfo>() ;
		
		try {			
			conn = super.getConnection() ;
			pstmt = conn.prepareStatement(sql) ;
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();				
			
			// while 구문을 사용하여 데이터 넣어 주기
			while(rs.next()) {
				CocazShoppingInfo bean = new CocazShoppingInfo(); 
				
				bean.setPnum(rs.getInt("pnum"));
				bean.setPname(rs.getString("pname"));
				bean.setQty(rs.getInt("qty"));
				bean.setPrice(rs.getInt("price"));
				bean.setImg(rs.getString("img"));
				
				lists.add(bean) ;
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lists;		
	}
	
	public void InsertCartData(Employee loginfo, Map<Integer, Integer> wishlist) {
		// 로그인 한 사람(loginfo)의 장바구니 찜 리스트(wishlist)를 임시 테이블(shoppinginfos)에 저장합니다.		
		
		Connection conn = null ;
		PreparedStatement pstmt = null ; 
		int cnt = -999 ; 
		
		String sql = "";
		
		try {
			conn = super.getConnection() ;
			conn.setAutoCommit(false);
			
			// 혹시 모를 이전 데이터는 삭제됩니다.
			sql = " delete from cocazshoppinginfos ";
			sql += " where eid = ? ";
			
			pstmt = conn.prepareStatement(sql) ;
			
			pstmt.setString(1, loginfo.getId());
			
			cnt = pstmt.executeUpdate() ;
			
			// 세션 영역의 wishlist 목록을 반복하여 인서트 합니다.
			
			sql = " insert into cocazshoppinginfos(eid, pnum, pname, qty, price, img, inputdate) " ;
			sql += " values(?, ?, ?, ?, ?, ?, default)" ;
			
			Set<Integer> keylist = wishlist.keySet();
			
			ProductDao pdao = new ProductDao();
			
			for(Integer pnum : keylist) {
				pstmt = conn.prepareStatement(sql) ; 
				
				Product bean = pdao.SelectOne(pnum);
				
				pstmt.setString(1, loginfo.getId());
				pstmt.setInt(2, pnum);
				pstmt.setString(3, bean.getName());
				pstmt.setInt(4, wishlist.get(pnum));
				pstmt.setInt(5, bean.getPrice());
				pstmt.setString(6, bean.getImg());
				
				cnt = pstmt.executeUpdate() ;
				if(pstmt != null) {pstmt.close();}
			}
			
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
						
		} finally {
			try {
				if(pstmt != null){pstmt.close();}
				if(conn != null){conn.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void Calculate(Employee bean, Map<Integer, Integer> itemlist) {
		// 회원과 카트 정보를 이용하여 계산을 수행합니다.
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		int cnt = -999;

		try {
			conn = super.getConnection();
			conn.setAutoCommit(false);
			// step 01 : orders table into insert data
			sql = " insert into orders(oid, mid, orderdate)";
			sql += " values(seqodid.nextval, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getId());
			cnt = pstmt.executeUpdate();
			if (pstmt != null) {
				pstmt.close();
			}

			// step 02 : get max invoice number from orders table
			int maxinvoice = -999; // 방금 추가된 송장 번호
			sql = " select max(oid) as invoice from orders ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				maxinvoice = rs.getInt("invoice");
			}
			System.out.println("방금 추가된 송장 번호 : " + maxinvoice);
			if (pstmt != null) {
				pstmt.close();
			}

			Set<Integer> keylist = itemlist.keySet();
			System.out.println("shopping item size : " + keylist.size());

			// 다음 구문은 상품별 적립 포인트를 가져 오기 위한 dao 객체입니다.
			ProductDao pdao = new ProductDao();

			// for statement
			for (Integer onum : keylist) {
				// step 03 : orderdetails table into insert data
				sql = " insert into orderdetails(odid, oid,  onum, qty )";
				sql += " values(seqordid.nextval, ?, ?, ?)";
				pstmt = conn.prepareStatement(sql);

				int qty = itemlist.get(onum); 
				pstmt.setInt(1, maxinvoice);
				pstmt.setInt(2, onum); 
				pstmt.setInt(3, qty);
				
				
				cnt = pstmt.executeUpdate();
				if (pstmt != null) {
					pstmt.close();
				}

				// step 04 : decreasing product stock
				sql = " update products set stock = stock - ? ";
				sql += " where num = ? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, qty);
				pstmt.setInt(2, onum);
				cnt = pstmt.executeUpdate();
				if (pstmt != null) {
					pstmt.close();
				}
				
			
			}

			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}

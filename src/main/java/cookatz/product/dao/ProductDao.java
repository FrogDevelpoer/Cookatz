package cookatz.product.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cookatz.common.dao.SuperDao;
import cookatz.product.bean.Product;


public class ProductDao extends SuperDao {
	public ProductDao() {

	}
	public List<Product> SelectAll(String str1) {
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select * from products " ;
		sql += " where category = ? " ; 
		sql += " order by num asc " ; 
		
		List<Product> lists = new ArrayList<Product>() ;
		
		try {			
			conn = super.getConnection() ;
			pstmt = conn.prepareStatement(sql) ;
			
			pstmt.setString(1, str1);
			
			rs = pstmt.executeQuery();				
			
			// while 구문을 사용하여 데이터 넣어 주기
			while(rs.next()) {
			   Product bean = new Product(); 
				
			    bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setCategory(rs.getString("category"));
				bean.setPrice(rs.getInt("price"));
				bean.setContent(rs.getString("content"));
				bean.setImg(rs.getString("img"));
				bean.setStock(rs.getInt("stock"));
				bean.setPdate(String.valueOf(rs.getDate("pdate")));
				bean.setRemark(rs.getString("remark"));
				
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

	public int UpdateData(Product bean) {
		// 특정 회원에 대한 정보를 수정합니다.
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = " update products set " ;
		sql += " name=?, category=?, price=?, content=?, img=?, stock=?, pdate=?, remark=? " ;
		sql += " where num = ? ";

		int cnt = -999;

		try {
			conn = super.getConnection();
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getCategory());
			pstmt.setInt(3, bean.getPrice());
			pstmt.setString(4, bean.getContent());
			pstmt.setString(5, bean.getImg());
			pstmt.setInt(6, bean.getStock());
			pstmt.setString(7, bean.getPdate());
			pstmt.setString(8, bean.getRemark());
			pstmt.setInt(9, bean.getNum());
			
			cnt = pstmt.executeUpdate();

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
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

	public int InsertData(Product bean) {
		System.out.println(bean);

		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = -999;

		String sql = " insert into products(num, name, category, price, content, img, stock, pdate) ";
		sql += " values(seqpd.nextval, ?, ?, ?, ?, ?, ?, sysdate) ";

		try {
			conn = super.getConnection();
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getCategory());
			pstmt.setInt(3, bean.getPrice());
			pstmt.setString(4, bean.getContent());
			pstmt.setString(5, bean.getImg());
			pstmt.setInt(6, bean.getStock());

			cnt = pstmt.executeUpdate();

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
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return cnt;
	}

	public int DeleteData(int num) {
		/*
		 * 상품이 제거되는 경우 해야 할 일 1. 주문 상세 테이블의 remark 컬럼 업데이트 2. 상품 테이블에 해당 행을 삭제
		 * 
		 */
		Connection conn = null;
		PreparedStatement pstmt = null;

		int cnt = -999;

		try {
			conn = super.getConnection();
			conn.setAutoCommit(false);

			String sql = "" ;

			Product bean = this.SelectOne(num);

			String imsi = "상품 " + bean.getName() + "(" + num + ")은(는) 판매 중지되었습니다.";
			// 1. 주문 상세 테이블의 remark 컬럼 업데이트
			sql = " update orderdetails set remark = ? ";
			sql += " where pnum = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, imsi);
			pstmt.setInt(2, num);
			cnt = pstmt.executeUpdate();
			System.out.println("table1" );
			if (pstmt != null) {pstmt.close();}

			// 2. 상품 테이블에 해당 행을 삭제
			sql = " delete from products where num = ? ";
				
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			cnt = pstmt.executeUpdate();
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
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

	public Product SelectOne(int num) {
		// 1건의 데이터를 조회합니다.
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " select * from products where num = ? ";

		Product bean = null;

		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean = new Product();

				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setCategory(rs.getString("category"));
				bean.setPrice(rs.getInt("price"));
				bean.setContent(rs.getString("content"));
				bean.setImg(rs.getString("img"));
				bean.setStock(rs.getInt("stock"));
				bean.setPdate(String.valueOf(rs.getDate("pdate")));
				bean.setRemark(rs.getString("remark"));

			}
		} catch (Exception e) {
			e.printStackTrace();
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

		return bean;
	}

	public List<Product> SelectAll2() {
		// 회원 전체 목록을 반환해 줍니다.
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select * from Products  " ;
		
		List<Product> lists = new ArrayList<Product>() ;
		
		try {
			Class.forName(driver) ;
			conn = DriverManager.getConnection(url, id, password) ;
			pstmt = conn.prepareStatement(sql) ;
					
			rs = pstmt.executeQuery();				
			
			// while 구문을 사용하여 데이터 넣어 주기
			while(rs.next()) {
				Product bean = new Product(); // 100번지	
		
			    bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setCategory(rs.getString("category"));
				bean.setPrice(rs.getInt("price"));
				bean.setContent(rs.getString("content"));
				bean.setImg(rs.getString("img"));
				bean.setStock(rs.getInt("stock"));
				bean.setPdate(String.valueOf(rs.getDate("pdate")));
				bean.setRemark(rs.getString("remark"));
			
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

}
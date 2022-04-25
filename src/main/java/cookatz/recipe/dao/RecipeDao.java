package cookatz.recipe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cookatz.common.dao.SuperDao;
import cookatz.recipe.bean.Recipe;

public class RecipeDao extends SuperDao{
	public RecipeDao() {
		
	}
	
	public List<Recipe> SelectAll(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select * from regi_recipe ";
		sql += " order by seq desc";
		
		List<Recipe> lists = new ArrayList<Recipe>();
		
		try {
			conn = super.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Recipe bean = new Recipe();
				bean.setCategory(rs.getString("category"));
				bean.setCook_Info(rs.getString("cook_info"));
				bean.setDifficulty(rs.getString("difficulty"));
				bean.setMain_photo(rs.getString("main_photo"));
				bean.setMaterial1(rs.getString("material1"));
				bean.setMaterial1_1(rs.getString("material1_1"));
				bean.setMaterial2(rs.getString("material2"));
				bean.setMaterial2_1(rs.getString("material2_1"));
				bean.setMaterial3(rs.getString("material3"));
				bean.setMaterial3_1(rs.getString("material3_1"));
				bean.setRecipe_title(rs.getString("recipe_title"));
				bean.setSeq(rs.getInt("seq"));
				bean.setWrite_date(String.valueOf(rs.getDate("write_date")));
				bean.setWriter_id(rs.getString("writer_id"));
				bean.setWriter_name(rs.getString("writer_name"));
				bean.setCategory(rs.getString("category"));
				bean.setRemark(rs.getString("remark"));
				
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

	public int InsertData(Recipe bean) {
		System.out.println(bean);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = -999;
		
		String sql = " insert into regi_recipe(seq, writer_id, writer_name, recipe_title, cook_info, write_date, cook_step, main_photo, category, difficulty, material1, material1_1, material2, material2_1, material3, material3_1, remark)";
		sql +=  " values(reginum.nextval, ?, ?, ?, ?, sysdate, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, null)";
		
		try {
			conn = super.getConnection();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bean.getWriter_id());
			pstmt.setString(2, bean.getWriter_name());
			pstmt.setString(3, bean.getRecipe_title());
			pstmt.setString(4, bean.getCook_Info());
			pstmt.setString(5, bean.getCook_step());
			pstmt.setString(6, bean.getMain_photo());
			pstmt.setString(7, bean.getCategory());
			pstmt.setString(8, bean.getDifficulty());
			pstmt.setString(9, bean.getMaterial1());
			pstmt.setString(10, bean.getMaterial1_1());
			pstmt.setString(11, bean.getMaterial2());
			pstmt.setString(12, bean.getMaterial2_1());
			pstmt.setString(13, bean.getMaterial3());
			pstmt.setString(14, bean.getMaterial3_1());
			
			
			cnt = pstmt.executeUpdate();
			
			conn.commit();
		}catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt;
	}
	public int UpdateData(Recipe bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = " update regi_recipe set ";
		sql += " recipe_title=?, cook_info=?, main_photo=?, category=?, difficulty=?, material1=?, material1_1=?, material2=?, material2_1=?, material3=?, material3_1=?, cook_step=?, remark=?";
		sql += " where seq = ? ";
		
		int cnt = -999;
		
		try {
			conn = super.getConnection();
			conn.setAutoCommit(false);
			
			
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bean.getRecipe_title());
			pstmt.setString(2, bean.getCook_Info());
			pstmt.setString(3, bean.getMain_photo());
			pstmt.setString(4, bean.getCategory());
			pstmt.setString(5, bean.getDifficulty());
			pstmt.setString(6, bean.getMaterial1());
			pstmt.setString(7, bean.getMaterial1_1());
			pstmt.setString(8, bean.getMaterial2());
			pstmt.setString(9, bean.getMaterial2_1());
			pstmt.setString(10, bean.getMaterial3());
			pstmt.setString(11, bean.getMaterial3_1());
			pstmt.setString(12, bean.getCook_step());
			pstmt.setString(13, bean.getRemark());
			pstmt.setInt(14, bean.getSeq());
			
			cnt = pstmt.executeUpdate();
			
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt;
		
	}
	public Recipe SelectOne(int seq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " select * from regi_recipe where seq = ? ";
		
		Recipe bean = null;
		
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, seq);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bean = new Recipe();
				
				bean.setCategory(rs.getString("category"));
				bean.setCook_Info(rs.getString("cook_info"));
				bean.setCook_step(rs.getString("cook_step"));
				bean.setDifficulty(rs.getString("difficulty"));
				bean.setMain_photo(rs.getString("main_photo"));
				bean.setMaterial1(rs.getString("material1"));
				bean.setMaterial1_1(rs.getString("material1_1"));
				bean.setMaterial2(rs.getString("material2"));
				bean.setMaterial2_1(rs.getString("material2_1"));
				bean.setMaterial3(rs.getString("material3"));
				bean.setMaterial3_1(rs.getString("material3_1"));
				bean.setRecipe_title(rs.getString("recipe_title"));
				bean.setWrite_date(String.valueOf(rs.getString("write_date")));
				bean.setWriter_id(rs.getString("writer_id"));
				bean.setWriter_name(rs.getString("writer_name"));
				bean.setSeq(rs.getInt("seq"));
				bean.setRemark(rs.getString("remark"));
				
			}
		} catch (SQLException e) {
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
		return bean;
	}
	public int DeleteData(int seq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int cnt = -999;
		
		try {
			conn = super.getConnection();
			conn.setAutoCommit(false);
			
			String sql = " delete from regi_recipe where seq = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			cnt = pstmt.executeUpdate();
			
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt;
	}
	
	public List<Recipe> PagingInfo(int beginRow, int endRow, String mode, String keyword){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Recipe> lists = new ArrayList<Recipe>();
		
		String sql = " select seq, writer_id, writer_name, recipe_title, cook_info, write_date, cook_step, main_photo, category, difficulty, material1, material1_1, material2, material2_1, material3, material3_1, remark ";
		sql += " from (";
		sql += " select rank() over(order by seq desc) as ranking, seq, writer_id, writer_name, recipe_title, cook_info, write_date, cook_step, main_photo, category, difficulty, material1, material1_1, material2, material2_1, material3, material3_1, remark  ";
		sql += " from regi_recipe";
		
		if(mode.equals("all") == false){
			sql += " where " + mode + " like '%" + keyword + "%' " ;
		}
		
		sql += " )";
		sql += " where ranking between ? and ?" ; 
		
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, beginRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Recipe bean = new Recipe();
				
				bean.setCategory(rs.getString("category"));
				bean.setCook_Info(rs.getString("cook_info"));
				bean.setCook_step(rs.getString("cook_step"));
				bean.setDifficulty(rs.getString("difficulty"));
				bean.setDifficulty(rs.getString("main_photo"));
				bean.setMaterial1(rs.getString("material1"));
				bean.setMaterial1_1(rs.getString("material1_1"));
				bean.setMaterial2(rs.getString("material2"));
				bean.setMaterial2_1(rs.getString("material2_1"));
				bean.setMaterial3(rs.getString("material3"));
				bean.setMaterial3_1(rs.getString("material3_1"));
				bean.setRecipe_title(rs.getString("recipe_title"));
				bean.setWrite_date(String.valueOf(rs.getString("write_date")));
				bean.setWriter_id(rs.getString("writer_id"));
				bean.setWriter_name(rs.getString("writer_name"));
				bean.setSeq(rs.getInt("seq"));
				bean.setRemark(rs.getString("remark"));
				
				lists.add(bean);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return lists;
		
	}
	
	public int GetTotalCount(String mode, String keyword) {
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		String sql = " select count(*) as cnt from regi_recipe " ; 
		
		if(mode.equals("all") == false) {
			sql += " where " + mode + " like '%" + keyword + "%'";
		}
		System.out.println(this.getClass() + " : " + sql);
		
		int cnt = -999 ; // 조회된 데이터 건수
		
		try {
			conn = this.getConnection() ;
			pstmt = conn.prepareStatement(sql) ;
			
			rs = pstmt.executeQuery() ;
			
			if (rs.next()) {
				cnt = rs.getInt("cnt") ;
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
		
		return cnt ;
	}

	public List<Recipe> SelectAll2() {
		// 회원 전체 목록을 반환해 줍니다.
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select * from REGI_RECIPE  " ;
		
		List<Recipe> lists = new ArrayList<Recipe>() ;
		
		try {
			Class.forName(driver) ;
			conn = DriverManager.getConnection(url, id, password) ;
			pstmt = conn.prepareStatement(sql) ;
					
			rs = pstmt.executeQuery();				
			
			// while 구문을 사용하여 데이터 넣어 주기
			while(rs.next()) {
				Recipe bean = new Recipe(); // 100번지	
		
				bean.setCategory(rs.getString("category"));
				bean.setCook_Info(rs.getString("cook_info"));
				bean.setDifficulty(rs.getString("difficulty"));
				bean.setMain_photo(rs.getString("main_photo"));
				bean.setMaterial1(rs.getString("material1"));
				bean.setMaterial1_1(rs.getString("material1_1"));
				bean.setMaterial2(rs.getString("material2"));
				bean.setMaterial2_1(rs.getString("material2_1"));
				bean.setMaterial3(rs.getString("material3"));
				bean.setMaterial3_1(rs.getString("material3_1"));
				bean.setRecipe_title(rs.getString("recipe_title"));
				bean.setSeq(rs.getInt("seq"));
				bean.setWrite_date(String.valueOf(rs.getDate("write_date")));
				bean.setWriter_id(rs.getString("writer_id"));
				bean.setWriter_name(rs.getString("writer_name"));
				bean.setCategory(rs.getString("category"));
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

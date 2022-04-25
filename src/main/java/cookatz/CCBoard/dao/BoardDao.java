package cookatz.CCBoard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cookatz.CCBoard.bean.Board;
import cookatz.common.dao.SuperDao;

public class BoardDao extends SuperDao{	
	public BoardDao() {
		
	}
	
	public List<Board> SelectAll() {
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select * from CookingClassBoards " ;
		sql += " order by bo_no desc " ; // 최근 게시물이 위로 오도록 ...
		
		List<Board> lists = new ArrayList<Board>() ;
		
		try {			
			conn = super.getConnection() ;
			pstmt = conn.prepareStatement(sql) ;
					
			rs = pstmt.executeQuery();				
			
			// while 구문을 사용하여 데이터 넣어 주기
			while(rs.next()) {
				Board bean = new Board(); 
				
				bean.setBo_category(rs.getString("bo_category"));
				bean.setBo_no(rs.getInt("bo_no"));
				bean.setBoard_comment(rs.getString("board_comment"));
				bean.setLikenum(rs.getInt("likenum"));
				bean.setReadhit(rs.getInt("readhit"));
				bean.setRegdate(rs.getString("regdate"));
				bean.setRemark(rs.getString("remark"));
				bean.setTitle(rs.getString("title"));
				bean.setVideo_upload(rs.getString("video_upload"));
				bean.setWriter(rs.getString("writer"));
				
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
	
	
	public int UpdateData(Board bean) {
		// 특정 회원에 대한 정보를 수정합니다.
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		
		String sql = " update CookingClassBoards set " ;
		sql += " writer=?, bo_category=?, title=?, video_upload=?, board_comment=?" ;
		sql += " where bo_no = ? " ;
		
		int cnt = -999 ; 
		
		try {
			conn = super.getConnection() ;
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql) ;
			
			pstmt.setString(1, bean.getWriter());
			pstmt.setString(2, bean.getBo_category());
			pstmt.setString(3, bean.getTitle());
			pstmt.setString(4, bean.getVideo_upload());
			pstmt.setString(5, bean.getBoard_comment());
			pstmt.setInt(6, bean.getBo_no());
			
			cnt = pstmt.executeUpdate() ; 
			
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
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt ;
	}
	
	public int InsertData(Board bean) {
		System.out.println(bean) ;		
		
		Connection conn = null ;
		PreparedStatement pstmt = null ; 
		int cnt = -999 ; 

		String sql = " insert into CookingClassBoards(bo_no, writer, bo_category, regdate, title, video_upload, board_comment, readhit, likenum, remark) " ;
		sql += " values(seqboard_no.nextval, ?, ?, default, ?, ?, ?, default, default, null)" ; 
		
		try {
			conn = super.getConnection() ;
			conn.setAutoCommit(false);  
			
			pstmt = conn.prepareStatement(sql) ; 
			
			pstmt.setString(1, bean.getWriter());
			pstmt.setString(2, bean.getBo_category());
			pstmt.setString(3, bean.getTitle());
			pstmt.setString(4, bean.getVideo_upload());
			pstmt.setString(5, bean.getBoard_comment());
			
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
				if(pstmt != null){pstmt.close();}
				if(conn != null){conn.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return cnt  ;
	}

	public int DeleteData(int bo_no) {
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		String sql = " delete from CookingClassBoards where bo_no = ?" ;

		int cnt = -999 ; 
		
		try {
			conn = super.getConnection() ;
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql) ;
			
			pstmt.setInt(1, bo_no);
			
			cnt = pstmt.executeUpdate() ;
			
			
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
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt ;
	}


	public Board SelectOne(int bo_no) {
		// 1건의 데이터를 조회합니다.
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		String sql = " select * from CookingClassBoards where bo_no = ? " ; 
		
		Board bean = null ; 
		
		try {
			conn = this.getConnection() ;
			pstmt = conn.prepareStatement(sql) ;
			
			pstmt.setInt(1, bo_no); 
			
			rs = pstmt.executeQuery() ;
			
			if (rs.next()) {
				bean = new Board();
				
				bean.setBo_category(rs.getString("bo_category"));
				bean.setBo_no(rs.getInt("bo_no"));
				bean.setBoard_comment(rs.getString("board_comment"));
				bean.setLikenum(rs.getInt("likenum"));
				bean.setReadhit(rs.getInt("readhit"));
				bean.setRegdate(String.valueOf(rs.getDate("regdate")));
				bean.setRemark(rs.getString("remark"));
				bean.setTitle(rs.getString("title"));
				bean.setVideo_upload(rs.getString("video_upload"));
				bean.setWriter(rs.getString("writer"));
				
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
		
		return bean;
	}

	public List<Board> PagingInfo(int beginRow, int endRow, String mode, String keyword) {
		// 페이징 처리 결과를 리턴합니다.
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		List<Board> lists = new ArrayList<Board>() ;
		
		String sql = " select bo_no, writer, bo_category, regdate, title, video_upload, board_comment, readhit, likenum, remark";
		sql += " from (";
		sql += " select rank() over(order by bo_no desc) as ranking, bo_no, writer, bo_category, regdate, title, video_upload, board_comment, readhit, likenum, remark ";
		sql += " from CookingClassBoards";
		
		if(mode.equals("all") == false){
			sql += " where " + mode + " like '%" + keyword + "%' " ;
		}
		
		sql += " )";
		sql += " where ranking between ? and ?" ; 
		
		try {
			conn = this.getConnection() ; 
			pstmt = conn.prepareStatement(sql) ;
			
			pstmt.setInt(1, beginRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery() ;
			
			while (rs.next()) {
				Board bean = new Board();
				
				
				bean.setBo_category(rs.getString("bo_category"));
				bean.setBo_no(rs.getInt("bo_no"));
				bean.setBoard_comment(rs.getString("board_comment"));
				bean.setLikenum(rs.getInt("likenum"));
				bean.setReadhit(rs.getInt("readhit"));
				bean.setRegdate(String.valueOf(rs.getDate("regdate")));
				bean.setRemark(rs.getString("remark"));
				bean.setTitle(rs.getString("title"));
				bean.setVideo_upload(rs.getString("video_upload"));
				bean.setWriter(rs.getString("writer"));
				
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
		
		return lists ;
	}

	public int GetTotalCount(String mode, String keyword) {

		Connection conn = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		String sql = " select count(*) as cnt from CookingClassBoards " ; 
		
		
		if (mode.equals("all") == false) {
			sql += " where " + mode + " like '%" + keyword + "%' " ;
		}
		System.out.println(this.getClass() + " : " + sql );
		
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

	public List<Board> SelectAll2() {
		// 회원 전체 목록을 반환해 줍니다.
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select * from CookingClassBoards  " ;
		
		List<Board> lists = new ArrayList<Board>() ;
		
		try {
			Class.forName(driver) ;
			conn = DriverManager.getConnection(url, id, password) ;
			pstmt = conn.prepareStatement(sql) ;
					
			rs = pstmt.executeQuery();				
			
			// while 구문을 사용하여 데이터 넣어 주기
			while(rs.next()) {
				Board bean = new Board(); // 100번지	
		
				bean.setBo_category(rs.getString("bo_category"));
				bean.setBo_no(rs.getInt("bo_no"));
				bean.setBoard_comment(rs.getString("board_comment"));
				bean.setLikenum(rs.getInt("likenum"));
				bean.setReadhit(rs.getInt("readhit"));
				bean.setRegdate(rs.getString("regdate"));
				bean.setRemark(rs.getString("remark"));
				bean.setTitle(rs.getString("title"));
				bean.setVideo_upload(rs.getString("video_upload"));
				bean.setWriter(rs.getString("writer"));
			
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
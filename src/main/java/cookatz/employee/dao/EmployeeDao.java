package cookatz.employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cookatz.employee.bean.Employee;



/*
DAO(Data Access Object)
데이터 베이스와 연동하여 sql 작업을 수행해주는 대행자 클래스
통상적으로 단위 업무는 메소드 단위로 처리합니다.
*/
public class EmployeeDao {
	String driver = "oracle.jdbc.driver.OracleDriver" ;
	String url = "jdbc:oracle:thin:@localhost:1521:xe" ;
	String id = "cookatz" ;
	String password = "cookatz" ;
	
	public EmployeeDao() {
		try {
			Class.forName(driver) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Connection getConnection() {
		Connection conn = null ;
		try {
			conn = DriverManager.getConnection(url, id, password) ;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn ;
	}
	
	public List<Employee> SelectAll() {
		// 회원 전체 목록을 반환해 줍니다.
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select * from employees " ;
		
		List<Employee> lists = new ArrayList<Employee>() ;
		
		try {
			Class.forName(driver) ;
			conn = DriverManager.getConnection(url, id, password) ;
			pstmt = conn.prepareStatement(sql) ;
					
			rs = pstmt.executeQuery();				
			
			// while 구문을 사용하여 데이터 넣어 주기
			while(rs.next()) {
				Employee bean = new Employee(); // 100번지	
				
				bean.setZipcode(rs.getInt("zipcode"));
				bean.setAddress2(rs.getString("address2"));	
				bean.setAddress1(rs.getString("address1"));			
				bean.setGender(rs.getString("gender"));
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setEmail(rs.getString("email"));
				bean.setPhone(rs.getString("phone"));
				
				bean.setMpoint(rs.getInt("mpoint"));
				// 날짜 형식은 다음과 같이 처리하도록 합니다.
				bean.setBirth1(rs.getString("birth1"));
				bean.setBirth2(rs.getString("birth2"));
				bean.setBirth3(rs.getString("birth3"));
				//bean.setBirth(String.valueOf(rs.getDate("birth")));
				
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
	
	
	public int UpdateData(Employee bean) {
		// 특정 회원에 대한 정보를 수정합니다.
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		
		String sql = " update employees set " ;
		sql += " name=?, password=?, gender=?, birth1=? , birth2=? , birth3=?, phone=?, email=?, mpoint=?, zipcode=?, address1=? ,address2=? " ;
		sql += " where id = ? " ;
		
		int cnt = -999 ; 
		
		try {
			Class.forName(driver) ;
			conn = DriverManager.getConnection(url, this.id, password) ;
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql) ;
			
			pstmt.setString(1, bean.getName()) ;
			pstmt.setString(2, bean.getPassword()) ;
			pstmt.setString(3, bean.getGender()) ;
			pstmt.setString(4, bean.getBirth1()) ;
			pstmt.setString(5, bean.getBirth2()) ;
			pstmt.setString(6, bean.getBirth3()) ;
			pstmt.setString(7, bean.getPhone()) ;
			pstmt.setString(8, bean.getEmail()) ;
			pstmt.setInt(9, bean.getMpoint()) ;
			
			pstmt.setInt(10, bean.getZipcode());
			pstmt.setString(11, bean.getAddress1()) ;
			pstmt.setString(12, bean.getAddress2()) ;
			
			pstmt.setString(13, bean.getId()) ; 			
			
			
			//System.out.println("beab????"+bean);
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
	
	
	public int InsertData(Employee bean) {
		// 회원 1명을 추가합니다.
		System.out.println(bean) ;		
		
		Connection conn = null ;
		PreparedStatement pstmt = null ; 
		int cnt = -999 ; 

		// Statememt
		String sql = " insert into employees(id, password, name, birth1, birth2, birth3, gender, phone, email, zipcode, address1, address2, mpoint) " ;
		sql += " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)  " ; 
		
		try {
			Class.forName(driver) ;

			conn = DriverManager.getConnection(url, id, password) ;
			conn.setAutoCommit(false); // 트랜잭션 기능 잠시 off
			
//			if (conn != null) {
//				System.out.println("접속 성공") ;
//			} else {
//				System.out.println("접속 실패") ;
//			}
			
			pstmt = conn.prepareStatement(sql) ; 
			
			// id, salary, manager, address, name, password, gender, birth, marriage) 
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getPassword());
			pstmt.setString(3, bean.getName());
			pstmt.setString(4, bean.getBirth1());
			pstmt.setString(5, bean.getBirth2());
			pstmt.setString(6, bean.getBirth3());
			pstmt.setString(7, bean.getGender());
			pstmt.setString(8, bean.getPhone());
			pstmt.setString(9, bean.getEmail());
			pstmt.setInt(10, bean.getZipcode());
			pstmt.setString(11, bean.getAddress1()) ;
			pstmt.setString(12, bean.getAddress2()) ;
			pstmt.setInt(13, bean.getMpoint());
			
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
				if(pstmt != null){pstmt.close();}
				if(conn != null){conn.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return cnt  ;
	}

	public int DeleteData(String id) {
		/*
		  	회원 탈퇴시 처리해야 할 일
		  	1. 게시물에 remark 컬럼 업데이트 
		  	2. 주문 테이블에 remark 컬럼 업데이트
		  	3. 회원 테이블에 해당 행을 삭제 
		  
		 */
		
		
		
		// 기본 키를 사용하여 회원을 목록에서 삭제합니다.
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		

		int cnt = -999 ; 
		
		try {
			Class.forName(driver) ;
			conn = DriverManager.getConnection(url, this.id, password) ;
			conn.setAutoCommit(false);
		
			String sql = "" ;
			
			Employee bean = this.SelectOne(id);
			
			// 홍길동(hong)이가 회원 탈퇴를 하였습니다.
			String imsi = bean.getName() + "(" + id + ")이가 회원 탈퇴를 하였습니다.";
			
			//1. 게시물에 remark 컬럼 업데이트 
			sql = " update regi_recipe set remark = ? ";//탈퇴한 회원이라도 게시글은 남아 있기 때문에 비고에 설명을 넣어줍니다
			sql+= " where writer_id =? ";
			
			
			System.out.println(imsi);
			System.out.println(id);
			pstmt = conn.prepareStatement(sql) ;
			
			pstmt.setString(1, imsi);
			
			pstmt.setString(2, id);
			
			cnt = pstmt.executeUpdate() ;
			
			
			
			//2. 주문 테이블에 remark 컬럼 업데이트s
			sql = " update orders set remark = ? ";
			sql+= " where mid =? ";
			System.out.println("test3");
			
			pstmt = conn.prepareStatement(sql) ;
			
			pstmt.setString(1, imsi);
			pstmt.setString(2, id);
			cnt = pstmt.executeUpdate() ;
			

		
		  	//3. 회원 테이블에 해당 행을 삭제 
			sql = "delete from employees where id = ?" ;
			pstmt = conn.prepareStatement(sql) ;
			
			pstmt.setString(1, id);
			
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


	public Employee SelectOne(String id) {
		// 1건의 데이터를 조회합니다.
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		String sql = " select * from employees where id = ? " ; 
		
		Employee bean = null ; 
		
		try {
			conn = this.getConnection() ;
			pstmt = conn.prepareStatement(sql) ;
			
			pstmt.setString(1, id); 
			
			rs = pstmt.executeQuery() ;
			
			if (rs.next()) {
				bean = new Employee();
				
				bean.setZipcode(rs.getInt("zipcode"));
				bean.setAddress2(rs.getString("address2"));	
				bean.setAddress1(rs.getString("address1"));					
				bean.setGender(rs.getString("gender"));
				bean.setId(rs.getString("id"));
				bean.setPhone(rs.getString("phone"));
				bean.setEmail(rs.getString("email"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setMpoint(rs.getInt("mpoint"));
				
				bean.setBirth1(rs.getString("birth1"));
				bean.setBirth2(rs.getString("birth2"));
				bean.setBirth3(rs.getString("birth3"));
				
				
				// 날짜 형식은 다음과 같이 처리하도록 합니다.
				//java.sql.Date date = rs.getDate("birth") ;
				//if(date == null) {
					//bean.setBirth("");
				//}else {
					//bean.setBirth(String.valueOf(date));	
				//}
				
		
				
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

	public boolean confirmId(String id) {
		boolean result = false;
		// 1건의 데이터를 조회합니다.
				Connection conn = null ;
				PreparedStatement pstmt = null ;
				ResultSet rs = null ;
				
		
		
		try {
			
			 conn = this.getConnection() ;
			String sql = " select id from employees where id = ? " ; 
			pstmt = conn.prepareStatement(sql) ;
			pstmt.setString(1, id); 
			 rs = null ;
			rs = pstmt.executeQuery() ;
			if (rs.next()) {
				result = true ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {rs.close();} catch (SQLException e){}
			try {pstmt.close();} catch (SQLException e) {}
			try {conn.close();} catch (SQLException e) {}
		}
		
		return result;
	}

	
	
	public Employee LoginCheck(String id, String password) {
		// 아이디와 비밀 번호를 이용하여 로그인 테스트를 수행합니다.
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		String sql = " select * from employees " ;
		sql += " where id = ? and password = ? " ;
		
		Employee bean = null ;

		try {
			conn = this.getConnection() ;
			pstmt = conn.prepareStatement(sql) ;
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery() ;
			
			if (rs.next()) { //db에 무언가 있으면
				bean = new Employee();
				
				bean.setZipcode(rs.getInt("zipcode"));
				bean.setAddress2(rs.getString("address2"));	
				bean.setAddress1(rs.getString("address1"));	
				
				bean.setGender(rs.getString("gender"));
				bean.setId(rs.getString("id"));
				bean.setPhone(rs.getString("phone"));
				bean.setEmail(rs.getString("email"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setMpoint(rs.getInt("mpoint"));
				

				bean.setBirth1(rs.getString("birth1"));
				bean.setBirth2(rs.getString("birth2"));
				bean.setBirth3(rs.getString("birth3"));
				
				// 날짜 형식은 다음과 같이 처리하도록 합니다.
				//java.sql.Date date = rs.getDate("birth") ;
				//if(date == null) {
					//bean.setBirth("");
				//}else {
					//bean.setBirth(String.valueOf(date));	
				//}
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null){rs.close();}
				if(pstmt != null){pstmt.close();}
				if(conn != null){conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return bean;
	}

	public List<Employee> PagingInfo(int beginRow, int endRow) {
		// 페이징 처리 결과를 리턴합니다.
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		List<Employee> lists = new ArrayList<Employee>() ;
		
		String sql = " select id, password, name, birth1, birth2, birth3,gender, phone, email,zipcode,address1,address2,mpoint";
		sql += " from (";
		sql += " select rank() over(order by name asc) as ranking,id, password, name, birth1, birth2, birth3,gender, phone, email,zipcode,address1,address2,mpoint";
		sql += " from employees";
		sql += " )";
		sql += " where ranking between ? and ?" ;
		
		try {
			conn = this.getConnection() ; 
			pstmt = conn.prepareStatement(sql) ;
			
			pstmt.setInt(1, beginRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery() ;
			
			while (rs.next()) {
				Employee bean = new Employee();
				
				bean.setZipcode(rs.getInt("zipcode"));
				bean.setAddress2(rs.getString("address2"));	
				bean.setAddress1(rs.getString("address1"));	
				
				bean.setGender(rs.getString("gender"));
				bean.setId(rs.getString("id"));
				bean.setEmail(rs.getString("email"));
				bean.setPhone(rs.getString("phone"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
			
				bean.setBirth1(rs.getString("birth1"));
				bean.setBirth2(rs.getString("birth2"));
				bean.setBirth3(rs.getString("birth3"));
				//bean.setBirth(String.valueOf(rs.getDate("birth")));
				
				
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

	public int GetTotalCount() {
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		String sql = " select count(*) as cnt from employees " ; 
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
}


















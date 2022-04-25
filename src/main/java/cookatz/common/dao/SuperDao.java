package cookatz.common.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 모든 Dao의 수퍼 클래스
public class SuperDao {
	public String driver = "oracle.jdbc.driver.OracleDriver" ;
	public String url = "jdbc:oracle:thin:@localhost:1521:xe" ;
	public String id = "Cookatz" ;
	public String password = "cookatz" ;
	
	public SuperDao() {
		try {
			Class.forName(driver) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection conn = null ;
		try {
			conn = DriverManager.getConnection(url, id, password) ;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn ;
	}
}

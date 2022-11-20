package fastcode.api.util.test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
jdbc.driverClassName=org.mariadb.jdbc.Driver
jdbc.url=jdbc:mariadb://localhost:3306/mariadb
jdbc.username=root
jdbc.password=root
 * */
public class ConnTest {
	
	static class DBConst{
		public static final String ORACLE_DRIVER = "";
		public static final String MYSQL_DRIVER = "";
		public static final String MARIA_DRIVER = "org.mariadb.jdbc.Driver";
		public static final String MSSQL_DRIVER = "";
		public static final String URL = "jdbc:mariadb://ugp7-017.cafe24.com:3306/hbeni1212";
		public static final String USERNAME = "hbeni1212";
		public static final String PASSWORD = "hanbiteni1212";
	}
	static class TestDAO{
		Connection conn;
		Statement stmt;
		TestDAO() {
			try {
				Class.forName(DBConst.MARIA_DRIVER);
				conn = DriverManager.getConnection(
						DBConst.URL, 
						DBConst.USERNAME,
						DBConst.PASSWORD);
				stmt = conn.createStatement();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		String findById(){
			String sql = String.format("select count(*) from g5_member");
			String s = "";
			try {
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					s = rs.getString("count");
				}
				
			} catch (SQLException e) {
				System.out.println("테이블 접속 실패");
				e.printStackTrace();
			}
			if(s.equals("0")) {
				System.out.println("해당 테이블에 등록된 값이 없습니다");
			}
			return s;
		}
		// Uss.STUDENT.toString()
		boolean createTable(){
			String sql = String.format(Uss.ai_student.toString());
			boolean b = false;
			
			try {
				b = stmt.execute(sql);
			} catch (SQLException e) {
				System.out.println("테이블 접속 실패");
				e.printStackTrace();
			}
			
			return b;
		}
		
	}
	
	public static void main(String... args) {
		System.out.println("DB 테스트");
		TestDAO instance = new TestDAO();
		System.out.println("생성결과: "+instance.createTable());
	}
}
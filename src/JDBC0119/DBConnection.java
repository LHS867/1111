package JDBC0119;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	// DB접속을 위한 DBConnect() 메소드
	public static Connection DBConnect() {
		
		// DB에 접속정보 저장을 위한 Connection 변수 con 선언
		Connection con = null;
		
		// 접속할 DB의 계정 정보
		String user = "leehee";
		String password = "1111";
		
		// 접속할 DB의 주소 정보
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB접속 성공!");
		} catch(ClassNotFoundException cne) {
			cne.printStackTrace();
			System.out.println("DB접속실패 : 드라이버 로딩 실패");
			// jdbc에서 이상이 생기면 발생하는 catch문
		} catch(SQLException se) {
			se.printStackTrace();
			System.out.println("DB접속실패 : 계정정보확인");
			// id, password, url이 틀리면 실행되는 catch문
		}
		
		return con;
	}
}

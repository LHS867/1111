package IC; 
  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBC {
	public static Connection DBConnect() {
		
		
		Connection con = null;
		
		
		String user = "leehee";
		String password = "1111";
		
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB접속 성공!");
		} catch(ClassNotFoundException cne) {
			cne.printStackTrace();
			System.out.println("DB접속실패 : 드라이버 로딩 실패");
			
		} catch(SQLException se) {
			se.printStackTrace();
			System.out.println("DB접속실패 : 계정정보확인");
			
		}
		
		return con;
	}
}

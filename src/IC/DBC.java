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
			System.out.println("DB���� ����!");
		} catch(ClassNotFoundException cne) {
			cne.printStackTrace();
			System.out.println("DB���ӽ��� : ����̹� �ε� ����");
			
		} catch(SQLException se) {
			se.printStackTrace();
			System.out.println("DB���ӽ��� : ��������Ȯ��");
			
		}
		
		return con;
	}
}

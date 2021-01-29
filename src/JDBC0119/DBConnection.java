package JDBC0119;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	// DB������ ���� DBConnect() �޼ҵ�
	public static Connection DBConnect() {
		
		// DB�� �������� ������ ���� Connection ���� con ����
		Connection con = null;
		
		// ������ DB�� ���� ����
		String user = "leehee";
		String password = "1111";
		
		// ������ DB�� �ּ� ����
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB���� ����!");
		} catch(ClassNotFoundException cne) {
			cne.printStackTrace();
			System.out.println("DB���ӽ��� : ����̹� �ε� ����");
			// jdbc���� �̻��� ����� �߻��ϴ� catch��
		} catch(SQLException se) {
			se.printStackTrace();
			System.out.println("DB���ӽ��� : ��������Ȯ��");
			// id, password, url�� Ʋ���� ����Ǵ� catch��
		}
		
		return con;
	}
}

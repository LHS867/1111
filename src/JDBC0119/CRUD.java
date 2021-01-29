package JDBC0119;

//import java.sql.Connection;
//import java.sql.Statement;
import java.sql.*;

public class CRUD {
	Connection con;
	Statement stmt;
	ResultSet rs;	// rs�� DATA�� �����Ѵٰ� ���� �ȴ�.
	
	// ������ ���̽� ����!
	DBConnection conn = new DBConnection();
	
	// CRUD
	// C: CREATE(����)
	// R: READ(�˻�)
	// U: UPDATE(����)
	// D: DELETE(����)
	
	// C: CREATE(����)
	// insert()�޼ҵ� ����
	public void insert() {
		con = conn.DBConnect();
		
		try {
			
			stmt = con.createStatement();
			String sql = "INSERT INTO JAVASQL VALUES('3��°!')";
			
			int count = stmt.executeUpdate(sql);
			System.out.println("���Ե� �������� �� : " + count);
			
			if(count > 0) {
				System.out.println("insert success!");
			} else {
				System.out.println("insert fail!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// R: READ(�˻�)
	// select() �޼ҵ�
	public void select() {
		con = DBConnection.DBConnect();	
		
		try {			
			stmt = con.createStatement();
			String sql = "SELECT * FROM JAVASQL";
			rs = stmt.executeQuery(sql);
			
			int i = 1;
			while(rs.next()) {	// ���ڵ尡 ���̻� �������� ���������� �ݺ�
								// ���ڵ尡 3���� 3�� �ݺ�, 10���� 10�� �ݺ�
				System.out.println(i + "��°");
				i++;
				System.out.println("TEST1 : " + rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	// U: UPDATE(����)
	// update() �޼ҵ�
	public void update() {
		con = conn.DBConnect();
		try {
			stmt = con.createStatement();
			String sql = "UPDATE JAVASQL SET TEST1 = '�����ȵ�����'"
					    +"WHERE TEST1 = 'SQL1'";
			
			int count = stmt.executeUpdate(sql);
			System.out.println("������ �������� �� : " + count);
			
			if(count > 0) {
				System.out.println("update success!");
			} else {
				System.out.println("update fail T^T");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// D: DELETE(����)
	// delete() �޼ҵ�
	public void delete() {
		con = conn.DBConnect();
		
		try {
			stmt = con.createStatement();
			String sql = "DELETE JAVASQL WHERE TEST1 = '3��°!'";
			
			int count = stmt.executeUpdate(sql);
			System.out.println("������ �������� �� : " + count);
			
			if(count > 0) {
				System.out.println("Delete success!");
			} else {
				System.out.println("Delete fail T^T");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}

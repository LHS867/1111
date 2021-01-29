package JDBC0119;

//import java.sql.Connection;
//import java.sql.Statement;
import java.sql.*;

public class CRUD {
	Connection con;
	Statement stmt;
	ResultSet rs;	// rs는 DATA를 저장한다고 보면 된다.
	
	// 데이터 베이스 접속!
	DBConnection conn = new DBConnection();
	
	// CRUD
	// C: CREATE(생성)
	// R: READ(검색)
	// U: UPDATE(수정)
	// D: DELETE(삭제)
	
	// C: CREATE(생성)
	// insert()메소드 생성
	public void insert() {
		con = conn.DBConnect();
		
		try {
			
			stmt = con.createStatement();
			String sql = "INSERT INTO JAVASQL VALUES('3번째!')";
			
			int count = stmt.executeUpdate(sql);
			System.out.println("삽입된 데이터의 수 : " + count);
			
			if(count > 0) {
				System.out.println("insert success!");
			} else {
				System.out.println("insert fail!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// R: READ(검색)
	// select() 메소드
	public void select() {
		con = DBConnection.DBConnect();	
		
		try {			
			stmt = con.createStatement();
			String sql = "SELECT * FROM JAVASQL";
			rs = stmt.executeQuery(sql);
			
			int i = 1;
			while(rs.next()) {	// 레코드가 더이상 존재하지 않을때까지 반복
								// 레코드가 3개면 3번 반복, 10개면 10번 반복
				System.out.println(i + "번째");
				i++;
				System.out.println("TEST1 : " + rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	// U: UPDATE(수정)
	// update() 메소드
	public void update() {
		con = conn.DBConnect();
		try {
			stmt = con.createStatement();
			String sql = "UPDATE JAVASQL SET TEST1 = '수정된데이터'"
					    +"WHERE TEST1 = 'SQL1'";
			
			int count = stmt.executeUpdate(sql);
			System.out.println("수정된 데이터의 수 : " + count);
			
			if(count > 0) {
				System.out.println("update success!");
			} else {
				System.out.println("update fail T^T");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// D: DELETE(삭제)
	// delete() 메소드
	public void delete() {
		con = conn.DBConnect();
		
		try {
			stmt = con.createStatement();
			String sql = "DELETE JAVASQL WHERE TEST1 = '3번째!'";
			
			int count = stmt.executeUpdate(sql);
			System.out.println("삭제된 데이터의 수 : " + count);
			
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

package JDBC0119;

public class JdbcMain {

	public static void main(String[] args) {
		// 앞서 만든 DBConnection클래스에서 만든
		// DBConnect()메소드가 잘 작동하는지 확인
		
		DBConnection conn = new DBConnection();
		DBConnection.DBConnect();

	}

}

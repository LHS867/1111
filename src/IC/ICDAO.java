package IC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ICDAO {

	Connection conn = null;

	PreparedStatement pstmt = null;

	ResultSet rs = null;

	public void connect() {
		conn = DBC.DBConnect();
	}

	public void conClose() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 1.�α���
	public int Login(String cid, String cpw) {
		String sql = "SELECT * FROM IC WHERE ICID=? AND ICPW =?";
		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, cid);
			pstmt.setString(2, cpw);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = 1;
			} else {
				result = 0;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}

		return result;
	}

	// 2.ȸ������
	public void memberJoin(ICDTO dto) {
		String sql = "INSERT INTO IC VALUES(?,?,?,?,?,?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);

			// ? �ȿ� �� �ֱ�
			pstmt.setString(1, dto.getcId());
			pstmt.setString(2, dto.getcPw());
			pstmt.setString(3, dto.getcName());
			pstmt.setString(4, dto.getcBirth());
			pstmt.setString(5, dto.getcGender());
			pstmt.setString(6, dto.getcEmail());
			pstmt.setString(7, dto.getcTell());
			pstmt.setString(8, dto.getcAddress());
			pstmt.setString(9, dto.getcAccountnumber());
			pstmt.setInt(10, dto.getcBalance());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("ȸ������ ����!");
			} else {
				System.out.println("ȸ������ ����!");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

	// 3.ȸ������ ��ȸ
	public void memberList(ICDTO dto) {
		String sql = "SELECT * FROM IC WHERE ICID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getcId());

			rs = pstmt.executeQuery();

			int i = 1;
			while (rs.next()) {
				System.out.println(i + "��° ȸ��");
				System.out.println("���̵� : " + rs.getString(1));
				System.out.println("��й�ȣ : " + rs.getString(2));
				System.out.println("�̸� : " + rs.getString(3));
				System.out.println("������� : " + rs.getString(4));
				System.out.println("���� : " + rs.getString(5));
				System.out.println("�̸��� : " + rs.getString(6));
				System.out.println("��ȭ��ȣ : " + rs.getString(7));
				System.out.println("�ּ� : " + rs.getString(8));
				System.out.println();
				i++;

				int result = pstmt.executeUpdate();

				if (result > 0) {
					System.out.println("ȸ�������� �ҷ�����");
				} else {
					System.out.println("ȸ�������� �ҷ����� ����");
				}
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	// 4.ȸ������ ����
	public void memberModify(ICDTO dto) {
		String sql = "UPDATE IC SET ICPW=?, ICNAME=?, ICBIRTH=?, " + "ICGENDER=?, ICEMAIL=?, ICTELL=?, ICADDRESS=? "
				+ "WHERE ICID=?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getcPw());
			pstmt.setString(2, dto.getcName());
			pstmt.setString(3, dto.getcBirth());
			pstmt.setString(4, dto.getcGender());
			pstmt.setString(5, dto.getcEmail());
			pstmt.setString(6, dto.getcTell());
			pstmt.setString(7, dto.getcAddress());
			pstmt.setString(8, dto.getcId());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("ȸ������ ��������!");
			} else {
				System.out.println("ȸ������ ��������!");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

	// 5-1.ȸ������
	public boolean idCheck(String dId, String dPw) {
		String sql = "SELECT ICID FROM IC " + "WHERE ICID=? AND ICPW=?";
		boolean checkResult = false;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dId);
			pstmt.setString(2, dPw);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				checkResult = true;
			} else {
				checkResult = false;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return checkResult;
	}

	// 5-2.ȸ������
	public void memberDelete(String dId) {
		String sql = "DELETE IC WHERE ICID=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dId);
			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("ȸ������ ��������!");
			} else {
				System.out.println("ȸ������ ��������!");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

	// 6.���µ��
	public void insertClient(ICDTO dto) {
		String sql = "UPDATE IC SET ICACCOUNTNUMBER=?, ICBALANCE=? WHERE ICID=? AND ICPW=?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getcAccountnumber());
			pstmt.setInt(2, dto.getcBalance());
			pstmt.setString(3, dto.getcId());
			pstmt.setString(4, dto.getcPw());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("���µ�ϼ���!");
			} else {
				System.out.println("���µ�Ͻ���!");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

	// 7.������ȸ
	public int checkBalance(String caccountnumber) {
		String sql = "SELECT ICBALANCE FROM IC WHERE ICACCOUNTNUMBER = ? ";
		int balance = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, caccountnumber);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				balance = rs.getInt(1);
				// balance = rs.getInt("BALANCE");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}

		return balance;
	}

	// 8.�����Ա�
	public void deposit(ICDTO dto) {
		String sql = "UPDATE IC SET ICBALANCE = ICBALANCE + ? WHERE ICACCOUNTNUMBER = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getcBalance());
			pstmt.setString(2, dto.getcAccountnumber());

			int result/* �ʿ���� ������ */ = pstmt.executeUpdate();// �� ���� Ȱ��Ǵ� ������

			if (result > 0) {
				System.out.println("�Ա� ����");
			} else {
				System.out.println("�Ա� ����");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	// 9.��ǰ����
	public void withdraw(String caccountnumber, String icname) {
		String sql1 = "SELECT ICICPRICE FROM ICIC WHERE ICICNAME=?";
		String sql = "UPDATE IC SET ICBALANCE = ICBALANCE - ? WHERE ICACCOUNTNUMBER = ?";

		try {
			pstmt = conn.prepareStatement(sql1);

			pstmt.setString(1, icname);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int cbalance = rs.getInt(1);

				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, cbalance);
				pstmt.setString(2, caccountnumber);

				int result/* �ʿ���� ������ */ = pstmt.executeUpdate();// �� ���� Ȱ��Ǵ� ������

				if (result > 0) {
					System.out.println("���� ����");
				} else {
					System.out.println("���� ����");
				}
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}

	}
	}




				
		
	



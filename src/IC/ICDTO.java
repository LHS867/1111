package IC;

public class ICDTO {
	

	// ȸ������ ���� �ʵ�
	private String cId; // ���̵�
	private String cPw; // ��й�ȣ
	private String cName; // �̸�
	private String cBirth; // �������
	private String cGender; // ����
	private String cEmail; // �̸���
	private String cTell; // �޴���ȭ
	private String cAddress;// �ּ�
	private String cAccountnumber;// ���¹�ȣ
	private int cBalance;// �ܾ�
	
	// ��ǰ����
	private String icCode; // ��ǰ��ȣ
	private String icName; // ��ǰ�̸�
	private int icPrice; // ��ǰ����
	private int icStock; // ��ǰ���
	private String icSize; // ��ǰ������

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String getcPw() {
		return cPw;
	}

	public void setcPw(String cPw) {
		this.cPw = cPw;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcBirth() {
		return cBirth;
	}

	public void setcBirth(String cBirth) {
		this.cBirth = cBirth;
	}

	public String getcGender() {
		return cGender;
	}

	public void setcGender(String cGender) {
		this.cGender = cGender;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public String getcTell() {
		return cTell;
	}

	public void setcTell(String cTell) {
		this.cTell = cTell;
	}

	public String getcAddress() {
		return cAddress;
	}

	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}

	public String getcAccountnumber() {
		return cAccountnumber;
	}

	public void setcAccountnumber(String cAccountnumber) {
		this.cAccountnumber = cAccountnumber;
	}

	public int getcBalance() {
		return cBalance;
	}

	public void setcBalance(int cBalance) {
		this.cBalance = cBalance;
	}

	public String getIcCode() {
		return icCode;
	}

	public void setIcCode(String icCode) {
		this.icCode = icCode;
	}

	public String getIcName() {
		return icName;
	}

	public void setIcName(String icName) {
		this.icName = icName;
	}

	public int getIcPrice() {
		return icPrice;
	}

	public void setIcPrice(int icPrice) {
		this.icPrice = icPrice;
	}

	public int getIcStock() {
		return icStock;
	}

	public void setIcStock(int icStock) {
		this.icStock = icStock;
	}

	public String getIcSize() {
		return icSize;
	}

	public void setIcSize(String icSize) {
		this.icSize = icSize;
	}

	@Override
	public String toString() {
		return "ICDTO [cId=" + cId + ", cPw=" + cPw + ", cName=" + cName + ", cBirth=" + cBirth + ", cGender=" + cGender
				+ ", cEmail=" + cEmail + ", cTell=" + cTell + ", cAddress=" + cAddress + ", cAccountnumber="
				+ cAccountnumber + ", cBalance=" + cBalance + ", icCode=" + icCode + ", icName=" + icName + ", icPrice="
				+ icPrice + ", icStock=" + icStock + ", icSize=" + icSize + "]";
	}

	public ICDTO() {
		super();
		
	}

	public ICDTO(String cId, String cPw, String cName, String cBirth, String cGender, String cEmail, String cTell,
			String cAddress, String cAccountnumber, int cBalance, String icCode, String icName, int icPrice,
			int icStock, String icSize) {
		super();
		this.cId = cId;
		this.cPw = cPw;
		this.cName = cName;
		this.cBirth = cBirth;
		this.cGender = cGender;
		this.cEmail = cEmail;
		this.cTell = cTell;
		this.cAddress = cAddress;
		this.cAccountnumber = cAccountnumber;
		this.cBalance = cBalance;
		this.icCode = icCode;
		this.icName = icName;
		this.icPrice = icPrice;
		this.icStock = icStock;
		this.icSize = icSize;
	}



}

package ams;

public class BankBook implements Account{
	private String accountNo; // ���¹�ȣ
	private String ownerName; // �����ָ�
	private String password; // ������
	private int balance; // �ܾ�

	public BankBook(String accountNo, String ownerName, String password, int balance) {
		this.accountNo = accountNo; // �ʵ尪�� �Ķ���Ͱ��� ����
		this.ownerName = ownerName;
		this.password = password;
		this.balance = balance;
	}
	
	

	public String getAccountNo() {
		return accountNo;
	}



	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}



	public String getOwnerName() {
		return ownerName;
	}



	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public int getBalance() {
		return balance;
	}



	public void setBalance(int balance) {
		this.balance = balance;
	}



	@Override
	public void deposit(int money) {
		if (money <= 0) {
			System.out.println("�Աݾ��� 0 ���� Ŀ�� �Ѵ�.");
		} else {
			this.balance += money;
		}
		
	}

	@Override
	public void withdraw(int money) {
		if (money <= 0) {
			System.out.println("��ݾ��� 0 ���� Ŀ�� �Ѵ�.");
		} else if (money > getBalance()) {
			System.out.println("�y�ݾ��� �ܾ׺��� �۾ƾ� �Ѵ�.");
		} else
		this.balance -= money;
		
	}
	// �ڹ� API �߿��� java.lang.Object Ŭ������ 
	// �޼ҵ��� toString() �� �������̵� 
	@Override
	public String toString() {
		return "����� ����\n"+ "["+BANK_NAME+ "]\n"+ "���¹�ȣ :"
				+ getAccountNo()+"\n"+"���¸� :"
				+ getOwnerName()+"\n"
				+ "��� : ******** \n"+"�ܾ� :"
				+ getBalance()+"\n"
				+ "���� ������ �����Ǿ����ϴ�.";
	}

}

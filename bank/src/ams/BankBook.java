package ams;

public class BankBook implements Account{
	private String accountNo; // 계좌번호
	private String ownerName; // 계좌주립
	private String password; // 통장비번
	private int balance; // 잔액

	public BankBook(String accountNo, String ownerName, String password, int balance) {
		this.accountNo = accountNo; // 필드값을 파라미터값과 매핑
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
			System.out.println("입금액은 0 보다 커야 한다.");
		} else {
			this.balance += money;
		}
		
	}

	@Override
	public void withdraw(int money) {
		if (money <= 0) {
			System.out.println("출금액은 0 보다 커야 한다.");
		} else if (money > getBalance()) {
			System.out.println("춞금액은 잔액보다 작아야 한다.");
		} else
		this.balance -= money;
		
	}
	// 자바 API 중에서 java.lang.Object 클래스의 
	// 메소드인 toString() 을 오버라이딩 
	@Override
	public String toString() {
		return "입출금 계좌\n"+ "["+BANK_NAME+ "]\n"+ "계좌번호 :"
				+ getAccountNo()+"\n"+"계좌명 :"
				+ getOwnerName()+"\n"
				+ "비번 : ******** \n"+"잔액 :"
				+ getBalance()+"\n"
				+ "으로 통장이 개설되었습니다.";
	}

}

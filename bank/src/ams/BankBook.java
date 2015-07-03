package ams;

public class BankBook implements Account{
	private String accountNo; // °èÁÂ¹øÈ£
	private String ownerName; // °èÁÂÁÖ¸³
	private String password; // ÅëÀåºñ¹ø
	private int balance; // ÀÜ¾×

	public BankBook(String accountNo, String ownerName, String password, int balance) {
		this.accountNo = accountNo; // ÇÊµå°ªÀ» ÆÄ¶ó¹ÌÅÍ°ª°ú ¸ÅÇÎ
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
			System.out.println("ÀÔ±İ¾×Àº 0 º¸´Ù Ä¿¾ß ÇÑ´Ù.");
		} else {
			this.balance += money;
		}
		
	}

	@Override
	public void withdraw(int money) {
		if (money <= 0) {
			System.out.println("Ãâ±İ¾×Àº 0 º¸´Ù Ä¿¾ß ÇÑ´Ù.");
		} else if (money > getBalance()) {
			System.out.println("­y±İ¾×Àº ÀÜ¾×º¸´Ù ÀÛ¾Æ¾ß ÇÑ´Ù.");
		} else
		this.balance -= money;
		
	}
	// ÀÚ¹Ù API Áß¿¡¼­ java.lang.Object Å¬·¡½ºÀÇ 
	// ¸Ş¼ÒµåÀÎ toString() À» ¿À¹ö¶óÀÌµù 
	@Override
	public String toString() {
		return "ÀÔÃâ±İ °èÁÂ\n"+ "["+BANK_NAME+ "]\n"+ "°èÁÂ¹øÈ£ :"
				+ getAccountNo()+"\n"+"°èÁÂ¸í :"
				+ getOwnerName()+"\n"
				+ "ºñ¹ø : ******** \n"+"ÀÜ¾× :"
				+ getBalance()+"\n"
				+ "À¸·Î ÅëÀåÀÌ °³¼³µÇ¾ú½À´Ï´Ù.";
	}

}

package ams;

public class Bank implements BankRole{
	private BankBook[] bankBookList; // ������ ����Ʈ�� �����ϴ� �迭
	private int count; // ���� �������� ����
	
	public Bank(int count) {
		bankBookList = new BankBook[count];
		/*
		 * �迭 ���� ���
		 * �迭�� �޼ҵ� �ȿ� ���������� ����� �����
		 * int[] nums = new int[i];
		 * ������ ���� �� bankBookList �迭�� �ʵ忡 ����� �ν��Ͻ� ����
		 * �ν��Ͻ� ������ �����ڸ� ���� �ʱ�ȭ �Ϸ��� ���
		 * ���� ���� ó�� �Ѵ�.
		 * �迭 ������ ���ڸ� ǥ���ϴ� count�� �ݵ�� �ʵ忡 ������ �־�� �Ѵ�.
		 */
	}
	// �ʵ忡 ����� �ν��Ͻ� ������ getter/setter ����

	public BankBook[] getBankBookList() {
		return bankBookList;
	}

	public int getCount() {
		return count;
	}

	@Override
	public void openAccount(String accountNo, String ownerName,
			String password, int balance) {
		// ��������� Account Ŭ������ ��ü�� ���� �����ϰ� �ذ�
		Account bankBook = new BankBook(accountNo, ownerName, password, balance);
		// ĳ���� : ����(ū) ������ ��ü�� ���� ������ �������� �� �� �ʿ��� ��� 
		bankBookList[count] = (BankBook) bankBook;
		count++; // ���� ������ ������Ų��.
		System.out.println(bankBook.toString()+"���� ���� ����");
	}

	@Override
	public Account searchAccountByAccoountNo(String accountNo) {
		Account searchAccount = null;
		/*
		 * �������� ����(������)�� ���� 3 ������ ����
		 * 1. ������Ʈ ��ü�� ����Ǵ� ���� : Ŭ���� ���� ex. static Ű����� ����� Pay.TAX
		 * 2. Ŭ���� ���ο� ����Ǵ� ���� : �ν��Ͻ� ���� ex. �ʵ忡 ����� static �� ���� ����
		 * 3. �޼ҵ� ���ο� ����Ǵ� ���� : ����(����)���� ex. searchAccount
		 */
		for (int i = 0; i < getCount(); i++) {
			/*
			 * bankBookList[i] �� bankBookList �� ����ִ� 
			 * ���尴ü �ϳ��� ����ŵ�ϴ�.
			 * equals() �� �ڹ� API �� �ִ� java.lang.String Ŭ������
			 * �޼ҵ�� ��Ʈ�� ���� �񱳸� �Ѵ�. ������ true �� �����Ѵ�.
			 */
			if (bankBookList[i].getAccountNo().equals(accountNo)) {
				searchAccount = bankBookList[i];
				return searchAccount; 
				/* ���� if ���� true ����� ���¹�ȣ�� �Ѿ�Դٸ� ���¹�ȣ�� �� �ϳ� ���̹Ƿ� 
				 * getCount() ���ڸ��� �� Ǯ�� ���� ���� �� ���¿��� ȸ���� ���߰� ���� ��ȯ�ض� 
				 */			
				}
		}
		return searchAccount;
	}

	@Override
	public Account[] searchAccountsByName(String ownerName) {
		int tempCount = searchCountByName(ownerName);
		if (tempCount == 0) { // �˻��Ϸ��� �̸����� �� ������ �ϳ��� ���� ���
			return null;
		}
		BankBook[] tempList = new BankBook[tempCount];
		tempCount = 0; // �������� �ʱ�ȭ
		for (int i = 0; i < getCount(); i++) {
			/*
			 * 
			 */
			if (bankBookList[i].getOwnerName().equals(ownerName)) {
				tempList[tempCount] = bankBookList[i];
				tempCount++;
			}
		}
		return tempList;
	}

	private int searchCountByName(String ownerName) {
		int searchCount = 0; // ���������� ������ �ʱ�ȭ -> �ڹ� ����
		for (int i = 0; i < getCount(); i++) {
			if (bankBookList[i].getOwnerName().equals(ownerName)) {
				
				searchCount++;
			}
		}
		return searchCount;
	}

	@Override
	public boolean closeAccount(String accountNo) {
		boolean isClose = false; // boolean �� Ÿ���� ����Ʈ ���� false �̴�.
		// ���� boolean �� �������� �ʱ�ȭ�� false �� �Ѵ�.
		for (int i = 0; i < getCount(); i++) {
			if (bankBookList[i].getAccountNo().equals(accountNo)) {
				isClose = true;
				// �迭���� ��Ҹ� �����ϴ� for �� ����
				for (int j = i; j < getCount()-1; j++) { // ȸ�� ī��Ʈ ���ڰ� �ϳ� ����
					/*
					 * �迭�� �ε����� �������� ������� ������ ����
					 * ���� j��° ��Ҹ� j+1 ��° ��ҷ� ����⸦ �����
					 * {1,2,3,4,5} �̷� �迭�� �ִٰ� �ϸ�
					 * {1,2,4,5} �� ����� �� ���� �ε��� ���� 2�� 3��° ����� 3 ���� ���� ��
					 */
					bankBookList[j] = bankBookList[j+1];
				}
				count--; // �� ������ �� ���� ������� ������ ��� ������ ����
			}
		}
		return isClose;
	}

}

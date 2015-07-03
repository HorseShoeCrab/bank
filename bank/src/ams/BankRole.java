package ams;
// ���� �Ŵ��� ��� ����
public interface BankRole {
	/*
	 * ���¸� ���� ���
	 */
	public void openAccount(String accountNo, String ownerName, String password, int balance);
	/*
	 * ���¹�ȣ�� Ư�� ���¸� ��ȸ(�˻�) ��� 
	 */
	public Account searchAccountByAccoountNo(String accountNo);
	/*
	 * ������ �̸����� �� ����� ������ �ִ� ���� ��ȸ
	 */
	public Account[] searchAccountsByName(String ownerName);
	/*
	 * ���¹�ȣ�� Ư������ ���(����) ���
	 */
	public boolean closeAccount(String accountNo);
}

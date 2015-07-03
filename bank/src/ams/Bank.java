package ams;

public class Bank implements BankRole{
	private BankBook[] bankBookList; // 통장을 리스트로 관리하는 배열
	private int count; // 통장 수량관리 변수
	
	public Bank(int count) {
		bankBookList = new BankBook[count];
		/*
		 * 배열 선언 방법
		 * 배열이 메소드 안에 지역변수로 선언될 경우라면
		 * int[] nums = new int[i];
		 * 하지만 지금 이 bankBookList 배열은 필드에 선언된 인스턴스 변수
		 * 인스턴스 변수를 생성자를 통해 초기화 하려는 경우
		 * 위의 예시 처럼 한다.
		 * 배열 내부의 숫자를 표시하는 count를 반드시 필드에 선언해 주어야 한다.
		 */
	}
	// 필드에 선언된 인스턴스 변수의 getter/setter 생성

	public BankBook[] getBankBookList() {
		return bankBookList;
	}

	public int getCount() {
		return count;
	}

	@Override
	public void openAccount(String accountNo, String ownerName,
			String password, int balance) {
		// 통장생성을 Account 클래스의 객체를 통해 간단하게 해결
		Account bankBook = new BankBook(accountNo, ownerName, password, balance);
		// 캐스팅 : 넓은(큰) 개념의 객체를 작은 범위의 담으려고 할 때 필요한 기능 
		bankBookList[count] = (BankBook) bankBook;
		count++; // 통장 갯수를 증가시킨다.
		System.out.println(bankBook.toString()+"으로 계좌 개설");
	}

	@Override
	public Account searchAccountByAccoountNo(String accountNo) {
		Account searchAccount = null;
		/*
		 * 변수에는 영역(스코프)에 따라 3 가지가 존재
		 * 1. 프로젝트 전체에 적용되는 변수 : 클래스 변수 ex. static 키워드로 선언된 Pay.TAX
		 * 2. 클래스 내부에 적용되는 변수 : 인스턴스 변수 ex. 필드에 선언된 static 이 없는 변수
		 * 3. 메소드 내부에 적용되는 변수 : 지역(로컬)변수 ex. searchAccount
		 */
		for (int i = 0; i < getCount(); i++) {
			/*
			 * bankBookList[i] 는 bankBookList 에 들어있는 
			 * 통장객체 하나를 가리킵니다.
			 * equals() 는 자바 API 에 있는 java.lang.String 클래스의
			 * 메소드로 스트링 값의 비교를 한다. 같으면 true 를 리턴한다.
			 */
			if (bankBookList[i].getAccountNo().equals(accountNo)) {
				searchAccount = bankBookList[i];
				return searchAccount; 
				/* 만약 if 문을 true 만드는 계좌번호가 넘어왔다면 계좌번호는 단 하나 뿐이므로 
				 * getCount() 숫자만을 다 풀지 말고 지금 이 상태에서 회전을 멈추고 값을 반환해라 
				 */			
				}
		}
		return searchAccount;
	}

	@Override
	public Account[] searchAccountsByName(String ownerName) {
		int tempCount = searchCountByName(ownerName);
		if (tempCount == 0) { // 검색하려는 이름으로 된 통장이 하나도 없는 경우
			return null;
		}
		BankBook[] tempList = new BankBook[tempCount];
		tempCount = 0; // 지역변수 초기화
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
		int searchCount = 0; // 지역변수는 무조건 초기화 -> 자바 문법
		for (int i = 0; i < getCount(); i++) {
			if (bankBookList[i].getOwnerName().equals(ownerName)) {
				
				searchCount++;
			}
		}
		return searchCount;
	}

	@Override
	public boolean closeAccount(String accountNo) {
		boolean isClose = false; // boolean 의 타입의 디폴트 값은 false 이다.
		// 따라서 boolean 의 지역변수 초기화는 false 로 한다.
		for (int i = 0; i < getCount(); i++) {
			if (bankBookList[i].getAccountNo().equals(accountNo)) {
				isClose = true;
				// 배열에서 요소를 삭제하는 for 문 패턴
				for (int j = i; j < getCount()-1; j++) { // 회전 카운트 숫자가 하나 감소
					/*
					 * 배열은 인덱스를 기준으로 순서대로 나열된 형태
					 * 따라서 j번째 요소를 j+1 번째 요소로 덮어쓰기를 만들면
					 * {1,2,3,4,5} 이런 배열이 있다고 하면
					 * {1,2,4,5} 로 만들면 이 것이 인덱스 값이 2인 3번째 요소인 3 값을 지운 것
					 */
					bankBookList[j] = bankBookList[j+1];
				}
				count--; // 뒷 값으로 앞 값을 덮어씌었기 때문에 요소 갯수가 줄음
			}
		}
		return isClose;
	}

}

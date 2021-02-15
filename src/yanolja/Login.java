package yanolja;

import java.util.Scanner;

public class Login { // 로그인 된 화면

	Scanner sc = new Scanner(System.in);
	UserDB db = new UserDB();
	HotelReservation hr = new HotelReservation();
	HotelReservationView hrv = new HotelReservationView();
	UserHistory uh = new UserHistory();
	ManagerMain mm = new ManagerMain();
	print pt = new print();
	
	int ch;

	public void Menu() { // 로그인 후 메뉴

		while (true) {
						
			System.out.println(pt.rogo());
			System.out.println(pt.id());
			System.out.print(pt.main());
			
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				viewMyAccount(); // 1. 내 정보
				break;
			case 2:
				hr.reservation(); // 2. 예약
				break;
			case 3:
				uh.Menu(); // 3. 예약 관리
				break;
			case 4:
				Member.member = null; // 현재 로그인된 회원 초기화
				return;
			}

		}

	}
	
	public void viewMyAccount() { // 내 정보

		while(true) {
			
			System.out.println(pt.rogo());
			System.out.println(pt.id());
			System.out.print(pt.myInfo());
			ch = sc.nextInt();

			switch(ch) {
			case 1: 
				db.selectMyAccount();
				break;
			case 2:
				db.updateAccount();
				break;
			case 3: return;

			}
		}

	}
	
}

package yanolja;

import java.util.Scanner;

public class ManagerMain {

	Scanner sc = new Scanner(System.in);
	Manager ob = new Manager();
	print pt = new print();

	public void managerMain() { // 관리자 로그인 후 메뉴

		int ch;
		try {
			while (true) {
				System.out.println(pt.managerLogo());
				System.out.print(pt.managerMenu());
				ch = sc.nextInt();
				switch (ch) {
				case 1:
					managerHotel(); // 관리자 호텔 관리
					break;
				case 2:
					managerHotelRoom(); // 관리자 호텔별 방 관리
					break;
				case 3:
					managerReservation(); // 관리자 예약 관리
					break;
				case 4: 
					managerUsers(); // 관리자 회원 관리
					break;
				case 5:
					return;
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void managerHotel() { // 관리자 - 1. 호텔 관리

		int ch;
		try {
			while (true) {
				do {
					System.out.println(pt.managerLogo());
					System.out.print(pt.hotelMenu());
					ch = sc.nextInt();
				} while (ch < 1 || ch > 5);
				switch (ch) {
				case 1:
					pt.blank();
					ob.printSc(); // 1. 전체 호텔 조회
					break;
				case 2:
					ob.hotelInsert(); // 2. 호텔 추가
					break;
				case 3:
					ob.hotelUpdate(); // 3. 호텔 수정
					break;
				case 4:
					ob.hotelDelete(); // 4. 호텔 삭제
					break;
				case 5:
					return; // 뒤로
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void managerHotelRoom() { // 관리자 - 2. 호텔 방관리

		int ch;
		while (true) {
			System.out.println(pt.managerLogo());
			System.out.print(pt.roomMenu());
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				pt.blank();
				ob.printRom(); // 1. 호텔 방 조회
				break;
			case 2:
				ob.roomInsert(); // 2. 호텔 방 추가
				break;
			case 3:
				ob.roomUpdate(); // 3. 호텔 방 수정
				break;
			case 4:
				ob.roomDelete(); // 4. 호텔 방 삭제
				break;
			case 5:
				return;
			}
		}

	}

	public void managerReservation() { // 관리자 - 3. 예약관리

		int ch;
		while(true) {
			System.out.println(pt.managerLogo());
			System.out.print(pt.managerRMMenu());
			ch = sc.nextInt();
			switch(ch) {
			case 1: ob.viewAllHistory(); break; // 1. 예약 조회
			case 2: ob.searchHistory(); break; // 2. 예약 검색
			case 3: ob.updateHistory(); break; // 3. 예약 수정
			case 4: ob.deleteHistory();break; // 4. 예약 취소
			case 5: return; // 뒤로
			}
		}
		
	}

	public void managerUsers() { // 관리자 - 4. 회원관리

		int ch;
		while (true) {
			System.out.println(pt.managerLogo());
			System.out.print(pt.managerUserMenu());
			ch = sc.nextInt();
			switch(ch) {
			case 1: ob.viewAllUsers(); break; // 1. 회원 조회
			case 2: ob.searchUser(); break; // 2. 회원 검색
			case 3: ob.updateUser(); break; // 3. 회원 수정
			case 4: ob.deleteUser(); break; // 4. 회원 삭제
			case 5: return; // 뒤로
			}
		}
		
	}

}

package yanolja;

import java.util.Scanner;

public class Login { // �α��� �� ȭ��

	Scanner sc = new Scanner(System.in);
	UserDB db = new UserDB();
	HotelReservation hr = new HotelReservation();
	HotelReservationView hrv = new HotelReservationView();
	UserHistory uh = new UserHistory();
	ManagerMain mm = new ManagerMain();
	print pt = new print();
	
	int ch;

	public void Menu() { // �α��� �� �޴�

		while (true) {
						
			System.out.println(pt.rogo());
			System.out.println(pt.id());
			System.out.print(pt.main());
			
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				viewMyAccount(); // 1. �� ����
				break;
			case 2:
				hr.reservation(); // 2. ����
				break;
			case 3:
				uh.Menu(); // 3. ���� ����
				break;
			case 4:
				Member.member = null; // ���� �α��ε� ȸ�� �ʱ�ȭ
				return;
			}

		}

	}
	
	public void viewMyAccount() { // �� ����

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

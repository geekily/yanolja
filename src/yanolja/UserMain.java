package yanolja;

import java.util.Scanner;

public class UserMain { // 초기 메뉴

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		UserDB db = new UserDB();
		ManagerMain mm = new ManagerMain();
		Login lg = new Login();
		print pt = new print();
		
		int ch;
		
		
		while(true) {
			
			System.out.println(pt.rogo());
			System.out.print(pt.display());
			ch = sc.nextInt();

			switch(ch) {
			case 1:
				db.joinUserDB();
				break;

			case 2:
				if(db.loginUserDB()!=null) {
					lg.Menu();
				}else {
					continue;
				}
				break;
				
			case 3:
				if(db.loginManager()==true) {
					mm.managerMain();
				}else {
					continue;
				}
				break;	
				
			case 4:
				pt.rogo();
				System.out.println(db.msgBlank+"프로그램 종료...");
				DBConn.close(); System.exit(0);
			}
		}

	}

}

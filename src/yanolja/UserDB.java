package yanolja;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class UserDB {

	Scanner sc = new Scanner(System.in);
	UserDBDAO dbdao = new UserDBDAO();
	String leftBlank="                                 ";
	String menuBlank="                 ";
    String insertBlank = leftBlank + menuBlank + "                              ▷";
    String msgBlank = leftBlank + menuBlank + "                           ▶";
    print pt = new print();
    int ch;

	public void joinUserDB() { // 회원가입

		try {
			UserDBDTO dbdto = null;
			boolean check = false;
			
			System.out.print(insertBlank+"아이디: ");
			do {	
				String id = sc.next();
				if(dbdao.dbidCheck(id)==true) { // 중복아이디 체크 (아이디는 대소문자 구별, 비밀번호는 X)
					System.out.println(msgBlank+"중복된 아이디입니다.");
					do {
						System.out.print(pt.printsr());
						ch = sc.nextInt();
						switch (ch) {
						case 1: return;
						}
					}while(ch<1||ch>1);
					check = false;
					break;
				}else {
					dbdto = new UserDBDTO();
					dbdto.setUserId(id);
					System.out.print(insertBlank+"비밀번호: ");
					dbdto.setPwd(sc.next());
					System.out.print(insertBlank+"이름: ");
					dbdto.setUserName(sc.next());
					System.out.print(insertBlank+"나이(숫자): "); // 나이가 숫자가 아니면 오류가 생김
					dbdto.setAge(sc.nextInt());
					System.out.print(insertBlank+"성별(M/W): "); // 성별 M 과 W만 입력되게 확인하는 변수 필요
					dbdto.setSex(sc.next());
					System.out.print(insertBlank+"국적: ");
					dbdto.setCountry(sc.next());
					System.out.print(insertBlank+"도시: ");
					dbdto.setCity(sc.next());
					System.out.print(insertBlank+"이메일: ");
					dbdto.setEmail(sc.next());
					System.out.print(insertBlank+"전화번호: ");
					dbdto.setTel(sc.next());
					if(dbdao.insertData(dbdto)==true) {
						System.out.println(msgBlank+"회원가입 성공");
						boolean flag = false;
						do {
							System.out.print(leftBlank + menuBlank + "                           ■아무키나 입력하세요 ");
							String str = sc.next();
							if(str!=null) {
								flag = true;
								break;
							}else {
								flag = false;
							}
						}while(flag);
						check = true;
						break;
					}else {
						System.out.println(msgBlank+"회원가입 실패");
						do {
							System.out.print(pt.printsr());
							ch = sc.nextInt();
							switch (ch) {
							case 1: return;
							}
						}while(ch<1||ch>1);
						check = false;
						break;
					}
				}
			}while(check);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public String loginUserDB() { // 로그인 (아이디는 대소문자 구별, 비밀번호는 X)

		Member.member = null; // 로그인된 아이디를 담는 변수 초기화
			
		try {
			boolean check = false; // 로그인 성공여부 확인
			do {
				System.out.print(insertBlank+"아이디: ");
				String userId = sc.next();
				System.out.print(insertBlank+"비밀번호: ");
				String pwd = sc.next();
				if(dbdao.userLoginCheck(userId, pwd)==1) {
					System.out.println(msgBlank+userId + "님이 로그인하셨습니다.");
					Member.member = userId; // 로그인에 성공 시 Member.member에 로그인 성공한 userId를 넣음
					check = true;
					boolean flag = false;
					do {
						System.out.print(leftBlank + menuBlank + "                           ■아무키나 입력하세요 ");
						String str = sc.next();
						if(str!=null) {
							flag = true;
							break;
						}else {
							flag = false;
						}
					}while(flag);
					break;
				}else if(dbdao.userLoginCheck(userId, pwd)==0) {
					System.out.println(msgBlank+"비밀번호가 잘못되었습니다.");
					do {
						System.out.print(pt.printsr());
						ch = sc.nextInt();
						switch (ch) {
						case 1: break;
						}
					}while(ch<1||ch>1);
					Member.member = null;
					check = false;
				}else {
					System.out.println(msgBlank+"존재하지 않는 아이디입니다.");
					do {
						System.out.print(pt.printsr());
						ch = sc.nextInt();
						switch (ch) {
						case 1: break;
						}
					}while(ch<1||ch>1);
					Member.member = null;
					check = false;
				}
			}while(check);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return Member.member;
	}

	public boolean loginManager() { // 매니저 로그인 (아이디는 대소문자 구별, 비밀번호는 X)

		boolean check = false;

		System.out.print(insertBlank+"관리자 아이디: ");
		String userId = sc.next();
		System.out.print(insertBlank+"비밀번호: ");
		String pwd = sc.next();
		if(dbdao.managerCheck(userId, pwd)==1) {
			System.out.println(msgBlank+"관리자님이 접속하셨습니다.");
			boolean flag = false;
			do {
				System.out.print(leftBlank + menuBlank + "                           ■아무키나 입력하세요 ");
				String str = sc.next();
				if(str!=null) {
					flag = true;
					break;
				}else {
					flag = false;
				}
			}while(flag);
			check = true;
		}else if(dbdao.managerCheck(userId, pwd)==0) {
			System.out.println(msgBlank+"비밀번호가 잘못되었습니다.");
			do {
				System.out.print(pt.printsr());
				ch = sc.nextInt();
				switch (ch) {
				case 1: break;
				}
			}while(ch<1||ch>1);
			check = false;
		}else {
			System.out.println(msgBlank+"잘못된 접근입니다!!");do {
				System.out.print(pt.printsr());
				ch = sc.nextInt();
				switch (ch) {
				case 1: break;
				}
			}while(ch<1||ch>1);
			check = false;
		}
		return check;

	}

	public void selectMyAccount() { // 내 정보 보기

		List<UserDBDTO> lists = dbdao.getList(Member.member);
		Iterator<UserDBDTO> it = lists.iterator();

		System.out.print("                       " + "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
		System.out.printf("                       " + " %10s┃%10s┃%10s┃%3s┃%2s┃%20s┃%20s┃%20s┃%20s┃%15s","ID","PWD","Name","AGE","SEX","COUNTRY","CITY","EMAIL","REGDATE","TEL");
		System.out.print("\n                       " + "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
		
		while(it.hasNext()) {
			UserDBDTO dbdto = it.next();
			System.out.printf("                       " + " %10s┃%10s┃%10s┃%3s┃%3s┃%20s┃%20s┃%20s┃%20s┃%15s",
					dbdto.getUserId(),dbdto.getPwd(),dbdto.getUserName(),dbdto.getAge(),dbdto.getSex(),dbdto.getCountry(),dbdto.getCity(),dbdto.getEmail(),dbdto.getRegDate(),dbdto.getTel());
			System.out.println();
		}
		do {
			System.out.print(pt.printsr());
			ch = sc.nextInt();
			switch (ch) {
			case 1: return;
			}
		}while(ch<1||ch>1);
	}
	
	public void updateAccount() { // 내 정보 수정

		try {
			UserDBDTO dbdto = new UserDBDTO();
			System.out.print(insertBlank+"비밀번호 변경: ");
			dbdto.setPwd(sc.next());
			System.out.print(insertBlank+"이름 변경: ");
			dbdto.setUserName(sc.next());
			System.out.print(insertBlank+"나이 변경(숫자): ");
			dbdto.setAge(sc.nextInt());
			System.out.print(insertBlank+"성별 변경(M/W): ");
			dbdto.setSex(sc.next());
			System.out.print(insertBlank+"국적 변경: ");
			dbdto.setCountry(sc.next());
			System.out.print(insertBlank+"도시 변경: ");
			dbdto.setCity(sc.next());
			System.out.print(insertBlank+"이메일 변경: ");
			dbdto.setEmail(sc.next());
			System.out.print(insertBlank+"전화번호 변경: ");
			dbdto.setTel(sc.next());
			dbdto.setUserId(Member.member);
			if(dbdao.updateData(dbdto)==true) {
				System.out.println(msgBlank+"수정 성공");
				boolean flag = false;
				do {
					System.out.print(leftBlank + menuBlank + "                           ■아무키나 입력하세요 ");
					String str = sc.next();
					if(str!=null) {
						flag = true;
						break;
					}else {
						flag = false;
					}
				}while(flag);
			}else {
				System.out.println(msgBlank+"수정 실패");
				do {
					System.out.print(pt.printsr());
					ch = sc.nextInt();
					switch (ch) {
					case 1: return;
					}
				}while(ch<1||ch>1);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
	
}
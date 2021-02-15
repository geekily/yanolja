package yanolja;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import yanolja.HotelDTO;

public class UserHistory {

	Scanner sc = new Scanner(System.in);
	UserHistoryDAO hdao = new UserHistoryDAO();
	print pt = new print();
	int ch;
	
	String leftBlank="                                 ";
	String menuBlank="                 ";
    String insertBlank = leftBlank + menuBlank + "                              ▷";
    String msgBlank = leftBlank + menuBlank + "                           ▶";
	String upBlank="\n\n\n\n\n\n\n\n\n\n";

	public void Menu() { // 예약내역 메뉴

		int ch;
		try {
			while (true) {			
				System.out.println(pt.rogo());
				System.out.print(pt.RMMenu());
				ch = sc.nextInt();
				switch (ch) {
				case 1: // 로그인된 사용자 예약내역 확인 
					viewUserHistory();
					break;
				case 2: // 예약 변경
					updateHistory();
					break;
				case 3: // 예약 취소
					deleteHistory();
					break;
				case 4: // 뒤로 가기
					return;
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void viewUserHistory() { // 로그인된 사용자 예약내역 보기

		try {
			List<UserHistoryDTO> lists = hdao.getList(Member.member);
			Iterator<UserHistoryDTO> it = lists.iterator();
			System.out.print(leftBlank+"          ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
			System.out.printf(leftBlank+"                %10s┃%10s┃%20s┃%20s┃%10s\n","USERID","HOTELNAME","CHECKIN","CHECKOUT","TOTALEXP");
			System.out.print(leftBlank+"          ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
			
			
			if(it.hasNext()!=false) {
				while(it.hasNext()) {
					UserHistoryDTO hdto = it.next();
					System.out.printf(leftBlank+"                %10s┃%10s┃%20s┃%20s┃%10s\n",hdto.getUserId(),hdto.getHotelName(),hdto.getCheckIn(),hdto.getCheckOut(),hdto.getTotalExp());
				}
				do {
					System.out.print(pt.printsr());
					ch = sc.nextInt();
					switch (ch) {
					case 1: return;
					}
				}while(ch<1||ch>1);
			}else {
				System.out.println(msgBlank+"예약내역이 없습니다.");
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
	

	public void deleteHistory() { // 예약 취소

		try {
			boolean check = false; // 아이디 체크용 변수
			do {
				System.out.print(insertBlank+"예약취소할 호텔이름: ");
				String hotelcode = hdao.getHotelCode(sc.next()); // 호텔이름 받아서 호텔코드로 반환 후 호텔이 있는지 체크
				if(hdao.checkHotel(hotelcode)==false) {
					System.out.println(msgBlank+"해당 호텔 예약내역이 없습니다.");
					do {
						System.out.print(pt.printsr());
						ch = sc.nextInt();
						switch (ch) {
						case 1: return;
						}
					}while(ch<1||ch>1);
					break;
				}else {
					System.out.print(insertBlank+"입실예정일(YYYY-MM-DD): ");
					String checkin = sc.next();
					if(hdao.checkCheckIn(hotelcode, checkin)==false) {
						System.out.println(msgBlank+"해당하는 예약건이 없습니다.");
						do {
							System.out.print(pt.printsr());
							ch = sc.nextInt();
							switch (ch) {
							case 1: return;
							}
						}while(ch<1||ch>1);
						break;
					}else {
						System.out.print(insertBlank+"퇴실예정일(YYYY-MM-DD): ");
						String checkout = sc.next();
						if(hdao.checkCheckOut(hotelcode, checkin, checkout)==false) {
							System.out.println(msgBlank+"해당하는 예약건이 없습니다.");
							do {
								System.out.print(pt.printsr());
								ch = sc.nextInt();
								switch (ch) {
								case 1: return;
								}
							}while(ch<1||ch>1);
							break;
						}else {
							String a; // 입력받은 값이 y 또는 n인지 확인하는 변수
							do {
								System.out.print(insertBlank+"정말 삭제하시겠습니까? ");
								a = sc.next();
								if(a.equalsIgnoreCase("y")) {
									if(hdao.deleteHistoryData(hotelcode,checkin,checkout)==true) {
										System.out.println(msgBlank+"삭제 성공");
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
										System.out.println(msgBlank+"삭제 실패");
										do {
											System.out.print(pt.printsr());
											ch = sc.nextInt();
											switch (ch) {
											case 1: return;
											}
										}while(ch<1||ch>1);
										check = true;								
									}
								}else if(a.equalsIgnoreCase("n")){
									System.out.println(msgBlank+"삭제를 취소하였습니다.");
									do {
										System.out.print(pt.printsr());
										ch = sc.nextInt();
										switch (ch) {
										case 1: return;
										}
									}while(ch<1||ch>1);
									break;							
								}else {
									System.out.println(msgBlank+"잘 못 입력하셨습니다.");					
								}
							}while(!a.equalsIgnoreCase("y")&&!a.equalsIgnoreCase("n"));
						}
					}
				}
				return;
			}while(check);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	/* public void updateHistory() { // 예약 변경

		try {
			HotelDTO hdto = new HotelDTO();
			System.out.println(upBlank+upBlank+upBlank+leftBlank+menuBlank+"● 예약변경할 호텔이름를 입력하세요");
			if(hdao.updateHistoryData(hdto.getHotelCode(sc.next()))==true) {
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

	} */
	
	public void updateHistory() { // 예약변경??

		try {
			HotelDTO hdto = new HotelDTO();
			System.out.println(upBlank+upBlank+upBlank+leftBlank+menuBlank+"● 예약변경할 호텔이름를 입력하세요");
			if(hdao.updateHistoryData(sc.next())==true) {
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



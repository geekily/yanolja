package yanolja;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import yanolja.HotelDTO;
import yanolja.ManagerMain;
import yanolja.print;


public class Manager {

	String leftBlank="                                 ";
	String upBlank="\n\n\n\n\n\n\n\n\n\n";
	String menuBlank="                 ";
	String insertBlank = leftBlank + menuBlank + "                              ¢¹";
	String msgBlank = leftBlank + menuBlank + "                           ¢º";
	ManagerDAO dao = new ManagerDAO();
	Scanner sc = new Scanner(System.in);
	print pt = new print();
	int ch; // µÚ·Î°¡±â ¼±ÅÃ¹ÞÀ» ¶§ ¹Þ´Â º¯¼ö

	public void printSc() { // °ü¸®ÀÚ - È£ÅÚ Á¶È¸ µð½ºÇÃ·¹ÀÌ

		int ch;

		try {
			while (true) {
				System.out.println(leftBlank+menuBlank+"¡á-¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬-¦¯");
				System.out.println(leftBlank+menuBlank+"¦­    È£ÅÚID ¦­  È£ÅÚÀÌ¸§  ¦­µî±Þ¦­   ´ëÇ¥ÀÚ   ¦­    ±¹°¡    ¦­    µµ½Ã   ¦­ ");
				System.out.println(leftBlank+menuBlank+"¦±-¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬-¦°");
				hotelPrint();
				System.out.println(leftBlank+menuBlank+" ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬");
				System.out.print(pt.printsr());
				ch = sc.nextInt();
				switch (ch) {
				case 1:
					return;
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void hotelPrint() { // ÀüÃ¼ È£ÅÚ Á¶È¸

		List<HotelDTO> lists = dao.hotelPrint();

		Iterator<HotelDTO> it = lists.iterator();

		while (it.hasNext()) {

			HotelDTO hdto = it.next();
			System.out.println(hdto.toStringG());

		}

	}

	public void hotelInsert() { // °ü¸®ÀÚ - È£ÅÚ Ãß°¡

		try {

			HotelDTO hdto = new HotelDTO();

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"¡ÜÈ£ÅÚÄÚµå ÀÔ·ÂÇÏ¼¼¿ä "+upBlank+upBlank+upBlank+upBlank);
			hdto.setHotelCode(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"¡ÜÈ£ÅÚÀÌ¸§ ÀÔ·ÂÇÏ¼¼¿ä "+upBlank+upBlank+upBlank+upBlank);
			hdto.setHotelName(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"¡ÜÈ£ÅÚµî±Þ ÀÔ·ÂÇÏ¼¼¿ä "+upBlank+upBlank+upBlank+upBlank);
			hdto.setHotelClass(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"¡Ü¿À³ÊÀÌ¸§ ÀÔ·ÂÇÏ¼¼¿ä "+upBlank+upBlank+upBlank+upBlank);
			hdto.setOwner(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"¡ÜÇØ´ç±¹°¡ ÀÔ·ÂÇÏ¼¼¿ä "+upBlank+upBlank+upBlank+upBlank);
			hdto.setCountry(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"¡ÜÇØ´çÁö¿ª ÀÔ·ÂÇÏ¼¼¿ä "+upBlank+upBlank+upBlank+upBlank);
			hdto.setCity(sc.next());

			dao.hotelInsert(hdto);


		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void hotelUpdate() { // °ü¸®ÀÚ - È£ÅÚ ¼öÁ¤

		try {

			HotelDTO hdto = new HotelDTO();

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"¡ÜÈ£ÅÚÄÚµå ÀÔ·ÂÇÏ¼¼¿ä "+upBlank+upBlank+upBlank+upBlank);
			hdto.setHotelCode(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"¡Ü¼ö)È£ÅÚÀÌ¸§ ÀÔ·ÂÇÏ¼¼¿ä "+upBlank+upBlank+upBlank+upBlank);
			hdto.setHotelName(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"¡Ü¼ö)È£ÅÚµî±Þ ÀÔ·ÂÇÏ¼¼¿ä "+upBlank+upBlank+upBlank+upBlank);
			hdto.setHotelClass(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"¡Ü¼ö)¿À³ÊÀÌ¸§ ÀÔ·ÂÇÏ¼¼¿ä "+upBlank+upBlank+upBlank+upBlank);
			hdto.setOwner(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"¡Ü¼ö)ÇØ´ç±¹°¡ ÀÔ·ÂÇÏ¼¼¿ä "+upBlank+upBlank+upBlank+upBlank);
			hdto.setCountry(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"¡Ü¼ö)ÇØ´çÁö¿ª ÀÔ·ÂÇÏ¼¼¿ä "+upBlank+upBlank+upBlank+upBlank);
			hdto.setCity(sc.next());

			dao.hotelUpdate(hdto);


		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void hotelDelete() { // °ü¸®ÀÚ - È£ÅÚ »èÁ¦

		try {

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"¡ÜÈ£ÅÚÄÚµå ÀÔ·ÂÇÏ¼¼¿ä "+upBlank+upBlank+upBlank+upBlank);
			String hotelcode = sc.next();

			dao.hotelDelete(hotelcode);


		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	//-------------È£ÅÚ·ë °ü¸®-------------------------

	public void roomPrint() { // ÀüÃ¼ È£ÅÚ¹æ º¸±â

		List<HotelDTO> lists = dao.roomPrint();

		Iterator<HotelDTO> it = lists.iterator();

		while (it.hasNext()) {

			HotelDTO hdto = it.next();

			System.out.println(hdto.toStringG());

		}

	}

	public void printRom() { // °ü¸®ÀÚ - È£ÅÚ¹æ Á¶È¸ µð½ºÇÃ·¹ÀÌ
		int ch;

		try {

			while (true) {

				do {
					System.out.println();
					System.out.println(leftBlank+menuBlank+menuBlank+"          ¡á-¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬-¦¯");
					System.out.println(leftBlank+menuBlank+menuBlank+"          ¦­  È£ÅÚID  ¦­  ¹æ ÀÌ¸§ ¦­");
					System.out.println(leftBlank+menuBlank+menuBlank+"          ¦±-¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬-¦°");
					roomPrint_ver2();
					// System.out.println(leftBlank+menuBlank+menuBlank+"          ¦±¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦°");
					System.out.print(pt.printsr());
					ch = sc.nextInt();

				} while (ch < 1 || ch > 1);

				switch (ch) {

				case 1:
					return; // µÚ·Î
				}

			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void roomPrint_ver2() { // ÀüÃ¼ È£ÅÚ¹æ Á¶È¸

		List<HotelDTO> lists = dao.roomPrint();

		Iterator<HotelDTO> it = lists.iterator();

		while (it.hasNext()) {

			HotelDTO hdto = it.next();

			System.out.println(hdto.toStringR());

		}

	}

	public void roomInsert() { // È£ÅÚ ¹æ Ãß°¡

		try {

			HotelDTO hdto = new HotelDTO();

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"¡ÜÈ£ÅÚÄÚµå ÀÔ·ÂÇÏ¼¼¿ä "+upBlank+upBlank+upBlank+upBlank);
			hdto.setHotelCode(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"¡Ü¹æÀÌ¸§ ÀÔ·ÂÇÏ¼¼¿ä "+upBlank+upBlank+upBlank+upBlank);
			hdto.setRoomName(sc.next());

			dao.roomInsert(hdto);


		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void roomUpdate() { // È£ÅÚ ¹æ ¼öÁ¤

		try {

			HotelDTO hdto = new HotelDTO();

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"¡ÜÈ£ÅÚÄÚµå ÀÔ·ÂÇÏ¼¼¿ä "+upBlank+upBlank+upBlank+upBlank);
			hdto.setHotelCode(sc.next());

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"¡Ü¼ö) ¹æÀÌ¸§ ÀÔ·ÂÇÏ¼¼¿ä "+upBlank+upBlank+upBlank+upBlank);
			hdto.setRoomName(sc.next());

			dao.roomUpdate(hdto);


		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void roomDelete() { // È£ÅÚ ¹æ »èÁ¦

		try {

			HotelDTO hdto = new HotelDTO();

			System.out.print(upBlank+upBlank+upBlank+leftBlank+menuBlank+"¡ÜÈ£ÅÚÄÚµå ÀÔ·ÂÇÏ¼¼¿ä "+upBlank+upBlank+upBlank+upBlank);
			hdto.setHotelCode(sc.next());

			System.out.println(upBlank+upBlank+upBlank+leftBlank+menuBlank+"¡Ü»èÁ¦ÇÒ ¹æÀÌ¸§ ÀÔ·ÂÇÏ¼¼¿ä "+upBlank+upBlank+upBlank+upBlank);
			hdto.setRoomName(sc.next());


			dao.roomDelete(hdto);


		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	//-----------------------------------------------------	

	ManagerDAO mdao = new ManagerDAO(); // ManagerDAO °´Ã¼ »ý¼º

	//-----------------°ü¸®ÀÚ ¿¹¾à°ü¸®---------------------

	public void viewAllHistory() { // ÀüÃ¼ »ç¿ëÀÚ ¿¹¾à³»¿ª º¸±â

		try {
			List<UserHistoryDTO> lists = mdao.getHistoryList();
			Iterator<UserHistoryDTO> it = lists.iterator();
			System.out.print(leftBlank+"               ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬\n");
			System.out.printf(leftBlank+"               %10s¦­%10s¦­%20s¦­%20s¦­%10s","USERID","HOTELCODE","CHECKIN","CHECKOUT","TOTALEXP");
			System.out.print("\n"+leftBlank+"               ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬\n");
			if(it.hasNext()!=false) {
				while(it.hasNext()) {
					UserHistoryDTO hdto = it.next();
					System.out.printf(leftBlank+"               %10s¦­%10s¦­%20s¦­%20s¦­%10s",hdto.getUserId(),hdto.getHotelCode(),hdto.getCheckIn(),hdto.getCheckOut(),hdto.getTotalExp());
					System.out.println();
				}
				do {
					System.out.print(pt.printsr());
					ch = sc.nextInt();
					switch (ch) {
					case 1: return;
					}
				}while(ch<1||ch>1);
			}else {
				System.out.println(msgBlank+"Á¶È¸µÇ´Â ¿¹¾à ³»¿ªÀÌ ¾ø½À´Ï´Ù.");
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

	public void searchHistory() { // ¾ÆÀÌµð·Î È¸¿øÀÇ ¿¹¾à³»¿ª °Ë»ö

		try {
			UserHistoryDTO hdto = null;
			boolean check = false; // È¸¿ø ÀÖ´ÂÁö È®ÀÎ¿ë º¯¼ö
			System.out.print(leftBlank+"               ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬\n");
			System.out.printf(leftBlank+"               %10s¦­%10s¦­%20s¦­%20s¦­%10s","USERID","HOTELCODE","CHECKIN","CHECKOUT","TOTALEXP");
			System.out.print("\n"+leftBlank+"               ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬\n");
			do { // ÀÖ´Â ¾ÆÀÌµðÀÎÁö Ã¼Å© ¾øÀ¸¸é ÁøÇà X
				System.out.print(insertBlank+"°Ë»öÇÒ È¸¿øID: ");
				String id = sc.next();
				if(mdao.dbidCheck(id)==false) {
					System.out.println(msgBlank+"µî·ÏµÇÁö ¾ÊÀº ¾ÆÀÌµðÀÔ´Ï´Ù.");
					do {
						System.out.print(pt.printsr());
						ch = sc.nextInt();
						switch (ch) {
						case 1: return;
						}
					}while(ch<1||ch>1);
					check = false;
				}else {
					hdto = new UserHistoryDTO();
					hdto = mdao.getHistory(id);
					System.out.printf(leftBlank+"               %10s¦­%10s¦­%20s¦­%20s¦­%10s",hdto.getUserId(),hdto.getHotelCode(),hdto.getCheckIn(),hdto.getCheckOut(),hdto.getTotalExp());
					System.out.println();
					do {
						System.out.print(pt.printsr());
						ch = sc.nextInt();
						switch (ch) {
						case 1: return;
						}
					}while(ch<1||ch>1);
					check = true;
					break;
				}
			}while(check);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void updateHistory() { // ¿¹¾à Á¤º¸ ¼öÁ¤

		try {
			UserHistoryDTO hdto = null;
			boolean check = false;
			do {
				System.out.print(insertBlank+"¼öÁ¤ÇÒ È¸¿ø ID: ");
				String id = sc.next();
				if(mdao.dbidCheck(id)==false) {
					System.out.println(msgBlank+"µî·ÏµÇÁö ¾ÊÀº ¾ÆÀÌµðÀÔ´Ï´Ù.");
					do {
						System.out.print(pt.printsr());
						ch = sc.nextInt();
						switch (ch) {
						case 1: return;
						}
					}while(ch<1||ch>1);
					check = false;
				}else {
					hdto = new UserHistoryDTO();
					System.out.print(insertBlank+"¼öÁ¤ÇÒ È£ÅÚÀÌ¸§: ");
					String hotelname = sc.next();
					System.out.print(insertBlank+"ÀÔ½Ç ³¯Â¥ ¼öÁ¤(YYYY-MM-DD): ");
					hdto.setCheckIn(sc.next());
					System.out.print(insertBlank+"Åð½Ç ³¯Â¥ ¼öÁ¤(YYYY-MM-DD): ");
					hdto.setCheckOut(sc.next());
					if(mdao.updateHistoryData(id, hotelname)==true) {
						System.out.println(msgBlank+"¼öÁ¤ ¼º°ø");
						boolean flag = false;
						do {
							System.out.print(leftBlank + menuBlank + "                           ¡á¾Æ¹«Å°³ª ÀÔ·ÂÇÏ¼¼¿ä ");
							String str = sc.next();
							if(str!=null) {
								flag = true;
								break;
							}else {
								flag = false;
							}
						}while(flag);
						check = true;
					}else {
						System.out.println(msgBlank+"¼öÁ¤ ½ÇÆÐ");
						do {
							System.out.print(pt.printsr());
							ch = sc.nextInt();
							switch (ch) {
							case 1: return;
							}
						}while(ch<1||ch>1);
						check = false;
					}
				}
			}while(check);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void deleteHistory() { // ¿¹¾à Ãë¼Ò

		try {
			boolean check = false; // ¾ÆÀÌµð Ã¼Å©¿ë º¯¼ö
			do {
				System.out.print(insertBlank+"¿¹¾àÃë¼ÒÇÒ È¸¿ø ID: ");
				String id = sc.next();
				if(mdao.dbidCheck(id)==false) {
					System.out.println(msgBlank+"µî·ÏµÇÁö ¾ÊÀº ¾ÆÀÌµðÀÔ´Ï´Ù.");
					do {
						System.out.print(pt.printsr());
						ch = sc.nextInt();
						switch (ch) {
						case 1: return;
						}
					}while(ch<1||ch>1);
					check =false;
				}else {
					System.out.print(insertBlank+"¿¹¾àÃë¼ÒÇÒ È£ÅÚÀÌ¸§: ");
					String hotelcode = mdao.getHotelCode(sc.next()); // È£ÅÚÀÌ¸§ ¹Þ¾Æ¼­ È£ÅÚÄÚµå·Î ¹ÝÈ¯ ÈÄ È£ÅÚÀÌ ÀÖ´ÂÁö Ã¼Å©
					if(mdao.checkHotel(hotelcode)==false) {
						System.out.println(msgBlank+"È£ÅÚÀÌ¸§ÀÌ Àß¸øµÆ½À´Ï´Ù."); 
						do {
							System.out.print(pt.printsr());
							ch = sc.nextInt();
							switch (ch) {
							case 1: return;
							}
						}while(ch<1||ch>1);
						break;
					}else {
						System.out.print(insertBlank+"ÀÔ½Ç¿¹Á¤ÀÏ(YYYY-MM-DD): ");
						String checkin = sc.next();
						if(mdao.checkCheckIn(hotelcode, checkin)==false) {
							System.out.println(msgBlank+"ÇØ´çÇÏ´Â ¿¹¾à°ÇÀÌ ¾ø½À´Ï´Ù.");
							do {
								System.out.print(pt.printsr());
								ch = sc.nextInt();
								switch (ch) {
								case 1: return;
								}
							}while(ch<1||ch>1);
							break;
						}else {
							System.out.print(insertBlank+"Åð½Ç¿¹Á¤ÀÏ(YYYY-MM-DD): ");
							String checkout = sc.next();
							if(mdao.checkCheckOut(hotelcode, checkin, checkout)==false) {
								System.out.println(msgBlank+"ÇØ´çÇÏ´Â ¿¹¾à°ÇÀÌ ¾ø½À´Ï´Ù.");
								do {
									System.out.print(pt.printsr());
									ch = sc.nextInt();
									switch (ch) {
									case 1: return;
									}
								}while(ch<1||ch>1);
								break;
							}else {
								String a; // ÀÔ·Â¹ÞÀº °ªÀÌ y ¶Ç´Â nÀÎÁö È®ÀÎÇÏ´Â º¯¼ö
								do {
									System.out.print(insertBlank+"Á¤¸» »èÁ¦ÇÏ½Ã°Ú½À´Ï±î? ");
									a = sc.next();
									if(a.equalsIgnoreCase("y")) {
										if(mdao.deleteHistoryData(id,hotelcode,checkin,checkout)==true) {
											System.out.println(msgBlank+"»èÁ¦ ¼º°ø");
											boolean flag = false;
											do {
												System.out.print(leftBlank + menuBlank + "                           ¡á¾Æ¹«Å°³ª ÀÔ·ÂÇÏ¼¼¿ä ");
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
											System.out.println(msgBlank+"»èÁ¦ ½ÇÆÐ");
											do {
												System.out.print(pt.printsr());
												ch = sc.nextInt();
												switch (ch) {
												case 1: return;
												}
											}while(ch<1||ch>1);
											check = true;
											break;
										}
									}else if(a.equalsIgnoreCase("n")){
										System.out.println(msgBlank+"»èÁ¦¸¦ Ãë¼ÒÇÏ¿´½À´Ï´Ù.");
										do {
											System.out.print(pt.printsr());
											ch = sc.nextInt();
											switch (ch) {
											case 1: return;
											}
										}while(ch<1||ch>1);
										break;						
									}else {
										System.out.println(msgBlank+"Àß ¸ø ÀÔ·ÂÇÏ¼Ì½À´Ï´Ù.");					
									}
								}while(!a.equalsIgnoreCase("y")&&!a.equalsIgnoreCase("n"));
							}
						}
					}
				}
			}while(check);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	//------------------°ü¸®ÀÚ È¸¿ø°ü¸®----------------------


	public void viewAllUsers() { // ÀüÃ¼ È¸¿ø º¸±â

		try {
			List<UserDBDTO> lists = mdao.getUsersList();
			Iterator<UserDBDTO> it = lists.iterator();

			System.out.print("                      " + "¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬\n");
			System.out.printf("                      " + " %10s¦­%10s¦­%10s¦­%3s¦­%2s¦­%20s¦­%20s¦­%20s¦­%20s¦­%15s","ID","PWD","Name","AGE","SEX","COUNTRY","CITY","EMAIL","REGDATE","TEL");
			System.out.print("\n                      " + "¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬\n");

			if(it.hasNext()!=false) {
				while(it.hasNext()) {
					UserDBDTO dbdto = it.next();
					System.out.printf("                      " + " %10s¦­%10s¦­%10s¦­%3s¦­%3s¦­%20s¦­%20s¦­%20s¦­%20s¦­%15s",
							dbdto.getUserId(),dbdto.getPwd(),dbdto.getUserName(),dbdto.getAge(),dbdto.getSex(),dbdto.getCountry(),dbdto.getCity(),dbdto.getEmail(),dbdto.getRegDate(),dbdto.getTel());
					System.out.println();
				}
				int ch;
				do {
					System.out.println(pt.printsr());
					ch = sc.nextInt();
					switch(ch) {
					case 1: return;
					}
				}while(ch<1||ch>1);
			}else {
				System.out.println(msgBlank+"Á¶È¸µÇ´Â È¸¿ø Á¤º¸°¡ ¾ø½À´Ï´Ù.");
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

	public void searchUser() { // ¾ÆÀÌµð·Î È¸¿ø Á¤º¸ °Ë»ö

		try {
			UserDBDTO dbdto = null;
			boolean check = false;

			System.out.print("                      " + "¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬\n");
			System.out.printf("                      " + " %10s¦­%10s¦­%10s¦­%3s¦­%2s¦­%20s¦­%20s¦­%20s¦­%20s¦­%15s","ID","PWD","Name","AGE","SEX","COUNTRY","CITY","EMAIL","REGDATE","TEL");
			System.out.print("\n                      " + "¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬\n");

			do {
				System.out.print(insertBlank+"°Ë»öÇÒ È¸¿ø ID: ");
				String id = sc.next();
				if(mdao.dbidCheck(id)==false) {
					System.out.println(msgBlank+"µî·ÏµÇÁö ¾ÊÀº ¾ÆÀÌµðÀÔ´Ï´Ù.");
					do {
						System.out.print(pt.printsr());
						ch = sc.nextInt();
						switch (ch) {
						case 1: return;
						}
					}while(ch<1||ch>1);
					check = false;
				}else {
					dbdto = new UserDBDTO();
					dbdto = mdao.getUser(id);
					System.out.printf("                      " + " %10s¦­%10s¦­%10s¦­%3s¦­%3s¦­%20s¦­%20s¦­%20s¦­%20s¦­%15s",
							dbdto.getUserId(),dbdto.getPwd(),dbdto.getUserName(),dbdto.getAge(),dbdto.getSex(),dbdto.getCountry(),dbdto.getCity(),dbdto.getEmail(),dbdto.getRegDate(),dbdto.getTel());
					System.out.println();
					do {
						System.out.print(pt.printsr());
						ch = sc.nextInt();
						switch (ch) {
						case 1: return;
						}
					}while(ch<1||ch>1);
					check = true;
					break;
				}
			}while(check);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void updateUser() { // È¸¿ø Á¤º¸ ¼öÁ¤

		try {
			UserDBDTO dbdto = null;
			boolean check = false;
			do {
				System.out.print(insertBlank+"¼öÁ¤ÇÒ È¸¿øÀÇ ID: ");
				String id = sc.next();
				if(mdao.dbidCheck(id)==false) {
					System.out.println(msgBlank+"µî·ÏµÇÁö ¾ÊÀº ¾ÆÀÌµðÀÔ´Ï´Ù.");
					do {
						System.out.print(pt.printsr());
						ch = sc.nextInt();
						switch (ch) {
						case 1: return;
						}
					}while(ch<1||ch>1);
					check = false;
				}else {
					dbdto = new UserDBDTO();
					dbdto.setUserId(id);
					System.out.print(insertBlank+"ºñ¹Ð¹øÈ£ º¯°æ: ");
					dbdto.setPwd(sc.next());
					System.out.print(insertBlank+"ÀÌ¸§ º¯°æ: ");
					dbdto.setUserName(sc.next());;
					System.out.print(insertBlank+"³ªÀÌ º¯°æ(¼ýÀÚ): ");
					dbdto.setAge(sc.nextInt());
					System.out.print(insertBlank+"¼ºº° º¯°æ(M/W): ");
					dbdto.setSex(sc.next());
					System.out.print(insertBlank+"±¹Àû º¯°æ: ");
					dbdto.setCountry(sc.next());
					System.out.print(insertBlank+"µµ½Ã º¯°æ: ");
					dbdto.setCity(sc.next());
					System.out.print(insertBlank+"ÀÌ¸ÞÀÏ º¯°æ: ");
					dbdto.setEmail(sc.next());
					System.out.print(insertBlank+"ÀüÈ­¹øÈ£ º¯°æ: ");
					dbdto.setTel(sc.next());
					if(mdao.updateUserData(dbdto)==true) {
						System.out.println(msgBlank+"¼öÁ¤ ¼º°ø");
						boolean flag = false;
						do {
							System.out.print(leftBlank + menuBlank + "                           ¡á¾Æ¹«Å°³ª ÀÔ·ÂÇÏ¼¼¿ä ");
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
						System.out.println(msgBlank+"¼öÁ¤ ½ÇÆÐ");
						do {
							System.out.print(pt.printsr());
							ch = sc.nextInt();
							switch (ch) {
							case 1: return;
							}
						}while(ch<1||ch>1);
						check = false;
					}				
				}
			}while(check);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void deleteUser() { // È¸¿ø Á¤º¸ »èÁ¦

		try {
			boolean check = false; // ¾ÆÀÌµð Ã¼Å©¿ë º¯¼ö
			do {
				System.out.print(insertBlank+"»èÁ¦ÇÒ È¸¿øÀÇ ID: ");
				String id = sc.next();
				if(mdao.dbidCheck(id)==false) {
					System.out.println(msgBlank+"µî·ÏµÇÁö ¾ÊÀº ¾ÆÀÌµðÀÔ´Ï´Ù.");
					do {
						System.out.print(pt.printsr());
						ch = sc.nextInt();
						switch (ch) {
						case 1: return;
						}
					}while(ch<1||ch>1);
					check =false;
				}else {
					String a; // ÀÔ·Â¹ÞÀº °ªÀÌ y ¶Ç´Â nÀÎÁö È®ÀÎÇÏ´Â º¯¼ö
					do {
						System.out.print(insertBlank+"Á¤¸» »èÁ¦ÇÏ½Ã°Ú½À´Ï±î? ");
						a = sc.next();
						if(a.equalsIgnoreCase("y")) {
							if(mdao.deleteUserData(id)==true) {
								System.out.println(msgBlank+"»èÁ¦ ¼º°ø");
								boolean flag = false;
								do {
									System.out.print(leftBlank + menuBlank + "                           ¡á¾Æ¹«Å°³ª ÀÔ·ÂÇÏ¼¼¿ä ");
									String str = sc.next();
									if(str!=null) {
										flag = true;
										break;
									}else {
										flag = false;
									}
								}while(flag);
								check = true;
							}else {
								System.out.println(msgBlank+"»èÁ¦ ½ÇÆÐ");
								do {
									System.out.print(pt.printsr());
									ch = sc.nextInt();
									switch (ch) {
									case 1: return;
									}
								}while(ch<1||ch>1);
								check = true;
								break;
							}
						}else if(a.equalsIgnoreCase("n")){
							System.out.println(msgBlank+"»èÁ¦¸¦ Ãë¼ÒÇÏ¿´½À´Ï´Ù.");
							do {
								System.out.print(pt.printsr());
								ch = sc.nextInt();
								switch (ch) {
								case 1: return;
								}
							}while(ch<1||ch>1);
							break;
						}else {
							System.out.println(msgBlank+"Àß ¸ø ÀÔ·ÂÇÏ¼Ì½À´Ï´Ù.");
						}
					}while(!a.equalsIgnoreCase("y")&&!a.equalsIgnoreCase("n"));
				}
			}while(check);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}

package yanolja;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import org.omg.CosNaming.NamingContextExt;

import yanolja.HotelDTO;
import yanolja.HotelReservationView;

public class HotelReservation extends Thread{

	HotelReservationView hrv=new HotelReservationView();
	String leftBlank=hrv.leftBlank;
	String answerCountry,answerCity,answerHotelName,answerRoomName;
	String hotelCode,checkIn,checkOut,price;

	public void reservation() {

		searchHotel();

	}

	//★★★국가 검색★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
	public void searchHotel() {

		Connection conn=DBConn.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Scanner sc=new Scanner(System.in);
		List<String> countryList=new ArrayList<String>();
		List<HotelDTO> listByCountry=new ArrayList<HotelDTO>();
		String sql;
		Boolean flag=true;

		try {
			//◆ 국가 검색
			hrv.blank();
			hrv.introView();
			do {
				System.out.print(leftBlank+"● 국가를 검색하세요 [예 : KOREA / USA··] : ");
				answerCountry=sc.next();

				sql="select country from hotel";
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();

				while(rs.next()) {
					countryList.add(rs.getString("country"));
				}

				for(int i=0;i<countryList.size();i++) {
					if(i<countryList.size()-1) {
						if(answerCountry.equals(countryList.get(i))) {
							flag=false;
							break;
						}
					}
					if(i==countryList.size()-1) {
						if(answerCountry.equals(countryList.get(i))) {
							flag=false;
							break;
						}else {
							hrv.blank();
							hrv.introView();
							System.out.println(leftBlank+"※ 검색 결과 : 일치하는 국가가 없습니다.\n");
							break;
						}
					}
				}
			}while(flag);

			//◆ 국가 별 출력
			hrv.blank();
			hrv.introView();
			sql="select hotelname,hotelclass,country,city from hotel where country=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, answerCountry);
			rs=pstmt.executeQuery();

			while(rs.next()) {
				HotelDTO dto=new HotelDTO();

				dto.setHotelName(rs.getString("hotelname"));
				dto.setHotelClass(rs.getString("hotelclass"));
				dto.setCountry(rs.getString("country"));
				dto.setCity(rs.getString("city"));

				listByCountry.add(dto);
			}

			hrv.hotelListView(listByCountry);
			rs.close();
			pstmt.close();
			DBConn.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		searchCity(listByCountry);
	}

	//★★★도시 검색★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
	public void searchCity(List<HotelDTO> listReturn) {

		Connection conn=DBConn.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Scanner sc=new Scanner(System.in);
		List<String> cityList=new ArrayList<String>();
		List<HotelDTO> listByCountry=listReturn;
		List<HotelDTO> listByCity=new ArrayList<HotelDTO>();
		String sql;
		Boolean flag=true;

		try {
			//◆ 도시 검색
			do {
				System.out.print(leftBlank+"● 도시를 검색하세요 [예 : SEOUL / LONDON··] : ");
				answerCity=sc.next();

				sql="select city from hotel";
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();

				while(rs.next()) {
					cityList.add(rs.getString("city"));
				}

				for(int i=0;i<cityList.size();i++) {
					if(i<cityList.size()-1) {
						if(answerCity.equals(cityList.get(i))) {
							flag=false;
							break;
						}
					}
					if(i==cityList.size()-1) {
						if(answerCity.equals(cityList.get(i))) {
							flag=false;
							break;
						}else {
							hrv.blank();
							hrv.introView();
							System.out.println(leftBlank+"※ 검색 결과 : 일치하는 도시가 없습니다.");
							hrv.hotelListView(listByCountry);
							break;
						}
					}
				}
			}while(flag);

			//◆ 도시 별 출력
			hrv.blank();
			hrv.introView();
			sql="select hotelcode,hotelname,hotelclass,country,city from hotel where city=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, answerCity);
			rs=pstmt.executeQuery();

			while(rs.next()) {
				HotelDTO dto=new HotelDTO();

				dto.setHotelCode(rs.getString("hotelcode"));
				dto.setHotelName(rs.getString("hotelname"));
				dto.setHotelClass(rs.getString("hotelclass"));
				dto.setCountry(rs.getString("country"));
				dto.setCity(rs.getString("city"));

				listByCity.add(dto);
			}
			hrv.hotelListView(listByCity);

			rs.close();
			pstmt.close();
			DBConn.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		selectHotel(listByCity);
	}

	//★★★호텔 선택★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
	public void selectHotel(List<HotelDTO> listReturn) {

		Connection conn=DBConn.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Scanner sc=new Scanner(System.in);
		List<String> hotelList=new ArrayList<String>();
		List<HotelDTO> listByCity=listReturn;
		String sql;
		Boolean flag=true;


		try {
			//◆ 호텔 선택
			do {
				System.out.print(leftBlank+"● 호텔을 선택하세요. : ");
				answerHotelName=sc.next();

				sql="select hotelcode from hotel where hotelname=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, answerHotelName);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					hotelCode=rs.getString("hotelcode");
				}

				sql="select hotelname from hotel";
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();

				while(rs.next()) {
					hotelList.add(rs.getString("hotelname"));
				}

				for(int i=0;i<hotelList.size();i++) {
					if(i<hotelList.size()-1) {
						if(answerHotelName.equals(hotelList.get(i))) {
							flag=false;
							break;
						}
					}
					if(i==hotelList.size()-1) {
						if(answerHotelName.equals(hotelList.get(i))) {
							flag=false;
							break;
						}else {
							hrv.blank();
							hrv.introView();
							System.out.println(leftBlank+"※ 선택 결과 : 일치하는 호텔이 없습니다.");
							hrv.hotelListView(listByCity);
							break;
						}
					}
				}
			}while(flag);

			rs.close();
			pstmt.close();
			DBConn.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		selectHotelRoom(answerHotelName);
	}

	//★★★호텔 객실 선택★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
	public void selectHotelRoom(String answerHotelNameReturn) {

		Connection conn=DBConn.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Scanner sc=new Scanner(System.in);
		List<String> RoomList=new ArrayList<String>();
		List<HotelDTO> listByHotelRoom=new ArrayList<HotelDTO>();
		String sql;
		Boolean flag=true;

		try {
			sql="select a.hotelname,b.roomname,b.price from hotel a,hotelroom b where a.hotelcode=b.hotelcode and a.hotelname=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, answerHotelNameReturn);
			rs=pstmt.executeQuery();

			while(rs.next()) {
				HotelDTO dto=new HotelDTO();

				RoomList.add(rs.getString("roomname"));
				dto.setHotelName(rs.getString("hotelname"));
				dto.setRoomName(rs.getString("roomname"));
				dto.setPrice(rs.getInt("price"));

				listByHotelRoom.add(dto);
			}

			hrv.blank();
			hrv.introView();
			hrv.hotelRoomListView(listByHotelRoom);
			do {
				System.out.print(leftBlank+"● 객실을 선택하세요. : ");
				answerRoomName=sc.next();

				for(int i=0;i<RoomList.size();i++) {
					if(i<RoomList.size()-1) {
						if(answerRoomName.equals(RoomList.get(i))) {
							flag=false;
							break;
						}
					}
					if(i==RoomList.size()-1) {
						if(answerRoomName.equals(RoomList.get(i))) {
							flag=false;
							break;
						}else {
							hrv.blank();
							hrv.introView();
							System.out.println(leftBlank+"※ 선택 결과 : 일치하는 객실이 없습니다.");
							hrv.hotelRoomListView(listByHotelRoom);
							break;
						}
					}
				}
			}while(flag);
			
			sql="select price from hotelroom where hotelcode=? and roomname=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, hotelCode);
			pstmt.setString(2, answerRoomName);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				price=rs.getString("price");
			}
			

			rs.close();
			pstmt.close();
			DBConn.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		selectDate(answerHotelNameReturn,answerRoomName);
	}

	//★★★입실 / 퇴실 날짜 선택★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
	public void selectDate(String answerHotelNameReturn,String answerRoomNameReturn) {

		Scanner sc=new Scanner(System.in);
		Calendar cal=Calendar.getInstance();
		List<HotelDTO> reservedList=new ArrayList<HotelDTO>();
		String hotelName=answerHotelNameReturn;
		String answer;
		boolean flag=true,flag2=false;
		int yearIn,monthIn,dayIn,yearOut,monthOut,dayOut,yearPage,monthPage,monthInLastDay,monthOutLastDay,intCheckIn,intCheckOut,totalIn,totalOut;

		class animation extends Thread{
			@Override
			public void run() {
				int i=0;
				while(i<=10) {
					System.out.print(".");
					i++;
					try {
						sleep(500);
					} catch (Exception e) {
						System.out.println(e.toString());
					}
				}
			}
		}

		//◆ 입실 년도 선택
		hrv.blank();
		hrv.introView();
		do {
			System.out.print(leftBlank+"● '"+hotelName+"'에 입실하실 년도를 입력하세요. : ");
			yearIn=sc.nextInt();
			if(yearIn<cal.get(Calendar.YEAR)) {
				hrv.blank();
				hrv.introView();
				System.out.println(leftBlank+"※ "+cal.get(Calendar.YEAR)+"년도 전은 입실이 불가능 합니다. \n");
			}else if(yearIn>cal.get(Calendar.YEAR)+2) {
				hrv.blank();
				hrv.introView();
				System.out.println(leftBlank+"※ 당일부터 최대 2년 내로만("+(cal.get(Calendar.YEAR)+2)+"년 "+(cal.get(Calendar.MONTH)+1)+"월 "+cal.get(Calendar.DATE)+"일) 예약이 가능합니다.\n");
			}
		}while((yearIn<cal.get(Calendar.YEAR))||(yearIn>cal.get(Calendar.YEAR)+2));


		//◆ 입실 월 선택
		hrv.blank();
		hrv.introView();
		do {
			System.out.println(leftBlank+"● 입실 날짜 : "+yearIn+"\n");
			System.out.print(leftBlank+"● '"+hotelName+"'에 입실하실 달을 입력하세요. : ");
			monthIn=sc.nextInt();
			System.out.println();

			if(yearIn==cal.get(Calendar.YEAR)&&monthIn<cal.get(Calendar.MONTH)+1) {
				hrv.blank();
				hrv.introView();
				System.out.println(leftBlank+"※ "+cal.get(Calendar.YEAR)+"년도 "+(cal.get(Calendar.MONTH)+1)+"월 전은 입실이 불가능 합니다. \n");
			}else if(monthIn<1||monthIn>12) {
				hrv.blank();
				hrv.introView();
				System.out.println(leftBlank+"※ 1부터 12 이하의 값을 입력 해주세요.\n");
			}else if((yearIn==cal.get(Calendar.YEAR)+2)&&(monthIn>cal.get(Calendar.MONTH)+1)) {
				hrv.blank();
				hrv.introView();
				System.out.println(leftBlank+"※ 당일부터 최대 2년 내로만("+(cal.get(Calendar.YEAR)+2)+"년 "+(cal.get(Calendar.MONTH)+1)+"월 "+cal.get(Calendar.DATE)+"일) 예약이 가능합니다.\n");
			}
		}while((monthIn<1||monthIn>12)
				||(yearIn==cal.get(Calendar.YEAR)&&monthIn<cal.get(Calendar.MONTH)+1)
				||(yearIn==cal.get(Calendar.YEAR)+2)&&(monthIn>cal.get(Calendar.MONTH)+1));

		System.out.print(leftBlank+"● '"+hotelName+"'의 "+yearIn+"년 "+monthIn+"월 입실가능 날짜를 불러오는 중 입니다");

		animation ob=new animation();
		ob.start();
		try {
			ob.join();
		} catch (Exception e) {
			System.out.println(e.toString());
		}


		//◆ 입실 일(day) 선택
		hrv.calendarView(yearIn,monthIn,answerHotelNameReturn,answerRoomNameReturn,hotelCode);

		do {
			flag2=false;
			System.out.print(leftBlank+"● '"+monthIn+"'월 중 '"+hotelName+"'에 입실하실 일(day)을 입력하세요 : ");
			dayIn=sc.nextInt();

			if((yearIn==cal.get(Calendar.YEAR)&&monthIn==cal.get(Calendar.MONTH)+1)&&(dayIn<=cal.get(Calendar.DATE))) {
				hrv.calendarView(yearIn,monthIn,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
				System.out.println(leftBlank+"※ 당일("+cal.get(Calendar.DATE)+"일) 및 지난 날짜는 선택할 수 없습니다.");
			}else if((yearIn==cal.get(Calendar.YEAR)+2)&&(monthIn==cal.get(Calendar.MONTH)+1)&&(dayIn>cal.get(Calendar.DATE))) {
				hrv.calendarView(yearIn,monthIn,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
				System.out.println(leftBlank+"※ 당일부터 최대 2년 내로만("+(cal.get(Calendar.YEAR)+2)+"년 "+(cal.get(Calendar.MONTH)+1)+"월 "+cal.get(Calendar.DATE)+"일) 예약이 가능합니다.\n");
			}

			cal.set(yearIn, monthIn-1, 1);
			monthInLastDay=cal.getActualMaximum(Calendar.DATE);

			if(dayIn<1||dayIn>monthInLastDay) {
				hrv.calendarView(yearIn,monthIn,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
				System.out.println(leftBlank+"※ '"+monthIn+"'월은 1일부터 "+monthInLastDay+"일까지 있습니다.\n");
			}

			cal=Calendar.getInstance();


			//--------중복체크------------------

			Connection conn=DBConn.getConnection();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String sql;
			String strMonthIn=null,strDayIn=null;

			if(monthIn<=9) {
				strMonthIn="0"+Integer.toString(monthIn);
			}else if(monthIn>9) {
				strMonthIn=Integer.toString(monthIn);
			}

			if(dayIn<=9) {
				strDayIn="0"+Integer.toString(dayIn);
			}else if(dayIn>9) {
				strDayIn=Integer.toString(dayIn);
			}

			totalIn=Integer.parseInt(Integer.toString(yearIn)+strMonthIn+strDayIn);

			try {
				sql="select hotelcode,roomname,checkin,checkout from reservation";
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();

				while(rs.next()) {
					HotelDTO dto=new HotelDTO();

					dto.setHotelCode(rs.getString("hotelcode"));
					dto.setRoomName(rs.getString("roomname"));
					dto.setCheckIn(rs.getString("checkin"));
					dto.setCheckOut(rs.getString("checkout"));
					reservedList.add(dto);
				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}

			Iterator<HotelDTO> it=reservedList.iterator();
			while(it.hasNext()) {
				HotelDTO dto=it.next();

				intCheckIn=Integer.parseInt(dto.getCheckIn().substring(0, 4)+dto.getCheckIn().substring(5, 7)+dto.getCheckIn().substring(8, 10));
				intCheckOut=Integer.parseInt(dto.getCheckOut().substring(0, 4)+dto.getCheckOut().substring(5, 7)+dto.getCheckOut().substring(8, 10));

				if(hotelCode.equals(dto.getHotelCode())&&answerRoomName.equals(dto.getRoomName())&&totalIn>=intCheckIn&&totalIn<=intCheckOut) {
					hrv.calendarView(yearIn,monthIn,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
					System.out.println(leftBlank+"※ 이미 예약 된 날짜 입니다.\n");
					flag2=true;
					break;
				}
			}

		}while((dayIn<1||dayIn>monthInLastDay)
				||(yearIn==cal.get(Calendar.YEAR)&&monthIn==cal.get(Calendar.MONTH)+1)&&(dayIn<=cal.get(Calendar.DATE))
				||((yearIn==cal.get(Calendar.YEAR)+2)&&(monthIn==cal.get(Calendar.MONTH)+1)&&(dayIn>cal.get(Calendar.DATE)))
				||flag2);


		//◆ 호텔 스케쥴 달력 출력 및 운용
		yearPage=yearIn;
		monthPage=monthIn;

		do {
			hrv.calendarView(yearPage,monthPage,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
			System.out.println(leftBlank+"입실 날짜 : "+yearIn+"년 "+monthIn+"월 "+dayIn+"일\n");
			System.out.print(leftBlank+"◀ 이전 달 보기 (a)    ■ 퇴실 날짜 선택 (s)    다음 달 보기 (d) ▶     입력 : ");
			answer=sc.next();

			if(answer.equals("a")||answer.equals("A")) {
				monthPage-=1;
				if(monthPage==0) {
					monthPage=12;
					yearPage-=1;
				}
				hrv.calendarView(yearPage,monthPage,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
			}else if(answer.equals("d")||answer.equals("D")) {
				monthPage+=1;
				if(monthPage==13) {
					monthPage=1;
					yearPage+=1;
				}
			}else if(answer.equals("s")||answer.equals("S")) {
				flag=false;
			}
		}while(flag);

		//◆ 퇴실 년도 선택
		hrv.calendarView(yearPage,monthPage,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
		do {
			System.out.println(leftBlank+"● 입실 날짜 : "+yearIn+"년 "+monthIn+"월 "+dayIn+"일\n");
			System.out.print(leftBlank+"● 퇴실년도를 입력하세요. : ");
			yearOut=sc.nextInt();
			if(yearOut<yearIn) {
				hrv.calendarView(yearPage,monthPage,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
				System.out.println(leftBlank+"※ 입실 날짜 이전은 입력할 수 없습니다.\n");
			}else if(yearOut>=cal.get(Calendar.YEAR)+80) {
				hrv.calendarView(yearPage,monthPage,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
				System.out.println(leftBlank+"※ "+yearOut+"년도에는 넌 이미 죽었어 새꺄\n");
			}else if((yearOut<cal.get(Calendar.YEAR)+80)&&(yearOut>(cal.get(Calendar.YEAR)+2))) {
				hrv.calendarView(yearPage,monthPage,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
				System.out.println(leftBlank+"※ 당일부터 최대 2년 내로만("+(cal.get(Calendar.YEAR)+2)+"년 "+(cal.get(Calendar.MONTH)+1)+"월 "+cal.get(Calendar.DATE)+"일) 예약이 가능합니다.\n");
			}
		}while(yearOut<yearIn||yearOut>(cal.get(Calendar.YEAR)+2));

		//◆ 퇴실 월 선택
		hrv.calendarView(yearPage,monthPage,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
		do {
			System.out.println(leftBlank+"● 입실 날짜 : "+yearIn+"년 "+monthIn+"월 "+dayIn+"일\n");
			System.out.println(leftBlank+"● 퇴실 날짜 : "+yearOut+"년\n");
			System.out.print(leftBlank+"● 퇴실하실 월을 입력하세요. : ");
			monthOut=sc.nextInt();
			if(yearOut==yearIn&&monthOut<monthIn) {
				hrv.calendarView(yearPage,monthPage,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
				System.out.println(leftBlank+"※ 입실 날짜 이전은 입력할 수 없습니다.\n");
			}else if(yearOut==(cal.get(Calendar.YEAR)+2)&&monthOut>cal.get(Calendar.MONTH)+1) {
				hrv.calendarView(yearPage,monthPage,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
				System.out.println(leftBlank+"※ 당일부터 최대 2년 내로만("+(cal.get(Calendar.YEAR)+2)+"년 "+(cal.get(Calendar.MONTH)+1)+"월 "+cal.get(Calendar.DATE)+"일) 예약이 가능합니다.\n");
			}
		}while((yearOut==yearIn&&monthOut<monthIn)
				||(yearOut==(cal.get(Calendar.YEAR)+2)&&(monthOut>cal.get(Calendar.MONTH)+1)));

		//◆ 퇴실 일(day) 선택
		hrv.calendarView(yearPage,monthPage,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
		do {
			flag2=false;
			System.out.println(leftBlank+"● 입실 날짜 : "+yearIn+"년 "+monthIn+"월 "+dayIn+"일\n");
			System.out.println(leftBlank+"● 퇴실 날짜 : "+yearOut+"년 "+monthOut+"월\n");
			System.out.print(leftBlank+"● 퇴실하실 일(day)을 입력하세요. : ");
			dayOut=sc.nextInt();
			if(yearOut==yearIn&&monthOut==monthIn&&dayOut<=dayIn) {
				hrv.calendarView(yearPage,monthPage,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
				System.out.println(leftBlank+"※ 입실 날짜 당일 및 이전은 입력할 수 없습니다.\n");
			}else if(yearOut==(cal.get(Calendar.YEAR)+2)&&(monthOut==cal.get(Calendar.MONTH)+1)&&dayOut>=cal.get(Calendar.DATE)) {
				hrv.calendarView(yearPage,monthPage,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
				System.out.println(leftBlank+"※ 당일부터 최대 2년 내로만("+(cal.get(Calendar.YEAR)+2)+"년 "+(cal.get(Calendar.MONTH)+1)+"월 "+cal.get(Calendar.DATE)+"일) 예약이 가능합니다.\n");
			}

			cal.set(yearOut, monthOut-1, 1);
			monthOutLastDay=cal.getActualMaximum(Calendar.DATE);

			if(dayOut<1||dayOut>monthOutLastDay) {
				hrv.calendarView(yearPage,monthPage,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
				System.out.println(leftBlank+"※ '"+monthOut+"'월은 1일부터 "+monthOutLastDay+"일까지 있습니다.\n");
			}

			cal=Calendar.getInstance();
			
			//--------중복체크------------------

			Connection conn=DBConn.getConnection();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String sql;
			String strMonthOut=null,strDayOut=null;

			if(monthOut<=9) {
				strMonthOut="0"+Integer.toString(monthOut);
			}else if(monthIn>9) {
				strMonthOut=Integer.toString(monthOut);
			}

			if(dayOut<=9) {
				strDayOut="0"+Integer.toString(dayOut);
			}else if(dayOut>9) {
				strDayOut=Integer.toString(dayOut);
			}

			totalOut=Integer.parseInt(Integer.toString(yearOut)+strMonthOut+strDayOut);

			try {
				sql="select hotelcode,roomname,checkin,checkout from reservation";
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();

				while(rs.next()) {
					HotelDTO dto=new HotelDTO();

					dto.setHotelCode(rs.getString("hotelcode"));
					dto.setRoomName(rs.getString("roomname"));
					dto.setCheckIn(rs.getString("checkin"));
					dto.setCheckOut(rs.getString("checkout"));
					reservedList.add(dto);
				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}

			Iterator<HotelDTO> it=reservedList.iterator();
			while(it.hasNext()) {
				HotelDTO dto=it.next();

				intCheckIn=Integer.parseInt(dto.getCheckIn().substring(0, 4)+dto.getCheckIn().substring(5, 7)+dto.getCheckIn().substring(8, 10));
				intCheckOut=Integer.parseInt(dto.getCheckOut().substring(0, 4)+dto.getCheckOut().substring(5, 7)+dto.getCheckOut().substring(8, 10));

				if(hotelCode.equals(dto.getHotelCode())&&answerRoomName.equals(dto.getRoomName())&&totalOut>=intCheckIn&&totalOut<=intCheckOut) {
					hrv.calendarView(yearPage,monthPage,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
					System.out.println(leftBlank+"※ 이미 예약 된 날짜 입니다.\n");
					flag2=true;
					break;
				}
				if(hotelCode.equals(dto.getHotelCode())&&answerRoomName.equals(dto.getRoomName())&&totalIn<intCheckIn&&totalOut>intCheckOut) {
					hrv.calendarView(yearPage,monthPage,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
					System.out.println(leftBlank+"※ 중간에 이미 예약 된 날짜가 있습니다.\n");
					flag2=true;
					break;
				}
			}

		}while((yearOut==yearIn&&monthOut==monthIn&&dayOut<=dayIn)
				||(yearOut==(cal.get(Calendar.YEAR)+2)&&(monthOut==cal.get(Calendar.MONTH)+1)&&dayOut>=cal.get(Calendar.DATE))
				||(dayOut<1||dayOut>monthOutLastDay)
				||flag2);

		checkIn=String.format("%d-%d-%d", yearIn,monthIn,dayIn);
		checkOut=String.format("%d-%d-%d", yearOut,monthOut,dayOut);

		insertData();
	}

	public void insertData() {

		Connection conn=DBConn.getConnection();
		PreparedStatement pstmt=null;
		String sql;

		try {
			sql="insert into reservation values(?,?,?,?,?,sysdate)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, Member.member);
			pstmt.setString(2, hotelCode);
			pstmt.setString(3, answerRoomName);
			pstmt.setString(4, checkIn);
			pstmt.setString(5, checkOut);
			pstmt.executeUpdate();

			sql="insert into userhistory values(?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, Member.member);
			pstmt.setString(2, hotelCode);
			pstmt.setString(3, checkIn);
			pstmt.setString(4, checkOut);
			pstmt.setString(5, price);
			pstmt.executeUpdate();

			try {
				System.out.println();
				System.out.println(leftBlank+"● 예약이 완료 됐습니다!");
				sleep(5000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			pstmt.close();
			DBConn.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}


	}

}



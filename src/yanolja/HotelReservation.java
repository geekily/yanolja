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

	//�ڡڡڱ��� �˻��ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
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
			//�� ���� �˻�
			hrv.blank();
			hrv.introView();
			do {
				System.out.print(leftBlank+"�� ������ �˻��ϼ��� [�� : KOREA / USA����] : ");
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
							System.out.println(leftBlank+"�� �˻� ��� : ��ġ�ϴ� ������ �����ϴ�.\n");
							break;
						}
					}
				}
			}while(flag);

			//�� ���� �� ���
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

	//�ڡڡڵ��� �˻��ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
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
			//�� ���� �˻�
			do {
				System.out.print(leftBlank+"�� ���ø� �˻��ϼ��� [�� : SEOUL / LONDON����] : ");
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
							System.out.println(leftBlank+"�� �˻� ��� : ��ġ�ϴ� ���ð� �����ϴ�.");
							hrv.hotelListView(listByCountry);
							break;
						}
					}
				}
			}while(flag);

			//�� ���� �� ���
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

	//�ڡڡ�ȣ�� ���áڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
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
			//�� ȣ�� ����
			do {
				System.out.print(leftBlank+"�� ȣ���� �����ϼ���. : ");
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
							System.out.println(leftBlank+"�� ���� ��� : ��ġ�ϴ� ȣ���� �����ϴ�.");
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

	//�ڡڡ�ȣ�� ���� ���áڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
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
				System.out.print(leftBlank+"�� ������ �����ϼ���. : ");
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
							System.out.println(leftBlank+"�� ���� ��� : ��ġ�ϴ� ������ �����ϴ�.");
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

	//�ڡڡ��Խ� / ��� ��¥ ���áڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
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

		//�� �Խ� �⵵ ����
		hrv.blank();
		hrv.introView();
		do {
			System.out.print(leftBlank+"�� '"+hotelName+"'�� �Խ��Ͻ� �⵵�� �Է��ϼ���. : ");
			yearIn=sc.nextInt();
			if(yearIn<cal.get(Calendar.YEAR)) {
				hrv.blank();
				hrv.introView();
				System.out.println(leftBlank+"�� "+cal.get(Calendar.YEAR)+"�⵵ ���� �Խ��� �Ұ��� �մϴ�. \n");
			}else if(yearIn>cal.get(Calendar.YEAR)+2) {
				hrv.blank();
				hrv.introView();
				System.out.println(leftBlank+"�� ���Ϻ��� �ִ� 2�� ���θ�("+(cal.get(Calendar.YEAR)+2)+"�� "+(cal.get(Calendar.MONTH)+1)+"�� "+cal.get(Calendar.DATE)+"��) ������ �����մϴ�.\n");
			}
		}while((yearIn<cal.get(Calendar.YEAR))||(yearIn>cal.get(Calendar.YEAR)+2));


		//�� �Խ� �� ����
		hrv.blank();
		hrv.introView();
		do {
			System.out.println(leftBlank+"�� �Խ� ��¥ : "+yearIn+"\n");
			System.out.print(leftBlank+"�� '"+hotelName+"'�� �Խ��Ͻ� ���� �Է��ϼ���. : ");
			monthIn=sc.nextInt();
			System.out.println();

			if(yearIn==cal.get(Calendar.YEAR)&&monthIn<cal.get(Calendar.MONTH)+1) {
				hrv.blank();
				hrv.introView();
				System.out.println(leftBlank+"�� "+cal.get(Calendar.YEAR)+"�⵵ "+(cal.get(Calendar.MONTH)+1)+"�� ���� �Խ��� �Ұ��� �մϴ�. \n");
			}else if(monthIn<1||monthIn>12) {
				hrv.blank();
				hrv.introView();
				System.out.println(leftBlank+"�� 1���� 12 ������ ���� �Է� ���ּ���.\n");
			}else if((yearIn==cal.get(Calendar.YEAR)+2)&&(monthIn>cal.get(Calendar.MONTH)+1)) {
				hrv.blank();
				hrv.introView();
				System.out.println(leftBlank+"�� ���Ϻ��� �ִ� 2�� ���θ�("+(cal.get(Calendar.YEAR)+2)+"�� "+(cal.get(Calendar.MONTH)+1)+"�� "+cal.get(Calendar.DATE)+"��) ������ �����մϴ�.\n");
			}
		}while((monthIn<1||monthIn>12)
				||(yearIn==cal.get(Calendar.YEAR)&&monthIn<cal.get(Calendar.MONTH)+1)
				||(yearIn==cal.get(Calendar.YEAR)+2)&&(monthIn>cal.get(Calendar.MONTH)+1));

		System.out.print(leftBlank+"�� '"+hotelName+"'�� "+yearIn+"�� "+monthIn+"�� �Խǰ��� ��¥�� �ҷ����� �� �Դϴ�");

		animation ob=new animation();
		ob.start();
		try {
			ob.join();
		} catch (Exception e) {
			System.out.println(e.toString());
		}


		//�� �Խ� ��(day) ����
		hrv.calendarView(yearIn,monthIn,answerHotelNameReturn,answerRoomNameReturn,hotelCode);

		do {
			flag2=false;
			System.out.print(leftBlank+"�� '"+monthIn+"'�� �� '"+hotelName+"'�� �Խ��Ͻ� ��(day)�� �Է��ϼ��� : ");
			dayIn=sc.nextInt();

			if((yearIn==cal.get(Calendar.YEAR)&&monthIn==cal.get(Calendar.MONTH)+1)&&(dayIn<=cal.get(Calendar.DATE))) {
				hrv.calendarView(yearIn,monthIn,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
				System.out.println(leftBlank+"�� ����("+cal.get(Calendar.DATE)+"��) �� ���� ��¥�� ������ �� �����ϴ�.");
			}else if((yearIn==cal.get(Calendar.YEAR)+2)&&(monthIn==cal.get(Calendar.MONTH)+1)&&(dayIn>cal.get(Calendar.DATE))) {
				hrv.calendarView(yearIn,monthIn,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
				System.out.println(leftBlank+"�� ���Ϻ��� �ִ� 2�� ���θ�("+(cal.get(Calendar.YEAR)+2)+"�� "+(cal.get(Calendar.MONTH)+1)+"�� "+cal.get(Calendar.DATE)+"��) ������ �����մϴ�.\n");
			}

			cal.set(yearIn, monthIn-1, 1);
			monthInLastDay=cal.getActualMaximum(Calendar.DATE);

			if(dayIn<1||dayIn>monthInLastDay) {
				hrv.calendarView(yearIn,monthIn,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
				System.out.println(leftBlank+"�� '"+monthIn+"'���� 1�Ϻ��� "+monthInLastDay+"�ϱ��� �ֽ��ϴ�.\n");
			}

			cal=Calendar.getInstance();


			//--------�ߺ�üũ------------------

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
					System.out.println(leftBlank+"�� �̹� ���� �� ��¥ �Դϴ�.\n");
					flag2=true;
					break;
				}
			}

		}while((dayIn<1||dayIn>monthInLastDay)
				||(yearIn==cal.get(Calendar.YEAR)&&monthIn==cal.get(Calendar.MONTH)+1)&&(dayIn<=cal.get(Calendar.DATE))
				||((yearIn==cal.get(Calendar.YEAR)+2)&&(monthIn==cal.get(Calendar.MONTH)+1)&&(dayIn>cal.get(Calendar.DATE)))
				||flag2);


		//�� ȣ�� ������ �޷� ��� �� ���
		yearPage=yearIn;
		monthPage=monthIn;

		do {
			hrv.calendarView(yearPage,monthPage,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
			System.out.println(leftBlank+"�Խ� ��¥ : "+yearIn+"�� "+monthIn+"�� "+dayIn+"��\n");
			System.out.print(leftBlank+"�� ���� �� ���� (a)    �� ��� ��¥ ���� (s)    ���� �� ���� (d) ��     �Է� : ");
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

		//�� ��� �⵵ ����
		hrv.calendarView(yearPage,monthPage,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
		do {
			System.out.println(leftBlank+"�� �Խ� ��¥ : "+yearIn+"�� "+monthIn+"�� "+dayIn+"��\n");
			System.out.print(leftBlank+"�� ��ǳ⵵�� �Է��ϼ���. : ");
			yearOut=sc.nextInt();
			if(yearOut<yearIn) {
				hrv.calendarView(yearPage,monthPage,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
				System.out.println(leftBlank+"�� �Խ� ��¥ ������ �Է��� �� �����ϴ�.\n");
			}else if(yearOut>=cal.get(Calendar.YEAR)+80) {
				hrv.calendarView(yearPage,monthPage,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
				System.out.println(leftBlank+"�� "+yearOut+"�⵵���� �� �̹� �׾��� ����\n");
			}else if((yearOut<cal.get(Calendar.YEAR)+80)&&(yearOut>(cal.get(Calendar.YEAR)+2))) {
				hrv.calendarView(yearPage,monthPage,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
				System.out.println(leftBlank+"�� ���Ϻ��� �ִ� 2�� ���θ�("+(cal.get(Calendar.YEAR)+2)+"�� "+(cal.get(Calendar.MONTH)+1)+"�� "+cal.get(Calendar.DATE)+"��) ������ �����մϴ�.\n");
			}
		}while(yearOut<yearIn||yearOut>(cal.get(Calendar.YEAR)+2));

		//�� ��� �� ����
		hrv.calendarView(yearPage,monthPage,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
		do {
			System.out.println(leftBlank+"�� �Խ� ��¥ : "+yearIn+"�� "+monthIn+"�� "+dayIn+"��\n");
			System.out.println(leftBlank+"�� ��� ��¥ : "+yearOut+"��\n");
			System.out.print(leftBlank+"�� ����Ͻ� ���� �Է��ϼ���. : ");
			monthOut=sc.nextInt();
			if(yearOut==yearIn&&monthOut<monthIn) {
				hrv.calendarView(yearPage,monthPage,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
				System.out.println(leftBlank+"�� �Խ� ��¥ ������ �Է��� �� �����ϴ�.\n");
			}else if(yearOut==(cal.get(Calendar.YEAR)+2)&&monthOut>cal.get(Calendar.MONTH)+1) {
				hrv.calendarView(yearPage,monthPage,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
				System.out.println(leftBlank+"�� ���Ϻ��� �ִ� 2�� ���θ�("+(cal.get(Calendar.YEAR)+2)+"�� "+(cal.get(Calendar.MONTH)+1)+"�� "+cal.get(Calendar.DATE)+"��) ������ �����մϴ�.\n");
			}
		}while((yearOut==yearIn&&monthOut<monthIn)
				||(yearOut==(cal.get(Calendar.YEAR)+2)&&(monthOut>cal.get(Calendar.MONTH)+1)));

		//�� ��� ��(day) ����
		hrv.calendarView(yearPage,monthPage,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
		do {
			flag2=false;
			System.out.println(leftBlank+"�� �Խ� ��¥ : "+yearIn+"�� "+monthIn+"�� "+dayIn+"��\n");
			System.out.println(leftBlank+"�� ��� ��¥ : "+yearOut+"�� "+monthOut+"��\n");
			System.out.print(leftBlank+"�� ����Ͻ� ��(day)�� �Է��ϼ���. : ");
			dayOut=sc.nextInt();
			if(yearOut==yearIn&&monthOut==monthIn&&dayOut<=dayIn) {
				hrv.calendarView(yearPage,monthPage,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
				System.out.println(leftBlank+"�� �Խ� ��¥ ���� �� ������ �Է��� �� �����ϴ�.\n");
			}else if(yearOut==(cal.get(Calendar.YEAR)+2)&&(monthOut==cal.get(Calendar.MONTH)+1)&&dayOut>=cal.get(Calendar.DATE)) {
				hrv.calendarView(yearPage,monthPage,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
				System.out.println(leftBlank+"�� ���Ϻ��� �ִ� 2�� ���θ�("+(cal.get(Calendar.YEAR)+2)+"�� "+(cal.get(Calendar.MONTH)+1)+"�� "+cal.get(Calendar.DATE)+"��) ������ �����մϴ�.\n");
			}

			cal.set(yearOut, monthOut-1, 1);
			monthOutLastDay=cal.getActualMaximum(Calendar.DATE);

			if(dayOut<1||dayOut>monthOutLastDay) {
				hrv.calendarView(yearPage,monthPage,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
				System.out.println(leftBlank+"�� '"+monthOut+"'���� 1�Ϻ��� "+monthOutLastDay+"�ϱ��� �ֽ��ϴ�.\n");
			}

			cal=Calendar.getInstance();
			
			//--------�ߺ�üũ------------------

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
					System.out.println(leftBlank+"�� �̹� ���� �� ��¥ �Դϴ�.\n");
					flag2=true;
					break;
				}
				if(hotelCode.equals(dto.getHotelCode())&&answerRoomName.equals(dto.getRoomName())&&totalIn<intCheckIn&&totalOut>intCheckOut) {
					hrv.calendarView(yearPage,monthPage,answerHotelNameReturn,answerRoomNameReturn,hotelCode);
					System.out.println(leftBlank+"�� �߰��� �̹� ���� �� ��¥�� �ֽ��ϴ�.\n");
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
				System.out.println(leftBlank+"�� ������ �Ϸ� �ƽ��ϴ�!");
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



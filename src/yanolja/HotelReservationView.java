package yanolja;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import yanolja.HotelDTO;

public class HotelReservationView {

	String leftBlank="                                 ";
	String middleBlank="         ";

	public void introView() {

		System.out.println("\n"+
				leftBlank+"﹥-收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收旬\n"+
				leftBlank+"早  __  __       _                                                                      _   _             _  早\n"+
				leftBlank+"早 |  \\/  |     | |                                                                    | | (_)           | | 早\n"+
				leftBlank+"早 | \\  / | __ _| | _____   _   _  ___  _   _ _ __   _ __ ___  ___  ___ _ ____   ____ _| |_ _  ___  _ __ | | 早\n"+
				leftBlank+"早 | |\\/| |/ _` | |/ / _ \\ | | | |/ _ \\| | | | '__| | '__/ _ \\/ __|/ _ \\ '__\\ \\ / / _` | __| |/ _ \\| '_ \\| | 早\n"+
				leftBlank+"早 | |  | | (_| |   <  __/ | |_| | (_) | |_| | |    | | |  __/\\__ \\  __/ |   \\ V / (_| | |_| | (_) | | | |_| 早\n"+
				leftBlank+"早 |_|  |_|\\__,_|_|\\_\\___|  \\__, |\\___/ \\__,_|_|    |_|  \\___||___/\\___|_|    \\_/ \\__,_|\\__|_|\\___/|_| |_(_) 早\n"+
				leftBlank+"早                           __/ |                                                                           早\n"+
				leftBlank+"早                          |___/                                                                            早\n"+
				leftBlank+"早                                                                                                           早\n"+
				leftBlank+"曲-收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收旭\n");
	}

	public void hotelListView(List<HotelDTO> list) {

		Iterator<HotelDTO> it=list.iterator();
		int num=1;

		System.out.println("\n"+leftBlank+"﹥-收有收收收收收有收收-收有收收收收收有收收收收收旬");
		System.out.printf(leftBlank+"早%3s早%10s早%7s早%10s早%10s早\n","No.","Hotel Name","Class","Country","City");
		System.out.println(leftBlank+"曳-收朱收收收收收朱收收收-朱收收收收收朱收收收收收朽");

		while(it.hasNext()) {
			HotelDTO dto=it.next();	
			System.out.printf(leftBlank+"早%3d早%10s早%1sClass早%10s早%10s早\n",num++,dto.getHotelName(),dto.getHotelClass(),dto.getCountry(),dto.getCity());
			if(it.hasNext()) {
				System.out.println(leftBlank+"曳-收朱收收收收收朱收收收-朱收收收收收朱收收收收收朽");	
			}
		}
		System.out.println(leftBlank+"曲-收朴收收收收收朴收收收-朴收收收收收朴收收收收收旭\n");
	}

	public void hotelRoomListView(List<HotelDTO> list) {

		Iterator<HotelDTO> it=list.iterator();
		int num=1;

		System.out.println("\n"+leftBlank+"﹥-收有收收收收收有收--收-旬");
		System.out.printf(leftBlank+"早%3s早%10s早%7s早\n","No.","Room Name","Price");
		System.out.println(leftBlank+"曳-收朱收收收收收朱收收收-朽");

		while(it.hasNext()) {
			HotelDTO dto=it.next();	
			System.out.printf(leftBlank+"早%3d早%10s早$%6d早\n",num++,dto.getRoomName(),dto.getPrice());
			if(it.hasNext()) {
				System.out.println(leftBlank+"曳-收朱收收收收收朱收收收-朽");	
			}
		}
		System.out.println(leftBlank+"曲-收朴收收收收收朴收收收-旭\n");
	}


	public void calendarView(int year,int month,String answerHotelNameReturn,String answerRoomNameReturn,String hotelCodeRetrun) {

		Vector<String> thisMonth=new Vector<String>();
		Vector<String> nextMonth=new Vector<String>();
		class StateVO{
			int no;
			String state;
			public int getNo() {
				return no;
			}
			public void setNo(int no) {
				this.no = no;
			}
			public String getState() {
				return state;
			}
			public void setState(String state) {
				this.state = state;
			}
		}
		Vector<StateVO> thisState=new Vector<StateVO>();
		Vector<StateVO> nextState=new Vector<StateVO>();
		List<HotelDTO> reservedList=new ArrayList<HotelDTO>();
		Calendar cal=Calendar.getInstance();
		Calendar cal2=Calendar.getInstance();
		String strThisMonth=null,strNextMonth=null;
		int week,nextYear=year;

		//﹣ 殖溘 褻濛
		cal.set(year, month-1, 1);
		week=cal.get(Calendar.DAY_OF_WEEK);
		for(int i=1;i<cal.get(Calendar.DAY_OF_WEEK);i++) {
			thisMonth.add("  ");
		}
		for(int i=1;i<=cal.getActualMaximum(Calendar.DATE);i++) {
			if(i<=9) {
				thisMonth.add("0"+Integer.toString(i));
			}else {
				thisMonth.add(Integer.toString(i));
			}
			if(thisMonth.lastElement().equals(Integer.toString(cal.getActualMaximum(Calendar.DATE)))) {
				for(int j=0;j<=15;j++) {
					thisMonth.add("  ");
				}
			}
		}

		cal.set(year, month, 1);
		week=cal.get(Calendar.DAY_OF_WEEK);
		for(int i=1;i<cal.get(Calendar.DAY_OF_WEEK);i++) {
			nextMonth.add("  ");
		}
		for(int i=1;i<=cal.getActualMaximum(Calendar.DATE);i++) {
			if(i<=9) {
				nextMonth.add("0"+Integer.toString(i));
			}else {
				nextMonth.add(Integer.toString(i));
			}
			if(nextMonth.lastElement().equals(Integer.toString(cal.getActualMaximum(Calendar.DATE)))) {
				for(int j=0;j<=15;j++) {
					nextMonth.add("  ");
				}
			}
		}

		if(month<=9) {
			strThisMonth="0"+Integer.toString(month);
		}else {
			strThisMonth=Integer.toString(month);
		}

		if(month+1<=9) {
			strNextMonth="0"+Integer.toString(month+1);
		}else {
			if(month+1<=12) {
				strNextMonth=Integer.toString(month+1);	
			}else {
				strNextMonth="0"+Integer.toString(1);
				nextYear+=1;
			}
		}

		//﹣ 錯滌 偌褒 鼻鷓 ル衛
		cal.set(year, month-1, 1);
		week=cal.get(Calendar.DAY_OF_WEEK);
		for(int i=1;i<cal.get(Calendar.DAY_OF_WEEK);i++) {
			StateVO svo=new StateVO();
			svo.setNo(0);
			svo.setState("          ");
			thisState.add(svo);
		}
		for(int i=1;i<=cal.getActualMaximum(Calendar.DATE);i++) {
			if(i<=cal.getActualMaximum(Calendar.DATE)) {
				StateVO svo=new StateVO();
				svo.setNo(i);
				svo.setState("﹥蕨擒陛棟");	
				thisState.add(svo);
			}
			if(thisState.lastElement().getNo()==cal.getActualMaximum(Calendar.DATE)) {
				for(int j=0;j<=15;j++) {
					StateVO svo=new StateVO();
					svo.setNo(0);
					svo.setState("          ");
					thisState.add(svo);
				}
			}
		}

		cal.set(year, month, 1);
		week=cal.get(Calendar.DAY_OF_WEEK);
		for(int i=1;i<cal.get(Calendar.DAY_OF_WEEK);i++) {
			StateVO svo=new StateVO();
			svo.setNo(0);
			svo.setState("          ");
			nextState.add(svo);
		}
		for(int i=1;i<=cal.getActualMaximum(Calendar.DATE);i++) {
			if(i<=cal.getActualMaximum(Calendar.DATE)) {
				StateVO svo=new StateVO();
				svo.setNo(i);
				svo.setState("﹥蕨擒陛棟");	
				nextState.add(svo);
			}
			if(nextState.lastElement().getNo()==cal.getActualMaximum(Calendar.DATE)) {
				for(int j=0;j<=15;j++) {
					StateVO svo=new StateVO();
					svo.setNo(0);
					svo.setState("          ");
					nextState.add(svo);
				}
			}
		}

		//﹣ ⑷營 陳瞼 檜瞪 嘐ル衛
				cal=Calendar.getInstance();
				cal2.set(year, month-1, 1);
				if(year<cal.get(Calendar.YEAR)||(year==cal.get(Calendar.YEAR)&&month<cal.get(Calendar.MONTH)+1)) {
					for(int i=0;i<=cal.getActualMaximum(Calendar.DATE);i++) {
						thisState.elementAt((cal2.get(Calendar.DAY_OF_WEEK)-1)+i).setState("          ");
					}
				}else if(year==cal.get(Calendar.YEAR)&&month==cal.get(Calendar.MONTH)+1){
					for(int i=0;i<=cal.get(Calendar.DATE)-1;i++) {
						thisState.elementAt((cal2.get(Calendar.DAY_OF_WEEK)-1)+i).setState("          ");
					}
				}

				cal=Calendar.getInstance();
				cal2.set(year, month, 1);
				if(nextYear<cal.get(Calendar.YEAR)||(nextYear==cal.get(Calendar.YEAR)&&Integer.parseInt(strNextMonth)<cal.get(Calendar.MONTH)+1)) {
					cal.set(nextYear, Integer.parseInt(strNextMonth)-1, 1);
					for(int i=0;i<=cal.getActualMaximum(Calendar.DATE);i++) {
						nextState.elementAt((cal2.get(Calendar.DAY_OF_WEEK)-1)+i).setState("          ");
					}
				}else if(nextYear==cal.get(Calendar.YEAR)&&Integer.parseInt(strNextMonth)==cal.get(Calendar.MONTH)+1){
					for(int i=0;i<=cal.get(Calendar.DATE)-1;i++) {
						nextState.elementAt((cal2.get(Calendar.DAY_OF_WEEK)-1)+i).setState("          ");
					}
				}

		//﹣ 2喇 �� 鼻鷓 嘐ル衛
		cal=Calendar.getInstance();
		if(year>cal.get(Calendar.YEAR)+2||(year==cal.get(Calendar.YEAR)+2&&month>cal.get(Calendar.MONTH)+1)) {
			cal.set(year, month-1, 1);
			for(int i=0;i<cal.getActualMaximum(Calendar.DATE);i++) {
				thisState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-1)+i).setState("          ");
			}
		}else if(year==cal.get(Calendar.YEAR)+2&&month==cal.get(Calendar.MONTH)+1){
			for(int i=0;i<=cal.getActualMaximum(Calendar.DATE)-1;i++) {
				thisState.elementAt((cal.get(Calendar.DAY_OF_WEEK))+cal.get(Calendar.DATE)+i).setState("          ");
			}
		}

		cal=Calendar.getInstance();
		if(nextYear>cal.get(Calendar.YEAR)+2||(nextYear==cal.get(Calendar.YEAR)+2&&Integer.parseInt(strNextMonth)>cal.get(Calendar.MONTH)+1)) {
			cal.set(nextYear, Integer.parseInt(strNextMonth)-1, 1);
			for(int i=0;i<cal.getActualMaximum(Calendar.DATE);i++) {
				nextState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-1)+i).setState("          ");
			}
		}else if(nextYear==cal.get(Calendar.YEAR)+2&&Integer.parseInt(strNextMonth)==cal.get(Calendar.MONTH)+1){
			for(int i=0;i<=cal.getActualMaximum(Calendar.DATE)-1;i++) {
				nextState.elementAt((cal.get(Calendar.DAY_OF_WEEK))+cal.get(Calendar.DATE)+i).setState("          ");
			}
		}

		//﹣ 蕨擒脹 偌褒 ル衛 滲唳
		Connection conn=DBConn.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql;
		int intCheckIn,intCheckOut;

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

			Iterator<HotelDTO> it=reservedList.iterator();
			while(it.hasNext()) {
				HotelDTO dto=it.next();

				intCheckIn=Integer.parseInt(dto.getCheckIn().substring(0, 4)+dto.getCheckIn().substring(5, 7)+dto.getCheckIn().substring(8, 10));
				intCheckOut=Integer.parseInt(dto.getCheckOut().substring(0, 4)+dto.getCheckOut().substring(5, 7)+dto.getCheckOut().substring(8, 10));

				cal.set(year, month-1, 1);
				//this殖溘 : и п縑 羹觼檣婁 羹觼嬴醒檜 氈堅, 轎溘 醞檣 殖縑 羹觼檣婁 羹觼嬴醒檜 氈擊 陽.
				if(hotelCodeRetrun.equals(dto.getHotelCode())
						&&answerRoomNameReturn.equals(dto.getRoomName())
						&&year==Integer.parseInt(dto.getCheckIn().substring(0, 4))
						&&year==Integer.parseInt(dto.getCheckOut().substring(0, 4))
						&&month==Integer.parseInt(dto.getCheckIn().substring(5, 7))
						&&month==Integer.parseInt(dto.getCheckOut().substring(5, 7))) {
					for(int i=Integer.parseInt(dto.getCheckIn().substring(8, 10))-1;i<=Integer.parseInt(dto.getCheckOut().substring(8, 10));i++) {
						thisState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-1)+i).setState("﹤衙霞    ");
					}
				}
				
				//this殖溘 : и п縑 羹觼檣婁 羹觼嬴醒檜 氈堅, 轎溘 醞檣 殖縑 羹觼檣檜 氈擊 陽.
				if(hotelCodeRetrun.equals(dto.getHotelCode())
						&&answerRoomNameReturn.equals(dto.getRoomName())
						&&year==Integer.parseInt(dto.getCheckIn().substring(0, 4))
						&&year==Integer.parseInt(dto.getCheckOut().substring(0, 4))
						&&month==Integer.parseInt(dto.getCheckIn().substring(5, 7))
						&&month<Integer.parseInt(dto.getCheckOut().substring(5, 7))) {
					for(int i=Integer.parseInt(dto.getCheckIn().substring(8, 10))-1;i<cal.getActualMaximum(Calendar.DATE);i++) {
						thisState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-1)+i).setState("﹤衙霞    ");
					}
				}
				
				//this殖溘 : и п縑 羹觼檣婁 羹觼嬴醒檜 氈堅, 轎溘 醞檣 殖縑 羹觼嬴醒檜 氈擊 陽.
				if(hotelCodeRetrun.equals(dto.getHotelCode())
						&&answerRoomNameReturn.equals(dto.getRoomName())
						&&year==Integer.parseInt(dto.getCheckIn().substring(0, 4))
						&&year==Integer.parseInt(dto.getCheckOut().substring(0, 4))
						&&month!=Integer.parseInt(dto.getCheckIn().substring(5, 7))
						&&month==Integer.parseInt(dto.getCheckOut().substring(5, 7))) {
					for(int i=0;i<Integer.parseInt(dto.getCheckOut().substring(8, 10));i++) {
						thisState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-1)+i).setState("﹤衙霞    ");
					}
				}
				
				//this殖溘 : и п縑 羹觼檣婁 羹觼嬴醒檜 氈堅, 轎溘 醞檣 殖檜 羹觼檣婁 羹觼嬴醒 餌檜縑 氈擊 陽.
				if(hotelCodeRetrun.equals(dto.getHotelCode())
						&&answerRoomNameReturn.equals(dto.getRoomName())
						&&year==Integer.parseInt(dto.getCheckIn().substring(0, 4))
						&&year==Integer.parseInt(dto.getCheckOut().substring(0, 4))
						&&month>Integer.parseInt(dto.getCheckIn().substring(5, 7))
						&&month<Integer.parseInt(dto.getCheckOut().substring(5, 7))) {
					for(int i=0;i<=cal.getActualMaximum(Calendar.DATE);i++) {
						thisState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-1)+i).setState("﹤衙霞    ");
					}
				}

				//this殖溘 : и п縑 羹觼檣檜 氈堅 棻擠п縑 羹觼嬴醒檜 氈朝 鼻鷓縑憮, 轎溘 醞檣 殖檜 羹觼檣曖 п縑 п渡ж賊憮 羹觼檣檜 氈擊 陽.
				if(hotelCodeRetrun.equals(dto.getHotelCode())
						&&answerRoomNameReturn.equals(dto.getRoomName())
						&&year==Integer.parseInt(dto.getCheckIn().substring(0, 4))
						&&year<Integer.parseInt(dto.getCheckOut().substring(0, 4))
						&&month==Integer.parseInt(dto.getCheckIn().substring(5, 7))) {
					for(int i=Integer.parseInt(dto.getCheckIn().substring(8, 10));i<=cal.getActualMaximum(Calendar.DATE);i++) {
						thisState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-2)+i).setState("﹤衙霞    ");
					
					}
				}

				//this殖溘 : и п縑 羹觼檣檜 氈堅 棻擠п縑 羹觼嬴醒檜 氈朝 鼻鷓縑憮, 轎溘 醞檣 殖檜 羹觼檣曖 п縑 п渡ж賊憮 羹觼檣婁 羹觼嬴醒 餌檜縑 氈擊 陽.
				if(hotelCodeRetrun.equals(dto.getHotelCode())
						&&answerRoomNameReturn.equals(dto.getRoomName())
						&&year==Integer.parseInt(dto.getCheckIn().substring(0, 4))
						&&year<Integer.parseInt(dto.getCheckOut().substring(0, 4))
						&&month>Integer.parseInt(dto.getCheckIn().substring(5, 7))) {
					for(int i=0;i<cal.getActualMaximum(Calendar.DATE);i++) {
						thisState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-1)+i).setState("﹤衙霞    ");
					}
				}
				
				//this殖溘 : и п縑 羹觼檣檜 氈堅 棻擠п縑 羹觼嬴醒檜 氈朝 鼻鷓縑憮, 轎溘 醞檣 殖檜 羹觼嬴醒曖 п縑 п渡ж賊憮 羹觼檣婁 羹觼嬴醒 餌檜縑 氈擊 陽.
				if(hotelCodeRetrun.equals(dto.getHotelCode())
						&&answerRoomNameReturn.equals(dto.getRoomName())
						&&year>Integer.parseInt(dto.getCheckIn().substring(0, 4))
						&&year==Integer.parseInt(dto.getCheckOut().substring(0, 4))
						&&month<Integer.parseInt(dto.getCheckOut().substring(5, 7))) {
					for(int i=0;i<cal.getActualMaximum(Calendar.DATE);i++) {
						thisState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-1)+i).setState("﹤衙霞    ");
					}
				}
				
				//this殖溘 : и п縑 羹觼檣檜 氈堅 棻擠п縑 羹觼嬴醒檜 氈朝 鼻鷓縑憮, 轎溘 醞檣 殖檜 羹觼嬴醒曖 п縑 п渡ж賊憮 羹觼嬴醒檜 氈擊 陽.
				if(hotelCodeRetrun.equals(dto.getHotelCode())
						&&answerRoomNameReturn.equals(dto.getRoomName())
						&&year>Integer.parseInt(dto.getCheckIn().substring(0, 4))
						&&year==Integer.parseInt(dto.getCheckOut().substring(0, 4))
						&&month==Integer.parseInt(dto.getCheckOut().substring(5, 7))) {
					for(int i=0;i<Integer.parseInt(dto.getCheckOut().substring(8, 10));i++) {
						thisState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-1)+i).setState("﹤衙霞    ");
					}
				}

				cal.set(year, month, 1);
				//next殖溘 : и п縑 羹觼檣婁 羹觼嬴醒檜 氈堅, 轎溘 醞檣 殖縑 羹觼檣婁 羹觼嬴醒檜 氈擊 陽.
				if(hotelCodeRetrun.equals(dto.getHotelCode())
						&&answerRoomNameReturn.equals(dto.getRoomName())
						&&nextYear==Integer.parseInt(dto.getCheckIn().substring(0, 4))
						&&nextYear==Integer.parseInt(dto.getCheckOut().substring(0, 4))
						&&Integer.parseInt(strNextMonth)==Integer.parseInt(dto.getCheckIn().substring(5, 7))
						&&Integer.parseInt(strNextMonth)==Integer.parseInt(dto.getCheckOut().substring(5, 7))) {
					for(int i=Integer.parseInt(dto.getCheckIn().substring(8, 10))-1;i<=Integer.parseInt(dto.getCheckOut().substring(8, 10));i++) {
						nextState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-1)+i).setState("﹤衙霞    ");
					}
				}
				
				//next殖溘 : и п縑 羹觼檣婁 羹觼嬴醒檜 氈堅, 轎溘 醞檣 殖縑 羹觼檣檜 氈擊 陽.
				if(hotelCodeRetrun.equals(dto.getHotelCode())
						&&answerRoomNameReturn.equals(dto.getRoomName())
						&&nextYear==Integer.parseInt(dto.getCheckIn().substring(0, 4))
						&&nextYear==Integer.parseInt(dto.getCheckOut().substring(0, 4))
						&&Integer.parseInt(strNextMonth)==Integer.parseInt(dto.getCheckIn().substring(5, 7))
						&&Integer.parseInt(strNextMonth)<Integer.parseInt(dto.getCheckOut().substring(5, 7))) {
					for(int i=Integer.parseInt(dto.getCheckIn().substring(8, 10))-1;i<cal.getActualMaximum(Calendar.DATE);i++) {
						nextState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-1)+i).setState("﹤衙霞    ");
					}
				}
				
				//next殖溘 : и п縑 羹觼檣婁 羹觼嬴醒檜 氈堅, 轎溘 醞檣 殖縑 羹觼嬴醒檜 氈擊 陽.
				if(hotelCodeRetrun.equals(dto.getHotelCode())
						&&answerRoomNameReturn.equals(dto.getRoomName())
						&&nextYear==Integer.parseInt(dto.getCheckIn().substring(0, 4))
						&&nextYear==Integer.parseInt(dto.getCheckOut().substring(0, 4))
						&&Integer.parseInt(strNextMonth)!=Integer.parseInt(dto.getCheckIn().substring(5, 7))
						&&Integer.parseInt(strNextMonth)==Integer.parseInt(dto.getCheckOut().substring(5, 7))) {
					for(int i=0;i<Integer.parseInt(dto.getCheckOut().substring(8, 10));i++) {
						nextState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-1)+i).setState("﹤衙霞    ");
					}
				}
				
				//next殖溘 : и п縑 羹觼檣婁 羹觼嬴醒檜 氈堅, 轎溘 醞檣 殖檜 羹觼檣婁 羹觼嬴醒 餌檜縑 氈擊 陽.
				if(hotelCodeRetrun.equals(dto.getHotelCode())
						&&answerRoomNameReturn.equals(dto.getRoomName())
						&&nextYear==Integer.parseInt(dto.getCheckIn().substring(0, 4))
						&&nextYear==Integer.parseInt(dto.getCheckOut().substring(0, 4))
						&&Integer.parseInt(strNextMonth)>Integer.parseInt(dto.getCheckIn().substring(5, 7))
						&&Integer.parseInt(strNextMonth)<Integer.parseInt(dto.getCheckOut().substring(5, 7))) {
					for(int i=0;i<=cal.getActualMaximum(Calendar.DATE);i++) {
						nextState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-1)+i).setState("﹤衙霞    ");
					}
				}

				//next殖溘 : и п縑 羹觼檣檜 氈堅 棻擠п縑 羹觼嬴醒檜 氈朝 鼻鷓縑憮, 轎溘 醞檣 殖檜 羹觼檣曖 п縑 п渡ж賊憮 羹觼檣檜 氈擊 陽.
				if(hotelCodeRetrun.equals(dto.getHotelCode())
						&&answerRoomNameReturn.equals(dto.getRoomName())
						&&nextYear==Integer.parseInt(dto.getCheckIn().substring(0, 4))
						&&nextYear<Integer.parseInt(dto.getCheckOut().substring(0, 4))
						&&Integer.parseInt(strNextMonth)==Integer.parseInt(dto.getCheckIn().substring(5, 7))) {
					for(int i=Integer.parseInt(dto.getCheckIn().substring(8, 10));i<=cal.getActualMaximum(Calendar.DATE);i++) {
						nextState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-2)+i).setState("﹤衙霞    ");
					
					}
				}

				//next殖溘 : и п縑 羹觼檣檜 氈堅 棻擠п縑 羹觼嬴醒檜 氈朝 鼻鷓縑憮, 轎溘 醞檣 殖檜 羹觼檣曖 п縑 п渡ж賊憮 羹觼檣婁 羹觼嬴醒 餌檜縑 氈擊 陽.
				if(hotelCodeRetrun.equals(dto.getHotelCode())
						&&answerRoomNameReturn.equals(dto.getRoomName())
						&&nextYear==Integer.parseInt(dto.getCheckIn().substring(0, 4))
						&&nextYear<Integer.parseInt(dto.getCheckOut().substring(0, 4))
						&&Integer.parseInt(strNextMonth)>Integer.parseInt(dto.getCheckIn().substring(5, 7))) {
					for(int i=0;i<cal.getActualMaximum(Calendar.DATE);i++) {
						nextState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-1)+i).setState("﹤衙霞    ");
					}
				}
				
				//next殖溘 : и п縑 羹觼檣檜 氈堅 棻擠п縑 羹觼嬴醒檜 氈朝 鼻鷓縑憮, 轎溘 醞檣 殖檜 羹觼嬴醒曖 п縑 п渡ж賊憮 羹觼檣婁 羹觼嬴醒 餌檜縑 氈擊 陽.
				if(hotelCodeRetrun.equals(dto.getHotelCode())
						&&answerRoomNameReturn.equals(dto.getRoomName())
						&&nextYear>Integer.parseInt(dto.getCheckIn().substring(0, 4))
						&&nextYear==Integer.parseInt(dto.getCheckOut().substring(0, 4))
						&&Integer.parseInt(strNextMonth)<Integer.parseInt(dto.getCheckOut().substring(5, 7))) {
					for(int i=0;i<cal.getActualMaximum(Calendar.DATE);i++) {
						nextState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-1)+i).setState("﹤衙霞    ");
					}
				}
				
				//next殖溘 : и п縑 羹觼檣檜 氈堅 棻擠п縑 羹觼嬴醒檜 氈朝 鼻鷓縑憮, 轎溘 醞檣 殖檜 羹觼嬴醒曖 п縑 п渡ж賊憮 羹觼嬴醒檜 氈擊 陽.
				if(hotelCodeRetrun.equals(dto.getHotelCode())
						&&answerRoomNameReturn.equals(dto.getRoomName())
						&&nextYear>Integer.parseInt(dto.getCheckIn().substring(0, 4))
						&&nextYear==Integer.parseInt(dto.getCheckOut().substring(0, 4))
						&&Integer.parseInt(strNextMonth)==Integer.parseInt(dto.getCheckOut().substring(5, 7))) {
					for(int i=0;i<Integer.parseInt(dto.getCheckOut().substring(8, 10));i++) {
						nextState.elementAt((cal.get(Calendar.DAY_OF_WEEK)-1)+i).setState("﹤衙霞    ");
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n"+
				leftBlank+"Ⅱ "+answerHotelNameReturn+" / "+answerRoomNameReturn+" Calendar"+"\n"+
				leftBlank+"﹥-收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收旬"+middleBlank+"﹥-收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收旬\n"+
				leftBlank+"早      _    _       _       _                                      _   _                  早"+middleBlank+"早      _    _       _       _                                      _   _                  早\n"+
				leftBlank+"早     | |  | |     | |     | |                                    | | (_)                 早"+middleBlank+"早     | |  | |     | |     | |                                    | | (_)                 早\n"+
				leftBlank+"早     | |__| | ___ | |_ ___| |  _ __ ___  ___  ___ _ ____   ____ _| |_ _  ___  _ __       早"+middleBlank+"早     | |__| | ___ | |_ ___| |  _ __ ___  ___  ___ _ ____   ____ _| |_ _  ___  _ __       早\n"+
				leftBlank+"早     |  __  |/ _ \\| __/ _ \\ | | '__/ _ \\/ __|/ _ \\ '__\\ \\ / / _` | __| |/ _ \\| '_ \\      早"+middleBlank+"早     |  __  |/ _ \\| __/ _ \\ | | '__/ _ \\/ __|/ _ \\ '__\\ \\ / / _` | __| |/ _ \\| '_ \\      早\n"+
				leftBlank+"早     | |  | | (_) | ||  __/ | | | |  __/\\__ \\  __/ |   \\ V / (_| | |_| | (_) | | | |     早"+middleBlank+"早     | |  | | (_) | ||  __/ | | | |  __/\\__ \\  __/ |   \\ V / (_| | |_| | (_) | | | |     早\n"+
				leftBlank+"早     |_|  |_|\\___/ \\__\\___|_| |_|  \\___||___/\\___|_|    \\_/ \\__,_|\\__|_|\\___/|_| |_|     早"+middleBlank+"早     |_|  |_|\\___/ \\__\\___|_| |_|  \\___||___/\\___|_|    \\_/ \\__,_|\\__|_|\\___/|_| |_|     早\n"+
				leftBlank+"早                                                                                         早"+middleBlank+"早                                                                                         早\n"+
				leftBlank+"早                                                                                         早"+middleBlank+"早                                                                                         早\n"+
				leftBlank+"曳-收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收朽"+middleBlank+"曳-收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收朽\n"+
				leftBlank+"早"+year+" / "+strThisMonth+"                                                                                早"+middleBlank+"早"+nextYear+" / "+strNextMonth+"                                                                                早\n"+
				leftBlank+"曳-收收收收收有收收-收收收有收收收收收-有收收收收收-有收收收收收-有收收收收收-有收收收收收-朽"+middleBlank+"曳-收收收收收有收收-收收收有收收收收收-有收收收收收-有收收收收收-有收收收收收-有收收收收收-朽\n"+
				leftBlank+"早    SUN    早    MON    早    TUS    早    WED    早    THU    早    FRI    早    SAT    早"+middleBlank+"早    SUN    早    MON    早    TUS    早    WED    早    THU    早    FRI    早    SAT    早\n"+
				leftBlank+"曳-收收收收收朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朽"+middleBlank+"曳-收收收收收朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朽\n"+
				leftBlank+"早"+thisMonth.get(0)+"         早"+thisMonth.get(1)+"         早"+thisMonth.get(2)+"         早"+thisMonth.get(3)+"         早"+thisMonth.get(4)+"         早"+thisMonth.get(5)+"         早"+thisMonth.get(6)+"         早"+middleBlank+"早"+nextMonth.get(0)+"         早"+nextMonth.get(1)+"         早"+nextMonth.get(2)+"         早"+nextMonth.get(3)+"         早"+nextMonth.get(4)+"         早"+nextMonth.get(5)+"         早"+nextMonth.get(6)+"         早\n"+
				leftBlank+"早"+thisState.elementAt(0).getState()+" 早"+thisState.elementAt(1).getState()+" 早"+thisState.elementAt(2).getState()+" 早"+thisState.elementAt(3).getState()+" 早"+thisState.elementAt(4).getState()+" 早"+thisState.elementAt(5).getState()+" 早"+thisState.elementAt(6).getState()+" 早"+middleBlank+"早"+nextState.elementAt(0).getState()+" 早"+nextState.elementAt(1).getState()+" 早"+nextState.elementAt(2).getState()+" 早"+nextState.elementAt(3).getState()+" 早"+nextState.elementAt(4).getState()+" 早"+nextState.elementAt(5).getState()+" 早"+nextState.elementAt(6).getState()+" 早\n"+
				leftBlank+"曳-收收收收收朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朽"+middleBlank+"曳-收收收收收朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朽\n"+
				leftBlank+"早"+thisMonth.get(7)+"         早"+thisMonth.get(8)+"         早"+thisMonth.get(9)+"         早"+thisMonth.get(10)+"         早"+thisMonth.get(11)+"         早"+thisMonth.get(12)+"         早"+thisMonth.get(13)+"         早"+middleBlank+"早"+nextMonth.get(7)+"         早"+nextMonth.get(8)+"         早"+nextMonth.get(9)+"         早"+nextMonth.get(10)+"         早"+nextMonth.get(11)+"         早"+nextMonth.get(12)+"         早"+nextMonth.get(13)+"         早\n"+
				leftBlank+"早"+thisState.elementAt(7).getState()+" 早"+thisState.elementAt(8).getState()+" 早"+thisState.elementAt(9).getState()+" 早"+thisState.elementAt(10).getState()+" 早"+thisState.elementAt(11).getState()+" 早"+thisState.elementAt(12).getState()+" 早"+thisState.elementAt(13).getState()+" 早"+middleBlank+"早"+nextState.elementAt(7).getState()+" 早"+nextState.elementAt(8).getState()+" 早"+nextState.elementAt(9).getState()+" 早"+nextState.elementAt(10).getState()+" 早"+nextState.elementAt(11).getState()+" 早"+nextState.elementAt(12).getState()+" 早"+nextState.elementAt(13).getState()+" 早\n"+
				leftBlank+"曳-收收收收收朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朽"+middleBlank+"曳-收收收收收朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朽\n"+
				leftBlank+"早"+thisMonth.get(14)+"         早"+thisMonth.get(15)+"         早"+thisMonth.get(16)+"         早"+thisMonth.get(17)+"         早"+thisMonth.get(18)+"         早"+thisMonth.get(19)+"         早"+thisMonth.get(20)+"         早"+middleBlank+"早"+nextMonth.get(14)+"         早"+nextMonth.get(15)+"         早"+nextMonth.get(16)+"         早"+nextMonth.get(17)+"         早"+nextMonth.get(18)+"         早"+nextMonth.get(19)+"         早"+nextMonth.get(20)+"         早\n"+
				leftBlank+"早"+thisState.elementAt(14).getState()+" 早"+thisState.elementAt(15).getState()+" 早"+thisState.elementAt(16).getState()+" 早"+thisState.elementAt(17).getState()+" 早"+thisState.elementAt(18).getState()+" 早"+thisState.elementAt(19).getState()+" 早"+thisState.elementAt(20).getState()+" 早"+middleBlank+"早"+nextState.elementAt(14).getState()+" 早"+nextState.elementAt(15).getState()+" 早"+nextState.elementAt(16).getState()+" 早"+nextState.elementAt(17).getState()+" 早"+nextState.elementAt(18).getState()+" 早"+nextState.elementAt(19).getState()+" 早"+nextState.elementAt(20).getState()+" 早\n"+
				leftBlank+"曳-收收收收收朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朽"+middleBlank+"曳-收收收收收朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朽\n"+
				leftBlank+"早"+thisMonth.get(21)+"         早"+thisMonth.get(22)+"         早"+thisMonth.get(23)+"         早"+thisMonth.get(24)+"         早"+thisMonth.get(25)+"         早"+thisMonth.get(26)+"         早"+thisMonth.get(27)+"         早"+middleBlank+"早"+nextMonth.get(21)+"         早"+nextMonth.get(22)+"         早"+nextMonth.get(23)+"         早"+nextMonth.get(24)+"         早"+nextMonth.get(25)+"         早"+nextMonth.get(26)+"         早"+nextMonth.get(27)+"         早\n"+
				leftBlank+"早"+thisState.elementAt(21).getState()+" 早"+thisState.elementAt(22).getState()+" 早"+thisState.elementAt(23).getState()+" 早"+thisState.elementAt(24).getState()+" 早"+thisState.elementAt(25).getState()+" 早"+thisState.elementAt(26).getState()+" 早"+thisState.elementAt(27).getState()+" 早"+middleBlank+"早"+nextState.elementAt(21).getState()+" 早"+nextState.elementAt(22).getState()+" 早"+nextState.elementAt(23).getState()+" 早"+nextState.elementAt(24).getState()+" 早"+nextState.elementAt(25).getState()+" 早"+nextState.elementAt(26).getState()+" 早"+nextState.elementAt(27).getState()+" 早\n"+
				leftBlank+"曳-收收收收收朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朽"+middleBlank+"曳-收收收收收朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朽\n"+
				leftBlank+"早"+thisMonth.get(28)+"         早"+thisMonth.get(29)+"         早"+thisMonth.get(30)+"         早"+thisMonth.get(31)+"         早"+thisMonth.get(32)+"         早"+thisMonth.get(33)+"         早"+thisMonth.get(34)+"         早"+middleBlank+"早"+nextMonth.get(28)+"         早"+nextMonth.get(29)+"         早"+nextMonth.get(30)+"         早"+nextMonth.get(31)+"         早"+nextMonth.get(32)+"         早"+nextMonth.get(33)+"         早"+nextMonth.get(34)+"         早\n"+
				leftBlank+"早"+thisState.elementAt(28).getState()+" 早"+thisState.elementAt(29).getState()+" 早"+thisState.elementAt(30).getState()+" 早"+thisState.elementAt(31).getState()+" 早"+thisState.elementAt(32).getState()+" 早"+thisState.elementAt(33).getState()+" 早"+thisState.elementAt(34).getState()+" 早"+middleBlank+"早"+nextState.elementAt(28).getState()+" 早"+nextState.elementAt(29).getState()+" 早"+nextState.elementAt(30).getState()+" 早"+nextState.elementAt(31).getState()+" 早"+nextState.elementAt(32).getState()+" 早"+nextState.elementAt(33).getState()+" 早"+nextState.elementAt(34).getState()+" 早\n"+
				leftBlank+"曳-收收收收收朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朽"+middleBlank+"曳-收收收收收朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朱收收收收收-朽\n"+
				leftBlank+"早"+thisMonth.get(35)+"         早"+thisMonth.get(36)+"         早"+thisMonth.get(37)+"         早"+thisMonth.get(38)+"         早"+thisMonth.get(39)+"         早"+thisMonth.get(40)+"         早"+thisMonth.get(41)+"         早"+middleBlank+"早"+nextMonth.get(35)+"         早"+nextMonth.get(36)+"         早"+nextMonth.get(37)+"         早"+nextMonth.get(38)+"         早"+nextMonth.get(39)+"         早"+nextMonth.get(40)+"         早"+nextMonth.get(41)+"         早\n"+
				leftBlank+"早"+thisState.elementAt(35).getState()+" 早"+thisState.elementAt(36).getState()+" 早"+thisState.elementAt(37).getState()+" 早"+thisState.elementAt(38).getState()+" 早"+thisState.elementAt(39).getState()+" 早"+thisState.elementAt(40).getState()+" 早"+thisState.elementAt(41).getState()+" 早"+middleBlank+"早"+nextState.elementAt(35).getState()+" 早"+nextState.elementAt(36).getState()+" 早"+nextState.elementAt(37).getState()+" 早"+nextState.elementAt(38).getState()+" 早"+nextState.elementAt(39).getState()+" 早"+nextState.elementAt(40).getState()+" 早"+nextState.elementAt(41).getState()+" 早\n"+
				leftBlank+"曲-收收收收收朴收收收收收-朴收收收收收-朴收收收收收-朴收收收收收-朴收收收收收-朴收收收收收-旭"+middleBlank+"曲-收收收收收朴收收收收收-朴收收收收收-朴收收收收收-朴收收收收收-朴收收收收收-朴收收收收收-旭\n\n\n\n\n\n\n\n\n\n");
	}

	public void blank() {
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
}

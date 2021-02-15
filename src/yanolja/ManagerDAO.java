package yanolja;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ManagerDAO {

	public List<HotelDTO> hotelPrint() { // 전체호텔 리스트 꺼내기

		List<HotelDTO> lists = new ArrayList<>();

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {

			sql = "select hotelcode,hotelname,hotelclass,owner,country,city ";
			sql+= "from hotel";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {

				HotelDTO hdto = new HotelDTO();

				hdto.setHotelCode(rs.getString("hotelcode"));
				hdto.setHotelName(rs.getString("hotelname"));
				hdto.setHotelClass(rs.getString("hotelclass"));
				hdto.setOwner(rs.getString("Owner"));
				hdto.setCountry(rs.getString("country"));
				hdto.setCity(rs.getString("city"));

				lists.add(hdto);
			}

			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return lists;
	}

	public void hotelInsert(HotelDTO hdto) { // 호텔 추가

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "insert into hotel values (?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, hdto.getHotelCode());
			pstmt.setString(2, hdto.getHotelName());
			pstmt.setString(3, hdto.getHotelClass());
			pstmt.setString(4, hdto.getOwner());
			pstmt.setString(5, hdto.getCountry());
			pstmt.setString(6, hdto.getCity());

			if(pstmt.executeUpdate()!=0) {
				System.out.println("추가성공");
			} else {
				System.out.println("추가실패");
			}

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void hotelUpdate(HotelDTO hdto) { // 호텔 수정

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "update hotel set hotelname=?,hotelclass=?,owner=?,country=?,city=? ";
			sql+= "where hotelcode=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, hdto.getHotelName());
			pstmt.setString(2, hdto.getHotelClass());
			pstmt.setString(3, hdto.getOwner());
			pstmt.setString(4, hdto.getCountry());
			pstmt.setString(5, hdto.getCity());
			pstmt.setString(6, hdto.getHotelCode());

			if(pstmt.executeUpdate()!=0) {
				System.out.println("수정성공");
			} else {
				System.out.println("수정실패");
			}

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void hotelDelete(String hotelcode) { // 호텔 삭제

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "delete hotel where hotelcode=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, hotelcode);

			if(pstmt.executeUpdate()!=0) {
				System.out.println("삭제성공");
			} else {
				System.out.println("삭제실패");
			} 

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	//---------------호텔룸 관리-----------------------

	public List<HotelDTO> roomPrint() { // 전체 호텔방 리스트 꺼내기

		List<HotelDTO> lists = new ArrayList<>();

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {

			sql = "select hotelcode,roomname ";
			sql+= "from hotelroom";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {

				HotelDTO hdto = new HotelDTO();

				hdto.setHotelCode(rs.getString("hotelcode"));
				hdto.setRoomName(rs.getString("roomname"));

				lists.add(hdto);
			}

			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return lists;
	}

	public void roomInsert(HotelDTO hdto) { // 호텔방 추가

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "insert into hotelroom values (?,?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, hdto.getHotelCode());
			pstmt.setString(2, hdto.getRoomName());

			if(pstmt.executeUpdate()!=0) {
				System.out.println("추가성공");
			} else {
				System.out.println("추가실패");
			} 

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void roomUpdate(HotelDTO hdto) { // 호텔방 수정

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "update hotelroom set roomname=? ";
			sql+= "where hotelcode=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, hdto.getRoomName());
			pstmt.setString(2, hdto.getHotelCode());

			if(pstmt.executeUpdate()!=0) {
				System.out.println("수정성공");
			} else {
				System.out.println("수정실패");
			} 

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void roomDelete(HotelDTO hdto) { // 호텔방 삭제

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "delete hotelroom where hotelcode=? and roomname=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hdto.getHotelCode());
			pstmt.setString(2, hdto.getRoomName());

			if(pstmt.executeUpdate()!=0) {
				System.out.println("삭제성공");
			} else {
				System.out.println("삭제실패");
			}  
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	//---------------관리자 예약 관리-----------------------

	public List<UserHistoryDTO> getHistoryList() { // 사용내역 보기의 전체 사용자 리스트

		List<UserHistoryDTO> lists = new ArrayList<>();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "select userid,hotelcode,checkin,checkout,totalexp from userhistory";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				UserHistoryDTO udto = new UserHistoryDTO();
				udto.setUserId(rs.getString("userid"));
				udto.setHotelCode(rs.getString("hotelCode"));
				udto.setCheckIn(rs.getString("checkIn"));
				udto.setCheckOut(rs.getString("checkOut"));
				udto.setTotalExp(rs.getInt("totalexp"));
				lists.add(udto);			
			}
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return lists;

	}

	public UserHistoryDTO getHistory(String id) { // 사용내역 보기의 전체 사용자 리스트 중 한명의 아이디 꺼내오기

		UserHistoryDTO hdto = new UserHistoryDTO();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "select hotelcode,checkin,checkout,totalexp from userhistory where userid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				hdto = new UserHistoryDTO();
				hdto.setHotelCode(rs.getString("hotelCode"));
				hdto.setCheckIn(rs.getString("checkIn"));
				hdto.setCheckOut(rs.getString("checkOut"));
				hdto.setTotalExp(rs.getInt("totalexp"));			
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return hdto;

	}

	public boolean updateHistoryData(String id, String hotelname) { // 관리자 - 예약 정보 db에서 수정

		UserHistoryDTO hdto = null;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		boolean check = false;

		try {
			sql = "update userhistory set checkin = ?, checkout = ? where userid = ? and hotelcode = (select hotelcode from hotel where hotelname = ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hdto.getCheckIn());
			pstmt.setString(2, hdto.getCheckOut());
			pstmt.setString(3, id);
			pstmt.setString(4, hotelname);
			if(pstmt.executeUpdate()!=0) {
				check = true; // 수정 성공
			}else {
				check = false; // 수정 실패
			}		
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return check;
	}

	public boolean deleteHistoryData(String id, String hotelcode, String checkin, String checkout) { // 관리자 - 예약 정보 db에서 취소

		UserHistoryDTO hdto = null;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		boolean check = false;

		try {
			sql = "delete userhistory where userid = ? and hotelcode = (select hotelcode from userhistory where hotelcode = ?) and checkin = ?, checkout = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, hotelcode);
			pstmt.setString(3, checkin);
			pstmt.setString(4, checkout);
			if(pstmt.executeUpdate()!=0) {
				check = true; // 삭제 성공
			}else {
				check = false; // 삭제 실패
			}
			pstmt.close();					
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return check;
	}


	//---------------관리자 회원 관리-----------------------

	public List<UserDBDTO> getUsersList(){ // 관리자 - 전체 회원 정보 리스트 꺼내기 (userid 정렬)
		List<UserDBDTO> lists = new ArrayList<>();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "select userid,pwd,username,age,sex,country,city,email,regdate,tel from userdb order by userid";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserDBDTO dbdto = new UserDBDTO();
				dbdto.setUserId(rs.getString("userid"));
				dbdto.setPwd(rs.getString("pwd"));
				dbdto.setUserName(rs.getString("username"));
				dbdto.setAge(rs.getInt("age"));
				dbdto.setSex(rs.getString("sex"));
				dbdto.setCountry(rs.getString("country"));
				dbdto.setCity(rs.getString("city"));
				dbdto.setEmail(rs.getString("email"));
				dbdto.setRegDate(rs.getString("regdate"));
				dbdto.setTel(rs.getString("tel"));
				lists.add(dbdto);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return lists;

	}

	public UserDBDTO getUser(String id) { // 회원내역 보기의 전체 회원 리스트 중 한명의 아이디 꺼내오기

		UserDBDTO dbdto = new UserDBDTO();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "select userid,pwd,username,age,sex,country,city,email,regdate,tel from userdb where userid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dbdto.setUserId(rs.getString("userid"));
				dbdto.setPwd(rs.getString("pwd"));
				dbdto.setUserName(rs.getString("username"));
				dbdto.setAge(rs.getInt("age"));
				dbdto.setSex(rs.getString("sex"));
				dbdto.setCountry(rs.getString("country"));
				dbdto.setCity(rs.getString("city"));
				dbdto.setEmail(rs.getString("email"));
				dbdto.setRegDate(rs.getString("regdate"));
				dbdto.setTel(rs.getString("tel"));
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return dbdto;

	}

	public boolean updateUserData(UserDBDTO dbdto) { // 관리자 - 회원 정보 db에서 수정

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		boolean check = false;

		try {
			sql = "update userdb set pwd = ?, username = ?, age = ?, sex = ?, country = ?, city = ?, email = ?, tel = ? where userid =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dbdto.getPwd());
			pstmt.setString(2, dbdto.getUserName());
			pstmt.setInt(3, dbdto.getAge());
			pstmt.setString(4, dbdto.getSex());
			pstmt.setString(5, dbdto.getCountry());
			pstmt.setString(6, dbdto.getCity());
			pstmt.setString(7, dbdto.getEmail());
			pstmt.setString(8, dbdto.getTel());
			pstmt.setString(9, dbdto.getUserId());
			if(pstmt.executeUpdate()!=0){
				check = true;
			}else {
				check = false;
			}
			pstmt.close();			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return check;
	}

	public boolean deleteUserData(String id) { // 관리자 - 회원 정보 db에서 삭제

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		boolean check = false;

		try {
			sql = "delete userdb where userid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			if(pstmt.executeUpdate()!=0) {
				check = true;
			}else {
				check = false;
			}
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return check;
	}

	public boolean dbidCheck(String id) { // 회원 검색할 때 아이디가 있나 없나 체크

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		boolean check = false;

		try {
			sql = "select userid from userdb where userid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			if(pstmt.executeUpdate()!=0) {
				check = true; // 아이디 있음
			}else {
				check = false; // 없는 아이디
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}		
		return check;

	}

	public String getHotelCode(String hotelname) { // 호텔이름을 받으면 호텔코드를 반납하는 메소드 (확인필요)

		String hc = null;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "select hotelcode from hotel where hotelname = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hotelname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				hc = rs.getString("hotelcode");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return hc;
	}

	public boolean checkHotel(String hotelcode) { // 호텔코드를 받아서 예약내역에 해당호텔이 있는지 확인하는 메소드

		boolean check = false;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "select hotelcode from userhistory where hotelcode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hotelcode);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				check = true;
			}else {
				check = false;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return check;
	}

	public boolean checkCheckIn(String hotelcode, String checkin) { // 호텔코드와 입실날짜를 받아서 userhistory에서 해당내역이 있는지 확인하는 메소드

		boolean check = false;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "select checkin from userhistory where hotelcode = ? and checkin = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hotelcode);
			pstmt.setString(2, checkin);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				check = true;
			}else {
				check = false;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return check;
	}

	public boolean checkCheckOut(String hotelcode, String checkin, String checkout) { // 호텔코드와 입실예정일 퇴실예정일을 받아서 userhistory에서 해당내역이 있는지 확인하는 메소드

		boolean check = false;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "select checkin from userhistory where hotelcode = ? and checkin = ? and checkout = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hotelcode);
			pstmt.setString(2, checkin);
			pstmt.setString(3, checkout);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				check = true;
			}else {
				check = false;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return check;
	}

}

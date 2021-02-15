package yanolja;

public class UserHistoryDTO {
	
	String userId;
	String hotelCode;
	String hotelName;
	String checkIn;
	String checkOut;
	int totalExp;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getHotelCode() {
		return hotelCode;
	}
	public void setHotelCode(String hotelCode) {
		this.hotelCode = hotelCode;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	public int getTotalExp() {
		return totalExp;
	}
	public void setTotalExp(int totalExp) {
		this.totalExp = totalExp;
	}
	@Override
	public String toString() {
		return String.format("%10s / %10s / %11s / %11s / %10d", 
				userId,hotelCode,checkIn,checkOut,totalExp);
	}
	
	

}

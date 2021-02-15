package yanolja;

public class HotelDTO {
	
	String hotelCode;
	String hotelName;
	String hotelClass;
	String owner;
	String country;
	String city;
	String roomName;
	String checkIn;
	String checkOut;
	int price;
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
	public String getHotelClass() {
		return hotelClass;
	}
	public void setHotelClass(String hotelClass) {
		this.hotelClass = hotelClass;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String hotelRoom) {
		this.roomName = hotelRoom;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
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
	@Override
	public String toString() {
		return String.format("%10s / %10s / %2s / %10s / %10s / %10s",
				hotelCode,hotelName,hotelClass,owner,country,city);
	}
	
	String  leftBlank="                                 ";
	String upBlank="\n\n\n";
	String menuBlank="                 ";
	String menuBlank2="                          ";
	
	public String toStringG() {
		return String.format(menuBlank+leftBlank
				+ "早%10s 早 %10s 早 %2s 早 %10s 早 %10s 早 %10s早",
				hotelCode,hotelName,hotelClass,owner,country,city);
	}
	public String toStringR() {
		return String.format(leftBlank + menuBlank +menuBlank2 +"   %4s           %4s  \n" + leftBlank + menuBlank +menuBlank2 +"%4d\n",
				hotelCode,roomName,price);
	}
}

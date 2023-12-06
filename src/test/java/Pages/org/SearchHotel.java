package Pages.org;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.org.BaseClass;

public class SearchHotel extends BaseClass {
	public SearchHotel() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="location")
	private WebElement location;
	@FindBy(id="hotels")
	private WebElement hotels;
	@FindBy(id="room_type")
	private WebElement roomType;
	@FindBy(id="room_nos")
	private WebElement totalRooms;
	@FindBy(id="datepick_in")
	private WebElement checkIn;
	@FindBy(id="datepick_out")
	private WebElement checkOut;
	@FindBy(id="adult_room")
	private WebElement adults;
	@FindBy(id="child_room")
	private WebElement childrens;
	@FindBy(id="username_show")
	private WebElement userIn;
	@FindBy(id="Submit")
	private WebElement btnSearch;
	public WebElement getBtnSearch() {
		return btnSearch;
	}
	public WebElement getUserIn() {
		return userIn;
	}
	@FindBy(id="Submit")
	private WebElement search;
	public WebElement getLocation() {
		return location;
	}
	public WebElement getHotels() {
		return hotels;
	}
	public WebElement getRoomType() {
		return roomType;
	}
	public WebElement getTotalRooms() {
		return totalRooms;
	}
	public WebElement getCheckIn() {
		return checkIn;
	}
	public WebElement getCheckOut() {
		return checkOut;
	}
	public WebElement getAdults() {
		return adults;
	}
	public WebElement getChildrens() {
		return childrens;
	}
	public WebElement getSearch() {
		return search;
	}

}

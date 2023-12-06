package Pages.org;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.org.BaseClass;

public class BookHotel extends BaseClass {
	public BookHotel() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//td[text()='Book A Hotel ']")
	private WebElement bookHotelTitle;
	@FindBy(id="first_name")
	private WebElement fullName;
	@FindBy(id="last_name")
	private WebElement lastName;
	@FindBy(id="address")
	private WebElement billingAddress;
	@FindBy(id="cc_num")
	private WebElement cardNum;
	@FindBy(id="cc_type")
	private WebElement cardType;
	@FindBy(id="cc_exp_month")
	private WebElement expireDate;
	@FindBy(id="cc_exp_year")
	private WebElement expiryYear;
	@FindBy(id="cc_cvv")
	private WebElement cvvNum;
	@FindBy(id="book_now")
	private WebElement bookNow;
	public WebElement getBookHotelTitle() {
		return bookHotelTitle;
	}
	public WebElement getFullName() {
		return fullName;
	}
	public WebElement getLastName() {
		return lastName;
	}
	public WebElement getBillingAddress() {
		return billingAddress;
	}
	public WebElement getCardNum() {
		return cardNum;
	}
	public WebElement getCardType() {
		return cardType;
	}
	public WebElement getExpireDate() {
		return expireDate;
	}
	public WebElement getCvvNum() {
		return cvvNum;
	}
	public WebElement getBookNow() {
		return bookNow;
	}
	public WebElement getExpiryYear() {
		return expiryYear;
	}
	

}

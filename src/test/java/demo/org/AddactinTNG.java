package demo.org;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.org.BaseClass;
import Pages.org.BookHotel;
import Pages.org.LoginPage;
import Pages.org.PageManager;
import Pages.org.SearchHotel;
import Pages.org.SelectHotel;

public class AddactinTNG extends BaseClass {
	//static WebElement userName;
	PageManager manager;
	SearchHotel searchHotel;
	SelectHotel selectHotel;
	BookHotel bookHotel;
	SoftAssert softAssert;
	
	@BeforeClass
	public void befClass() {
		loadBrowser("chrome");
		maximizeWindow();
		implicitWait();
		loadUrl("http://www.adactin.com/HotelApp/");
		manager=new PageManager();
		
	}
    @Parameters("browser")
	@Test(priority=1)
	public void logIn() throws FileNotFoundException {
		LoginPage logIn=manager.getLogInPage();
		softAssert=new SoftAssert();
		passValue(logIn.getUserName(),
				excelRead("C:\\Users\\USER\\eclipse-workspace\\ProjectOne\\src\\test\\resources\\New.xlsx","Credential",1,0));
		passValue(logIn.getPassWord(),
				excelRead("C:\\Users\\USER\\eclipse-workspace\\ProjectOne\\src\\test\\resources\\New.xlsx","Credential",1,1));
		clickElement(logIn.getLogIn());	
		searchHotel=manager.getSearchHotel();
		//System.out.println(searchHotel.hashCode());
		String actual = searchHotel.getUserIn().getAttribute("value");
		softAssert.assertEquals(actual,"Hello SathyaSVS!","Wrong user logged in!");
	}
	@Test(priority=2,dependsOnMethods = "logIn")
	public void searchHotel() throws FileNotFoundException {
		
		selectDropDown(searchHotel.getLocation(),"value" ,
				excelRead("C:\\Users\\USER\\eclipse-workspace\\ProjectOne\\src\\test\\resources\\New.xlsx","SrchHotel",1,0));
		selectDropDown(searchHotel.getHotels(),"value" ,
				excelRead("C:\\Users\\USER\\eclipse-workspace\\ProjectOne\\src\\test\\resources\\New.xlsx","SrchHotel",1,1));
		selectDropDown(searchHotel.getRoomType(),"value" ,
				excelRead("C:\\Users\\USER\\eclipse-workspace\\ProjectOne\\src\\test\\resources\\New.xlsx","SrchHotel",1,2));
		clickElement(searchHotel.getBtnSearch());
		selectHotel=manager.getSelectHotel();
		String expected = selectHotel.getTitle().getText();
		System.out.println(expected);
		softAssert.assertEquals(expected, "Select Hotel ","User not Logged into selecthotel page!");
	}
	
	@Test(priority=3)
	public void selectHotel() {
		clickElement(selectHotel.getSelectHotel());
		clickElement(selectHotel.getContinueClick());
		bookHotel=manager.getBookHotel();
		softAssert.assertEquals("bookHotel.getBookHotelTitle().getText()","Book A Hotel ","User not about to book hotel! ");
	}
	@Test(priority=4)
	public void BookAHotel() throws FileNotFoundException {
passValue(bookHotel.getFullName(), 
		excelRead("C:\\Users\\USER\\eclipse-workspace\\ProjectOne\\src\\test\\resources\\New.xlsx","Book",1,0));
passValue(bookHotel.getLastName(), 
		excelRead("C:\\Users\\USER\\eclipse-workspace\\ProjectOne\\src\\test\\resources\\New.xlsx","Book",1,1));
passValue(bookHotel.getBillingAddress(), 
		excelRead("C:\\Users\\USER\\eclipse-workspace\\ProjectOne\\src\\test\\resources\\New.xlsx","Book",1,2));
passValue(bookHotel.getCardNum(), 
		excelRead("C:\\Users\\USER\\eclipse-workspace\\ProjectOne\\src\\test\\resources\\New.xlsx","Book",1,3));
selectDropDown(bookHotel.getCardType(), "value","VISA" );
selectDropDown(bookHotel.getExpireDate(), "text","May" );
selectDropDown(bookHotel.getExpiryYear(), "value", "2027");
passValue(bookHotel.getCvvNum(), 
		excelRead("C:\\Users\\USER\\eclipse-workspace\\ProjectOne\\src\\test\\resources\\New.xlsx","Book",1,4));
clickElement(bookHotel.getBookNow());
	}
	@AfterClass
	public void tearDown() throws Exception {
	closeBrowser();
	softAssert.assertAll();
	}
	

	
}

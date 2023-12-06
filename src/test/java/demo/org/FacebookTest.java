package demo.org;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.org.BaseClass;

public class FacebookTest extends BaseClass {
	
	@BeforeMethod
	public void tearUp() {
		loadBrowser("chrome");
		maximizeWindow();
		implicitWait();
		loadUrl("https://www.facebook.com/");
	}
	@Test(dataProvider="Login Data")
	public void logIn(Object userName,Object passWord) {
		WebElement txtUserName = findingElement("id","email" );
		txtUserName.sendKeys(userName.toString());
		WebElement txtpassWord = findingElement("id","pass");
		txtpassWord.sendKeys(passWord.toString());
		
		
			}
	@DataProvider(name="Login Data")
	public Object[][] getData() {
		Object[][] data=new Object[][] {
			{"Sathya123","SathyaGreens"},{"sathya@QA","Sathya345"},{"Sathya#44","sathya321"}
		};
		return data;
	}
	
	

}

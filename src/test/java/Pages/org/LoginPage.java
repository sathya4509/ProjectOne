package Pages.org;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.org.BaseClass;

public class LoginPage extends BaseClass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="username")
	private WebElement userName;
	@FindBy(id="password")
	private WebElement passWord;
	@FindBy(id="login")
	private WebElement logIn;
	@FindBy(linkText="New User Register Here")
	private WebElement newUser;
	public  WebElement getUserName() {
		return userName;
	}
	
	public WebElement getPassWord() {
		return passWord;
	}
	
	public WebElement getLogIn() {
		return logIn;
	}
	
	public WebElement newUser() {
		return newUser;
	}
	

}

package Pages.org;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.org.BaseClass;

public class SelectHotel extends BaseClass {
	public SelectHotel() {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//td[text()='Select Hotel ']")
	private WebElement title;
	@FindBy(id="radiobutton_0")
	private WebElement selectHotel;
	@FindBy(id="continue")
	private WebElement continueClick;
	public WebElement getTitle() {
		return title;
	}

	public WebElement getContinueClick() {
		return continueClick;
	}
	public WebElement getSelectHotel() {
		return selectHotel;
	}

}

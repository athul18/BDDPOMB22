package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class MyAccountPage extends TestBase {
//PageFactory
	@FindBy(css= "input.form-control.input-lg")
	WebElement searchBox;
	
	@FindBy(css= "span.input-group-lg")
	WebElement searchBtn;
	
	public MyAccountPage() {
		 PageFactory.initElements(driver, this);
	}
	//Actions
	public void searchItem(String strItem) {
		searchBox.sendKeys(strItem);
		searchBtn.click();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
}

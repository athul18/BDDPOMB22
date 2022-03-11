package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase{
   @FindBy(id = "input-email")
   WebElement email;
   
   @FindBy(id = "input-password")
   WebElement pwd;
   
   @FindBy(css = "input.btn.btn-primary")
   WebElement lgnBtn;
   
   public LoginPage() {
	   PageFactory.initElements(driver, this);
   }
   
   public void login(String strUser, String strPwd) {
	   email.sendKeys(strUser);
	   pwd.sendKeys(strPwd);
	   lgnBtn.click();
   }
   
}

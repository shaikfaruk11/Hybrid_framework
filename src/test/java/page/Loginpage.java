package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resuablecomponents.TechnicalComponents;

public class Loginpage extends TechnicalComponents {

public Loginpage(WebDriver driver) {
	this.driver=driver;	
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//input[@id='user-name']")
public WebElement username;

@FindBy(xpath="//input[@id='password']")
public WebElement password;
@FindBy(xpath="//input[@id='login-button']")
public WebElement loginbutton;
public void enterusername(String text) {
	TechnicalComponents.type(username, text);
}
public void enterpassword(String text) {
	TechnicalComponents.type(password, text);
}
 public void clickonlogin() throws Exception {
	 TechnicalComponents.click(loginbutton);
} 

}
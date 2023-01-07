package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import resuablecomponents.Helper;

public class Products  extends Helper{
	
	public Products(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//div[@class='inventory_item_name'])[1]")
	public WebElement item;
	
	@FindBy(xpath="//div[@class='inventory_details_price']")
	public WebElement price;
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	public WebElement cart;
	
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	public WebElement addcart;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	public WebElement clickonCart;
	
	@FindBy(xpath="//div[@class='inventory_item_name']")
	public WebElement productnameDisplay;
	
	@FindBy(xpath="//div[@class='inventory_item_price']")
	public WebElement ItempriceDisplay;
	
	@FindBy(xpath="//button[@class='btn btn_action btn_medium checkout_button']")
	public WebElement checkout;
	
	
	public void clickonitem() throws Exception {
		Helper.click(item);
	}
	
	public void verifyprice() {
	String itemprice=	Helper.getelementText(price);
	Assert.assertEquals(itemprice, "$29.99");
	}
	public void verifycart() {
	 Helper.elementisdisplayed(addcart);
 String text=Helper.getelementText(addcart);
 Assert.assertEquals(text, "1");
 logger.log(LogStatus.PASS,"actuall value"+text+""+"expected value 1");
		
	}
	public void verifyDisplay() {
		addcart.click();
		String text=Helper.getelementText(productnameDisplay);
		Assert.assertEquals(text,"Sauce Labs Backpack");
		logger.log(LogStatus.PASS,"actual value"+text+""+"expected value Sauce Labs Backpack");
		
		String text2=Helper.getelementText(ItempriceDisplay);
		Assert.assertEquals(text2,"$29.99");
		logger.log(LogStatus.PASS, "actual value"+text2+""+"expected value $29.99" );
		checkout.click();
	}
	
	
}

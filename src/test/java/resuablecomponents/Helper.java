package resuablecomponents;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import config.*;

public class Helper extends Testsetup {

	public static void navigattetourl(String url) {
		try {
		driver.get(url);
		driver.manage().window().maximize();
	}catch(Exception e) {
		logger.log(LogStatus.FAIL," url is not defined"+url);
	}
	}
	 public String getcurrenturl() {
		String url= driver.getCurrentUrl();
		return url;
	 }
	
	 public static void type(WebElement element,String text){
		 try {
		 if( element.isDisplayed()) {
			element.sendKeys(text);
		 }
	 }catch(Exception e) {
		 logger.log(LogStatus.FAIL,"element is not found");
	 }
	 }
	 
	 public static void click(WebElement element)  throws Exception{
		if(element.isDisplayed()) {
			element.click();
		}
	 }
		
		 public  static void jsclick(WebElement element)  throws Exception{
				if(element.isDisplayed()) {
					js=(JavascriptExecutor)driver;
					js.executeScript("arguments[0].click();",element);
				}
	 }
	
		 public static String getscreenshot()  {
			 String path = null;
			 try {
			 ts=(TakesScreenshot)driver;
			 File pic=ts.getScreenshotAs(OutputType.FILE);
			String screenshots=LocalDateTime.now().toString().replace(":", "").replace(".", "").replace("T", "").replace("-", "");
			String folderName=LocalDateTime.now().getDayOfMonth()+"_"+LocalDateTime.now().getMonthValue()+"_"+LocalDateTime.now().getYear();
		     path=System.getProperty("user.dir")+"./Reports/"+folderName+"/Screenshots/"+screenshots+".png";
			FileUtils.copyFile(pic, new File(path));
			 }catch(Exception e) {
				 logger.log(LogStatus.FAIL,"screenhot is not captured");
			 }
			return path;
		
		 }
		 
		  public static  String getelementText(WebElement element) {
			  String text =element.getText();
			   return text;
		  }
	 
		   public static void  elementisdisplayed(WebElement element) {
			  
		boolean flag= element.isDisplayed();
		Assert.assertEquals(flag,true);
		   
}
}
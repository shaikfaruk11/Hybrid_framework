package resuablecomponents;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import page.Loginpage;

public class BussinessComponents  extends TechnicalComponents{

	public void lunchapplication(String url)  throws Exception {
		TechnicalComponents.navigattetourl(url);
		logger.log(LogStatus.PASS, "navigate to url:"+url);
		logger.log(LogStatus.PASS,logger.addScreenCapture(TechnicalComponents.getscreenshot()));
		String actualurl=getcurrenturl();
		Assert.assertEquals(url, actualurl);
	}
	
	public void login(String username, String Password)  {
		try {
		Loginpage login= new Loginpage(driver);
		logger.log(LogStatus.PASS, "username:-"+username);
		login.enterusername(username);
		logger.log(LogStatus.PASS,logger.addScreenCapture(TechnicalComponents.getscreenshot()));
		login.enterpassword(Password);
		logger.log(LogStatus.PASS,logger.addScreenCapture(TechnicalComponents.getscreenshot()));
		logger.log(LogStatus.PASS, "password:-"+Password);
		logger.log(LogStatus.PASS, "click on login");
		login. clickonlogin();
		logger.log(LogStatus.PASS,logger.addScreenCapture(TechnicalComponents.getscreenshot()));
	}catch(Exception e) {
		logger.log(LogStatus.FAIL,e.getMessage().toString()+" "+logger.addScreenCapture(TechnicalComponents.getscreenshot()));
	}
	}
	
}
package resuablecomponents;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import page.Loginpage;

public class BussinessComponents  extends Helper{

	public void lunchapplication(String url)  throws Exception {
		Helper.navigattetourl(url);
		logger.log(LogStatus.PASS, "navigate to url:"+url);
		logger.log(LogStatus.PASS,logger.addScreenCapture(Helper.getscreenshot()));
		String actualurl=getcurrenturl();
		Assert.assertEquals(url, actualurl);
	}
	
	public void login(String username, String Password)  {
		try {
		Loginpage login= new Loginpage(driver);
		logger.log(LogStatus.PASS, "username:-"+username);
		login.enterusername(username);
		logger.log(LogStatus.PASS,logger.addScreenCapture(Helper.getscreenshot()));
		login.enterpassword(Password);
		logger.log(LogStatus.PASS,logger.addScreenCapture(Helper.getscreenshot()));
		logger.log(LogStatus.PASS, "password:-"+Password);
		logger.log(LogStatus.PASS, "click on login");
		login. clickonlogin();
		logger.log(LogStatus.PASS,logger.addScreenCapture(Helper.getscreenshot()));
	}catch(Exception e) {
		logger.log(LogStatus.FAIL,e.getMessage().toString()+" "+logger.addScreenCapture(Helper.getscreenshot()));
	}
	}
	
}
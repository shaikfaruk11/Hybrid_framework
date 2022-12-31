package testScripts;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import resuablecomponents.BussinessComponents;
import resuablecomponents.Helper;

public class Verifyaddtocart extends BussinessComponents {
	
	
	@Test
	public void perfromaddtocart() {
	
		try {
			lunchapplication(getProperties("url"));
			login(getProperties("username"),getProperties("password"));
			verifyaddtocart();
			logger.log(LogStatus.PASS, logger.addScreenCapture(Helper.getscreenshot()));
			logger.log(LogStatus.PASS, "testcase is passed");
		}catch(Exception e) {
			logger.log(LogStatus.FAIL, " testcases is failed");
		}
	}
	

}

package testScripts;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import resuablecomponents.BussinessComponents;
import resuablecomponents.TechnicalComponents;

public class VerifyLoginfunctionality  extends BussinessComponents{

@Test
public void verifylogin() {
	try {
	lunchapplication(getProperties("url"));
	login(getProperties("username"), getProperties("password"));
	logger.log(LogStatus.PASS, "testcases is passed");
	}catch(Exception e) {
		logger.log(LogStatus.PASS,e.getMessage().toString()+" "+logger.addScreenCapture(TechnicalComponents.getscreenshot()));
	}
}

}

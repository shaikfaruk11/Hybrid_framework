package testScripts;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import resuablecomponents.BussinessComponents;

public class VerifyURL extends BussinessComponents{
// verify  current url
	@Test
	public void openapplication() throws Exception {
		lunchapplication(getProperties("url"));
		logger.log(LogStatus.PASS, "testcases is passed");
	}
}

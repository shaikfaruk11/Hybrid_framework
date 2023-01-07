package testScripts;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import resuablecomponents.BussinessComponents;

public class VerifyItemPriceinProductpage extends BussinessComponents {
 
	@Test
	public void verifyPriceinproductpages() throws Exception {
		try {
		lunchapplication(getProperties("url"));
		login(getProperties("username"), getProperties("password"));
		verifyItemPrice() ;
		logger.log(LogStatus.PASS," testcases is passed");
		
	}catch(Exception e) {
		logger.log(LogStatus.FAIL, "testcase is failed"+e.getMessage());
	}
}

}
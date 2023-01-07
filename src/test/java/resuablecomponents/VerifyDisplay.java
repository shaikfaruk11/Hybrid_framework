package testScripts;

import org.testng.annotations.Test;

import resuablecomponents.BussinessComponents;

public class VerifyDisplay extends BussinessComponents {
	
	@Test
	
	public void cartverify() throws Exception {
		
		lunchapplication(getProperties("url"));
		login(getProperties("username"),getProperties("password"));
		addCart();
		clickoncart();
	}

}

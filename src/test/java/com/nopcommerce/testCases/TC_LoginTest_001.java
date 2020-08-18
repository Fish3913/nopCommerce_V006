package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.testBase.BaseClass;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() throws IOException
	{
		logger.info("**********Starting Tc_LoginTest_001*******************");
		driver.get(confiPropObj.getProperty("baseURL"));
	
		LoginPage lp=new LoginPage (driver);
		logger.info("**********proving login details*******************");
		lp.setUsername(confiPropObj.getProperty("useremail"));
		lp.setpassword(confiPropObj.getProperty("password"));
		lp.ClickLogin();
		
	String exp_title="Dashboard / nopCommerce administration";
	String act_title=driver.getTitle();
	
	if(act_title.equals(exp_title)) 
	{
		logger.info("**********login test passed*******************");
		Assert.assertTrue(true);
	}
	else 
	{
		logger.error("*************login test failed******************");
		captureScreen(driver,"loginTest");  //name of the test method name
		Assert.assertTrue(false);	
	}
		
	}

	
	
	
	
	

}

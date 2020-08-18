package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.testBase.BaseClass;
import com.nopcommerce.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
			    @Test(dataProvider="LoginData")
			    public void loginTest(String user,String pwd,String exp) throws InterruptedException 
			    {
			 logger.info("*********Starting TC_LoginDDT_002*************");
			 driver.get(confiPropObj.getProperty("baseURL"));
			 
			 LoginPage lp=new LoginPage(driver);
			 lp.setUsername(user);
			 lp.setpassword(pwd);
			 lp.ClickLogin();
			 Thread.sleep(5000);
			 
			 String exp_title="Dashboard / nopCommerce administration";
			 String act_title=driver.getTitle();
			 
			 if(exp_title.equals(act_title))
			 {
				if(exp.equals("Pass")) 
				{
					logger.info("*********Login test is passed***************");
					lp.clickLogout();
					Thread.sleep(3000);
					Assert.assertTrue(true);
				} 
				else if(exp.equals("Fail"))
				{
					logger.info("*********Login test is passed***************");
					lp.clickLogout();
					Thread.sleep(3000);
					Assert.assertTrue(false);
				}
				 
				  }
			 else if(!exp_title.equals(act_title)) 
			 {
				if(exp.equals("Pass")) 
				{
					logger.warn("**********login test is failed**************");
					Assert.assertTrue(false);
				}
				else if(exp.equals("Fail")) 
				{
					logger.warn("**********login test is passed**************");
					Assert.assertTrue(true);	
				}
				 
				 
			 }
			 logger.info("**********finished  TC_LoginDDT_002 **************");
			 
			 
			 }
			
			    
			    
			    @DataProvider(name="LoginData")
			    public String [][] getData() throws IOException{
			
			    String path= System.getProperty("user.dir")+"/testData/LoginData.xlsx";
			    
			 int totalrows =XLUtils.getRowCount(path, "Sheet1");
			 int totalcols =XLUtils.getCellCount(path, "Sheet1", 1);
			 
			  String logindata [][]=new String [totalrows] [totalcols];  
			  
			  for(int i=1;i<=totalrows;i++) //5
			  {
				  for(int j=0;j<totalcols;j++)
				  {
					  logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);//1 2
				  }
			  }
			
			return logindata;	
}
		}

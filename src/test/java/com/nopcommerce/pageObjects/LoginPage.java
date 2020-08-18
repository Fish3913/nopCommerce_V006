package com.nopcommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

		    WebDriver driver;
		    
		 public LoginPage(WebDriver driver)       //to initiate the driver
		 {
			this.driver =driver; 
			PageFactory.initElements(this.driver, this); // to use findby
		 }   
		 
		    //locators
		 @FindBy(id="Email")
		 @CacheLookup
		 WebElement txtEmail;
	
		 @FindBy(id="Password")
		 @CacheLookup
		 WebElement txtpassword;
		 
		 @FindBy(xpath="//input[@class='button-1 login-button']")
		 @CacheLookup
		 WebElement btnLogin;
		 
		 @FindBy(xpath="/html/body/div[3]/div[1]/div/div/ul/li[3]/a") 
		 @CacheLookup
		 WebElement linkLogout;
		 
		 //action methods
		  public void setUsername(String uname)
		   {
			 txtEmail.clear();
			 txtEmail.sendKeys(uname); 
		   }
		  public void setpassword(String pwd) 
		  {
			  txtpassword.clear();
			  txtpassword.sendKeys(pwd);  
		  }
		  public void ClickLogin()  
		  {
			  btnLogin.click();  
		  }
		 public void clickLogout ()   
		 {
			 linkLogout.click(); 
		 }
		    
	}

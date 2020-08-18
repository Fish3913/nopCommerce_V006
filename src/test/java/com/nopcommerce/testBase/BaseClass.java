package com.nopcommerce.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public Properties confiPropObj; //object created for properties class
	public Logger logger=LogManager.getLogger(this.getClass());
	@BeforeClass
	@Parameters("browser")
	public void setup(String br) throws IOException
	{
		//load/open config.properties files
		confiPropObj=new Properties();
		FileInputStream configfile=new FileInputStream(System.getProperty("user.dir")+"\\resources\\config.properties"); //open the file in the reading mode
		confiPropObj.load(configfile); //load the file by using the variable we gave
		//end of loading config.properties
		
		if(br.equals("chrome")) 
		{
			WebDriverManager.chromedriver().setup(); //initiate the driver
			driver= new ChromeDriver();       //launch the driver	
		}
		else if(br.equals("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver(); 
		}
		else if(br.equals("edge")) 
		{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver(); 
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	

	@AfterClass
	public void teardown() 
	{
	driver.quit();	
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "\\screenshots\\" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}
	
	public int randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (Integer.parseInt(generatedString2));
	}
	
	
	
	
}

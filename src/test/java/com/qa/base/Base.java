package com.qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.qa.pages.Loginpage;
import com.qa.util.Constants;

public class Base {
public WebDriver driver;
String baseurl;
Loginpage login;

@BeforeClass
public void commonsetup() {
	System.setProperty(Constants.CHROME_DRIVER_KEY,"C:\\Users\\HP\\Desktop\\New folder (5)\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Constants.Iwait, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Constants.Pltime, TimeUnit.SECONDS);
	
//	baseurl="http://www.kapoorlampshades.com/my-account/";
	driver.get(Constants.BASEURL);
	driver.manage().deleteAllCookies();
	
}
@AfterClass
public void quitbrowser() {
	//driver.quit();
}
@BeforeMethod
public void methodsetup() {
	Checkpoint.clearHashMap();
	
}
}

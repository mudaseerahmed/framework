package com.qa.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qa.base.Base;
import com.qa.base.Checkpoint;
import com.qa.base.Customdriver;
import com.qa.base.WebDriverFactory;
import com.qa.util.Util;

public class Loginpage extends Base{
	String text="//a[text()='Dashboard']";
	
	//WebDriverFactory wd=WebDriverFactory.getinstance();
	//WebDriver driver;
	public Loginpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	//method to enter username or password in the login page
	public void enterusernamepassword(String idorpassword,String text) {
		driver.findElement(By.id(idorpassword)).sendKeys(text);
		
		
	}
	
	public void enterusername() {
		
		Customdriver cd=new Customdriver(driver);
		cd.sendData(driver.findElement(By.id("username")),"hellohow491@gmail.com","entered username",true);
		//sendData(WebElement element, String data, String info, Boolean clear) 
		
	}
	public void enterpassword() {
		
		Customdriver cd=new Customdriver(driver);
		cd.sendData(driver.findElement(By.id("password")),"Vaayoo123$","entered password",true);
		//sendData(WebElement element, String data, String info, Boolean clear) 
		
	}
	//method to click on signin button
	
	public void clickonsignin() {
		Customdriver cd=new Customdriver(driver);
		//elementClick(WebElement element, String info, long timeToWait)
		cd.elementClick(driver.findElement(By.name("login")), "clicked on signin", 10L);
		
	}
	public void clickonsignin(String name) {
		driver.findElement(By.name(name)).click();
		WebElement actual=driver.findElement(By.xpath(text));
		//String actualtext=actual.getText();
		//Assert.assertEquals(actualtext,exptext);
		
	}
	public boolean gettext() {
		
		String  actual=driver.findElement(By.xpath(text)).getText();
		Boolean result=actual.equalsIgnoreCase("Dashboard");
		System.out.println(result+"is result");
	
		
	//	Assert.assertEquals(actual,"Dashboard");
		Checkpoint.mark("test01", result,"pass" );
		Checkpoint.markfinal("test01", result, "pass");
		return Util.verifyTextMatch(actual, "Dashboard");
		
		
		
		
	}

	
}

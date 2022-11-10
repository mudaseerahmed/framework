package com.qa.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	public WebDriver driver;
	protected String baseURL;
	
	@BeforeClass
	public void commonSetup() {
		driver=WebDriverFactory.getinstance().getdriver("chrome");
		
	}
	

}

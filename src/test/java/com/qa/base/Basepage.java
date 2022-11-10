package com.qa.base;

import org.openqa.selenium.WebDriver;

public class Basepage {
	
	WebDriver driver;
	
	public Basepage(WebDriver driver) {
		this.driver=driver;
	}
	public boolean verifytitle(String title) {
		return driver.getTitle().equalsIgnoreCase(title);
	}
	
	
	

}

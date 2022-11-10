package com.qa.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.base.WebDriverFactory;
import com.qa.pages.Loginpage;
import com.qa.pages.shoppage;
import com.qa.util.Constants;

public class Logintest extends Base {

	 
	
	
	
@Test(priority=1)
public void login() {
	
//	wd.getdriver("chrome");
	Loginpage lp=new Loginpage(driver);
	lp.enterusername();
	lp.enterpassword();
	
	//lp.enterusernamepassword(Constants.uname, Constants.username);
	//lp.enterusernamepassword(Constants.pwd, Constants.password);
	//lp.clickonsignin("login");
	lp.clickonsignin();
	lp.gettext();
	Assert.assertTrue(lp.gettext());
	
	
}
@Test(priority=2)
public void clearcartifpresent() throws InterruptedException {
	
	shoppage sh=new shoppage(driver);
	
	//sh.movemouseonmyaccount();
	sh.movemouseaccount();
	//sh.clickonanylinkinmyaccount("Cart");
	sh.clickcart();
	//sh.clickondeleteifpresent();
	sh.getprice();
	

	

}



@Test(enabled=false)
public void clickanylinkvalidatetotal() {
	shoppage sh=new shoppage(driver);
	sh.clickshop();
	sh.clickonlink(1);
	sh.clickonprice(1,2);
	sh.priceoflamp(2);
	sh.quantityvalue();
	sh.clickoncart();
	sh.validatecart();
	sh.movemouseoncart();
	sh.Total();

	//sh
	
}

}

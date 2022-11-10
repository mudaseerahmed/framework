package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pages.Loginpage;
import com.qa.pages.shoppage;

public class Addtocart extends Base{
	@Test
	public void validateAddtocart() throws InterruptedException {
		
		shoppage sp=new shoppage(driver);
		sp.entertextinsearch();
		sp.clicknexttosearch();
		sp.clickaddtocart();
		sp.gettextofprice();
		sp.gettextofcartquantity();
		sp.movemouseoncart();
		sp.clickcheckout();
		sp.clickonloginincheckoutpage();
		Loginpage lp=new Loginpage(driver);
		lp.enterusername();
		lp.enterpassword();
		lp.clickonsignin();

}
}

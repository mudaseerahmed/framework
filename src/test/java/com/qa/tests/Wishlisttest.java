package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pages.Loginpage;
import com.qa.pages.shoppage;

public class Wishlisttest extends Base{
	@Test
	public void validatewishlist() throws InterruptedException {
		Loginpage lp=new Loginpage(driver);
		lp.enterusername();
		lp.enterpassword();
		
		//lp.enterusernamepassword(Constants.uname, Constants.username);
		//lp.enterusernamepassword(Constants.pwd, Constants.password);
		//lp.clickonsignin("login");
		lp.clickonsignin();
		shoppage sp=new shoppage(driver);
		sp.entertextinsearch();
		sp.clicknexttosearch();
		sp.clickaddtowishlist();
		sp.gettextinlamps();
		sp.validatebrowsewishlistpresent();
		sp.clickbrowse();
		sp.gettextoflampinwishlistpage();
		sp.clickremovebutton();
		Thread.sleep(4000);
		sp.gettextafterremove();
		sp.gettextconfirmation();
	}

}

package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pages.lampspage;

public class Validatefromtowithprice  extends Base{
	@Test
	public void validateprice() throws InterruptedException {
		lampspage lp=new lampspage(driver);
		lp.getpricecomparewithfromto();

}
}

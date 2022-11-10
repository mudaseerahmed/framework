package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pages.lampspage;

public class sortthepriceascdes extends Base {
	@Test
	public void validatehighlow() throws InterruptedException {
		lampspage lp=new lampspage(driver);
		lp.selectbyprice("price-desc");
		Thread.sleep(3000);
		lp.getpricehightolow();
		
		

}
}

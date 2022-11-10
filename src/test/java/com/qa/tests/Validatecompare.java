package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pages.lampspage;

public class Validatecompare extends Base {

	@Test
	public void validatecompare() throws InterruptedException {
		lampspage lp=new lampspage(driver);
		lp.movemouseonimage();
		lp.clickclearall();
		lp.validateclearall();
		lp.mousemoveonimageclickview();
		
}
}

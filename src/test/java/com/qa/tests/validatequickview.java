package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pages.lampspage;

public class validatequickview extends Base{
	@Test
	public void validatehighlow() throws InterruptedException {
		lampspage lp=new lampspage(driver);
		lp.mousemoveonimageclickview();

}
}


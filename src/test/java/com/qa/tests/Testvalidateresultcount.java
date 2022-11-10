package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pages.lampspage;

public class Testvalidateresultcount extends Base {
	@Test 
	public void validateresultcount() throws InterruptedException {
		lampspage lp=new lampspage(driver);
		lp.clicklinksonebyonevalidatecount();

	

}}
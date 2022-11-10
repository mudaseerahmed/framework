package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pages.Loginpage;
import com.qa.pages.lampspage;

public class Countlamptest extends Base{

	
	@Test(priority=1)
	public void countnooflamps() {
		
		lampspage lmp=new lampspage(driver);
		lmp.countnooflamppagebypage();
		
		
//		
}
}

package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pages.Ouchcarthomepage;

public class clickcoloronebyone extends Base {
@Test
public void clickcoloronebyone() throws InterruptedException {
	Ouchcarthomepage ou=new Ouchcarthomepage(driver);
	ou.movemouseonmenu("Sofas");
	ou.clickonmenuitem();
	ou.clickonquickview();
	ou.clickcoloronebyone();
	ou.clickclose();
}
}

package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pages.Ouchcarthomepage;

public class validatecountinsofas extends Base {
	@Test
	public void validatecount() {
		Ouchcarthomepage ou=new Ouchcarthomepage(driver);
		ou.movemouseonmenu("Sofas");
		ou.clickonmenuitem();
		ou.gettextfromdropdown();
		ou.validatenoofimages();
		ou.clicknexttillend();
		ou.gettotaltext();
	

}
}

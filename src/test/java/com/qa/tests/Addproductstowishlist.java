package com.qa.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pages.shoppage;

public class Addproductstowishlist extends Base {
	
	@BeforeClass
	public void setup() {
		Excelreadexample.setExcelFile("C:\\Users\\HP\\eclipse-workspace\\Letskodeit\\src\\main\\resources\\Excel\\Readexcel.xlsx","Sheet1");
	}
	@DataProvider(name="verifysearch")
	public Object[][] getsearchcoursedata(){
		Object[][] testdata=Excelreadexample.getTestData("Search");
		return testdata;
		
		
	}
	
	@Test(dataProvider="verifysearch")
	public void verifysearch(String options) {
		shoppage sp=new shoppage(driver);
		
		sp.enterdata(options);
		
	}

}

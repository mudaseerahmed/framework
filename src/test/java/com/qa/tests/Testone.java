package com.qa.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.util.Constants;

public class Testone {
	@Test
	public void test() {
	
	System.setProperty(Constants.CHROME_DRIVER_KEY,"C:\\Users\\HP\\Desktop\\New folder (5)\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Constants.Iwait, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Constants.Pltime, TimeUnit.SECONDS);
	
//	baseurl="http://www.kapoorlampshades.com/my-account/";
	driver.get("https://www.kapoorlampshades.com/product-category/pedestal-lamps/");
	int totalProducts=0;
	
	int first,last;
	int page=1;
	while(true)
	{
	int count = driver.findElements(By.cssSelector("div.product-wrapper")).size();
	System.out.println("Page:"+page+"; Number of products:"+count);
	totalProducts+=count;
	first=totalProducts-8;
	System.out.println("first "+first);
	last=totalProducts;
	System.out.println("last is "+last);
	String text=driver.findElement(By.xpath("//div[@class='row']//div[@class='toolbar']//p")).getText();
	String []text1=text.split(" ");
	String text2=text1[1];
	text2=text2.trim();
	
	System.out.println(text2+"first on webpage");
	//String text3=text2.replace("-", "+++");
String tot=first+"-"+last; 
tot=tot.trim();
System.out.println(tot);

//Assert.assertEquals(tot,text2);

	

	
	
	

	 


	
	//System.out.println(firstc+"is correct first");
//	System.out.println(firstl+"is correct last");
	

	try
	{
		System.out.println(totalProducts+"---->");
	driver.findElement(By.xpath("//a[.='Next']")).click();
	}
	catch (Exception e)
	{
	break;
	}

	page++;
	}

	System.out.println("Total Number of products:"+totalProducts);
	//driver.quit();
	}

	

}

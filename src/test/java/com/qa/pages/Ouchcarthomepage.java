package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.qa.base.Base;

public class Ouchcarthomepage extends Base {
	int countvalidate;
	int totalproducts=0;
	
	public Ouchcarthomepage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public void movemouseonmenu(String text) {
		String tex="(//div//a[text()='"+text+"'])[2]";
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath(tex))).perform();
		
		
		
		
	}
	public void clickonmenuitem() {
		String text="(//li/a[text()='Fabric Sofas'])[2]";
		driver.findElement(By.xpath(text)).click();
	}
	public void gettextfromdropdown() {
		String text="(//button[@class='value-picker-button']//span[1])[1]";
		String tex=driver.findElement(By.xpath(text)).getText();
		String texts[]=tex.split(" ");
		System.out.println(texts[1]);
		//div[@class='collection__dynamic-part']//img
		countvalidate=Integer.parseInt(texts[1]);
		
	}
	public void validatenoofimages() {
		
		String text="//div[@class='collection__dynamic-part']//img";
		int count=driver.findElements(By.xpath(text)).size();
		System.out.println(count);
		Assert.assertEquals(countvalidate,count);
		
		
	}
	
	public void clicknext() {
		driver.findElement(By.xpath("//a[text()='Next']")).click();
	}
	public void clicknexttillend() {
		
		int page=1;
		

		while(true)
		{
			String texts;
			texts="//div[@class='collection__dynamic-part']//img";
			int count=driver.findElements(By.xpath(texts)).size();
			totalproducts+=count;
		
		try {	
			driver.findElement(By.xpath("//a[text()='Next']")).click();
			Thread.sleep(4000);
			
			//System.out.println(totalproducts);
		//	System.out.println(totalproducts);
		}
		catch(Exception e) {
			
			break;
		}
		page++;
		
	}
		System.out.println(totalproducts+"is the total");
	
	}

public void gettotaltext() {
	
	String text="//span[contains(text(),'products')]";
	String texts=driver.findElement(By.xpath(text)).getText();
	String textsp[]=texts.split(" ");
	String total=textsp[3];
	int totalproductsint=Integer.parseInt(total);
	Assert.assertEquals(totalproducts,totalproductsint);
	System.out.println("total value is "+total);
	
	
}
public void clickonquickview() {
	
	String text="(//a[contains(text(),'Swivel Barrel')])[1]//following::button[1]";
	driver.findElement(By.xpath(text)).click();
	
	
}
public void clickcoloronebyone() throws InterruptedException {
	
	String col="//div[contains(@class,'color-swatch')]//label";
	List<WebElement>clickonbyone=driver.findElements(By.xpath(col));
	
	int count=clickonbyone.size();
	
	for(int i=0;i<count;i++) {
		clickonbyone.get(i).click();
		Thread.sleep(2000);
	}
	
	
	
}
public void clickclose() {
	String close="(//button[@title='Close'])[1]";
    driver.findElement(By.xpath(close)).click();
}
}

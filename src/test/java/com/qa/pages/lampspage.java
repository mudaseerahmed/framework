package com.qa.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.base.Base;
import com.qa.tests.Loggingdemo;

public class lampspage  extends Base{
	  private static final Logger log = LogManager.getLogger(Loggingdemo.class.getName());
	
	public lampspage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	public void countnooflamppagebypage() {
		int sum=0;
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement Filter=driver.findElement(By.xpath("//span[text()='Filter by price']"));
		js.executeScript("arguments[0].scrollIntoView(true);",Filter);
	    	
		List<WebElement> next=driver.findElements(By.xpath("//a[text()='Next']"));
		int count=next.size();
		
		
		
		List<WebElement>lamp=driver.findElements(By.className("gridview"));
		
	int cn=0;

		//	System.out.println(count);
		log.info("the count is "+count);
			
while(count>0) {
			cn=lamp.size();
			sum=sum+cn;
		driver.findElement(By.xpath("//a[text()='Next']")).click();
		js.executeScript("arguments[0].scrollIntoView(true);",Filter);
		if(count==1)
		{		count--;
		}
		
		lamp=driver.findElements(By.className("gridview"));
		cn=lamp.size();
		sum=sum+cn;
}
		
log.info("the value is sum "+sum);
		
		System.out.println(sum);
		
		
	
}
	
	//move mouse on image click on compare 
	//validate compare after clicking on item
	public void movemouseonimage() throws InterruptedException {
		
		List<WebElement>mo=driver.findElements(By.xpath("//div[@class='product-image']"));
		int n=mo.size();
		List<WebElement>com=driver.findElements(By.xpath("//ul//li//a[contains(@class,'compare')]"));
		int comp=com.size();
	try {	
		Actions a=new Actions(driver);
		for(int i=0;i<n;i++) {
			System.out.println("value is "+i);
			WebElement e=driver.findElement(By.xpath("//div[@class='product-image']"));
			JavascriptExecutor js=(JavascriptExecutor)driver;
			int x=i+1;
			int y=2*i+1;
			int z=2*i+2;
			
		
			js.executeScript("arguments[0].scrollIntoView(true);",e);
			String tex="(//h3[@class='product-name']/a)["+y+"]";
			String firsttext=driver.findElement(By.xpath(tex)).getText();
		a.moveToElement(driver.findElement(By.xpath("(//div[@class='gridview']//h3[@class='product-name']//a)["+x+"]"))).perform();
	    String cn="(//ul[@class='add-to-links']//li[3])["+y+"]";
	    driver.findElement(By.xpath(cn)).click();
		System.out.println("clicked on "+y);
		Thread.sleep(3000);
		driver.findElement(By.id("cboxClose")).click();
		Thread.sleep(3000);
		String comppath="(//ul[@class='products-list']//a)["+z+"]";
		String comptext=driver.findElement(By.xpath(comppath)).getText();
		Assert.assertEquals(firsttext,comptext);
		System.out.println("the text on the page is "+firsttext);
		System.out.println("the text below compare is "+comptext);
		
		
		}
		
		
		}
	catch(Exception e) {
	
		
	}
		
	}
	
	public void clickclearall() throws InterruptedException {
		driver.findElement(By.className("clear-all")).click();
		Thread.sleep(4000);
	}
	//to validate clear is clearing the values above compare
	public void validateclearall() {
		
		String text="//ul[@class='products-list']//a";
		List<WebElement>cl=driver.findElements(By.xpath(text));
		int count=cl.size();
		Assert.assertEquals(count, 0);
		
		
		
		
		
	}
	public void getprice() {
		String textpr="//div[@class='price-box']//span//span/..";
		List<WebElement>pr=driver.findElements(By.xpath(textpr));
		int count=pr.size();
		for(int i=2;i<=count;i=i+4) {
			String text=driver.findElement(By.xpath("(//div[@class='price-box']//span//span/..)["+i+"]")).getText();
			log.info("the text is "+text);
		}
		
	}
	public void selectbyprice(String text) {
		WebElement e=driver.findElement(By.className("orderby"));
		Select s=new Select(e);
		s.selectByValue(text);
		log.info("value selected");
	}
	public void getpricehightolow() {
		String textpr="//div[@class='price-box']//span//span/..";
		List<WebElement>pr=driver.findElements(By.xpath(textpr));
		int count=pr.size();
		for(int i=2;i<=count;i=i+4) {
			int j=i+4;
			String text=driver.findElement(By.xpath("(//div[@class='price-box']//span//span/..)["+i+"]")).getText();
			text=text.substring(1);
			text=text.replace(",", "");
			float x=Float.parseFloat(text);
			if(j>count) {
				break;
			}
			String texty=driver.findElement(By.xpath("(//div[@class='price-box']//span//span/..)["+j+"]")).getText();
			texty=texty.substring(1);
			texty=texty.replace(",", "");
			
			float y=Float.parseFloat(texty);
			
			
			if(x>=y) {
			log.info(x+"  is greater than or equal to ---->"+y);
			}
			else {
				log.info(x+"is less than "+y);
				
			}
		
			
	
}}
	
	//get the price of all the bulbs and compare the value of from with the bulb
	
	public void getpricecomparewithfromto() {
		
		String textpr="//div[@class='price-box']//span//span/..";
		List<WebElement>pr=driver.findElements(By.xpath(textpr));
		String fromtext=driver.findElement(By.className("from")).getText();
		fromtext=fromtext.substring(1);
		fromtext=fromtext.replace(",","");
		Float from=Float.parseFloat(fromtext);
		System.out.println("the value of from is  "+from);
		String totext=driver.findElement(By.className("to")).getText();
		totext=totext.substring(1);
		totext=totext.replace(",","");
		Float to=Float.parseFloat(totext);
		System.out.println("the value of to is  "+to);
		
		int count=pr.size();
		for(int i=2;i<=count;i=i+4) {
			String text=driver.findElement(By.xpath("(//div[@class='price-box']//span//span/..)["+i+"]")).getText();
			text=text.substring(1);
			text=text.replace(",","");
			System.out.println("the text is "+text);
			Float f=Float.parseFloat(text);
			System.out.println("the value of bulb is --"+f+"RS");
			
		  //  Assert.assertTrue(f>=from,from+"is less than or equal to"+f);
			
		
			
		}}
	//method to move mouse on image and click on quick view
	//validate text and price on the image and quick view page using assertion
		public void mousemoveonimageclickview() throws InterruptedException {
			int x=0;
try {
		
			List<WebElement>mo=driver.findElements(By.xpath("//div[@class='product-image']"));
			int n=mo.size();
			List<WebElement>com=driver.findElements(By.xpath("//ul//li//a[contains(@class,'compare')]"));
			int comp=com.size();
	
			Actions a=new Actions(driver);
			for(int i=0;i<n;i++) {
				System.out.println("value is "+i);
				WebElement e=driver.findElement(By.xpath("//div[@class='product-image']"));
				JavascriptExecutor js=(JavascriptExecutor)driver;
				 x=i+1;
		
				
			
js.executeScript("arguments[0].scrollIntoView(true);",e);

a.moveToElement(driver.findElement(By.xpath("(//div[@class='product-image'])["+x+"]"))).perform();
WebDriverWait wait=new WebDriverWait(driver,20);
String cn="(//ul[@class='add-to-links']//li[4])["+x+"]";
wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(cn))));
		   
		   driver.findElement(By.xpath(cn)).click();
		   
		String cl="//span[@class='closeqv']/i";
		Thread.sleep(3000);
		driver.findElement(By.xpath(cl)).click();
			}	}
catch(Exception e) {
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	 String cn="(//ul[@class='add-to-links']//li[4])["+x+"]";
	 WebElement button=driver.findElement(By.xpath(cn));
	  js.executeScript("arguments[0].click();", button);
	  String cl="//span[@class='closeqv']/i";
		Thread.sleep(3000);
		driver.findElement(By.xpath(cl)).click();
}}
 //method to click on link one by one validate results count
		//validate count is same at both places
		public void clicklinksonebyonevalidatecount() throws InterruptedException {
			int i=0;
			List<WebElement>count=driver.findElements(By.xpath("//ul[@class='product-categories']//li/a"));
			
			for( i=0;i<count.size();i++) {
				int y=i+1;
				String counttext="(//ul[@class='product-categories']//li/span)["+y+"]";
				
				count.get(i).click();
				Thread.sleep(3000);
				String showing="//div[@class='toolbar-inner']//p";
				String showingt=driver.findElement(By.xpath(showing)).getText();
				System.out.println("the text on the right side is "+showingt);
				String shows[]=showingt.split(" ");
				System.out.println("the value  result is"+shows[3]);
				char[]ch=shows[3].toCharArray();
		
					
				StringBuilder sb=new StringBuilder();
			
				
				for(char c:ch) {
					if(Character.isDigit(c)) {
					
					sb.append(c);
				
					
					
				}
					else {
					
							
						}
						
					}
					
				
				String singlestring=sb.toString();
				if(singlestring.equals(" ")||singlestring.equals("")) {
					continue;
				}
				System.out.println("the value on the right side**********"+singlestring);
			int zz=Integer.parseInt(singlestring);
		//	System.out.println(zz+"is the value of the final result after conversion+++++++");
				
				
				
			//	String show=driver.findElement(By.xpath(showing)).getText();
				
		/*	int no=shows.length;
			for(int i1=0;i1<no;i1++) {
				if(shows[i1].contains("result")) {
					int y7=shows[i1].indexOf("result");	
					String y11=shows[i1].substring(y7-2);
					System.out.println("the value before result is"+y11);
					
				}*/
				
				
			
				
				WebDriverWait wait=new WebDriverWait(driver,6);
			
			
				
				
			
				String textpr=driver.findElement(By.xpath(counttext)).getText();
				textpr=textpr.replace(")","");
				textpr=textpr.replace("(","");
				System.out.println("the text is "+textpr);
				int val=Integer.parseInt(textpr);
				System.out.println(val+" is the int value");
				driver.navigate().back();
			//	driver.navigate().refresh();
			//	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(showing)));
				
	/*		if(show.endsWith("single")) {
			System.out.println("the value is 1");
				
				driver.navigate().back();
				}
			else  {
		//		System.out.println("the text is one");
				int w1=show.indexOf("results");
				int y3=w1-2;
				String fshow=showarr[y3];
				System.out.println("the value after showing is"+fshow);
				
				driver.navigate().back();
				
			}
			
			
		/*		if(third.equals("single")) {
					
					System.out.println("the count is 1");
				}
				else {
					
					int y2=Integer.parseInt(third);
					
					
				}*/
				
				
		//		driver.navigate().refresh();
				//driver.navigate().back();
			//	Thread.sleep(3000);
			//	String text=count.get(i).getText();
		//		text=text.replace(")","");
			//	text=text.replace("(","");
			
				
				
			
			}}
			
		}

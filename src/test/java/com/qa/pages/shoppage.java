package com.qa.pages;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.base.Base;
import com.qa.base.Checkpoint;
import com.qa.base.Customdriver;
import com.qa.util.Util;

public class shoppage extends Base{
	float valueonlistpage;
	float total=0;
	int quantity;
	float valueondetailedpage;
	float totalvalue;
	public shoppage(WebDriver driver) {
		this.driver=driver;
	}
	public void clickshop() {
driver.findElement(By.xpath("//div[@class='primary-menu-container']//a[text()='Shop']")).click();	
}

	public void clickonlink(int x) {
		List<WebElement>link=driver.findElements(By.xpath("//ul[@class='product-categories']//a"));
		int n=link.size();
		link.get(n-n+x-1).click();
		
		
	}
	public void movemouseonmyaccount() {
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.id("menu-top-menu"))).perform();
		
		
	}
	public void movemouseaccount() {
		Customdriver cd=new Customdriver(driver);
		//mouseHover(String locator, String info
		cd.mouseHover("id=>menu-top-menu","hovered mouse on account");
		
	}
	public void clickonanylinkinmyaccount(String text) {
	String linkaccount="//ul[@class='sub-menu']//a[text()='"+text+"']";
	driver.findElement(By.xpath(linkaccount)).click();
	
		
	}
	public void clickcart() {
		
		// elementClick(WebElement element, String info, long timeToWait)
		Customdriver cd=new Customdriver(driver);
		cd.elementClick(driver.findElement(By.xpath("//ul[@class='sub-menu']//a[text()='Cart']")), "clicked on cart", 10L);
	
		
		
	}
	
	public void clickondeleteifpresent() throws InterruptedException {
		
		int count=driver.findElements(By.cssSelector("td.product-remove>a")).size();
		System.out.println("Number of product in cart:"+count);
		for(int i=0;i<count;i++)
		{
		driver.findElement(By.cssSelector("td.product-remove>a")).click();
		Thread.sleep(4000);
		}
		System.out.println("Deleted all product from cart");
		
		
		}
	public void getprice() {
		String text=driver.findElement(By.className("product-name")).getText();
		Boolean result=text.equalsIgnoreCase("Product");
		Checkpoint.mark("test02", result,"pass" );
		float z=0,res4=0;
		List<WebElement>qu=driver.findElements(By.cssSelector("input[type='number']"));
		int y=0;
		int a=qu.size();
		List<String>b=new ArrayList<String>();
		for(int i=0;i<a;i++) {
			String quant=qu.get(i).getAttribute("value");
			b.add(quant);
			
		}
		String arr[]=new String[b.size()];
		int j;
		for(j=0;j<b.size();j++) {
			arr[j]=b.get(j);
			
		}
		int res[]=new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			res[i]=Integer.valueOf(arr[i]);
			System.out.println(res[i]);
			
		}
		
	
		
		String price="//td[@class='product-price']//bdi";
		String pri=" ";
		List<String>c=new ArrayList<String>();
		List<WebElement>pr=driver.findElements(By.xpath(price));
		int n=pr.size();
		for(int i=0;i<n;i++) {
		
			
			pri=pr.get(i).getText();
			pri=pri.substring(1);
			pri=pri.replaceAll(",","");
			c.add(pri);
		}
			String brr[]=new String[c.size()];
			String total=" ";
			float res1[]=new float[brr.length];
			for(int i1=0;i1<c.size();i1++) {
				brr[i1]=c.get(i1);
			}
			float res3[]=new float[brr.length];
			for(int i=0;i<brr.length;i++) {
				res3[i]=Float.valueOf(brr[i]);
				System.out.println(res3[i]);
				 res4=res3[i]*res[i];
				System.out.println(res4+"is the total value");
				z=z+res4;
				
				List<WebElement>act=driver.findElements(By.xpath("//tr/td[@class='product-subtotal']/span"));
				int n4=act.size();
				String act2=" ";
				float fact2=0;
				int i2=0;
				
				for( i2=0;i2<n4;i2++) {
					 act2=act.get(i2).getText();
					act2=act2.substring(1);
					act2=act2.replace(",","");
			 fact2=Float.parseFloat(act2)	;
			
					
					
					
				}
				System.out.println(fact2+"is"+i2);
			}
			
				System.out.println("Total value in float is "+z);
				//System.out.println(res1[i1]);
				String actualprices="(//strong//span[last()])[1]";
				String actualprice=driver.findElement(By.xpath(actualprices)).getText();
				actualprice=actualprice.substring(1);
				actualprice=actualprice.replace(",", "");
				float actpr=Float.parseFloat(actualprice);
				Assert.assertEquals(actpr,z);
				System.out.println("the value on the webpage is "+actpr);
				
				
				
				
			
		/*	for(int q=0;q<res.length;q++) {
				int num1=res[q];
				float num2=res1[q];
				total+=Float.toString(num1*num2);
				
			}
			System.out.println(total);
			
		*/
			
			
		
		
		
	}
			
		
			
			
	
		 

		


		
		
		
	
	
	//ul[@class='sub-menu']//a[text()='Cart']
	public void clickonprice(int x,int y) {
		String tag="//div[@class='gridview']//h3";
		String path="(//div[@class='price-box']//bdi)["+y+"]";
		String texts=driver.findElement(By.xpath(path)).getText();
		texts=texts.substring(1);
		texts=texts.replace(",", "");
		
		System.out.println("price of the product is "+texts);
		List<WebElement>count=driver.findElements(By.xpath(tag));
		int n=count.size();
		count.get(n-n+x-1).click();
		valueonlistpage=Float.parseFloat(texts);
		System.out.println(valueonlistpage+" value after conversion in list view ");
		
		
		
		
		
		
		
	}
	public void priceoflamp(int n) {
		
		String path="(//div[@class='row']//bdi)["+n+"]";
		String text=driver.findElement(By.xpath(path)).getText();
		text=text.substring(1);
		text=text.replace(",", "");
		System.out.println("price of the product is "+text);
		valueondetailedpage=Float.parseFloat(text);
		System.out.println(valueondetailedpage+"  in detailed view page after conversion");
		
		
		
		
	}
	public void quantityvalue() {
		
		String value=driver.findElement(By.cssSelector("input[type='number']")).getAttribute("value");
		System.out.println("the value of attribute is "+value);
		
		
		
		
	}
	public void clickoncart() {
		
	String cssbutton="button[name='add-to-cart']";
	driver.findElement(By.cssSelector(cssbutton)).click();
		String text="hello";
WebElement e=driver.findElement(By.xpath("//a[contains(text(),'"+text+'"'));
	
	
	
	}
	
	public void validatecart() {
		String value=driver.findElement(By.xpath("//span[@class='cart-total']")).getText();
		value=value.substring(1);
		value=value.replace(",", "");
		float val=Float.parseFloat(value);
		Assert.assertEquals(val,valueonlistpage);
		Assert.assertEquals(val,valueondetailedpage);
		
		
	}
	
	public void movemouseoncart() {
		String title="//span[@class='cart-title']/..";
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath(title))).perform();
		
		
		
	}
	public void validatesubtotal() {
		String path="//p[@class='total']//span[@class='woocommerce-Price-amount amount']";
	String text=driver.findElement(By.xpath(path)).getText();
	
		
		
	}
	
	public void Total() {
		String total="//p[contains(text(),'Subtotal')]//following::bdi[1]";
		String texts=driver.findElement(By.xpath(total)).getText();
		texts=texts.substring(1);
		texts=texts.replace(",","");
		totalvalue=Float.parseFloat(texts);
		System.out.println("total value is "+totalvalue);
		Assert.assertEquals(totalvalue,valueonlistpage);
		Assert.assertEquals(totalvalue,valueondetailedpage);
		
		
		
		
		
	}
	public void entertextinsearch() {
		Customdriver cd=new Customdriver(driver);
		cd.sendData(driver.findElement(By.id("ws")),"table lamp 6500","entered text tample lamp",true);
		// sendData(WebElement element, String data, String info, Boolean clear)
		
		
		
		
	}
	
	public void clicknexttosearch() {
		Customdriver cd=new Customdriver(driver);
		cd.elementClick(driver.findElement(By.id("wsearchsubmit")),"Clicked on search button",10L);
		//elementClick(WebElement element, String info, long timeToWait)
		
		
		
		
		
	}
	
	
public void clickaddtowishlist() {
	
	Customdriver cd=new Customdriver(driver);
	cd.elementClick(driver.findElement(By.xpath("//span[text()='Compare']//preceding::span[1]")), "clicked on wishlist", 10L);
	
	
}

public void validatebrowsewishlistpresent() {
	//isElementPresent(String locator, String info)

	Customdriver cd=new Customdriver(driver);
	cd.isElementPresent("xpath=>//a[contains(text(),'Browse')]", "validated browser is present");
	
	
}
public void gettextinlamps() {
	Customdriver cd=new Customdriver(driver);
	cd.getText(driver.findElement(By.cssSelector("h1")), "text is found");
	
	
//	getText(WebElement element, String info)
}
public void clickbrowse() {
	

	Customdriver cd=new Customdriver(driver);
	cd.elementClick(driver.findElement(By.xpath("//a[contains(text(),'Browse')]")), "clicked on browselink", 10L);
	

}
public void gettextoflampinwishlistpage() {
	Customdriver cd=new Customdriver(driver);
	cd.getText(driver.findElement(By.xpath("//td[3]/a")), "text is found");
	
	
}

public void clickremovebutton() {
	
	
	Customdriver cd=new Customdriver(driver);
	cd.elementClick(driver.findElement(By.xpath("//tr/td[@class='product-remove']//a")), "clicked on  remove link", 10L);
	
	
	
	
}

public void gettextafterremove() {
	Customdriver cd=new Customdriver(driver);
	cd.getText(driver.findElement(By.xpath("//td")), "text is found after removing");
	
	
	
}
public void gettextconfirmation() {
	Customdriver cd=new Customdriver(driver);
	cd.getText(driver.findElement(By.className("woocommerce-message")), "text is in green color");
	
}
public void clickaddtocart() {
	Customdriver cd=new Customdriver(driver);
	cd.elementClick(driver.findElement(By.name("add-to-cart")), "clicked on add to cart", 10L);
	
	
	
}
public void gettextofprice() {
	Customdriver cd=new Customdriver(driver);
	cd.getText(driver.findElement(By.xpath("//h1//following::span[3]")), "price of lamp");

}
public void gettextofcartquantity() {
	
	Customdriver cd=new Customdriver(driver);
	cd.getText(driver.findElement(By.className("cart-quantity")), "cart quantity");
	
	
	
}
public void clickcheckout() {
	Customdriver cd=new Customdriver(driver);
	cd.elementClick(driver.findElement(By.xpath("//p/a[1]")), "clicked on checkout", 10L);
	
}
public void clickonloginincheckoutpage() {
	Customdriver cd=new Customdriver(driver);
	cd.elementClick(driver.findElement(By.xpath("(//div[contains(text(),'Returning customer?')]//following::a[1])[1]")), "clicked on login in checkout page", 10L);
	
	
}

//enter data click on enter and verify true using assertion and check in stock or out of stock
public void enterdata(String text) {
	driver.findElement(By.id("ws")).clear();
	driver.findElement(By.id("ws")).sendKeys(text);
	driver.findElement(By.id("ws")).sendKeys(Keys.ENTER);
	String text1=driver.findElement(By.cssSelector("h1")).getText();
	boolean text2 = text1.equalsIgnoreCase(text);
	Assert.assertTrue(text2,"both are equal");
	String pricexp="(//bdi)[4]";
	String price=driver.findElement(By.xpath(pricexp)).getText();
	System.out.println(price+" is price");
	
	
	String st="//p[contains(@class,'stock')]";
	String stock=driver.findElement(By.xpath(st)).getText();
	System.out.println(stock);
	System.out.println("++++++++++++++++");
	

	
	
	
	
}
}

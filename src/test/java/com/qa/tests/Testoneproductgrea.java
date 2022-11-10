package com.qa.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.util.Constants;

public class Testoneproductgrea {
	@Test
	public void great() {
	System.setProperty(Constants.CHROME_DRIVER_KEY,"C:\\Users\\HP\\Desktop\\New folder (5)\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
    driver.get("https://www.kapoorlampshades.com/product-category/ceiling-lights/");
    driver.manage().window().maximize();
    WebElement orderBy = driver.findElement(By.className("orderby"));
    Select select=new Select(orderBy);
    select.selectByVisibleText("Sort by price: high to low");
    List<WebElement> priceList = driver.findElements(By.xpath("//div[@class='gridview']//div[@class='price-box']//ins//bdi"));
    List<Integer> list = new ArrayList<>();
    for (WebElement element : priceList){
        String text = element.getText();
        String s = text.replaceAll("\\D", "");
      System.out.println(s+"is price");
        int price = Integer.parseInt(s);
        list.add(price);
    }
    Boolean greaterThan = true;
    Boolean lesserThan = false;
    for (int i = 0; i <= list.size(); i++) {
        try {
            if (list.get(i) > list.get(i + 1)) {
                greaterThan = true;
                Assert.assertTrue(greaterThan);
                System.out.println(list.get(i)+" greater than--->"+list.get(i+1));
            }else{
                lesserThan = false;
                //System.out.println(lesserThan);
            }
        }catch(IndexOutOfBoundsException e){
        }
    }}
}



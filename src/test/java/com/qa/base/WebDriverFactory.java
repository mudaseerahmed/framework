package com.qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;

import com.qa.util.Constants;

public class WebDriverFactory {
	public static final WebDriverFactory instance =new WebDriverFactory();
	public WebDriver driver;
	
	
	private WebDriverFactory() {
		
	}

	public static WebDriverFactory getinstance() {
		return instance;
		
		
	}
	private static ThreadLocal<WebDriver> threadedDriver=new ThreadLocal<WebDriver>();
	private static ThreadLocal<String> threadedbrowser=new ThreadLocal<String>();
	
	public WebDriver getdriver(String browser) {
		
		WebDriver driver=null;
		setDriver(browser);
		threadedbrowser.set(browser);
		
		if(threadedDriver.get()==null) {
			try {
				if(browser.equalsIgnoreCase("firefox")) {
					driver=new FirefoxDriver();
					threadedDriver.set(driver);
					
					
				}
				if(browser.equalsIgnoreCase("chrome")) {
					ChromeOptions options=setChromeoptions();
					System.setProperty(Constants.CHROME_DRIVER_KEY,"C:\\Users\\HP\\Desktop\\New folder (5)\\chromedriver.exe");
					
					driver=new ChromeDriver();
					threadedDriver.set(driver);
					
					
				}
				if(browser.equalsIgnoreCase("iexplorer")) {
					   InternetExplorerOptions ieOptions = setIEOptions();
					driver=new InternetExplorerDriver();
					threadedDriver.set(driver);
					
					
				}
				
				
			}
			catch(Exception e) {
				e.printStackTrace();
				
			}
			threadedDriver.get().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			threadedDriver.get().manage().window().maximize();
			
		}
		return threadedDriver.get();
		
		}
	public String getBrowser() {
		return threadedbrowser.get();
	}
			
	 public void quitDriver() {
	        threadedDriver.get().quit();
	        threadedDriver.set(null);
	    }

	 public void setDriver(String browser) {
		 
		String driverpath="";
		String os=System.getProperty("os.name").toLowerCase().substring(0,3);
		System.out.println(os);
		String directory=System.getProperty("user.dir")+"//drivers";
		String driverkey=" ",drivervalue=" ";
		
		if(browser.equalsIgnoreCase("firefox")) {
			driverkey="webdriver.gecko.driver";
			drivervalue="geckodriver";
			
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			driverkey="webdriver.chrome.driver";
			drivervalue="chromedriver";
			
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			driverkey="webdriver.ie.driver";
			drivervalue="IEdriverServer";
			
		
		
		
		
	 }
		else {
			System.out.println("browser type not supported");
		}
	 
		driverpath=directory+drivervalue+(os.equals("win")?".exe":"");
		
		System.out.println(driverpath);
		System.setProperty(driverkey,driverpath);
		
		
}
	 private ChromeOptions setChromeoptions() {
		 ChromeOptions options=new ChromeOptions();
		 options.addArguments("disable-infobars");
		 return options;
		 
		 
		 
		 
	 }
	 
	 private FirefoxOptions setFFOptions() {
		 
		 FirefoxOptions options=new FirefoxOptions();
		 options.setCapability(CapabilityType.HAS_NATIVE_EVENTS, false);
		 
		 return options;
		 
		 
	 }
	 
	 private InternetExplorerOptions setIEOptions() {
		 InternetExplorerOptions options=new InternetExplorerOptions();
		 options.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		 options.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
		 options.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
		 options.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		 options.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		 options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		 return options;
		 
	 }
}


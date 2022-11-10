package com.qa.util;

import java.io.IOException;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import com.qa.base.BaseTest;
import com.qa.base.Customdriver;
import com.qa.base.WebDriverFactory;

public class Testlistener extends BaseTest implements ITestListener {
	private  static ExtentReports extent=Extentmanager.getInstance();
	private static ThreadLocal<ExtentTest>extentTest=new ThreadLocal<ExtentTest>();
	private static final Logger log=LogManager.getLogger(Testlistener.class.getName());
	
	

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentTest test=extent.createTest(result.getInstanceName()+"::"+result.getMethod().getMethodName());
		extentTest.set(test);
		log.info("started success");
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("sucess---> "+result.getName());
		String resname=result.getMethod().getMethodName();
		String logtext="<b>"+"test method"+resname+"successfull"+"</b>";
		 Markup m = MarkupHelper.createLabel(logtext, ExtentColor.GREEN);
	        extentTest.get().log(Status.PASS, m);
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("on test failure"+result.getName());
		String methodname=result.getMethod().getMethodName();
		String exceptionmessage=Arrays.toString(result.getThrowable().getStackTrace());
	//	extentTest.get().fail(null)
		  log.info("************************************************************");
	        log.info("onTestFailure -> Test Method Name: " + result.getName());
	        log.info("************************************************************");
	        String methodName = result.getMethod().getMethodName();
	        String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
	        extentTest.get().fail("<details>" + "<summary>" + "<b>" + "<font color=red>" +
	                "Exception Occurred: Click to see details: " + "</font>" + "</b>" + "</summary>" +
	        exceptionMessage.replaceAll(",", "<br>") + "</details>" + " \n");

	   String browser =WebDriverFactory.getinstance().getBrowser();
	    //    log.info("Test Listener Browser Name: " + browser);
	       WebDriver  driver = com.qa.base.WebDriverFactory.getinstance().getdriver(browser);
	        Customdriver cd = new Customdriver(driver);
	     //   cd.takeScreenshot(methodName, exceptionMessage)
	        String path = cd.takeScreenshot(result.getName(),browser);
	        
	        try {
	            extentTest.get().fail("<b>" + "<font color=red>" +
	                    "Screenshot of failure" + "</font>" + "</b>",
	                    MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	            log.info("Successfully attached screenshot");
	        } catch (IOException e) {
	            extentTest.get().fail("Test Method Failed, cannot attach screenshot");
	        }

	        String logText = "<b>" + "Test Method " + methodName + " Failed" + "</b>";
	        Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
	        extentTest.get().log(Status.FAIL, m);
	        log.info("************************************************************");
	        log.info("Test Method Name: " + result.getMethod().getMethodName() + " Failed");
	        log.info("************************************************************");
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		log.info("on start"+context.getName());
		
	ITestNGMethod methods[]=context.getAllTestMethods();
	log.info("These methods will be executed in this <test> tag");
	for(ITestNGMethod method:methods) {
		log.info(method.getMethodName());
		
	}
	
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		log.info("---"+context.getName());
		extent.flush();
		
		
	}

}

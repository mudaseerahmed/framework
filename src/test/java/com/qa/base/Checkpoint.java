package com.qa.base;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.qa.tests.Loggingdemo;

public class Checkpoint {
	private static final Logger log=LogManager.getLogger(Checkpoint.class.getName());
	
	
	
	public static HashMap<String,String>resultmap=new HashMap<String,String>();
	private static String Pass="PASS";
	private static String Fail="FAIL";
	
	public static void clearHashMap() {
		resultmap.clear();
		
		
	}
	private static void setstatus(String mapkey,String status) {
		resultmap.put(mapkey, status);
	log.info(mapkey+":"+resultmap.get(mapkey));
		
		
	}
	public static void mark(String testname,boolean result,String resultmessage) {
testname=testname.toLowerCase();
String mapkey=testname+"."+resultmessage;
try {
	if(result) {
		setstatus(mapkey,Pass);
		
	}
	else {
		setstatus(mapkey,Fail);
		
	}
}
catch(Exception e ) {
	System.out.println("exception occured");
	setstatus(mapkey,Fail);
	e.printStackTrace();
	
	
}
	}
public static void markfinal(String testname,boolean result,String resultmessage) {
testname=testname.toLowerCase();
String mapkey=testname+"."+resultmessage;
try {
	if(result) {
		setstatus(mapkey,Pass);
		
	}
	else {
		setstatus(mapkey,Fail);
		
	}
}
catch(Exception e ) {
	System.out.println("exception occured");
	setstatus(mapkey,Fail);
	e.printStackTrace();
	
	
}
ArrayList<String>resultlist=new ArrayList<String>();
for(String key:resultmap.keySet()) {
	resultlist.add(resultmap.get(mapkey));
	
	
	
	
	
}

for(int i=0;i<resultlist.size();i++) {
	if(resultlist.contains("Fail")) {
		
		
		Assert.assertTrue(false);
		log.info("test method failed");
	}
	else {
		
		Assert.assertTrue(true);
		System.out.println("test method passed");
	}
}

}
	

}

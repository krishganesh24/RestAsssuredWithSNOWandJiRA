package com.restapi.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
	
	private ExtentManager() {
		
	}
	
	
	
public static final ThreadLocal<ExtentTest> exTest = new ThreadLocal<ExtentTest>();


public static ExtentTest getExtTest() {
	return exTest.get();
}

public static void setgetExtTest(ExtentTest test) {
	 exTest.set(test);
}

}

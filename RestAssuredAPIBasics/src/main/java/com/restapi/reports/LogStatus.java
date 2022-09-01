package com.restapi.reports;

public class LogStatus {



	private LogStatus() {

	}

	public static void pass(String msg) {

		ExtentManager.getExtTest().log(com.aventstack.extentreports.Status.PASS,msg);
	}

	public static void fail(Exception msg) {

		ExtentManager.getExtTest().log(com.aventstack.extentreports.Status.FAIL,msg);
	}

	public static void fail (AssertionError a) {

		ExtentManager.getExtTest().log(com.aventstack.extentreports.Status.FAIL,a);

	}
	
	public static void fatal (String msg) {

		ExtentManager.getExtTest().log(com.aventstack.extentreports.Status.FATAL,msg);

	}
	
	
	public static void info (String msg) {

		ExtentManager.getExtTest().log(com.aventstack.extentreports.Status.INFO,msg);

	}


}

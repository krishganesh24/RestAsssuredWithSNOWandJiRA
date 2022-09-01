package com.restapi.reports;

import com.aventstack.extentreports.ExtentReports;

public class ExtentReport {
	
	
	
	public static ExtentReports report = null;
	public static String extentReportpath="";
	
	private ExtentReport () {
		
		extentReportpath="C:\\Users\\krish\\eclipse-workspace\\RestAssuredAPIBasics"+"/ExtentReports/index.html";
		report= new ExtentReports();
		
		
	}
	
	public static void initialize() {
		
		new ExtentReport();
	}
	

}

package com.restapi.servicenow;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.restapi.reports.ExtentReport;
import com.restapi.reports.Reporter;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class BaseRestapimpl extends Reporter {
	public static RequestSpecification inputReq ;
	public static String SnowURL="https://dev131709.service-now.com/api/now/table/incident";
	public static Response response;
	public static String sys_id = "";
	/*
	 * 
	 * @BeforeSuite public void beforeSuite(){ startResult(); }
	 * 
	 * @BeforeClass public void beforeClass(){ startTestModule(testCaseName,
	 * testDescription); }
	 * 
	 * @BeforeMethod public void beforeMethod(){ test = startTestCase(testNodes);
	 * test.assignCategory(category); test.assignAuthor(authors);
	 * 
	 * }
	 * 
	 * @AfterSuite public void afterSuite(){ endResult(); }
	 * 
	 */
	/*
	 * @BeforeSuite public void setupSuite() { ExtentReport.initialize(); }
	 */
	@BeforeSuite
	public void preConfig() {
		RestAssured.baseURI=SnowURL;
		inputReq= RestAssured.given().				
				log().all().				
				auth().basic("admin", "abQJKctlE4qSF-8=");
	}
	@AfterMethod
	public void postConfig() {
		//response.prettyPrint();
		response.then().log().all();
	}
	/*
	 * @AfterSuite public void afterSuite () throws IOException {
	 * ExtentReport.report.flush(); File htmlFile = new File
	 * (ExtentReport.extentReportpath);
	 * Desktop.getDesktop().browse(htmlFile.toURI());
	 * 
	 * }
	 */
	@Override
	public long takeSnap() {
		// TODO Auto-generated method stub
		return 0;
	}
}

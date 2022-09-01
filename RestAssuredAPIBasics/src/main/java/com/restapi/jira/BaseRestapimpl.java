package com.restapi.jira;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class BaseRestapimpl {
public static RequestSpecification inputReq ;
public static String JiraURL="https://testleafjune2022.atlassian.net/rest/api/2/issue";
public static Response response;
public static String issue_id = "";
@BeforeSuite
public void preConfig() {
		RestAssured.baseURI="https://testleafjune2022.atlassian.net/rest/api/2/issue";
		inputReq= RestAssured.given().				
				log().all().				
				auth().preemptive().basic("testleafjune2022@gmail.com","toHqSo7tFkY22hkDTyjy520B");
	}

//gM2LBaQ6MVxkOp7V8oAE7584
@AfterMethod
public void postConfig() {
	//response.prettyPrint();
	response.then().log().all();
}
}

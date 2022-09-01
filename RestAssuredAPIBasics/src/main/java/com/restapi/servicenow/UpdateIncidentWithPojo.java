package com.restapi.servicenow;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.restapi.reports.LogStatus;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateIncidentWithPojo extends BaseRestapimpl {
	@Test()
	public void createincident() {
		// LogStatus.info("--Request--");

		PostIncidentwithPojo obj = new PostIncidentwithPojo("Laptop not working", "Windows Server-10.12.13.14",	"Hardware");

		System.out.println(obj);
		inputReq.contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(obj);
		response = inputReq.post();
		response.then().assertThat().body("result.number", Matchers.containsString("INC"));
		sys_id = response.jsonPath().get("result.sys_id");
		System.out.println("Created Sys id = " + sys_id);
	}
	
	
	public void updateIncident() {
		
		PostIncidentwithPojo obj = new PostIncidentwithPojo("Laptop is not working", "","Software");
		
		System.out.println(obj);
		response=inputReq.contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(obj).put(sys_id);
		
		response.then().assertThat().statusCode(200);
		
		
		
		
		
	}
}

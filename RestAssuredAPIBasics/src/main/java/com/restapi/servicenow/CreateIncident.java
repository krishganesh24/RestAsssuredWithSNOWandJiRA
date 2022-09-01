package com.restapi.servicenow;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.restapi.reports.LogStatus;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIncident extends BaseRestapimpl {
	@Test()
	public void createincident() {
		// LogStatus.info("--Request--");
		inputReq.contentType(ContentType.JSON).queryParam("sysparm_fields", "sys_id,description,category,number")
		.accept(ContentType.JSON)
		.body("{\"short_description\":\"Laptop not working\",\"description\": \"Windows Server-10.12.13.14. is not able to login\",\"category\":\"Hardware\"},");
		response = inputReq.post();
		response.then().assertThat().body("result.number", Matchers.containsString("INC"));
		sys_id = response.jsonPath().get("result.sys_id");
		System.out.println("Created Sys id = " + sys_id);
	}
}

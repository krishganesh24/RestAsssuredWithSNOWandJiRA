package com.restapi.servicenow;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateIncident extends BaseRestapimpl {
	@Test(dependsOnMethods = "com.restapi.servicenow.CreateIncident.createincident")
	public void updateRequest() {
		inputReq.contentType(ContentType.JSON).body(
				"{\"short_description\":\"Laptop is working\",\"description\": \"Windo-1n\",\"category\":\"Software\"},");
		response = inputReq.put(sys_id);
		response.then().assertThat().statusCode(200);
	}
}

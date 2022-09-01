package com.restapi.servicenow;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteIncident extends BaseRestapimpl {

	@Test(dependsOnMethods = "com.restapi.servicenow.CreateIncident.createincident")
	public void deleteIncident( ) {

		inputReq.contentType(ContentType.JSON);
		response = inputReq.delete(sys_id);
		response.then().assertThat().statusCode(204);
		Assert.assertEquals(response.statusCode() ,204);

	}

}

package com.restapi.servicenow;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetIncidents extends BaseRestapimpl {

	@Test(dependsOnMethods = "com.restapi.servicenow.CreateIncident.createincident")
	public void  getIncident(){

		response = inputReq.when().get(sys_id);
		response.then().assertThat().statusCode(200);
		response.then().assertThat().body("result.sys_id", Matchers.equalTo(sys_id));

		System.out.println("Status COde="+response.statusCode());
		int respcode = response.getStatusCode();
		Assert.assertEquals(respcode, 200);
		/*
		 * List<Object> listofsysids = response.jsonPath().getList("result.sys_id");
		 * System.out.println("List of Sysids ="+listofsysids);
		 */



	}


}

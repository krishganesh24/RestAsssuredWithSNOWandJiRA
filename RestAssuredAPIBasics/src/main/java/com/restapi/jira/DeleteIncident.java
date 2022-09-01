package com.restapi.jira;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class DeleteIncident extends BaseRestapimpl {
	@Test(dependsOnMethods = "com.restapi.jira.CreateIssue.createJiraIssue")
	public void deleteIncident( ) {
		inputReq.contentType(ContentType.JSON);
		response = inputReq.delete(issue_id);
		response.then().assertThat().statusCode(204);
		Assert.assertEquals(response.statusCode() ,204);
	}
}

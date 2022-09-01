package com.restapi.jira;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateIncident extends BaseRestapimpl {
	@Test(dependsOnMethods = "com.restapi.jira.CreateIssue.createJiraIssue")
	public void updateRequest() {
		inputReq.contentType(ContentType.JSON).body("{\r\n" + "    \"fields\": {\r\n" + "    \"project\":\r\n"
				+ "                {\r\n" + "                    \"key\": \"AUG\"\r\n" + "                },\r\n"
				+ "    \"summary\": \"create issue in AUG project\",\r\n"
				+ "    \"description\": \"Creating of an issue using project keys and issue type names using the REST API Automation\",\r\n"
				+ "    \"issuetype\": {\r\n" + "                    \"name\": \"Task\"\r\n" + "                }\r\n"
				+ "    }\r\n" + "}");
		response = inputReq.put(issue_id);
		response.then().assertThat().statusCode(200);
	}
}

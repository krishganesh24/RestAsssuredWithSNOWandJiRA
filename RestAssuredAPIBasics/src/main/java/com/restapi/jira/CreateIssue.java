package com.restapi.jira;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;




public class CreateIssue extends BaseRestapimpl {
	@Test()
	public void createJiraIssue() {
		inputReq.contentType(ContentType.JSON).accept(ContentType.JSON).body("{\r\n" + "    \"fields\": {\r\n"
				+ "    \"project\":\r\n" + "                {\r\n" + "                    \"key\": \"AUG\"\r\n"
				+ "                },\r\n" + "    \"summary\": \"create issue in AUG project\",\r\n"
				+ "    \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n"
				+ "    \"issuetype\": {\r\n" + "                    \"name\": \"Task\"\r\n" + "                }\r\n"
				+ "    }\r\n" + "}");
		response = inputReq.post();
		response.then().assertThat().body("key", Matchers.containsString("AUG"));
		issue_id = response.jsonPath().get("id");
		System.out.println("Created IssueID = " + issue_id);
	}
}

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostResuestforIncidentwithJSONfile {

	@Test
	public void createincident() {

		File inputfile = new File ("./src/main/resources/CreateIncident.json");

		RestAssured.baseURI="https://dev131709.service-now.com/api/now/table/incident";
		//RestAssured.authentication= RestAssured.basic("admin", "abQJKctlE4qSF-8=");
		RequestSpecification input = RestAssured.given().
				log().all().
				auth().
				basic("admin", "abQJKctlE4qSF-8=").contentType(ContentType.JSON).
				accept("application/json").
				body(inputfile);
		Response response = input.post();
		response.prettyPrint();
		System.out.println("Response Code="+response.statusCode());
		Assert.assertEquals(201, response.statusCode());
		String sysid = response.jsonPath().get("result.sys_id");
		System.out.println("Created Sys id ="+sysid);
	}

}

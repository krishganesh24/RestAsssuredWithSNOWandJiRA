
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIncident {

	@Test
	public void createincident() {



		RestAssured.baseURI="https://dev131709.service-now.com/api/now/table/incident";
		//RestAssured.authentication= RestAssured.basic("admin", "abQJKctlE4qSF-8=");
		RequestSpecification input = RestAssured.given().
				log().all().
				auth().
				basic("admin", "abQJKctlE4qSF-8=").contentType(ContentType.JSON).queryParam ("sysparm_fields", "sys_id,description,category,number,caller_id").
				accept("application/json").
				body("{\"short_description\":\"Laptop not working\",\"description\": \"Windows Server-10.12.13.14. is not able to login\",\"category\":\"Hardware\"},");
		Response response = input.post();
		response.prettyPrint();
		Assert.assertEquals(201, response.statusCode());
		String sysid = response.jsonPath().get("result.sys_id");
		System.out.println("Created Sys id"+sysid);
		
		response.then().assertThat().body("result.number", Matchers.containsString("INC"));
		response.then().log().all();
	}

}

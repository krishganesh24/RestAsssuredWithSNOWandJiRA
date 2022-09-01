import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateIncident {
	
	@Test
	public void updateRequest( ) {
		
		
		RestAssured.baseURI="https://dev131709.service-now.com/api/now/table/incident";
		RequestSpecification input = RestAssured.given().log().all().auth().basic("admin", "abQJKctlE4qSF-8=" ).
		contentType(ContentType.JSON).
		queryParam("sysparm_fields", "sys_id,description,category,number").
		body("{\"short_description\":\"Laptop is not working\",\"description\": \"Windo-10.12.13.14. is not able to login\",\"category\":\"Software\"},");
		
		Response response = input.put("2ec2419297a5d110a871bfb6f053af3a");
		
		response.then().assertThat().statusCode(200);
		response.then().log().all();
		
		
		
	}

}

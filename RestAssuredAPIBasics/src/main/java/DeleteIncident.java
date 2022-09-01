import org.apache.http.client.params.AllClientPNames;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteIncident {

	@Test
	public void deleteIncident() {

		RestAssured.baseURI = "https://dev131709.service-now.com/api/now/table/incident";
		RequestSpecification input = RestAssured.given().log().all().auth().basic("admin", "abQJKctlE4qSF-8=")
				.contentType(ContentType.JSON);
		Response response1 = input.delete("f2a6991697e5d110a871bfb6f053afd9");
		response1.then().assertThat().statusCode(204);
		Assert.assertEquals(response1.statusCode(), 204);
		Response response2 = input.delete("f2a6991697e5d110a871bfb6f053afd9");
		response2.then().assertThat().statusCode(404);
		Assert.assertEquals(response2.statusCode(), 404);
		response2.then().log().all();

	}

}

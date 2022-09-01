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

public class GetIncidents {

	@Test
	public void getAllIncidents() {

		Map<String, String> querymap = new HashMap<String, String>();
		querymap.put("sysparm_fields", "sys_id,description,category,number,caller_id");
		querymap.put("category", "software");
		RestAssured.baseURI = "https://dev131709.service-now.com/api/now/table/incident";
		// RestAssured.authentication= RestAssured.basic("admin", "abQJKctlE4qSF-8=");
		RequestSpecification input = RestAssured.given().log().all().auth().basic("admin", "abQJKctlE4qSF-8=");
		Response response = input.get("ea4c5d3297211110a871bfb6f053afad");
		response.prettyPrint();
		System.out.println("Status COde=" + response.statusCode());
		int respcode = response.getStatusCode();
		Assert.assertEquals(respcode, 200);
		/*
		 * List<Object> listofsysids = response.jsonPath().getList("result.sys_id");
		 * System.out.println("List of Sysids ="+listofsysids);
		 */
		response.then().assertThat().statusCode(200);
		String callid = response.jsonPath().getString("result.caller_id.link");
		System.out.println("callIDURL:" + callid);
		Response callerid = input.get(callid);
		callerid.then().assertThat().statusCode(200);
		String actualcallerid = callerid.jsonPath().getString("result.name");
		System.out.println("Actualcaller id =" + actualcallerid);
		callerid.then().assertThat().body("result.name", Matchers.equalTo("Abel Tuter"));
		response.then().assertThat().body("result.sys_id", Matchers.equalTo("ea4c5d3297211110a871bfb6f053afad"));
		response.then().log().all();
	}

}

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FirstRestAssured {

@Test
	public void  sendGetRequest(){


		Map<String,String> querymap = new HashMap<String,String>();
		querymap.put("sysparm_fields", "sys_id,description,category,number");
		querymap.put("category", "software");
		RestAssured.baseURI="https://dev131709.service-now.com/api/now/table/incident";
		//RestAssured.authentication= RestAssured.basic("admin", "abQJKctlE4qSF-8=");
		RequestSpecification input = RestAssured.given().log().all().auth().basic("admin", "abQJKctlE4qSF-8=").queryParams(querymap);
		Response response = input.get();
		response.prettyPrint();
		System.out.println("Status COde="+response.statusCode());
		int respcode = response.getStatusCode();
		Assert.assertEquals(respcode, 200);
		List<Object> listofsysids = response.jsonPath().getList("result.sys_id");
		System.out.println("List of Sysids ="+listofsysids);

	}


}

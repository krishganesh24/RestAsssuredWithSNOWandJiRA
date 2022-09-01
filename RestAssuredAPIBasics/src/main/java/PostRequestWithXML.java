import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.path.xml.mapping.XmlObjectDeserializer;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithXML {



	public class PostResuestforIncident {

		@Test
		public void createincident()  {


			File inputfile = new File ("./src/main/resources/CreateIncident.xml");
			RestAssured.baseURI="https://dev131709.service-now.com/api/now/table/incident";
			RequestSpecification input = RestAssured.given().log().all().auth().
					basic("admin", "abQJKctlE4qSF-8=")
					.queryParam("sysparm_fields", "sys_id,description,category,number").
					contentType(ContentType.XML).
					accept(ContentType.XML).
					body(inputfile);
			Response response = input.post();
			response.prettyPrint();
			Assert.assertEquals(201, response.statusCode());
			String sysid = response.xmlPath().get("response.result.sys_id");
			System.out.println("Created Sys id"+sysid);
		}

	}
}

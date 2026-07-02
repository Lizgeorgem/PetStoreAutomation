package api.test;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.Routes;
import api.endpoints.userendpoints;
import api.payload.User;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import api.test.UserTests;


public class SchemaValidation {
	
	@Test(dependsOnGroups="post",groups="schema")
	
	public void testReaduserschema()                  
	{
		
		Response res=userendpoints.Readuser(UserTests.userpayload.getUsername());
		Assert.assertEquals(res.getStatusCode(),200);
		res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("petstoreschema.json"));
		res.then().log().all();
	}
	
}

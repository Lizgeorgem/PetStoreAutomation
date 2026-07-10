package api.endpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import api.payload.Pet;

public class petendpoints {
	
	public static Response addpet(Pet petpayload)
	{
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(petpayload)
				.when()
				.post(Routes.petpost_url);
		
		return res;
	}
	
	public static Response getpet(int petid)
	{
		Response res=given()
				.pathParam("petid", petid)
				.when()
				.get(Routes.petget_url);
		
		return res;
	}
	
	public static Response updatepet(Pet petpayload)
	{
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(petpayload)	
				.when()
				.put(Routes.petupdate_url);
		return res;
	}
	
	public static Response deletepet(int petid)
	{
		Response res=given()	
				.pathParam("petid", petid)
				.when()
				.delete(Routes.petdelete_url);
		return res;
	}
	

}

package api.endpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.Pet;

public class petendpoints2 {
	
	static ResourceBundle getURL()
	{
		ResourceBundle routes=ResourceBundle.getBundle("Routes");
		return routes;
		}
	
	public static Response addpet(Pet petpayload)
	{
		String petposturl=getURL().getString("pet_post_url");
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(petpayload)
				.when()
				.post(petposturl);
		
		return res;
	}
	
	public static Response getpet(int petid)
	{
		String petgeturl=getURL().getString("pet_get_url");
		Response res=given()
				.pathParam("petid", petid)
				.when()
				.get(petgeturl);
		
		return res;
	}
	
	public static Response updatepet(Pet petpayload)
	{
		String petupdateurl=getURL().getString("pet_update_url");
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(petpayload)	
				.when()
				.put(petupdateurl);
		return res;
	}
	
	public static Response deletepet(int petid)
	{
		String petdeleteurl=getURL().getString("pet_del_url");
		Response res=given()	
				.pathParam("petid", petid)
				.when()
				.delete(petdeleteurl);
		return res;
	}
	

}

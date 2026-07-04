package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import api.payload.Store2;

public class storeendpoints2 {

	public static Response createorder(Store2 storepayload2)
	{
			Response res=given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(storepayload2)
					.when()
					.post(Routes.storepost_url);
			return res;
	}
	
	public static Response getorder(int id)
	{
			Response res=given()
					.pathParam("orderid", id)
					.when()
					.get(Routes.storeget_url);
			return res;
	}
	
	public static Response deleteorder(int id)
	{
			Response res=given()
					.pathParam("orderid", id)
					.when()
					.get(Routes.storedelete_url);
			return res;
	}

}


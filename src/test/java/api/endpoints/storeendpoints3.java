package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.Store;

public class storeendpoints3 {
	
	static ResourceBundle getURL()
	{
		ResourceBundle routes=ResourceBundle.getBundle("Routes");
		return routes;
	}

	public static Response createorder(Store storepayload)
	{
		String storeposturl=getURL().getString("store_post_url");
			Response res=given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(storepayload)
					.when()
					.post(storeposturl);
			return res;
	}
	
	public static Response getorder(int id)
	{
		String storegeturl=getURL().getString("store_get_url");
			Response res=given()
					.pathParam("orderid", id)
					.when()
					.get(storegeturl);
			return res;
	}
	
	public static Response deleteorder(int id)
	{
		String storedelurl=getURL().getString("store_del_url");
			Response res=given()
					.pathParam("orderid", id)
					.when()
					.get(storedelurl);
			return res;
	}

}


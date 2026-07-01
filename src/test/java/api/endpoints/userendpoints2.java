package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.User;

//contains CRUD (Create,read,update,delete) methods implementation
public class userendpoints2 {
	
	static ResourceBundle getURL()
	{
		ResourceBundle routes=ResourceBundle.getBundle("Routes");
		return routes;
	}

	public static Response createuser(User payload)
	{
		String posturl=getURL().getString("post_url");
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post(posturl);
		return res;
		
	}
	
	public static Response Readuser(String Username)
	{
		String geturl=getURL().getString("get_url");
		Response res=given()
				.pathParam("username",Username)
				.when()
				.get(geturl);
		return res;
		
	}
	public static Response Updateuser(User payload, String Username)
	{
		String updateurl=getURL().getString("update_url");
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username",Username)
				.when()
				.put(updateurl);
		return res;
		
	}
	public static Response Deleteuser(String Username)
	{
		String deleteurl=getURL().getString("delete_url");
		Response res=given()
				.pathParam("username",Username)
				.when()
				.delete(deleteurl);
		return res;
		
	}
}  
package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;

//contains CRUD (Create,read,update,delete) methods implementation
public class userendpoints {

	public static Response createuser(User payload)
	{
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post(Routes.post_url);
		return res;
		
	}
	
	public static Response Readuser(String Username)
	{
		Response res=given()
				.pathParam("username",Username)
				.when()
				.get(Routes.get_url);
		return res;
		
	}
	public static Response Updateuser(User payload, String Username)
	{
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username",Username)
				.when()
				.put(Routes.update_url);
		return res;
		
	}
	public static Response Deleteuser(String Username)
	{
		Response res=given()
				.pathParam("username",Username)
				.when()
				.delete(Routes.delete_url);
		return res;
		
	}
}  
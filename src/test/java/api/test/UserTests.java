package api.test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import com.github.javafaker.Faker;

import api.endpoints.userendpoints;
import api.payload.User;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import api.test.SchemaValidation;

public class UserTests {
	public static User userpayload;
	Faker fake;
	
	@BeforeClass
	
	public void setupdata()
	{
		fake=new Faker();
		userpayload=new User();
		userpayload.setId(fake.idNumber().hashCode());
		userpayload.setUsername(fake.name().username());
		userpayload.setFirstName(fake.name().firstName());
		userpayload.setLastName(fake.name().lastName());
		userpayload.setEmail(fake.internet().emailAddress());
		userpayload.setPassword(fake.internet().password());
		userpayload.setPhone(fake.phoneNumber().cellPhone());
		
	}
	
	@Test(priority=1,groups="post")
	public void testpostuser()
	{
		Response res=userendpoints.createuser(userpayload);
		Assert.assertEquals(res.getStatusCode(),200);
	}
	
	@Test(dependsOnGroups="schema")
	public void testReaduser()                  
	{
		
		Response res=userendpoints.Readuser(this.userpayload.getUsername());
		Assert.assertEquals(res.getStatusCode(),200);
		res.then().log().body();
		String UserName=res.jsonPath().get("username");
		Assert.assertEquals(UserName,this.userpayload.getUsername());
	}
	
	@Test(dependsOnMethods="testReaduser")
	public void testUpdateuser()
	{
		//userpayload.setUsername(fake.name().username());
		userpayload.setFirstName(fake.name().firstName());
		userpayload.setLastName(fake.name().lastName());
		Response res=userendpoints.Updateuser(userpayload, this.userpayload.getUsername());
		Assert.assertEquals(res.getStatusCode(),200);
		
		Response resafter=userendpoints.Readuser(this.userpayload.getUsername());
		resafter.then().log().body();
		resafter.then().body("username",equalTo(this.userpayload.getUsername()));
	}
	
	@Test(dependsOnMethods="testUpdateuser")
	public void testDeleteuser()
	{
		Response res=userendpoints.Deleteuser(this.userpayload.getUsername());
		res.then().log().body().statusCode(200);
	}

}

package api.test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import com.github.javafaker.Faker;

import api.endpoints.userendpoints;
import api.endpoints.userendpoints2;
import api.payload.User;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTests2 {
	User userpayload;
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
	
	@Test(priority=1)
	public void testpostuser()
	{
		Response res=userendpoints2.createuser(userpayload);
		Assert.assertEquals(res.getStatusCode(),200);
	}
	
	@Test(priority=2)
	public void testReaduser()                  
	{
		
		Response res=userendpoints2.Readuser(this.userpayload.getUsername());
		Assert.assertEquals(res.getStatusCode(),200);
		res.then().log().body();
		String UserName=res.jsonPath().get("username");
		Assert.assertEquals(UserName,this.userpayload.getUsername());
	}
	
	@Test(priority=3)
	public void testUpdateuser()
	{
		userpayload.setUsername(fake.name().username());
		userpayload.setFirstName(fake.name().firstName());
		userpayload.setLastName(fake.name().lastName());
		Response res=userendpoints.Updateuser(userpayload, this.userpayload.getUsername());
		Assert.assertEquals(res.getStatusCode(),200);
		
		Response resafter=userendpoints2.Readuser(this.userpayload.getUsername());
		resafter.then().log().body();
		resafter.then().body("username",equalTo(this.userpayload.getUsername()));
	}
	
	@Test(priority=4)
	public void testDeleteuser()
	{
		Response res=userendpoints2.Deleteuser(this.userpayload.getUsername());
		res.then().log().body().statusCode(200);
	}

}

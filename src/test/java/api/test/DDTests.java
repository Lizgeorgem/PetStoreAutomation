package api.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.endpoints.userendpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class DDTests {
	
	//Step 1: Here we are going to do post req with details from excel sheet
	//Step 2 : Here we are going to get usernames from excel sheet and we are doing a del req
	
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testPostUser(String UserID, String username, String fname, String lname, String useremail, String pwd, String ph)
	{
		User userpayload=new User();
		userpayload.setId(Integer.parseInt(UserID));
		userpayload.setUsername(username);
		userpayload.setFirstName(fname);
		userpayload.setLastName(lname);
		userpayload.setEmail(useremail);
		userpayload.setPassword(pwd);
		userpayload.setPassword(ph);
		Response res=userendpoints.createuser(userpayload);
		System.out.println(res.asString());
		 Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority=2,dependsOnMethods= {"testPostUser"},dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void testdeleteUser(String username)
	{
		Response res=userendpoints.Deleteuser(username);
		Assert.assertEquals(res.getStatusCode(), 200);
	}

}

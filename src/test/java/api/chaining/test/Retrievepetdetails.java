package api.chaining.test;
import api.payload.Pet;
import api.test.PetTests;
import api.payload.Category;
import api.payload.Tag;
import io.restassured.response.Response;
import api.endpoints.petendpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
                 
public class Retrievepetdetails {
	
	@Test(dependsOnGroups="add",groups="get")
	public void getpet(ITestContext context)
	{
    int petid=(Integer)context.getAttribute("petid");
	Response res=petendpoints.getpet(petid);
	res.then().log().all();
	
	
	}
}

package api.test;
import api.payload.Store;
import io.restassured.response.Response;
import api.endpoints.storeendpoints3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StoreTests2 {
	
	Store storepayload;
	Faker fake;
	int id;
	
	@BeforeClass
	public void storedatasetup()
	{
		fake=new Faker();
		storepayload=new Store();
		storepayload.setId(fake.idNumber().hashCode());
		storepayload.setPetid(fake.idNumber().hashCode());
		storepayload.setQuantity(fake.number().randomDigit());
		storepayload.setShipdate(fake.date().toString());
		
	}
	
	@Test(priority=1)
	public void testpostorder()
	{
		Response res=storeendpoints3.createorder(storepayload);
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority=2)
	public void testgetorder()
	{
		id=this.storepayload.getId();
		Response res=storeendpoints3.getorder(id);
		int idno=res.jsonPath().get("id");
		Assert.assertEquals(idno, id);
	}
	
	@Test(priority=3)
	
	public void testdeleteeorder()
	{
		Response res=storeendpoints3.deleteorder(id);
		res.then().log().all().statusCode(200);
	}
	

}

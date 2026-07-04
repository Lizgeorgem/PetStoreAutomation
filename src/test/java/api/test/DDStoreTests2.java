package api.test;
import api.payload.Store2;
import api.utilities.DataProvidersstore;
import io.restassured.response.Response;
import api.endpoints.storeendpoints2;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DDStoreTests2 {
	
	Store2 storepayload2;
	
	@Test(priority=1,dataProvider="Data1",dataProviderClass=DataProvidersstore.class)
	public void testpostorder(String id,String petid,String quantity,String shipdate,String status,String complete)
	{
		storepayload2=new Store2();
		storepayload2.setId(Integer.parseInt(id));
		storepayload2.setPetid(Integer.parseInt(petid));
		storepayload2.setQuantity(Integer.parseInt(quantity));
		storepayload2.setShipdate(shipdate);
		storepayload2.setStatus(status);
		storepayload2.setComplete(Boolean.parseBoolean(complete));
		Response res=storeendpoints2.createorder(storepayload2);
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority=2,dataProvider="id1",dataProviderClass=DataProvidersstore.class)
	public void testgetorder(String id)
	{
		//id=this.storepayload.getId();
		Response res=storeendpoints2.getorder(Integer.parseInt(id));
		int idno=res.jsonPath().get("id");
		Assert.assertEquals(idno, Integer.parseInt(id));
	}
	
	@Test(priority=3,dataProvider="id1",dataProviderClass=DataProvidersstore.class)
	
	public void testdeleteeorder(String id)
	{
		Response res=storeendpoints2.deleteorder(Integer.parseInt(id));
		res.then().log().all().statusCode(200);
	}
	

}

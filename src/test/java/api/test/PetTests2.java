package api.test;
import api.payload.Pet;
import api.payload.Category;
import api.payload.Tag;
import io.restassured.response.Response;
import api.endpoints.petendpoints2;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class PetTests2 {
	
	Faker fake;
	Pet petpayload;
	
	@BeforeClass
	public void petdatasetup()
	{
		fake=new Faker();
		petpayload=new Pet();
		petpayload.setId(fake.idNumber().hashCode());
		Category category= new Category();
		category.setId(fake.number().numberBetween(1, 100));
		category.setName(fake.animal().name());
		petpayload.setCategory(category);
		petpayload.setName(fake.name().firstName());
		petpayload.setPhotoUrls(new String[] {fake.internet().avatar()});
		Tag tag=new Tag();
		tag.setId(fake.number().numberBetween(1, 100));
		tag.setName(fake.animal().name());
		petpayload.setTags(new Tag[] {tag});
		petpayload.setStatus("available");	
		
	}
	
	@Test(priority=1)
	public void TestPostPet()
	{
		Response res=petendpoints2.addpet(petpayload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
	}
	
	@Test(priority=2)
	public void TestGetPet()
	{
		Response res=petendpoints2.getpet(this.petpayload.getId());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(this.petpayload.getId(),res.jsonPath().getInt("id"));
	}
	@Test(priority=3)
	public void TestUpdatePet()
	{
		petpayload.setName(fake.name().firstName());
		petpayload.setStatus("notavailable");
		Response res=petendpoints2.updatepet(petpayload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
	}
	@Test(priority=4)
	public void TestDeletePet()
	{
		Response res=petendpoints2.deletepet(this.petpayload.getId());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
	}
	
	}
	
	



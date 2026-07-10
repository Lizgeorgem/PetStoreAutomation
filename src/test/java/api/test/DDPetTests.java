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
import api.utilities.DataProviderspet;


public class DDPetTests {
	
	Faker fake=new Faker();
	Pet petpayload1=new Pet();
	@Test(priority=1,dataProvider="Data2",dataProviderClass=DataProviderspet.class)
	public void TestPostPet(String id,String categoryId,String categoryName,String petName,String photoUrl,String tagId,String tagName,String status)
	{
		petpayload1.setId(Integer.parseInt(id));
		Category category=new Category();
		category.setId(Integer.parseInt(categoryId));
		category.setName(categoryName);
		petpayload1.setCategory(category);
		petpayload1.setName(petName);
		petpayload1.setPhotoUrls(new String[] {photoUrl});
		Tag tag=new Tag();
		tag.setId(Integer.parseInt(tagId));
		tag.setName(tagName);
		petpayload1.setTags(new Tag[] {tag});
		petpayload1.setStatus(status);
		
		Response res=petendpoints2.addpet(petpayload1);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);	
		
	}
	
	@Test(priority=2,dataProvider="petid",dataProviderClass=DataProviderspet.class)
	public void TestGetPet(String id)
	{
		Response res=petendpoints2.getpet(Integer.parseInt(id));
		res.then().log().body();
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(Integer.parseInt(id),res.jsonPath().getInt("id"));
		
	}
	@Test(priority=3,dataProvider="Data2",dataProviderClass=DataProviderspet.class)
	public void TestUpdatePet(String id,String categoryId,String categoryName,String petName,String photoUrl,String tagId,String tagName,String status)
	{
		petpayload1.setName(fake.name().firstName());
		petpayload1.setStatus("pending");
		Response res=petendpoints2.updatepet(petpayload1);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
	}
	@Test(priority=4,dataProvider="petid",dataProviderClass=DataProviderspet.class)
	public void TestDeletePet(String id)
	{
		Response res=petendpoints2.deletepet(Integer.parseInt(id));
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
	}
	
	}
	
	



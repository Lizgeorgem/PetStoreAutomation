package api.endpoints;

public class Routes {
	
	public static String base_url="https://petstore.swagger.io/v2";
	public static String base_url1="https://petstore.swagger.io/v2/store";
	
	//user model
	
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String update_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";
	
	//store model
	
	public static String storepost_url=base_url1+"/order";
	public static String storeget_url=base_url1+"/order/{orderid}";
	public static String storedelete_url=base_url1+"/order/{orderid}";
	
	//pet model
	
	public static String petpost_url=base_url+"/pet";
	public static String petget_url=base_url+"/pet/{petid}";
	public static String petupdate_url=base_url+"/pet";
	public static String petdelete_url=base_url+"/pet/{petid}";
	

}

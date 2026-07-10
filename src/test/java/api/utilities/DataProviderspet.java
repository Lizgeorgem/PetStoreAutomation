package api.utilities;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import java.io.IOException;

public class DataProviderspet {
	@DataProvider(name="Data2")
	public String[][] getAllData() throws IOException
	{
		String path=System.getProperty("user.dir")+"\\TestData\\testdata2.xlsx";
		XLUtility xl=new XLUtility(path);
		int rownum=xl.getRowCount("Sheet1");
		int colcount=xl.getCellCount("Sheet1", 1);
		String apidata[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				apidata[i-1][j]=xl.getCellData("Sheet1", i, j);
			}
			
		}
		return apidata;
	}
	
	@DataProvider(name="petid")
	public String[] getPetid() throws IOException
	{
		String path=System.getProperty("user.dir")+"\\TestData\\testdata2.xlsx";
		XLUtility xl=new XLUtility(path);
		int rownum=xl.getRowCount("Sheet1");
		String apidata[]=new String[rownum];
		for(int i=1;i<=rownum;i++)
		{
			apidata[i-1]=xl.getCellData("Sheet1",i,0);
		}
		return apidata;
	}
	
	
}

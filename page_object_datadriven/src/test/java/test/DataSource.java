package test;

import org.testng.annotations.DataProvider;
import utility.Utility;

public class DataSource {

	
	@DataProvider(name="DP")
	public Object[][] selectdataProvider() throws Exception{
		
		Object [][] exceldata;
		exceldata= Utility.getTableArray("C:\\Users\\govinda.gupta\\Govinda_10926847\\TestCase1Data.xlsx", "Sheet1");
		return exceldata;
		
		
		}
	
	@DataProvider(name="FDP")
	public Object[][] flightprovideData() throws Exception{
		/*Object [][] exceldata;
		exceldata=Utility.getTableArray("C:\\Selinium\\.xlsx", "Sheet1");
		return exceldata;*/
		
		return new Object[][]{{"govinda","gupta","12345"}};
		}
	
	
}

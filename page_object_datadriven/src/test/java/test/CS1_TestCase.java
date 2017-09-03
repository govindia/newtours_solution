/*'###############################################################################
'-------------------------------------------------------------------------------
' Case Study: Case Study 1

' Script Name: TS_BookFlight
' Brief Functional Description: Book a return Journey
' Created On: 02-04-2016
' Created By: govinda.gupta
' Comments/Remmark: Using TestNG framework for this Test
'-------------------------------------------------------------------------------
'###############################################################################

*/
package test;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.FlightBookingPage;
import pages.FlightsPage;
import pages.IternityPage;
import pages.LoginPage;
import pages.SelectFlightPage;
import utility.Log;
import utility.Utility;


public class CS1_TestCase{
	
	WebDriver driver;
	FlightsPage flights;
	SelectFlightPage selectflight;
	FlightBookingPage bookflight;
	IternityPage collectiternity;
	
	@BeforeTest
	public void setUpTest(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\govinda.gupta\\git\\New_Tours_Demo\\page_object_datadriven\\drivers\\chromedriver.exe");
        driver =new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com");
		Log.info("User is navigated to the home page");
		Assert.assertTrue(driver.findElement(By.name("userName")).isDisplayed());
		Log.info("Username field is present");
		Utility.captureScreenShot(driver, "login_page");
		Assert.assertEquals(driver.getTitle(),"Welcome: Mercury Tours");
		Log.info("Home page is validated using page title");
	}
	
	@Test(priority=1)
	public void loginTest()
	{    
		
		String expectedtitle="Find a Flight: Mercury Tours:";
		String actualtitle;
		LoginPage login=new LoginPage(driver);
		login.setUsername("mercury");
		login.setPassword("mercury");
		flights=login.clickLogin();
		Utility.captureScreenShot(driver, "flightfinder_page");
		Assert.assertTrue(driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img")).isDisplayed());
		Log.info("Flight Finder page validated sucessfully");
		actualtitle=driver.getTitle();
		Assert.assertEquals(actualtitle, expectedtitle);
		Log.info("Flight Finder page validated sucessfully by title");
		
	}
	@Test(priority=2)
	public void findFlight(){
		int i=1;
		List<String> options;
		
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Assert.assertTrue(driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img")).isDisplayed());
		Log.info("Flight Finder page validated sucessfully");
		Utility.captureScreenShot(driver, "Flightfinder_page");
		flights.setType();
		flights.setPassenger(0);
		options=flights.getDropdownValues();
		for(String option:options){
			Log.info("option"+i+"="+option);
			System.out.println("option"+i+"="+option);
			i++;
		}
	
		flights.setDepart_from("Frankfurt");
		flights.setDepartureDate("April-7");
		flights.setArriving_in("London");
		flights.setArrivalDate("April-8");
		flights.setService_class();
		flights.setAirlinpreference("Unified Airlines");
		selectflight=flights.clickContinue();
	}
	
	@Test(priority=3)
	public void selectFlight(){
		
		Assert.assertTrue(driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img")).isDisplayed());
		Log.info("Select Flight page validated sucessfully");
		Utility.captureScreenShot(driver, "selectflight_page");
		selectflight.setDepartflight("Blue Skies Airlines$361");
		selectflight.setReturnflight("Blue Skies Airlines$630");
		bookflight=selectflight.clickContinue();
		
		
	}
	
	@Test(priority=4,dataProvider="DP")
	public void bookFlight(String firstname,String lastname,String cardnumber){
		Assert.assertTrue(driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img")).isDisplayed());
		Log.info("Flight Booking page validated sucessfully");
		Utility.captureScreenShot(driver, "Flightbooking_page");
		bookflight.setFirstname(firstname);
		bookflight.setLastname(lastname);
		bookflight.setNumber(cardnumber);
		collectiternity=bookflight.clickSecurePurchase();
		
	}
	
	@AfterTest
	public void tearDown(){
		Assert.assertTrue(driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td/p/font/b/font[2]")).isDisplayed());
		Log.info("Iternity is successfully generated");
		collectiternity.setLogout();
		driver.close();
		
	}	
	
	@DataProvider(name="DP")
	public Object[][] provideData() throws Exception{
		return new Object[][]{{"govinda","gupta","12345"}};
		}
	
	/*@DataProvider(name="SDP")
	public Object[][] provideSearchData() throws Exception{
		Object [][] exceldata;
		exceldata=Utility.getTableArray("c:\\Selinium\\TestCase1Data.xlsx", "Sheet1");
		return exceldata;
		
		}*/
		
		
		
	}



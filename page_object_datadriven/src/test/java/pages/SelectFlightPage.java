package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectFlightPage extends BasePage {
	
	@FindBy(name="reserveFlights")
	WebElement submit;
	
	
	public SelectFlightPage(WebDriver driver) {
		super(driver);
	}
	
	List<WebElement> getOptions(String xpath){
	
		List<WebElement> options=driver.findElements(By.xpath(xpath));
		
		return options;
		
		
	}
	
	
	public void setDepartflight(String departflight) {
		List<WebElement> options=getOptions("//input[@name='outFlight']");
		
		for(WebElement option:options){
			
			if(option.getAttribute("value").contains(departflight)){
				
				option.click();
			}
		}
	}

	

	public void setReturnflight(String returnflight)  {
		List<WebElement> options=getOptions("//input[@name='inFlight']");
		
		for(WebElement option:options){
			
			if(option.getAttribute("value").contains(returnflight)){
				
				option.click();
			}
		}
	}

	
	public FlightBookingPage clickContinue()
	{
		this.submit.click();
		
		return new FlightBookingPage(driver);
		
	}
	
}



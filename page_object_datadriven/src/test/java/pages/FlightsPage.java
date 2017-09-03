package pages;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

public class FlightsPage extends BasePage {


	@CacheLookup
	@FindBy(xpath="//input[@value='roundtrip']")
	WebElement type;
	@CacheLookup
	@FindBy(name="passCount")
	WebElement passenger;
	@CacheLookup
	@FindBy(name="fromPort")
	WebElement depart_from;
	@CacheLookup
	@FindBy(name="fromMonth")
	WebElement from_month;
	@CacheLookup
	@FindBy(name="fromDay")
	WebElement from_day;
	@CacheLookup
	@FindBy(name="toPort")
	WebElement arriving_in;
	@CacheLookup
	@FindBy(name="toMonth")
	WebElement to_month;
	@CacheLookup
	@FindBy(name="toDay")
	WebElement to_day;
	@CacheLookup
	@FindBys(value = { @FindBy(name="servClass"),@FindBy(xpath="//input[@value='Coach']") })
	WebElement service_class;
	@CacheLookup
	@FindBy(name="airline")
	WebElement airline_preference;
	@CacheLookup
	@FindBy(name="findFlights")
	WebElement submit;
	

	public FlightsPage(WebDriver driver){
		
		super(driver);
	}
	
	public void setType() {
		this.type.click();
	}
	
	public void setPassenger(int passengercount) {
		Select departingFrom=new Select(passenger);
		departingFrom.selectByIndex(passengercount);;
	}
	
	public void setDepart_from(String departingCity ) {
		Select departingFrom=new Select(depart_from);
		departingFrom.selectByVisibleText(departingCity);
	}
	
	public void setDepartureDate(String departingOnValue) {
		
		String[] departingOnValues = departingOnValue.split("-");
		Select fromMonth=new Select(from_month);
		fromMonth.selectByVisibleText(departingOnValues[0]);
		Select fromDay=new Select(from_day);
		fromDay.selectByVisibleText(departingOnValues[1]);
	}

	public void setArrivalDate(String arrivingOnValue) {
		String[] arrivingOnValues = arrivingOnValue.split("-");
		Select fromMonth=new Select(to_month);
		fromMonth.selectByVisibleText(arrivingOnValues[0]);
		Select fromDay=new Select(to_day);
		fromDay.selectByVisibleText(arrivingOnValues[1]);
	}

	public void setService_class() {
		this.service_class.click();
	}

	public void setArriving_in(String arrivingCity) {
		Select departingFrom=new Select(arriving_in);
		departingFrom.selectByVisibleText(arrivingCity);
	}

	public void setAirlinpreference(String airlinpreference) {
		Select departingFrom=new Select(airline_preference);
		departingFrom.selectByVisibleText(airlinpreference);
	}
	
	public SelectFlightPage clickContinue(){
		
		this.submit.click();
		
		return new SelectFlightPage(driver);
		
	}
	
	
	
	public List<String> getDropdownValues(){
		
		List<WebElement> weOptions;
		List<String> strOptions=new ArrayList<String>();
		Select departingFrom=new Select(depart_from);
		weOptions=departingFrom.getOptions();
		for(WebElement option:weOptions){
			
			strOptions.add(option.getAttribute("value"));
			
		}
		
		return strOptions;
	}
}




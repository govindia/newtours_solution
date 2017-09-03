package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class FlightBookingPage extends BasePage {

	public FlightBookingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
	
	@CacheLookup
	@FindBy(name="passFirst0")
	WebElement firstname;
	@CacheLookup
	@FindBy(name="passLast0")
	WebElement lastname;
	@CacheLookup
	@FindBy(name="creditnumber")
	WebElement number;
	@CacheLookup
	@FindBy(id="ex")
	WebElement expiration;
	@CacheLookup
	@FindBy(id="ex")
	WebElement billingcountry;
	@CacheLookup
	@FindBy(id="ex")
	WebElement deliverycountry;
	@CacheLookup
	@FindBy(name="buyFlights")
	WebElement submit;
	
	
	public void setFirstname(String firstname) {
		this.firstname.sendKeys(firstname);
	}
	public void setLastname(String lastname) {
		this.lastname.sendKeys(lastname);
	}
	public void setNumber(String number) {
		this.number.sendKeys(number);
	}
	public void setExpiration(String expiration) {
		this.expiration.sendKeys(expiration);
	}
	public void setBillingcountry(String billingcountry) {
		this.billingcountry.sendKeys(billingcountry);
	}
	public void setDeliverycountry(String deliverycountry) {
		this.deliverycountry.sendKeys(deliverycountry);
	}
	public IternityPage clickSecurePurchase() {
		this.submit.click();
		return new IternityPage(driver);
	}
	
	
	
}

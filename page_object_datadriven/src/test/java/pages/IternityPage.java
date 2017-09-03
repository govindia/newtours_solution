package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class IternityPage extends BasePage {

	public IternityPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
	
	@CacheLookup
	@FindBy(xpath="html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img")
	WebElement backtohome;
	@CacheLookup
	@FindBy(xpath="html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img")
	WebElement flights;
	@CacheLookup
	@FindBy(xpath="html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img")
	WebElement logout;
	
	public void setBacktohome() {
		this.backtohome.click();
	}
	public void setFlights() {
		this.flights.click();
	}
	public void setLogout() {
		this.logout.click();
	}
	
	
}

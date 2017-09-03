package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	@CacheLookup
	@FindBy(name="userName")
	WebElement username;
	@CacheLookup
	@FindBy(name="password")
	WebElement password;
	@CacheLookup
	@FindBy(name="login")
	WebElement login;
	
	
	public LoginPage(WebDriver driver){
		
		super(driver);	
	}
	public void setUsername(String username) {
		this.username.sendKeys(username);
	}
	public void setPassword(String password) {
		this.password.sendKeys(password);
	
	}
	public FlightsPage clickLogin() {
		this.login.click();
		return (new FlightsPage(driver));
	}
	
	
}

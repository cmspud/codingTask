package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LandingPage extends TestBase{
	
//	Page Factory - Object Repository
	@FindBy(css="a.login")
	WebElement signinLink;
	
	@FindBy(css="input#search_query_top")
	WebElement searchBox;
	
	@FindBy(css="button[name='submit_search']")
	WebElement searchBtn;
	
	@FindBy(css="a[title='My Store']")
	WebElement logo;
	
	
//	Initializing page Objects
	public LandingPage() {
		PageFactory.initElements(driver, this);
	}

//	Page Actions
	public String validateLandingPageTitle() {
		return driver.getTitle();
	}
	
	public boolean logoPresent() {
		return logo.isDisplayed();
	}
	
	public LoginPage clickOnSignin() {
		signinLink.click();
		return new LoginPage();
	}
	
	
}
	

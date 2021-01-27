package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class AccountPage extends TestBase{
	AccountPage accountPage;
	LoginPage loginPage;
	
//	Page Factory - Object Repository
	@FindBy(css="a.account")
	WebElement userAccountName;
	
	@FindBy(css="button[name='submit_search']")
	WebElement searchBtn;
	
	@FindBy(xpath="//*[@id='header_logo']/a/img")
	WebElement logo;
	
	@FindBy(css="input#search_query_top")
	WebElement searchBox;	
	
	
	
//	Initializing Page Objects	
	
	public AccountPage() {
		PageFactory.initElements(driver, this);
	}
	
//	page Actions
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public String getUserAccountName() {
		return userAccountName.getText();
	}
	
	public SearchPage clickOnSearchBtn() {
		searchBtn.click();
		
		return new SearchPage();
	}
	
	public LandingPage clickOnLogo(){
		logo.click();
		
		return new LandingPage();
	}
	
	public void clickOnDressesBtn() {
		
	}
	
	public boolean logoPresent() {
		return logo.isDisplayed();
	}
	
	
	
	

}

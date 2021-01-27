package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase{


//	Page Factory - Object Repository
	@FindBy(css="input#email")
	WebElement email;
	
	@FindBy(css="input#passwd")
	WebElement password;
	
	@FindBy(css="button[name='submit_search']")
	WebElement searchBtn;
	
	@FindBy(xpath="//*[@id='header_logo']/a/img")
	WebElement logo;
	
	@FindBy(css="button#SubmitLogin")
	WebElement signinBtn;
	
//	Initializing Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
//	page Actions
	public AccountPage validLogin(String username, String pwd) {
		email.sendKeys(username);
		password.sendKeys(pwd);
		signinBtn.click();
		
		return new AccountPage();		
	}
	
	public void invalidLoing(String username, String pwd) {
		email.sendKeys(username);
		password.sendKeys(pwd);
		signinBtn.click();
	}
	
	public String verifyloginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean logoPresent() {
		return logo.isDisplayed();
	}
}
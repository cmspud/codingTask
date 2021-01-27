package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class SearchPage extends TestBase{
	
//	Page Factory - Object Repository
	@FindBy(css="a.account")
	WebElement userAccountName;
	
	@FindBy(css="button[name='submit_search']")
	WebElement searchBtn;
	
	@FindBy(xpath="//*[@id='header_logo']/a/img")
	WebElement logo;
	
	@FindBy(css="input#search_query_top")
	WebElement searchBox;	
	
	@FindBy(css="a[title='Women']")
	WebElement WomenBtn;
	
	@FindBy(css="a[title='Dresses']")
	WebElement DressesBtn;
	
	@FindBy(css="a[title='T-shirts']")
	WebElement TShirsBtn;
	
	@FindBy(css="a[title='Summer Dresses']")
	WebElement SummerDressesBtn;
	
//	@FindBy(css="product-container")
//	WebElement products;
	
	@FindBy(css="a[title='Add to cart']")
	WebElement AddToCartBtn;
	
	
//	Initializing Page Objects	
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	
//	Page Actions
	
	public String getSearchPageTitle() {
		return driver.getTitle();
	}
		
	public LandingPage clickOnLogo(){
		logo.click();
		
		return new LandingPage();
	}
	
	public void clickOnDressesBtn() {
		DressesBtn.click();
	}
	
	public boolean logoPresent() {
		return logo.isDisplayed();
	}

	public void clickOncasualDresses() {
		Actions action = new Actions(driver);
		action.moveToElement(DressesBtn).build().perform();
		SummerDressesBtn.click();
	}
	
	public void selectLowestFirst(String option) {
		Select select = new Select(driver.findElement(By.id("selectProductSort")));
		select.deselectByVisibleText(option);
	}
	
	public void doSearch() {
		searchBox.sendKeys("dress");
		searchBtn.click();
	}
	
	public void ClickOnAddToCartButton() {
		AddToCartBtn.click();
	}

}

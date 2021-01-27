package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.AccountPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;

public class SearchPageTest extends TestBase {

	LandingPage landingPage;
	LoginPage loginPage;
	AccountPage accountPage;
	SearchPage searchPage;
	
	SearchPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initializeDriver();
		landingPage = new LandingPage();
		loginPage = landingPage.clickOnSignin();
		accountPage = loginPage.validLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		searchPage = accountPage.clickOnSearchBtn();
	}
	
	@Test
	public void logoTest() {
		boolean flag = accountPage.logoPresent();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void verifySearchPageTitleTest() {
		String searchPageTitle = searchPage.getSearchPageTitle();
		Assert.assertEquals(searchPageTitle, "Search - My Store");
	}
	
	@Test
	public void AddtoCartTest() {
		Actions action = new Actions(driver);
		searchPage.doSearch();
		List<WebElement> products = driver.findElements(By.cssSelector("a[title='Summer Dresses']"));
		for(WebElement product:products) {
			String productName = product.getText();
			if(productName.equals("Blouse")) {
				action.moveToElement(product).build().perform();
				searchPage.ClickOnAddToCartButton();			
			}
				
		}
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

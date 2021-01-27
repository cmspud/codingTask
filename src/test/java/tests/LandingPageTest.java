package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class LandingPageTest extends TestBase{
	LandingPage landingPage;
	LoginPage loginPage;
	
	public LandingPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initializeDriver();
		landingPage = new LandingPage();		
	}
	
	@Test(priority=1)
	public void landingPageTitleTest() {
		String title = landingPage.validateLandingPageTitle();
		Assert.assertEquals(title, "My Store");
	}
	
	@Test(priority=1)
	public void logoTest() {
		boolean flag = landingPage.logoPresent();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void signinLinkTest() {
		loginPage = landingPage.clickOnSignin();		
	}	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}

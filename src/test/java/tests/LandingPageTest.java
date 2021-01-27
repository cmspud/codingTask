package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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
		AssertJUnit.assertEquals(title, prop.getProperty("LANDING_PAGE_TITLE"));
	}
	
	@Test(priority=1)
	public void logoTest() {
		boolean flag = landingPage.logoPresent();
		AssertJUnit.assertTrue(flag);
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

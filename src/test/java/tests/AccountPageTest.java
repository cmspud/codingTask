package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.AccountPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class AccountPageTest extends TestBase {
	LandingPage landingPage;
	LoginPage loginPage;
	AccountPage accountPage;
	
	
	AccountPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initializeDriver();
		landingPage = new LandingPage();
		loginPage = landingPage.clickOnSignin();
		accountPage = loginPage.validLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void logoTest() {
		boolean flag = accountPage.logoPresent();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void verifyUserAccountNameTest() {
		String userAccountName = accountPage.getUserAccountName();
		Assert.assertEquals(userAccountName, "spoorthi dasari");
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

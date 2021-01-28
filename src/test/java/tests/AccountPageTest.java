package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;

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
		AssertJUnit.assertTrue(flag);
	}
	
	@Test
	public void verifyUserAccountNameTest() {
		String userAccountName = accountPage.getUserAccountName();
		AssertJUnit.assertEquals(userAccountName, "spoorthi dasari");
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

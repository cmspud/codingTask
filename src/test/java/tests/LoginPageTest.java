package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import base.TestBase;
import pageObjects.AccountPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import utils.TestUtil;

public class LoginPageTest extends TestBase{
	LandingPage landingPage;
	LoginPage loginPage;
	AccountPage accountPage;
	
	String sheetName = "logindata";
	
	LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initializeDriver();
		landingPage = new LandingPage();
		loginPage = landingPage.clickOnSignin();
	}
	
	@Test
	public void verifyloginPageTitleTest() {
		String title = loginPage.verifyloginPageTitle();
		System.out.println(title);
		AssertJUnit.assertEquals(title, "Login - My Store");
	}
	
	@Test(priority=1)
	public void logoTest() {
		boolean flag = loginPage.logoPresent();
		AssertJUnit.assertTrue(flag);
	}	
	
	@Test()
	public void validLoginTest() {
		String title = driver.getTitle();
		Assert.assertEquals(title, prop.getProperty("LOGIN_PAGE_TITLE"));
		loginPage.validLogin(prop.getProperty("username"),prop.getProperty("password"));		
		String title1 = driver.getTitle();
		Assert.assertEquals(title1, prop.getProperty("ACCOUNT_PAGE_TITLE"));
	}
	
	@DataProvider()
	public Object[][] getcodingTaskTestData() {
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=4, dataProvider="getcodingTaskTestData")
	public void inValidLoginTest(String email, String password) {
		loginPage.validLogin(email, password);
		Assert.assertFalse(loginPage.errorPresent());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

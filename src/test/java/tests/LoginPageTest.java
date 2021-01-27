package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
		Assert.assertEquals(title, "Login - My Store");
	}
	
	@Test(priority=1)
	public void logoTest() {
		boolean flag = loginPage.logoPresent();
		Assert.assertTrue(flag);
	}
	
	
	
	@Test()
	public void validLoginTest() {
		loginPage.validLogin(prop.getProperty("username"),prop.getProperty("password"));		
	}
	
	@DataProvider()
	public Object[][] getcodingTaskTestData() {
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider="getcodingTaskTestData")
	public void inValidLoginTest(String email, String password) {
		loginPage.validLogin(email, password);
	}
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

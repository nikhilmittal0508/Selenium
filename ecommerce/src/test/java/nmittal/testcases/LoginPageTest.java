package nmittal.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import nmittal.base.BaseClass;
import nmittal.pageobjects.HomePage;
import nmittal.pageobjects.IndexPage;
import nmittal.pageobjects.LoginPage;

public class LoginPageTest extends BaseClass {
	private IndexPage indexPage;
	private LoginPage loginPage;
	private HomePage homePage;
	
	@BeforeMethod
	public void setup() {
		launchApp("chrome"); 
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test
	public void Invalidemail() throws Throwable
	{
		indexPage= new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		String alertmsg = loginPage.checkemail("nikhil");
		String expectedalert = "Invalid email address.";
		Assert.assertTrue(alertmsg.contains(expectedalert));
	}
	
	
}

package nmittal.testcases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import nmittal.base.BaseClass;
import nmittal.pageobjects.AccountCreationPage;
import nmittal.pageobjects.HomePage;
import nmittal.pageobjects.IndexPage;
import nmittal.pageobjects.Landingpage;
import nmittal.pageobjects.LoginPage;

public class AccountCreationPageTest extends BaseClass {
	private IndexPage indexPage;
	private LoginPage loginPage;
	private HomePage homePage;
	private AccountCreationPage accountCreationPage;
	
	@BeforeMethod
	public void setup() {
		launchApp("chrome"); 
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	//@Test
	public void validateReg() throws Throwable {
		//Log.startTestCase("printtitle");
		indexPage= new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		accountCreationPage = loginPage.createNewAccount("nikhilmittal15@gmail.com");
		String name = "nikhil";
		accountCreationPage.createAccount(name);
		homePage = accountCreationPage.validateRegistration();
		String username = homePage.username();
		Assert.assertTrue(username.contains(name));
		
		//Log.endTestCase("printtitle");
	}
	
	//@Test
	public void verifyErrorMsg() throws Throwable {
		//Log.startTestCase("printtitle");
		indexPage= new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		accountCreationPage = loginPage.createNewAccount("nikhilmittal16@gmail.com");
		ArrayList<String> error_list = accountCreationPage.emptyInfo();
		Assert.assertEquals(8, error_list.size());
		
		//Log.endTestCase("printtitle");
	}
	
	@Test
	public void validateIncorrectinfo() throws Throwable {
		//Log.startTestCase("printtitle");
		
		indexPage= new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		accountCreationPage = loginPage.createNewAccount("nikhilmittal16@gmail.com");		
		accountCreationPage.incorretInfo();
		
	}
}

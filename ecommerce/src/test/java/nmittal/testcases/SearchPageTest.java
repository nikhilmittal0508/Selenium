package nmittal.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import nmittal.base.BaseClass;
import nmittal.pageobjects.AccountCreationPage;
import nmittal.pageobjects.CatalogPage;
import nmittal.pageobjects.HomePage;
import nmittal.pageobjects.IndexPage;
import nmittal.pageobjects.LoginPage;
import nmittal.pageobjects.ProductPage;
import nmittal.pageobjects.SearchPage;

public class SearchPageTest extends BaseClass{
	private IndexPage indexPage;
	private LoginPage loginPage;
	private HomePage homePage;
	private SearchPage searchPage;
	private CatalogPage catalogPage;
	
	@BeforeMethod
	public void setup() {
		launchApp("chrome"); 
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test
	public void searchProduct() throws Throwable
	{
		indexPage= new IndexPage();
		catalogPage=indexPage.womentshirt();
		String prodName_exp = catalogPage.getProductName();
		
		searchPage = indexPage.search(prodName_exp);
		String prodName_actual = searchPage.getSearchProductName();
		
		Assert.assertTrue(prodName_actual.contains(prodName_exp));
		
	}
}

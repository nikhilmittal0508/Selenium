package nmittal.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import nmittal.base.BaseClass;
import nmittal.pageobjects.CatalogPage;
import nmittal.pageobjects.IndexPage;
import nmittal.pageobjects.Landingpage;

public class CatalogPageTest extends BaseClass{
	private IndexPage indexPage;
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
	public void verifyAddWishlist() throws Throwable {
		//Log.startTestCase("printtitle");
		indexPage= new IndexPage();
		catalogPage=indexPage.womentshirt();
		String errormsg = catalogPage.addWishlistNoLogin();
		
		Assert.assertEquals(errormsg, "You must be logged in to manage your wishlist.");
				
	}
}

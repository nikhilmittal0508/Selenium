package nmittal.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import nmittal.base.BaseClass;
import nmittal.pageobjects.CatalogPage;
import nmittal.pageobjects.IndexPage;
import nmittal.pageobjects.OrderSummaryPage;
import nmittal.pageobjects.ProductPage;

public class OrderSummaryPageTest extends BaseClass{
	private IndexPage indexPage;
	private CatalogPage catalogPage;
	private ProductPage productPage;
	private OrderSummaryPage orderSummaryPage;
	
	@BeforeMethod
	public void setup() {
		launchApp("chrome"); 
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test
	public void verifyPrice() throws Throwable {
		indexPage= new IndexPage();
		catalogPage=indexPage.womentshirt();
		productPage = catalogPage.getDetail();
		orderSummaryPage = productPage.editProductDetails();
		orderSummaryPage.verify_price();
	}
	
}

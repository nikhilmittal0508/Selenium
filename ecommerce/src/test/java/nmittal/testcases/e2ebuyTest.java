package nmittal.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import nmittal.base.BaseClass;
import nmittal.pageobjects.AddressPage;
import nmittal.pageobjects.CatalogPage;
import nmittal.pageobjects.CheckPayPage;
import nmittal.pageobjects.HomePage;
import nmittal.pageobjects.IndexPage;
import nmittal.pageobjects.LoginPage;
import nmittal.pageobjects.OrderConfirmationPage;
import nmittal.pageobjects.OrderSummaryPage;
import nmittal.pageobjects.PaymentPage;
import nmittal.pageobjects.ProductPage;
import nmittal.pageobjects.SearchPage;
import nmittal.pageobjects.ShippingPage;

public class e2ebuyTest extends BaseClass{
	private IndexPage indexPage;
	private CatalogPage catalogPage;
	private ProductPage productPage;
	private OrderSummaryPage orderSummaryPage;
	private LoginPage loginPage;
	private AddressPage addressPage;
	private ShippingPage shippingPage;
	private PaymentPage paymentPage;
	private CheckPayPage checkPayPage;
	private OrderConfirmationPage orderConfirmationPage;
	
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
		productPage = catalogPage.getDetail();
		orderSummaryPage = productPage.editProductDetails();
		loginPage = orderSummaryPage.clickoncheckout();
		addressPage = loginPage.login("nikhilmittal15@gmail.com","Nik0508@",addressPage);
		shippingPage = addressPage.clickonaddresssubmit();
		paymentPage = shippingPage.clickshipsubmit();
		checkPayPage = paymentPage.clickchequepay();
		orderConfirmationPage = checkPayPage.clickorderconfirm();
		
		String confirmation = orderConfirmationPage.confirmationText();
		Assert.assertTrue(confirmation.contains("complete"));
		
	}
}








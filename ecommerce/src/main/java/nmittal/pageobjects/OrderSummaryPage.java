package nmittal.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import actiondriver.Action;
import nmittal.base.BaseClass;

public class OrderSummaryPage extends BaseClass{

	Action action= new Action();
	
	public OrderSummaryPage()
	{
		PageFactory.initElements(getDriver(), this);
		
	}
	
	@FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium']")
	WebElement summarycheckout;
	
	@FindBy(css="input[id='quantity_wanted']")
	WebElement quantity;
	
	@FindBy(css="td[class='cart_unit'] span[id='product_price_1_3_0']")
	WebElement unitprice;
	
	@FindBy(css="td[class='cart_total'] span[id='total_product_price_1_3_0']")
	WebElement totalprice;
	
	@FindBy(css="a[title='Add']")
	WebElement addinsummary;
	
	public LoginPage clickoncheckout()
	{
		action.click(getDriver(), summarycheckout);
		return new LoginPage();
	}
	
	public void verify_price() throws InterruptedException
	{
		float unit_price = Float.parseFloat(unitprice.getText().substring(1));
		float total_price = Float.parseFloat(totalprice.getText().substring(1));
		Assert.assertEquals(unit_price, total_price);
		
		action.click(getDriver(), addinsummary);
		
		TimeUnit.SECONDS.sleep(10);
		
		total_price = Float.parseFloat(totalprice.getText().substring(1));
		
		System.out.println(unit_price);
		System.out.println(total_price);
		
		Assert.assertEquals(2*unit_price, total_price);
	}
}

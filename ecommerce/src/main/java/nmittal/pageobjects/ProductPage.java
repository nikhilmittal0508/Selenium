package nmittal.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.Action;
import nmittal.base.BaseClass;

public class ProductPage extends BaseClass{

	Action action= new Action();
	
	public ProductPage()
	{
		PageFactory.initElements(getDriver(), this);
		
	}
	
	@FindBy(css="a[class='btn btn-default button-plus product_quantity_up']")
	WebElement plusbtn;
	
	@FindBy(css="select[id='group_1']")
	WebElement size;
	
	@FindBy(css="button[name='Submit']")
	WebElement addcartbtn;
	
	@FindBy(css="a[title='Proceed to checkout']")
	WebElement checkoutbtn;
	
	public OrderSummaryPage editProductDetails()
	{
		//action.click(getDriver(), plusbtn);
		//action.selectBySendkeys("L", size);
		action.click(getDriver(), addcartbtn);
		action.explicitWait(getDriver(), checkoutbtn, 20);
		action.click(getDriver(), checkoutbtn);
		
		return new OrderSummaryPage();
	}
	
	
}

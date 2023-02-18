package nmittal.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.Action;
import nmittal.base.BaseClass;

public class AddressPage extends BaseClass{

	Action action= new Action();
	
	public AddressPage()
	{
		PageFactory.initElements(getDriver(), this);
		
	}
	
	@FindBy(css="button[name='processAddress']")
	WebElement addresssubmit;
	
	
	public ShippingPage clickonaddresssubmit()
	{
		action.click(getDriver(), addresssubmit);
		return new ShippingPage();
	}
	
	
}

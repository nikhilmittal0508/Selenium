package nmittal.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.Action;
import nmittal.base.BaseClass;

public class ShippingPage extends BaseClass{

	Action action= new Action();
	
	public ShippingPage()
	{
		PageFactory.initElements(getDriver(), this);
		
	}
	
	@FindBy(css="div[id='uniform-cgv']")
	WebElement tandc;
	
	
	@FindBy(css="button[name='processCarrier']")
	WebElement shipingsubmit;
	
	public PaymentPage clickshipsubmit()
	{
		action.click(getDriver(), tandc);
		action.click(getDriver(), shipingsubmit);
		
		return new PaymentPage();
	}
}

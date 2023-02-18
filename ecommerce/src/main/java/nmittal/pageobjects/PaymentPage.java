package nmittal.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.Action;
import nmittal.base.BaseClass;

public class PaymentPage extends BaseClass{

	Action action= new Action();
	
	public PaymentPage()
	{
		PageFactory.initElements(getDriver(), this);
		
	}
	
	@FindBy(css="a[class='cheque']")
	WebElement paycheque;
	
	public CheckPayPage clickchequepay()
	{
		action.click(getDriver(), paycheque);
		
		return new CheckPayPage();
	}
	
	

}

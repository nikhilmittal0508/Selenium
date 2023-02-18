package nmittal.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.Action;
import nmittal.base.BaseClass;

public class CheckPayPage extends BaseClass{

	Action action= new Action();
	
	public CheckPayPage()
	{
		PageFactory.initElements(getDriver(), this);
		
	}
	
	@FindBy(css="button[class='button btn btn-default button-medium']")
	WebElement confirmorder;
	
	public OrderConfirmationPage clickorderconfirm()
	{
		action.click(getDriver(), confirmorder);
		return new OrderConfirmationPage();
	}
	
	
	
}

package nmittal.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.Action;
import nmittal.base.BaseClass;

public class OrderConfirmationPage extends BaseClass{

	Action action= new Action();
	
	public OrderConfirmationPage()
	{
		PageFactory.initElements(getDriver(), this);
		
	}
	
	@FindBy(css="p[class='alert alert-success']")
	WebElement orderconfirm;
	
	public String confirmationText()
	{
		return orderconfirm.getText();
	}
	
	
}
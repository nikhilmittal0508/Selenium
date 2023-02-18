package nmittal.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.Action;
import nmittal.base.BaseClass;

public class HomePage extends BaseClass{

	Action action= new Action();
	
	public HomePage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	WebElement username;
	
	public String username()
	{
		action.explicitWait(getDriver(), username, 40);
		System.out.println(username.getText());
		return username.getText();
	}
	
}

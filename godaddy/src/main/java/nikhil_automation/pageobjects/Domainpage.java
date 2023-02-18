package nikhil_automation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import actiondriver.Action;
import nikhil_automation.base.BaseClass;

public class Domainpage extends BaseClass{
	
Action action= new Action();
	
	public Domainpage()
	{
		PageFactory.initElements(getDriver(), this);
		
	}
	
	@FindBy(xpath="//input[@class='searchInput form-control    ']")
	WebElement searchbox;
	
	@FindBy(xpath="//button[@type='Submit']")
	WebElement buybtn;
	
	@FindBy(xpath="(//button[.='Add to Cart'])[1]")
	WebElement addCartbtn;
	
	@FindBy(xpath="//span[@class='text-primary-o ms4']")
	WebElement pricetag;
	
	@FindBy(xpath="//span[contains(text(),'Domain Taken')]")
	WebElement domainaval;
	
	
	public boolean domainval()
	{
		action.explicitWait(getDriver(), searchbox, 10);
		boolean present = action.isDisplayed(getDriver(), searchbox);
		Assert.assertTrue(present);
		boolean enabled = action.isEnabled(getDriver(), searchbox);
		Assert.assertTrue(enabled);
		
		boolean buybtnpresent = action.isDisplayed(getDriver(), buybtn);
		Assert.assertTrue(buybtnpresent);
		
		action.type(searchbox, "mydomain");
		action.click(getDriver(), buybtn);
				
		String availability = domainaval.getText();
		Assert.assertTrue(availability.contains("Domain Taken"));
		
		boolean addCartbtnpresent = action.isDisplayed(getDriver(), addCartbtn);
		Assert.assertTrue(addCartbtnpresent);
		
		boolean pricetagpresent = action.isDisplayed(getDriver(), pricetag);
		
		return pricetagpresent;
	}
	
}


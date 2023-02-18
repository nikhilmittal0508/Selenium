package nmittal.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.Action;
import nmittal.base.BaseClass;

public class SearchPage extends BaseClass{

	Action action= new Action();
	
	public SearchPage()
	{
		PageFactory.initElements(getDriver(), this);
		
	}
	
	@FindBy(css="div[class='product-container'] div h5 a[class='product-name']")
	WebElement productname;
	
	public String getSearchProductName()
	{
		String prodName_actual = productname.getText().trim();
		return prodName_actual;
	}
	
	
}

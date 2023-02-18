package nmittal.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.Action;
import nmittal.base.BaseClass;

public class IndexPage extends BaseClass{

	Action action= new Action();
	
	public IndexPage()
	{
		PageFactory.initElements(getDriver(), this);
		
	}
	
	@FindBy(xpath="//a[@class='login']")
	WebElement signinbtn;
	
	@FindBy(css="input[id='search_query_top']")
	WebElement searchbox;
	
	@FindBy(css="button[name='submit_search']")
	WebElement searchsubmit;
	
	@FindBy(css="a[title='Women']")
	WebElement womenlink;
	
	@FindBy(css="li ul li a[title='T-shirts']")
	WebElement womentshirt;
	
	public LoginPage clickOnSignIn() throws Throwable {
		action.fluentWait(getDriver(), signinbtn, 10);
		action.click(getDriver(), signinbtn);
		return new LoginPage();
	}
	
	public String getMyStoreTitle() {
		String myStoreTitel=getDriver().getTitle();
		return myStoreTitel;
	}
	
	public CatalogPage womentshirt()
	{
		action.mouseOverElement(getDriver(),womenlink);
		action.explicitWait(getDriver(), womentshirt, 10);
		action.click(getDriver(), womentshirt);
		return new CatalogPage();
	}
	
	public SearchPage search(String prodName)
	{
		action.type(searchbox, prodName);
		action.click(getDriver(), searchsubmit);
		return new SearchPage();
	}
}

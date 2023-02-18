package nmittal.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.Action;
import nmittal.base.BaseClass;

public class LoginPage extends BaseClass{

	Action action= new Action();
	
	public LoginPage()
	{
		PageFactory.initElements(getDriver(), this);
		
	}
	
	@FindBy(id="email_create")
	WebElement enteremail;
	
	@FindBy(xpath="//button[@id='SubmitCreate']")
	WebElement submitbtn;
	
	@FindBy(css="input[id='email']")
	WebElement loginemail;
	
	@FindBy(css="input[id='passwd']")
	WebElement loginpwd;
	
	@FindBy(css="button[id='SubmitLogin']")
	WebElement login;
	
	@FindBy(css="div[class='alert alert-danger'] ol li")
	WebElement alert;
	
	public HomePage login(String uname, String pswd,HomePage homePage) throws Throwable {
		action.scrollByVisibilityOfElement(getDriver(), loginemail);
		action.type(loginemail, uname);
		action.type(loginpwd, pswd);
		action.JSClick(getDriver(), login);
		Thread.sleep(2000);
		homePage=new HomePage();
		return homePage;
	}
	
	public AddressPage login(String uname, String pswd,AddressPage addressPage) throws Throwable {
		action.scrollByVisibilityOfElement(getDriver(), loginemail);
		action.type(loginemail, uname);
		action.type(loginpwd, pswd);
		action.JSClick(getDriver(), login);
		Thread.sleep(2000);
		addressPage=new AddressPage();
		return addressPage;
	}
	
	public AccountCreationPage createNewAccount(String newEmail) throws Throwable {
		action.type(enteremail, newEmail);
		action.click(getDriver(), submitbtn);
		return new AccountCreationPage();
	}
	
	public String checkemail(String email)
	{
		action.explicitWait(getDriver(), enteremail, 10);
		action.type(enteremail, email);
		action.click(getDriver(), submitbtn);
		action.explicitWait(getDriver(), alert, 10);
		System.out.println(alert.getText());
		return alert.getText();
	}
}

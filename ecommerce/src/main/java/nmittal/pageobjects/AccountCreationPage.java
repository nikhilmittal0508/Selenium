package nmittal.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.Action;
import nmittal.base.BaseClass;

public class AccountCreationPage extends BaseClass{

	Action action= new Action();
	
	public AccountCreationPage()
	{
		PageFactory.initElements(getDriver(), this);
		
	}
	
	@FindBy(css="input[id='id_gender1']")
	WebElement gendercheckbox;
	
	@FindBy(css="input[id='customer_firstname']")
	WebElement customerfirstname;
	
	@FindBy(css="input[id='customer_lastname']")
	WebElement customersecname;
	
	@FindBy(css="input[id='passwd']")
	WebElement pwd;
	
	@FindBy(css="input[id='firstname']")
	WebElement addressfirstname;
	
	@FindBy(css="input[id='lastname']")
	WebElement addresssecname;
	
	@FindBy(css="input[id='address1']")
	WebElement address;
	
	@FindBy(css="input[id='city']")
	WebElement addresscity;
	
	@FindBy(css="select[id='id_state']")
	WebElement addressstate;
	
	@FindBy(css="input[id='postcode']")
	WebElement addresscode;
	
	@FindBy(css="input[id='phone_mobile']")
	WebElement phonenum;
	
	@FindBy(css="button[id='submitAccount']")
	WebElement accountSubmit;
	
	@FindBy(css="div[class='alert alert-danger'] ol li")
	List<WebElement> error_list;
	
	public void createAccount(String name)
	{
		action.click(getDriver(), gendercheckbox);
		action.type(customerfirstname, name);
		action.type(customersecname, "mittal");
		action.type(pwd, "Nik0508@");
		action.type(addressfirstname, "nikhil");
		action.type(addresssecname, "mittal");
		action.type(address, "27 , ana sagar link road");
		action.type(addresscity, "Anchorage");
		action.selectBySendkeys("Alaska", addressstate);		
		action.type(addresscode, "99503");
		action.type(phonenum, "7872688454");
	}
	
	public ArrayList<String> emptyInfo()
	{
		//action.explicitWait(getDriver(), accountSubmit, 10);
		action.click(getDriver(), accountSubmit);
		
		ArrayList<String> myList = new ArrayList<String>();
				
		for(WebElement err_ele :error_list)
		{
			System.out.println(err_ele.getText());
			myList.add(err_ele.getText());
			
		}
		return myList;
	}
	
	public void incorretInfo()
	{
		action.explicitWait(getDriver(), gendercheckbox, 10);
		action.click(getDriver(), gendercheckbox);
		action.type(customerfirstname, "123");
		action.type(customersecname, "456");
		action.type(pwd, "abc");
		action.type(addressfirstname, "111");
		action.type(addresssecname, "222");
		action.type(address, "abcd");
		action.type(addresscity, "Anchorage");
		action.selectBySendkeys("Alaska", addressstate);		
		action.type(addresscode, "abcd");
		action.type(phonenum, "efgh");
		action.click(getDriver(), accountSubmit);				
		for(WebElement err_ele :error_list)
		{
			System.out.println(err_ele.getText());			
		}
		
	}
	
	public HomePage validateRegistration() throws Throwable {
		accountSubmit.click();
		return new HomePage();
	}
}

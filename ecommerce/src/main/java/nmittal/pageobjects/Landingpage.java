package nmittal.pageobjects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import actiondriver.Action;
import nmittal.base.BaseClass;
//import nikhil_automation.pageobjects.Domainpage;

public class Landingpage extends BaseClass{

	Action action= new Action();
	
	public Landingpage()
	{
		PageFactory.initElements(getDriver(), this);
		
	}
	
	@FindBy(xpath="//a[@class='login']")
	WebElement signinbtn;
	
	
	@FindBy(id="email_create")
	WebElement enteremail;
	
	@FindBy(xpath="//button[@id='SubmitCreate']")
	WebElement submitbtn;
	
	
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
	
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	WebElement username;
	
	@FindBy(css="div[class='alert alert-danger'] ol li")
	WebElement alert;
	
	@FindBy(css="div[class='alert alert-danger'] ol li")
	List<WebElement> error_list;
	
	@FindBy(css="a[title='Women']")
	WebElement womenlink;
	
	@FindBy(css="li ul li a[title='T-shirts']")
	WebElement womentshirt;
	
	@FindBy(css="div[class='product-container'] div h5 a[class='product-name']")
	WebElement productname;
	
	@FindBy(css="input[id='search_query_top']")
	WebElement searchbox;
	
	@FindBy(css="button[name='submit_search']")
	WebElement searchsubmit;
	
	@FindBy(xpath="//a/span[text()='More']")
	WebElement morebtn;
	
	@FindBy(css="a[class='btn btn-default button-plus product_quantity_up']")
	WebElement plusbtn;
	
	@FindBy(css="select[id='group_1']")
	WebElement size;
	
	@FindBy(css="button[name='Submit']")
	WebElement addcartbtn;
	
	@FindBy(css="a[title='Proceed to checkout']")
	WebElement checkoutbtn;
	
	@FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium']")
	WebElement summarycheckout;
	
	@FindBy(css="input[id='email']")
	WebElement loginemail;
	
	@FindBy(css="input[id='passwd']")
	WebElement loginpwd;
	
	@FindBy(css="button[id='SubmitLogin']")
	WebElement login;
	
	@FindBy(css="button[name='processAddress']")
	WebElement addresssubmit;
	
	@FindBy(css="div[id='uniform-cgv']")
	WebElement tandc;
	
	
	@FindBy(css="button[name='processCarrier']")
	WebElement shipingsubmit;
	
	@FindBy(css="a[class='cheque']")
	WebElement paycheque;
	
	@FindBy(css="button[class='button btn btn-default button-medium']")
	WebElement confirmorder;
	
	@FindBy(css="p[class='alert alert-success']")
	WebElement orderconfirm;
	
	@FindBy(css="a[class='addToWishlist wishlistProd_1']")
	WebElement wishlistbtn;
	
	@FindBy(css="div[class='fancybox-inner']")
	WebElement errorbox;
	
	@FindBy(css="input[id='quantity_wanted']")
	WebElement quantity;
	
	@FindBy(css="td[class='cart_unit'] span[id='product_price_1_3_0']")
	WebElement unitprice;
	
	@FindBy(css="td[class='cart_total'] span[id='total_product_price_1_3_0']")
	WebElement totalprice;
	
	@FindBy(css="a[title='Add']")
	WebElement addinsummary;
	
	public String registerAcc(String name)
	{
		action.click(getDriver(), signinbtn);
		action.explicitWait(getDriver(), enteremail, 10);
		action.type(enteremail, "nikhilmittal12@gmail.com");
		action.click(getDriver(), submitbtn);
		action.explicitWait(getDriver(), gendercheckbox, 10);
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
		action.click(getDriver(), accountSubmit);
		action.explicitWait(getDriver(), username, 40);
		System.out.println(username.getText());
		return username.getText();
		
	}
	
	public String checkemail(String email)
	{
		action.click(getDriver(), signinbtn);
		action.explicitWait(getDriver(), enteremail, 10);
		action.type(enteremail, email);
		action.click(getDriver(), submitbtn);
		action.explicitWait(getDriver(), alert, 10);
		System.out.println(alert.getText());
		return alert.getText();
	}
	
	public ArrayList<String> errormsg(String email)
	{
		action.click(getDriver(), signinbtn);
		action.explicitWait(getDriver(), enteremail, 10);
		action.type(enteremail, email);
		action.click(getDriver(), submitbtn);
		action.explicitWait(getDriver(), accountSubmit, 10);
		action.click(getDriver(), accountSubmit);
		
		ArrayList<String> myList = new ArrayList<String>();
		
		for(WebElement err_ele :error_list)
		{
			System.out.println(err_ele.getText());
			myList.add(err_ele.getText());
			
		}
		return myList;
	}
	
	public void incorrectinfo(String email)
	{
		action.click(getDriver(), signinbtn);
		action.explicitWait(getDriver(), enteremail, 10);
		action.type(enteremail, email);
		action.click(getDriver(), submitbtn);
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
		
		ArrayList<String> myList = new ArrayList<String>();
		
		for(WebElement err_ele :error_list)
		{
			System.out.println(err_ele.getText());
			//myList.add(err_ele.getText());
			
		}
		
	}
	
	public void search()
	{
		action.mouseOverElement(getDriver(),womenlink);
		action.explicitWait(getDriver(), womentshirt, 10);
		action.click(getDriver(), womentshirt);
		String prodName_exp = productname.getText().trim();
		action.type(searchbox, prodName_exp);
		action.click(getDriver(), searchsubmit);
		action.explicitWait(getDriver(), productname, 15);
		String prodName_actual = productname.getText().trim();
		Assert.assertTrue(prodName_actual.contains(prodName_exp));
	}
	
	public String buy()
	{
		action.mouseOverElement(getDriver(),womenlink);
		action.explicitWait(getDriver(), womentshirt, 10);
		action.click(getDriver(), womentshirt);
		action.mouseOverElement(getDriver(),productname);
		if(action.isDisplayed(getDriver(), morebtn))
			action.click(getDriver(), morebtn);
		action.explicitWait(getDriver(), plusbtn, 20);
		action.click(getDriver(), plusbtn);
		action.selectBySendkeys("L", size);
		action.click(getDriver(), addcartbtn);
		action.explicitWait(getDriver(), checkoutbtn, 20);
		action.click(getDriver(), checkoutbtn);
		action.explicitWait(getDriver(), summarycheckout, 20);
		action.click(getDriver(), summarycheckout);
		
		action.explicitWait(getDriver(), loginemail, 20);
		action.type(loginemail, "nikhilmittal06@gmail.com");
		action.type(loginpwd, "Nik0508@");
		action.click(getDriver(), login);
		
		action.explicitWait(getDriver(), addresssubmit, 20);
		action.click(getDriver(), addresssubmit);
		
		action.explicitWait(getDriver(), tandc, 20);
		action.click(getDriver(), tandc);
		action.click(getDriver(), shipingsubmit);
		
		action.explicitWait(getDriver(), paycheque, 20);
		action.click(getDriver(), paycheque);
		
		action.explicitWait(getDriver(), confirmorder, 20);
		action.click(getDriver(), confirmorder);
		
		action.explicitWait(getDriver(), orderconfirm, 20);
		return orderconfirm.getText();
	}
	
	public String wishlist()
	{
		action.mouseOverElement(getDriver(),womenlink);
		action.explicitWait(getDriver(), womentshirt, 10);
		action.click(getDriver(), womentshirt);
		action.mouseOverElement(getDriver(),productname);
		
		if(action.isDisplayed(getDriver(), wishlistbtn))
			action.click(getDriver(), wishlistbtn);
		
		action.explicitWait(getDriver(), errorbox, 10);
		System.out.println(errorbox.getText());
		return errorbox.getText();
		
	}
	
	public void price() throws InterruptedException
	{
		action.mouseOverElement(getDriver(),womenlink);
		action.explicitWait(getDriver(), womentshirt, 10);
		action.click(getDriver(), womentshirt);
		action.mouseOverElement(getDriver(),productname);
		if(action.isDisplayed(getDriver(), morebtn))
			action.click(getDriver(), morebtn);
		
		action.explicitWait(getDriver(), quantity, 20);
		int quantitynum = Integer.parseInt(quantity.getAttribute("value"));
		Assert.assertEquals(1, quantitynum);
		
		action.selectBySendkeys("M", size);
		action.click(getDriver(), addcartbtn);
		
		action.explicitWait(getDriver(), checkoutbtn, 20);
		action.click(getDriver(), checkoutbtn);
		
		action.explicitWait(getDriver(), unitprice, 20);
		
		float unit_price = Float.parseFloat(unitprice.getText().substring(1));
		float total_price = Float.parseFloat(totalprice.getText().substring(1));
		Assert.assertEquals(unit_price, total_price);
		
		action.click(getDriver(), addinsummary);
		
		TimeUnit.SECONDS.sleep(10);
		
		total_price = Float.parseFloat(totalprice.getText().substring(1));
		
		System.out.println(unit_price);
		System.out.println(total_price);
		
		Assert.assertEquals(2*unit_price, total_price);
		
	}
}

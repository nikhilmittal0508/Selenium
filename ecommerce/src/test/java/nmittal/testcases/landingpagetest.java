package nmittal.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import nmittal.base.BaseClass;
import nmittal.pageobjects.Landingpage;
import utility.Log;

public class landingpagetest extends BaseClass{
	
	private Landingpage landingpage;
	
	@BeforeMethod
	public void setup() {
		launchApp("chrome"); 
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	//@Test
	public void validateReg() throws Throwable {
		//Log.startTestCase("printtitle");
		landingpage= new Landingpage();
		String name = "nikhil";
		String username = landingpage.registerAcc(name);
		
		Assert.assertTrue(username.contains(name));
		
		//Log.endTestCase("printtitle");
	}
	
	//@Test
	public void Invalidemail() throws Throwable {
		//Log.startTestCase("printtitle");
		landingpage= new Landingpage();
		String name = "nikhil";
		String alertmsg = landingpage.checkemail(name);
		
		String expectedalert = "Invalid email address.";
		
		Assert.assertTrue(alertmsg.contains(expectedalert));
		
		//Log.endTestCase("printtitle");
	}
	
	//@Test
	public void verifyErrorMsg() throws Throwable {
		//Log.startTestCase("printtitle");
		landingpage= new Landingpage();
		String emailid = "nikhilmittal13@gmail.com";
		ArrayList<String> error_list = landingpage.errormsg(emailid);
		Assert.assertEquals(8, error_list.size());
	}
	
	//@Test
	public void validateIncorrectinfo() throws Throwable {
		//Log.startTestCase("printtitle");
		landingpage= new Landingpage();
		String emailid = "nikhilmittal14@gmail.com";
		landingpage.incorrectinfo(emailid);
		//Assert.assertEquals(8, error_list.size());
	}
	
	//@Test
	public void searchProduct() throws Throwable {
		//Log.startTestCase("printtitle");
		landingpage= new Landingpage();
		landingpage.search();
		//Assert.assertEquals(8, error_list.size());
	}
	
	
	@Test
	public void buyProduct() throws Throwable {
		//Log.startTestCase("printtitle");
		landingpage= new Landingpage();
		String confirmation = landingpage.buy();
		Assert.assertTrue(confirmation.contains("complete"));
		
	}
	
	//@Test
	public void verifyAddWishlist() throws Throwable {
		//Log.startTestCase("printtitle");
		landingpage= new Landingpage();
		String errormsg = landingpage.wishlist();
		
		Assert.assertEquals(errormsg, "You must be logged in to manage your wishlist.");
				
	}
	
	//@Test
	public void verifyPrice() throws Throwable {
		//Log.startTestCase("printtitle");
		landingpage= new Landingpage();
		landingpage.price();
				
	}
	
}

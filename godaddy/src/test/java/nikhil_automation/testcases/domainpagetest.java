package nikhil_automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import nikhil_automation.base.BaseClass;
import nikhil_automation.pageobjects.Domainpage;
import nikhil_automation.pageobjects.Landingpage;

public class domainpagetest extends BaseClass{
	
	private Landingpage landingpage;
	private Domainpage domainpage;
	
	@BeforeMethod
	public void setup() {
		launchApp("chrome"); 
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	
	@Test
	public void validatedomain()
	{
		landingpage= new Landingpage();
		domainpage=landingpage.domain_exp();
		boolean pricetag = domainpage.domainval();
		
		Assert.assertTrue(pricetag);
		
	}
	
}

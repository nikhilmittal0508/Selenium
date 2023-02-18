package nikhil_automation.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import nikhil_automation.base.BaseClass;
import nikhil_automation.pageobjects.Landingpage;
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
	
	@Test
	public void printtitle() throws Throwable {
		//Log.startTestCase("printtitle");
		landingpage= new Landingpage();
		String title = landingpage.getTitlecustom();
		System.out.println("title: "+title);
		//Log.endTestCase("printtitle");
	}
	
	@Test
	public void verifyTitle() throws Throwable {
		//Log.startTestCase("verifyTitle");
		landingpage= new Landingpage();
		String title = landingpage.getTitlecustom();
		System.out.println("title: "+title);
		Assert.assertEquals(title,"Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN");
		String url = landingpage.getCurrUrl();
		System.out.println("url: "+url);
		Assert.assertEquals(url, "https://www.godaddy.com/en-in");
		String pagesource = landingpage.getPageSource();
		pagesource = pagesource.replaceAll("&amp;","&");
		//System.out.println("pagesource: "+pagesource);
		System.out.println(pagesource.contains(title));
		//Assert.assertTrue(pagesource.contains(title));
		Assert.assertTrue(pagesource.contains(title));
		//Log.endTestCase("verifyTitle");
	}
	
	//@Test
	public void verifyDomainName() throws Throwable {
		//Log.startTestCase("verifyTitle");
		landingpage= new Landingpage();
		String title_exp = landingpage.domainSearch();
		title_exp = title_exp.replaceAll("&amp;","&");
		String title = "Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN";
		
		System.out.println(title_exp.contains(title));
		Assert.assertTrue(title_exp.contains(title));
		
	}
	
	//@Test
	public void verifyAllSubMenu() throws Throwable {
		//Log.startTestCase("verifyTitle");
		landingpage= new Landingpage();
		
		String title = "Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN";
		
		String[] pageSources = landingpage.allSubMenu();
		System.out.println(pageSources.length);
		
	}
	
}

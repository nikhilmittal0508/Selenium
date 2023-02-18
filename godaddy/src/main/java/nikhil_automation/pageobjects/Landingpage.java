package nikhil_automation.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import actiondriver.Action;
import nikhil_automation.base.BaseClass;
import nikhil_automation.pageobjects.Domainpage;

public class Landingpage extends BaseClass{

	Action action= new Action();
	
	public Landingpage()
	{
		PageFactory.initElements(getDriver(), this);
		
	}
	
	@FindBy(className="product-flyout-btn")
	WebElement menubutton;
	
	@FindBy(xpath="//button[contains(text(),'Domains')]")
	WebElement Domainbtn;
	
	@FindBy(xpath="//div[@data-subnav-lists='domain']/ul/li/a")
	List<WebElement> Domainmenu_list;
	
	@FindBy(xpath="//a[.='Domain Name Search']")
	WebElement Domainnamesearch;
	
	@FindBy(xpath="//a[@class='logo fos']")
	WebElement Godaddylogo;
	
	public String getTitlecustom()
	{
		return getDriver().getTitle();
	}
	
	public String getCurrUrl()
	{
		return getDriver().getCurrentUrl();
	}
	
	public String getPageSource()
	{
		return getDriver().getPageSource();
	}
	
	public String domainSearch()
	{
		action.click(getDriver(), menubutton);
		action.explicitWait(getDriver(), Domainbtn, 10);
		action.click(getDriver(), Domainbtn);
		action.explicitWait(getDriver(), Domainnamesearch, 10);
		action.click(getDriver(), Domainnamesearch);
		return getDriver().getPageSource();
		
	}
	
	public String[] allSubMenu()
	{
		String[] pagesources = new String[Domainmenu_list.size()];
		
		int i=0;
		for(WebElement submenu :Domainmenu_list)
		{
			/*
			System.out.println(submenu.getText());
			pagesources[i] = submenu.getText();
			i++;
			*/
			
			action.explicitWait(getDriver(), menubutton, 20);
			action.click(getDriver(), menubutton);
			action.explicitWait(getDriver(), Domainbtn, 20);
			action.click(getDriver(), Domainbtn);
			action.explicitWait(getDriver(), submenu, 20);
			System.out.println(submenu.getText());
			action.click(getDriver(), submenu);
			//submenu.click();
			pagesources[i] = getDriver().getPageSource();
			System.out.println(getDriver().getCurrentUrl());
			action.explicitWait(getDriver(), Godaddylogo, 20);
			action.click(getDriver(), Godaddylogo);
			i++;
			
		}
		
		return pagesources;
		
	}
	
	public Domainpage domain_exp()
	{
		action.explicitWait(getDriver(), menubutton, 20);
		action.click(getDriver(), menubutton);
		action.explicitWait(getDriver(), Domainbtn, 20);
		action.click(getDriver(), Domainbtn);
		action.explicitWait(getDriver(), Domainnamesearch, 10);
		System.out.println(Domainnamesearch.getText());
		String domain_text = Domainnamesearch.getText();
		Assert.assertTrue(domain_text.contains("Domain Name Search"));
		action.click(getDriver(), Domainnamesearch);
		
		return new Domainpage();
		
	}
	
}

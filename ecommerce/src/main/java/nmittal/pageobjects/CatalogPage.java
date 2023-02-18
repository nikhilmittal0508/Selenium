package nmittal.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.Action;
import nmittal.base.BaseClass;

public class CatalogPage extends BaseClass{

	Action action= new Action();
	
	public CatalogPage()
	{
		PageFactory.initElements(getDriver(), this);
		
	}
	
	@FindBy(css="div[class='product-container'] div h5 a[class='product-name']")
	WebElement productname;
	
	@FindBy(xpath="//a/span[text()='More']")
	WebElement morebtn;
	
	@FindBy(css="a[class='addToWishlist wishlistProd_1']")
	WebElement wishlistbtn;
	
	@FindBy(css="div[class='fancybox-inner']")
	WebElement errorbox;
	
	public String getProductName()
	{
		String prodName_exp = productname.getText().trim();
		return prodName_exp;
	}
	
	public ProductPage getDetail()
	{
		action.mouseOverElement(getDriver(),productname);
		if(action.isDisplayed(getDriver(), morebtn))
			action.click(getDriver(), morebtn);
		return new ProductPage();
	}
	
	public String addWishlistNoLogin()
	{
		action.mouseOverElement(getDriver(),productname);
		if(action.isDisplayed(getDriver(), wishlistbtn))
			action.click(getDriver(), wishlistbtn);
		
		action.explicitWait(getDriver(), errorbox, 10);
		System.out.println(errorbox.getText());
		return errorbox.getText();
	}
}

package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingDetails_PF 
{
	public ShippingDetails_PF(WebDriver web) {
		PageFactory.initElements(web, this);
	}
	
	@FindBy(xpath = "//input[@name='order.shipToFirstName']") private WebElement shipping_FName;
	@FindBy(xpath = "//input[@name='order.shipToLastName']") private WebElement shipping_LName;
	@FindBy(xpath = "//input[@name='order.shipAddress1']") private WebElement shipping_Address1;
	@FindBy(xpath = "//input[@name='order.shipAddress2']") private WebElement shipping_Address2;
	@FindBy(xpath = "//input[@name='order.shipCity']") private WebElement shipping_City;
	@FindBy(xpath = "//input[@name='order.shipState']") private WebElement shipping_State;
	@FindBy(xpath = "//input[@name='order.shipZip']") private WebElement shipping_Zip;
	@FindBy(xpath = "//input[@name='order.shipCountry']") private WebElement shipping_Country;
	
	@FindBy(name = "newOrder") private WebElement placingShipping;
	
	public WebElement getShipping_FName()
	{
		return shipping_FName;
	}
	
	public WebElement getShipping_LName()
	{
		return shipping_LName;
	}
	
	public WebElement getShipping_Address1()
	{
		return shipping_Address1;
	}
	
	public WebElement getShipping_Address2()
	{
		return shipping_Address2;
	}
	
	public WebElement getShipping_City()
	{
		return shipping_City;
	}
	
	public WebElement getShipping_State()
	{
		return shipping_State;
	}
	
	public WebElement getShipping_Zip()
	{
		return shipping_Zip;
	}
	
	public WebElement getShipping_Country()
	{
		return shipping_Country;
	}
	
	public WebElement getPlacingShipping()
	{
		return placingShipping;
	}

}

package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base_Works.ChooseBrowser;

public class Payment_PF extends ChooseBrowser
{
	public Payment_PF(WebDriver web)
	{
		PageFactory.initElements(web, this);
	}
	
	
	@FindBy(name="order.cardType") private WebElement dropdown;
	@FindBy(name="//option[@value='American Express']") private WebElement americanExpress;
	@FindBy(xpath = "//input[@name='order.creditCard']") private WebElement creditcard;
	@FindBy(xpath = "//input[@name='order.expiryDate']") private WebElement expiryDate;
	
	@FindBy(name="shippingAddressRequired") private WebElement checkbox;
	
	@FindBy(name="newOrder") private WebElement paymentDetails;
	
	public WebElement getDropdown()
	{
		return dropdown;
	}
	
	public WebElement getAmericanExpress()
	{
		return americanExpress;
	}
	
	public WebElement getCreditcard()
	{
		return creditcard;
	}
	
	public WebElement getexpiryDate()
	{
		return expiryDate;
	}
	
	public WebElement getcheckbox()
	{
		return checkbox;
	}
	
	public WebElement getPaymentDetails()
	{
		return paymentDetails;
	}
}

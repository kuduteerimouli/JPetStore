package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_Works.ChooseBrowser;

public class OrderPlaced_PF extends ChooseBrowser
{
	WebDriver web;
	
	public OrderPlaced_PF(WebDriver web)
	{
		PageFactory.initElements(web, this);
	}
	
	@FindBy(linkText = "Confirm") private WebElement confirm;
	
	public WebElement getConfirm()
	{
		return confirm;
	}
}

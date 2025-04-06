package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_Works.ChooseBrowser;

public class SignOut_PF extends ChooseBrowser
{
	WebDriver web;
	
	public SignOut_PF(WebDriver web)
	{
		PageFactory.initElements(web, this);
	}
	
	@FindBy(linkText = "Sign Out") private WebElement signout;
	
	public WebElement getSignout()
	{
		return signout;
	}

}

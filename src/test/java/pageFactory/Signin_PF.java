package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signin_PF {
	WebDriver web;
	
	public Signin_PF(WebDriver web)
	{
		this.web = web;
		PageFactory.initElements(web, this);
	}
	
	@FindBy(name="username") private WebElement username;
	@FindBy(name="password") private WebElement nPassword;
	@FindBy(name="signon") private WebElement login;
	
	public WebElement getUserName()
	{
		return username;
	}
	
	public WebElement getNPassword()
	{
		return nPassword;
	}
	
	public WebElement getLogin()
	{
		return login;
	}

}

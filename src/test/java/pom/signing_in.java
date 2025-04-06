package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class signing_in {

	WebDriver web;
	
	public signing_in(WebDriver web)
	{
		this.web=web;
	}
	
	private By username=By.name("username");
	private By nPassword=By.name("password");
	private By login=By.name("signon");
	
	
	public WebElement getUserName()
	{
		return web.findElement(username);
	}
	
	public WebElement getNPassword()
	{
		return web.findElement(nPassword);
	}
	public WebElement getLogin()
	{
		return web.findElement(login);
	}
	
}

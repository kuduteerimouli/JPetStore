package pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JpetRegister 
{
	WebDriver web;
	WebDriverWait wait;
	public JpetRegister(WebDriver web)
	{
		this.web=web;
		this.wait=new WebDriverWait(web, Duration.ofSeconds(10));
	}
	
	private By username=By.name("username");
	private By nPassword=By.name("password");
	private By Repeat_Password=By.name("repeatedPassword");
	
	private By fName=By.name("account.firstName");
	private By lName=By.name("account.lastName");
	private By email=By.name("account.email");
	private By phone=By.name("account.phone");
	private By address1=By.name("account.address1");
	private By address2=By.name("account.address2");
	private By city=By.name("account.city");
	private By state=By.name("account.state");
	private By zip=By.name("account.zip");
	private By country=By.name("account.country");

	private By myList=By.name("account.listOption");
	private By myBanner=By.name("account.bannerOption");
	private By saveAccount=By.name("newAccount");
	
	private WebElement waitforeleElement(By locator)
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public WebElement getUserName()
	{
		return waitforeleElement(username);
	}
	
	public WebElement getNPassword()
	{
		return waitforeleElement(nPassword);
	}
	
	public WebElement getRepeatPassword()
	{
		return waitforeleElement(Repeat_Password);
	}
	
	public WebElement getFName()
	{
		return waitforeleElement(fName);
	}
	
	public WebElement getLName()
	{
		return waitforeleElement(lName);
	}
	
	public WebElement getEmail()
	{
		return waitforeleElement(email);
	}
	public WebElement getPhone()
	{
		return waitforeleElement(phone);
	}
	
	public WebElement getAddress1()
	{
		return waitforeleElement(address1);
	}
	
	public WebElement getAddress2()
	{
		return waitforeleElement(address2);
	}
	
	public WebElement getCity()
	{
		return waitforeleElement(city);
	}
	
	public WebElement getState()
	{
		return waitforeleElement(state);
	}
	
	public WebElement getZip()
	{
		return waitforeleElement(zip);
	}
	
	public WebElement getCountry()
	{
		return waitforeleElement(country);
	}
	
	public WebElement getMyList()
	{
		return waitforeleElement(myList);
	}
	
	public WebElement getMyBanner()
	{
		return waitforeleElement(myBanner);
	}
	
	public WebElement getSaveAccount()
	{
		return waitforeleElement(saveAccount);
	}
	
}

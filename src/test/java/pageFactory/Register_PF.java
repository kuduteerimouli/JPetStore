package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register_PF {
	WebDriver web;
	public Register_PF(WebDriver web)
	{
		PageFactory.initElements(web, this);
	}
	
	@FindBy(name="username") private WebElement username;
	@FindBy(name="password") private WebElement nPassword;
	@FindBy(name="repeatedPassword") private WebElement Repeat_Password;
	@FindBy(name="account.firstName") private WebElement fname;
	@FindBy(name="account.lastName") private WebElement lname;
	@FindBy(name="account.email") private WebElement email;
	@FindBy(name="account.phone") private WebElement phone;
	@FindBy(name="account.address1") private WebElement address1;
	@FindBy(name="account.address2") private WebElement address2;
	@FindBy(name="account.city") private WebElement city;
	@FindBy(name="account.state") private WebElement state;
	@FindBy(name="account.zip") private WebElement zip;
	@FindBy(name="account.country") private WebElement country;
	@FindBy(name="account.listOption") private WebElement myList;
	@FindBy(name="account.bannerOption") private WebElement myBanner;
	@FindBy(name="newAccount") private WebElement saveAccount;
	
	public WebElement getUserName()
	{
		return username;
	}
	
	public WebElement getNPassword()
	{
		return nPassword;
	}
	
	public WebElement getRepeatPassword()
	{
		return Repeat_Password;
	}
	
	public WebElement getFName()
	{
		return fname;
	}
	
	public WebElement getLName()
	{
		return lname;
	}
	
	public WebElement getEmail()
	{
		return email;
	}
	public WebElement getPhone()
	{
		return phone;
	}
	
	public WebElement getAddress1()
	{
		return address1;
	}
	
	public WebElement getAddress2()
	{
		return address2;
	}
	
	public WebElement getCity()
	{
		return city;
	}
	
	public WebElement getState()
	{
		return state;
	}
	
	public WebElement getZip()
	{
		return zip;
	}
	
	public WebElement getCountry()
	{
		return country;
	}
	
	public WebElement getMyList()
	{
		return myList;
	}
	
	public WebElement getMyBanner()
	{
		return myBanner;
	}
	
	public WebElement getSaveAccount()
	{
		return saveAccount;
	}
}

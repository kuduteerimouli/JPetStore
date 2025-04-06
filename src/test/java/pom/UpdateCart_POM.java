package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base_Works.ChooseBrowser;

public class UpdateCart_POM  extends ChooseBrowser
{
	public UpdateCart_POM(WebDriver web)
	{
		this.web=web;
	}
	
	private By quantity_dog=By.xpath("//input[@name='EST-28']");
	private By updateCart=By.xpath("//input[@name='updateCartQuantities']");
	private By remove_parrot=By.xpath("(//a[contains(text(),'Remove')])[2]");
	private By checkout=By.xpath("//a[normalize-space()='Proceed to Checkout']");
	private By quantity_parrot=By.xpath("//input[@name='EST-18']");
	
	public WebElement getQuantity_dog()
	{
		return web.findElement(quantity_dog);
	}
	
	public WebElement getUpdateCart()
	{
		return web.findElement(updateCart);
	}
	
	public WebElement getRemove_parrot()
	{
		return web.findElement(remove_parrot);
	}
	
	public WebElement getCheckout()
	{
		return web.findElement(checkout);
	}
	
	public WebElement getQuantity_parrot()
	{
		return web.findElement(quantity_parrot);
	}

}

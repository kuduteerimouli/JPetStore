package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class UpdateCart_PF 
{
	public UpdateCart_PF(WebDriver web)
	{
		PageFactory.initElements(web,this);
	}
	
	@FindBy(xpath = "//input[@name='EST-27']") private WebElement Chihuahua_quantity;
	@FindBy(xpath = "//input[@name='updateCartQuantities']") private WebElement updateCart;
	@FindBy(xpath = "//a[contains(@href,'EST-18') and contains(text(),'Remove')]") 
    private WebElement remove_parrot;
	@FindBy(xpath = "//a[normalize-space()='Proceed to Checkout']") private WebElement checkout;
	
	@FindBy(xpath = "//input[@name='EST-18']") private WebElement quantity_parrot;
	//@FindBy(xpath = "//input[@name='EST-28']") private WebElement quantity_dog;
	
	public WebElement getChihuahua_quantity()
	{
		return Chihuahua_quantity;
	}
	public WebElement getUpdateCart()
	{
		return updateCart;
	}
	
	public WebElement getRemove_parrot()
	{
		return remove_parrot;
	}
	
	public WebElement getCheckout()
	{
		return checkout;
	}
	
	public WebElement getQuantity_parrot()
	{
		return quantity_parrot;
	}
	
//	public WebElement getQuantity_dog()
//	{
//		return quantity_dog;
//	}

}

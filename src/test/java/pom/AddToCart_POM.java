package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base_Works.ChooseBrowser;

public class AddToCart_POM extends ChooseBrowser
{
	public AddToCart_POM(WebDriver web)
	{
		this.web=web;
	}
	
	private By Dogs=By.xpath("//img[@src='../images/dogs_icon.gif']");
	private By golden_Retriever=By.xpath("//a[normalize-space()='K9-RT-01']");
	private By info_goldenRetriever=By.xpath("//a[normalize-space()='EST-28']");
	private By birds=By.xpath("//img[@src='../images/birds_icon.gif']");
	private By Amazon_Parrot=By.xpath("//a[normalize-space()='AV-CB-01']");
	private By info_AmazonParrot=By.xpath("//a[normalize-space()='EST-18']");

	private By add=By.linkText("Add to Cart");
	
	public WebElement getGolden_Retriever()
	{
		return web.findElement(golden_Retriever);
	}
	
	public WebElement getInfo_goldenRetriever()
	{
		return web.findElement(info_goldenRetriever);
	}
	
	public WebElement getbirds()
	{
		return web.findElement(birds);
	}
	
	public WebElement getAmazon_Parrot()
	{
		return web.findElement(Amazon_Parrot);
	}
	
	public WebElement getInfo_AmazonParrot()
	{
		return web.findElement(info_AmazonParrot);
	}
	
	public WebElement getDogs()
	{
		return web.findElement(Dogs);
	}
	
	public WebElement getAdd()
	{
		return web.findElement(add);
	}
}

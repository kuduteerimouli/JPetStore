package pageFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart_PF 
{
	WebDriver web;
	WebDriverWait wait;
	public AddToCart_PF(WebDriver web)
	{
		this.web = web;
        this.wait = new WebDriverWait(web, Duration.ofSeconds(10));
		PageFactory.initElements(web, this);
	}
	
	//Finding Adult Male Chihuahua
	@FindBy(xpath = "//img[@src='../images/dogs_icon.gif']") private WebElement Dogs;
	@FindBy(linkText = "K9-CW-01") private WebElement Chihuahua;
	@FindBy(linkText = "EST-27") private WebElement info_Chihuahua;
	
	 //Finding Amazon Parrot
    @FindBy(xpath = "//img[@src='../images/birds_icon.gif']") private WebElement birds;
	@FindBy(xpath = "//a[normalize-space()='AV-CB-01']") private WebElement Amazon_Parrot;
	@FindBy(xpath = "//a[normalize-space()='EST-18']") private WebElement info_AmazonParrot;
	
	//Finding Golden Retriever
//	@FindBy(xpath = "//img[@src='../images/dogs_icon.gif']") private WebElement Dogs;
//	@FindBy(xpath = "//a[normalize-space()='K9-RT-01']") private WebElement golden_Retriever;
//	@FindBy(xpath = "//a[normalize-space()='EST-28']") private WebElement info_goldenRetriever;
//
    
	
	//Adding to cart
	@FindBy(linkText = "Add to Cart") private WebElement add;
	
	public WebElement getChihuahua()
	{
		return Chihuahua;
	}
	
	public WebElement getInfo_Chihuahua()
	{
		return info_Chihuahua;
	}
	
	public WebElement getbirds()
	{
		return birds;
	}
	
	public WebElement getAmazon_Parrot()
	{
		return Amazon_Parrot;
	}
	
	public WebElement getInfo_AmazonParrot()
	{
		return info_AmazonParrot;
	}
	
	public WebElement getDogs()
	{
		return Dogs;
	}
	
	public WebElement getAdd()
	{
		return add;
	}
	
	
	//Methods 
//	public WebElement getGolden_Retriever()
//	{
//		return golden_Retriever;
//	}
//	
//	public WebElement getInfo_goldenRetriever()
//	{
//		return info_goldenRetriever;
//	}
//	
}

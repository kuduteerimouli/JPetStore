package operations_pom;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base_Works.ChooseBrowser;
import pageFactory.AddToCart_PF;
import pom.AddToCart_POM;

public class Operation_AddToCart_POM extends ChooseBrowser
{
	AddToCart_POM addtocart;
	@Test
	public void adding() throws InterruptedException, IOException
	{
		web.navigate().to("https://petstore.octoperf.com/actions/Catalog.action");
		addtocart=new AddToCart_POM(web);
		
		addtocart.getDogs().click();
		Thread.sleep(1000);
		addtocart.getGolden_Retriever().click();
		Thread.sleep(1000);
		addtocart.getInfo_goldenRetriever().click();
		Thread.sleep(1000);
		addtocart.getAdd().click();
		Thread.sleep(1000);
		web.navigate().to("https://petstore.octoperf.com/actions/Catalog.action");
		addtocart.getbirds().click();
		Thread.sleep(1000);
		addtocart.getAmazon_Parrot().click();
		Thread.sleep(1000);
		addtocart.getInfo_AmazonParrot().click();
		Thread.sleep(1000);
		addtocart.getAdd().click();
		Thread.sleep(1000);
		System.out.println("Items are added to cart...");
		screenShot("Added Pets");	
	}
}
package operations_PF;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base_Works.ChooseBrowser;
import pageFactory.AddToCart_PF;
import reports.ExtentReports_1;

public class Operation_AddToCart_PF extends ChooseBrowser
{
	AddToCart_PF addtocart;
    ExtentTest test;
    WebDriverWait wait;
    
    @BeforeClass
    public void setup() {
    	ExtentReports_1.getInstance();
    }
	@Test
	public void adding() throws InterruptedException, IOException
	{
		test = ExtentReports_1.createTest("Add to Cart Test");
		web.navigate().to("https://petstore.octoperf.com/actions/Catalog.action");
		
		addtocart=new AddToCart_PF(web);
		test.info("Navigated to JPetStore Catalog Page");
		wait = new WebDriverWait(web, Duration.ofSeconds(10));
		addtocart.getDogs().click();
		Thread.sleep(1000);
		addtocart.getChihuahua().click();
		test.log(Status.INFO, "Selecting pet");
		//addtocart.getGolden_Retriever().click();
		Thread.sleep(1000);
		addtocart.getInfo_Chihuahua().click();
		test.log(Status.INFO, "Viewing pet details");
		//addtocart.getInfo_goldenRetriever().click();
		Thread.sleep(1000);
		addtocart.getAdd().click();
		test.log(Status.INFO, "Adding pet to cart");
		Thread.sleep(1000);
		web.navigate().to("https://petstore.octoperf.com/actions/Catalog.action");
		addtocart.getbirds().click();
		Thread.sleep(1000);
		addtocart.getAmazon_Parrot().click();
		test.log(Status.INFO, "Selecting pet");
		Thread.sleep(1000);
		addtocart.getInfo_AmazonParrot().click();
		test.log(Status.INFO, "Viewing pet details");
		Thread.sleep(1000);
		addtocart.getAdd().click();
		test.log(Status.INFO, "Adding pet to cart");
		test.log(Status.PASS, "All items successfully added to cart!");
		System.out.println("Add to cart is done.");
		screenShot("Add To Cart Page");
		test.log(Status.INFO, "Screenshot captured after adding items to cart.");
		ExtentReports_1.flushReports();
	}
	
}
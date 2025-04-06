package operations_PF;

import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base_Works.ChooseBrowser;
import pageFactory.OrderPlaced_PF;
import reports.ExtentReports_1;

public class Operation_OrderPlaced_PF extends ChooseBrowser
{
	
	OrderPlaced_PF confirm;
	ExtentReports extent;
    ExtentTest test;
    WebDriverWait wait;
    @BeforeMethod
    public void setup() {
        extent = ExtentReports_1.getInstance();
        test = ExtentReports_1.createTest("Order Confirmation Test");
    }
	@Test
	public void confirmation() throws IOException, InterruptedException
	{
		try {
			
		   test.log(Status.INFO, "Navigating to Order Confirmation Page");
		   web.navigate().to("https://petstore.octoperf.com/actions/Order.action?newOrder=true");
           confirm = new OrderPlaced_PF(web);
           waitForElementToBeClickable(confirm.getConfirm(), 10);
           screenShot("Confirming Order");
           test.log(Status.INFO, "Before clicking confirm button");
           confirm.getConfirm().click();
           test.log(Status.PASS, "Order is confirmed successfully!");
           System.out.println(" Order is confirmed...");
		}
		catch (Exception e) {
            test.log(Status.FAIL, "Test failed: " + e.getMessage());

            // Capture failure screenshot (but not adding to Extent Report)
            screenShot("Order Failed");

            Assert.fail("Exception occurred: " + e.getMessage());
        }
	}
	@AfterMethod
	public void tearDown() {
	    extent.flush(); // Ensure logs are written to the report
	}

}

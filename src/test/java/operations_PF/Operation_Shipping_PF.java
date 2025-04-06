package operations_PF;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base_Works.ChooseBrowser;
import pageFactory.ShippingDetails_PF;
import reports.ExtentReports_1;

public class Operation_Shipping_PF extends ChooseBrowser
{
	ShippingDetails_PF shipping;
	ExtentReports extent;
    ExtentTest test;
    
    @BeforeMethod
    public void setup() throws IOException {
    	ExcelData();
        extent = ExtentReports_1.getInstance();
        test = ExtentReports_1.createTest("Shipping Details Test");
    }
	@Test
	public void ship_Details() throws IOException, InterruptedException
	{
		try {
			 test.log(Status.INFO, "Starting Shipping Details Test");
	            
		
		//web.navigate().to("https://petstore.octoperf.com/actions/Order.action");
		shipping=new ShippingDetails_PF(web);
		
		
		shipping.getShipping_FName().clear();
		shipping.getShipping_FName().sendKeys(ship_Fname);
		shipping.getShipping_LName().clear();
		shipping.getShipping_LName().sendKeys(ship_Lname);
		shipping.getShipping_Address1().clear();
		shipping.getShipping_Address1().sendKeys(ship_add1);
		shipping.getShipping_Address2().clear();
		shipping.getShipping_Address2().sendKeys(ship_add2);
		shipping.getShipping_City().clear();
		shipping.getShipping_City().sendKeys(ship_city);
		shipping.getShipping_State().clear();
		shipping.getShipping_State().sendKeys(ship_state);
		shipping.getShipping_Zip().clear();
		shipping.getShipping_Zip().sendKeys(ship_zip);
		shipping.getShipping_Country().clear();
		shipping.getShipping_Country().sendKeys(ship_country);
		
		System.out.println("First Name: " + ship_Fname);
		System.out.println("Last Name: " + ship_Lname);
		System.out.println("Address 1: " + ship_add1);
		System.out.println("Address 2: " + ship_add2);
		System.out.println("City: " + ship_city);
		System.out.println("State: " + ship_state);
		System.out.println("Zip: " + ship_zip);
		System.out.println("Country: " + ship_country);

		
		screenShot("Shipping Details Page");
		test.log(Status.INFO, "Screenshot is taken after Shipping details entered.");
		System.out.println("Shipping details are succesfully updated.");
		Thread.sleep(1000);
		shipping.getPlacingShipping().click();
		test.log(Status.PASS, "Shipping details entered successfully");
        } 
		catch (Exception e) {
            test.log(Status.FAIL, "Test failed: " + e.getMessage());
            screenShot("Shipping Details Failed");
            Assert.fail("Exception occurred: " + e.getMessage());
        }
	}
	@AfterMethod
    public void tearDown() {
        ExtentReports_1.flushReports();
    }
	
}

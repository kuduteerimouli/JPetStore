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
import pageFactory.SignOut_PF;
import reports.ExtentReports_1;

public class Operation_SignOut_PF extends ChooseBrowser
{
    SignOut_PF out;
    ExtentReports extent;
    ExtentTest test;

    @BeforeMethod
    public void setup() {
        extent = ExtentReports_1.getInstance();
        test = ExtentReports_1.createTest("Sign Out Test");
    }

    @Test
    public void signingOut() throws InterruptedException, IOException
    {
        try {
            test.log(Status.INFO, "Navigating to Order Confirmation Page before signing out.");
            web.navigate().to("https://petstore.octoperf.com/actions/Order.action?newOrder=&confirmed=true");

            out = new SignOut_PF(web);
            
            // Explicit wait before clicking Sign Out
            waitForElementToBeClickable(out.getSignout(), 10);
            screenShot("Cofirming order");
            test.log(Status.INFO, "Before clicking Sign Out button");
            out.getSignout().click();
            
            // Explicit wait for page transition after Sign Out
             
            test.log(Status.PASS, "Sign-out successful.");
            screenShot("Sign-out");
            System.out.println("Signing-out Successfully.....");

            closeBrowser();
        } 
        catch (Exception e) {
            test.log(Status.FAIL, "Sign-out failed: " + e.getMessage());

            // Capture screenshot on failure
            screenShot("Sign-Out Failed");
            
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }
        @AfterMethod
        public void tearDown() {
            extent.flush(); // Ensure logs are written to the report
        }
    
}

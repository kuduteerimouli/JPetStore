package operations_PF;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base_Works.ChooseBrowser;
import pageFactory.Payment_PF;
import reports.ExtentReports_1;

public class Operation_Payment_PF extends ChooseBrowser {
	Payment_PF order;
	WebDriverWait wait;
	ExtentTest test;

	@Test
	public void ordering() throws IOException, InterruptedException {
		try {
			// Initialize Extent Reports
			test = ExtentReports_1.createTest("Payment Processing Test");

			// Navigate to Payment Page
			web.navigate().to("https://petstore.octoperf.com/actions/Order.action?newOrderForm=");
			test.log(Status.INFO, "Navigated to Payment Page");

			order = new Payment_PF(web);
			wait = new WebDriverWait(web, Duration.ofSeconds(10));

			// Select Payment Method
			test.log(Status.INFO, "Selecting payment method: American Express");
			order.getDropdown().click();
			Select s = new Select(wait.until(ExpectedConditions.visibilityOf(order.getDropdown())));
			s.selectByVisibleText("American Express");
			test.log(Status.PASS, "Payment method selected: American Express");

			// Enter Credit Card Details
			test.log(Status.INFO, "Entering credit card details");
			wait.until(ExpectedConditions.visibilityOf(order.getCreditcard())).clear();
			order.getCreditcard().sendKeys("343456567878");
			test.log(Status.PASS, "Credit card entered successfully");

			// Enter Expiry Date
			test.log(Status.INFO, "Entering expiry date");
			wait.until(ExpectedConditions.visibilityOf(order.getexpiryDate())).clear();
			order.getexpiryDate().sendKeys("12/2029");
			test.log(Status.PASS, "Expiry date entered successfully");

			// Click on Shipping Address Checkbox
			test.log(Status.INFO, "Clicking on shipping address checkbox");
			wait.until(ExpectedConditions.elementToBeClickable(order.getcheckbox())).click();
			test.log(Status.PASS, "Shipping address checkbox selected");

			// Capture Screenshot before submitting
			screenShot("Payment Page");
			test.log(Status.INFO, "Screenshot captured before submitting payment");

			// Click on Submit Payment Details
			test.log(Status.INFO, "Submitting payment details");
			wait.until(ExpectedConditions.elementToBeClickable(order.getPaymentDetails())).click();
			test.log(Status.PASS, "Payment details submitted successfully");

		} catch (Exception e) {
			test.log(Status.FAIL, "Test failed due to: " + e.getMessage());
			screenShot("Payment Method Failed"); // Capture Screenshot on Failure
		} finally {
			ExtentReports_1.flushReports();
		}
	}
}

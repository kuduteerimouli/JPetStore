package operations_PF;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base_Works.ChooseBrowser;
import pageFactory.UpdateCart_PF;
import reports.ExtentReports_1;

public class Operation_UpdateCart_PF extends ChooseBrowser {
	UpdateCart_PF update;
	ExtentTest test;
	WebDriverWait wait;

	@Test
	public void Update_Quantity() throws InterruptedException, IOException {
		try {
			test = ExtentReports_1.createTest("Update Cart Test");

			update = new UpdateCart_PF(web);
			wait = new WebDriverWait(web, Duration.ofSeconds(10));

			test.log(Status.INFO, "Navigated to Cart Page");

			// Updating Chihuahua quantity
			test.log(Status.INFO, "Updating Chihuahua quantity");
			WebElement chihuahuaQty = wait.until(ExpectedConditions.visibilityOf(update.getChihuahua_quantity()));
			chihuahuaQty.clear();
			chihuahuaQty.sendKeys("5");
			test.log(Status.PASS, "Chihuahua quantity updated to 5");

			// Clicking Update Cart
			test.log(Status.INFO, "Clicking Update Cart");
			wait.until(ExpectedConditions.elementToBeClickable(update.getUpdateCart())).click();
			test.log(Status.PASS, "Cart successfully updated with Chihuahua quantity as 5");

			// Removing parrot (if present)
			try {
				WebElement removeParrot = wait.until(ExpectedConditions.elementToBeClickable(update.getRemove_parrot()));
				removeParrot.click();
				test.log(Status.PASS, "Parrot removed from cart");
			} catch (Exception e) {
				test.log(Status.INFO, "Parrot was already removed or not present.");
			}

			screenShot("Update Cart Page");
			test.log(Status.INFO, "Screenshot captured after cart update");

			// Clicking Proceed to Checkout
			test.log(Status.INFO, "Proceeding to Checkout");
			WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(update.getCheckout()));
			checkoutBtn.click();

			// Wait for checkout page transition
			Thread.sleep(2000);
			String currentUrl = web.getCurrentUrl();
			test.log(Status.INFO, "Current Page URL: " + currentUrl);

			// Verifying if the Chihuahua quantity is still 5 after checkout
//			try {
//				WebElement updatedQuantityField = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("EST-27")));
//				String finalQty = updatedQuantityField.getAttribute("value");
//
//				if (finalQty.equals("5")) {
//					test.log(Status.PASS, "Chihuahua quantity remains 5 after proceeding to checkout");
//				} else {
//					test.log(Status.FAIL, "Quantity reset to " + finalQty + " after checkout");
//				}
//			} catch (Exception e) {
//				test.log(Status.FAIL, "Chihuahua quantity field is not found after checkout. Possible page change.");
//			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Test failed due to: " + e.getMessage());
			screenShot("Update Cart Failed");
		} finally {
			ExtentReports_1.flushReports();
		}
	}
}

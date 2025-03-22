package cucumber_Signin_work;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import base_Works.ChooseBrowser;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.Signin_PF;
import reports.ExtentReports_1;

public class Stepdef_Signin extends ChooseBrowser {
    WebDriver web;
    Signin_PF signin;
    WebDriverWait wait;

    private static ExtentReports extent;
    private static ExtentTest test;

    @Before
    public void setup() throws InterruptedException, IOException {
        web = ChooseBrowser.web;
        signin = new Signin_PF(web);  // Initializing PageFactory

        if (extent == null) {
            extent = ExtentReports_1.getInstance();
        }
        test = extent.createTest("User Sign-in Test");

        // Load properties from data.properties
        dataproperties();
    }

    @Given("User navigates to JPetStore login page")
    public void user_navigates_to_j_pet_store_login_page() {
        try {
            web.navigate().to("https://petstore.octoperf.com/actions/Account.action?signonForm=");
            test.log(Status.INFO, "Navigated to JPetStore login page");
            System.out.println("User navigates to JPetStore login page");
        } catch (Exception e) {
            test.log(Status.FAIL, "Navigation failed: " + e.getMessage());
        }
    }

    @When("User enters username")
    public void user_enters_username() {
        try {
            wait = new WebDriverWait(web, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(signin.getUserName())).clear();
            signin.getUserName().sendKeys(fname); // Using the username from data.properties
            test.log(Status.INFO, "Entered username: " + fname);
            System.out.println("User enters username: " + fname);
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to enter username: " + e.getMessage());
        }
    }

    @And("User enters password")
    public void user_enters_password() {
        try {
            wait.until(ExpectedConditions.visibilityOf(signin.getNPassword())).clear();
            signin.getNPassword().sendKeys(password); // Using the password from data.properties
            test.log(Status.INFO, "Entered password");
            System.out.println("User enters password");
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to enter password: " + e.getMessage());
        }
    }

    @Then("User clicks on login button")
    public void user_clicks_on_login_button() {
        try {
            screenShot("Sign-in Page"); // Take screenshot before login
            test.log(Status.INFO, "Screenshot taken before login");

            wait.until(ExpectedConditions.elementToBeClickable(signin.getLogin())).click();
            test.log(Status.INFO, "Clicked on login button");
            System.out.println("User clicks on login button");
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to click login button: " + e.getMessage());
        }
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() throws IOException, InterruptedException {
        try {
            wait.until(ExpectedConditions.urlContains("actions/Catalog.action")); // Validate successful login
            screenShot("Jpet Home Page"); // Screenshot after login
            test.log(Status.PASS, "User logged in successfully");
            System.out.println("User logged in successfully");
        } catch (Exception e) {
            test.log(Status.FAIL, "Login failed: " + e.getMessage());
        } finally {
            ExtentReports_1.flushReports(); // Flush reports after execution
        }
    }
}

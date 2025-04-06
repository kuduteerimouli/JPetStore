package cucumber_Signin_work;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
    private Signin_PF signin;
    private WebDriverWait wait;
    private static ExtentReports extent;
    private static ExtentTest test;

    @Before
    public void setup() throws InterruptedException, IOException {
        // Initialize WebDriver from ChooseBrowser class
        if (web == null) {
            openBrowser("chrome"); // Default browser
        }
        
        signin = new Signin_PF(web);  // Initialize PageFactory elements
        wait = new WebDriverWait(web, Duration.ofSeconds(10));

        // Initialize Extent Reports
        if (extent == null) {
            extent = ExtentReports_1.getInstance();
        }
        test = extent.createTest("User Sign-in Test");
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

    @When("User enters username {string}")
    public void user_enters_username(String username) {
        signin.getUserName().clear();
        signin.getUserName().sendKeys(username);
        System.out.println("Entered Username: " + username);
    }

    @And("User enters password {string}")
    public void user_enters_password(String password) {
        signin.getNPassword().clear();
        signin.getNPassword().sendKeys(password);
        System.out.println("Entered Password: " + password);
    }


    @Then("User clicks on login button")
    public void user_clicks_on_login_button() {
        try {
            screenShot("Sign-in Page");  // Take screenshot before login
            test.log(Status.INFO, "Screenshot taken before login");

            wait.until(ExpectedConditions.elementToBeClickable(signin.getLogin())).click();
            test.log(Status.INFO, "Clicked on login button");
            System.out.println("User clicks on login button");
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to click login button: " + e.getMessage());
        }
    }

    @Then("User should see {string}")
    public void user_should_see(String expectedStatus) throws IOException, InterruptedException {
        try {
            boolean isLoginSuccessful = wait.until(ExpectedConditions.urlContains("actions/Catalog.action"));

            if (expectedStatus.equals("Login successful")) {
                Assert.assertTrue(isLoginSuccessful, "Invalid username or password. Signon failed.");
                screenShot("JPet Home Page");
                test.log(Status.PASS, "User logged in successfully");
                System.out.println("Login successful");
            } else {
                Assert.assertFalse(isLoginSuccessful, "Invalid username or password. Signon failed.");
                screenShot("Login Failed Page");
                test.log(Status.FAIL, "Login failed as expected");
                System.out.println("Login failed");
            }
        } catch (Exception e) {
            test.log(Status.FAIL, "Login failed unexpectedly: " + e.getMessage());
        } finally {
            ExtentReports_1.flushReports();
        }
    }
}

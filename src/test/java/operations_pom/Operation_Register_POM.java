package operations_pom;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base_Works.ChooseBrowser;
import pom.JpetRegister;
import reports.ExtentReports_1;

public class Operation_Register_POM extends ChooseBrowser
{
	JpetRegister jpr;
	ExtentTest test;
	WebDriverWait wait;
	@BeforeTest
	public void setup()
	{
		ExtentReports_1.getInstance();
	}
	@Test
	@Parameters({"browser"})
	public void RegisterRunning(String browser) throws InterruptedException, IOException
	{
		test=ExtentReports_1.createTest("User Registration Test");
		try{
		openBrowser(browser);
		test.log(Status.INFO, "Browser launched: "+browser);
		
		//User Information
		jpr=new JpetRegister(web);
		web.navigate().to("https://petstore.octoperf.com/actions/Account.action?newAccountForm=");
		test.log(Status.INFO, "Navigated to Registration Page");
		
		dataproperties();
		WebDriverWait wait=new WebDriverWait(web, Duration.ofSeconds(10));
		
		
		//filling User Information
		wait.until(ExpectedConditions.visibilityOf(jpr.getUserName())).sendKeys(fname);
		jpr.getNPassword().sendKeys(password);
		jpr.getRepeatPassword().sendKeys(password);
		test.log(Status.PASS, "User information entered succesfully.");
	    //Account Personal Information
		jpr.getFName().sendKeys(fname);
		jpr.getLName().sendKeys(lname);
		jpr.getEmail().sendKeys(email);
		jpr.getPhone().sendKeys(phone);
		jpr.getAddress1().sendKeys(add1);
		jpr.getAddress2().sendKeys(add2);
		jpr.getCity().sendKeys(city);
		jpr.getState().sendKeys(state);
		jpr.getZip().sendKeys(pincode);
		jpr.getCountry().sendKeys(country);
		jpr.getMyList().click();
		jpr.getMyBanner().click();
		test.log(Status.PASS, "personal information entered successfully.");
		screenShot("Registration Page");
		test.log(Status.INFO, "screenshot captured before form submission.");
		
		scrollToElement(jpr.getSaveAccount());
		jpr.getSaveAccount().click();
		test.log(Status.PASS, "Registration form submitted successfully.");

		System.out.println("Registration is Done");	
		test.log(Status.PASS, "Navigated to Sign in page after Registration.");
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Test failed due to: "+e.getMessage());
		}finally
		{
			ExtentReports_1.flushReports();
		}
	}
}
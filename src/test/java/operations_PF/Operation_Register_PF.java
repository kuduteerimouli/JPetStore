package operations_PF;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.google.common.io.Files;

import base_Works.ChooseBrowser;
import pageFactory.Register_PF;
import pom.JpetRegister;
import reports.ExtentReports_1;

public class Operation_Register_PF extends ChooseBrowser
{
	Register_PF jpr;	
	
	@BeforeTest
	public void setup()
	{
		ExtentReports_1.getInstance();
	}
	@Test
	@Parameters({"browser"})
	public void RegisterRunning(String browser) throws InterruptedException, IOException
	{
		openBrowser(browser);
		
		//User Information
		jpr=new Register_PF(web);
		web.navigate().to("https://petstore.octoperf.com/actions/Account.action?newAccountForm=");
		dataproperties();
		Thread.sleep(3000);
		jpr.getUserName().sendKeys(fname);
		jpr.getNPassword().sendKeys(password);
		jpr.getRepeatPassword().sendKeys(password);
		
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
		screenShot("Registration Page");
		
		scrollToElement(jpr.getSaveAccount());
		jpr.getSaveAccount().click();
		
		
		
//		WebDriverWait wait= new WebDriverWait(web, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.alertIsPresent());
//		web.switchTo().alert().accept();
		System.out.println("Registration is Done");	
		ExtentReports_1.createTest("Registration Completed").log(Status.PASS, "Navigated to Sign in page after Registration.");
		ExtentReports_1.getInstance().flush();		
	}
}

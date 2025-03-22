package operations_pom;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base_Works.ChooseBrowser;
import pageFactory.Signin_PF;
import pom.signing_in;
import reports.ExtentReports_1;

public class Operation_Signin_POM extends ChooseBrowser
{
	signing_in sin;
	@Test
	public void signin() throws IOException, InterruptedException
	{
		ExtentReports_1.getInstance();
		web.navigate().to("https://petstore.octoperf.com/actions/Account.action?signonForm=");
		sin=new signing_in(web);
		sin.getUserName().clear();
		sin.getNPassword().clear();
		Thread.sleep(1000);
		sin.getUserName().sendKeys(fname);
		sin.getNPassword().sendKeys(password);
		screenShot("signin Page");
		Thread.sleep(2000);
		sin.getLogin().click();
	
		ExtentReports_1.createTest("Signin Completed").log(Status.PASS, "Navigated to home page after Signin.");

		ExtentReports_1.getInstance().flush();
		
		
	}
}
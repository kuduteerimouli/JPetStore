package operations_PF;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base_Works.ChooseBrowser;
import pageFactory.Signin_PF;
import pom.signing_in;
import reports.ExtentReports_1;

public class Operation_Signin_PF extends ChooseBrowser
{
	Signin_PF sin;
	@Test
	public void signin() throws IOException, InterruptedException
	{
		ExtentReports_1.getInstance();
		web.navigate().to("https://petstore.octoperf.com/actions/Account.action?signonForm=");
		sin=new Signin_PF(web);
		sin.getUserName().clear();
		sin.getNPassword().clear();
		Thread.sleep(1000);
		sin.getUserName().sendKeys(fname);
		sin.getNPassword().sendKeys(password);
		screenShot("Signin Details");
		
		sin.getLogin().click();
	
		ExtentReports_1.createTest("Signin Completed").log(Status.PASS, "Navigated to home page after Signin.");

		ExtentReports_1.getInstance().flush();
		
		
	}
}

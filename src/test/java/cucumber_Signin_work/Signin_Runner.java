package cucumber_Signin_work;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "C:\\Users\\mouli\\eclipse-workspace\\CapstonProject\\src\\test\\java\\cucumber_Signin_work\\signin_work.feature",
		glue="cucumber_Signin_work", monochrome = true,plugin = {"pretty","html:target/cucumber.html"}, tags = "@signin"
		)
public class Signin_Runner extends AbstractTestNGCucumberTests{

}



package base_Works;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class ChooseBrowser 
{
	protected static  String fname,lname,password,email,phone,add1,add2,city,state,pincode,country;
	protected static String ship_Fname,ship_Lname,ship_add1,ship_add2,ship_city,ship_state,ship_zip,ship_country;
	protected static WebDriver web;
	protected static File src=null;
	protected static Properties pro;
	protected static String filePath;
	
	
	public static void openBrowser(String browser) throws InterruptedException
	{
		if(web==null) {                 //Checking weather the web driver is null or not
	
		if(browser.equalsIgnoreCase("chrome")) //if webdriver is null , it choose according string value
		{
			web=new ChromeDriver();
			
		}
		else if (browser.equalsIgnoreCase("edge"))
		{
			web=new EdgeDriver();
		}
		else {
			System.out.println("Browser not supported! Defaulting to chrome");
			web=new ChromeDriver();
		}
		web.manage().window().maximize();
		web.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		web.get("https://www.google.com/");
		}
	}
	
	public static void scrollToElement(WebElement element)
	{
		//finding the element
		JavascriptExecutor js=(JavascriptExecutor) web;
		 js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);
	     js.executeScript("window.scrollBy(0,-100);");//scrolling through y-axis
	}
	
	public static void screenShot(String name) throws IOException, InterruptedException
    {
	    WebDriverWait wait = new WebDriverWait(web, Duration.ofSeconds(10)); 
	    wait.until(ExpectedConditions.jsReturnsValue("return document.readyState=='complete'")); // Wait for page load
	    
	    File src = ((TakesScreenshot) web).getScreenshotAs(OutputType.FILE);
	    Files.copy(src, new File("./screenshot/" + "pic-" + name+ ".png"));
	    System.out.println("Screenshot captured successfully.");
	}
	
	public static void dataproperties() throws IOException
	{
		//Taking the data from data.properties file
		filePath="C:\\Users\\mouli\\eclipse-workspace\\CapstonProject\\src\\main\\java\\base_Works\\data.properties";
		try (FileInputStream fis=new FileInputStream(filePath)){
		pro=new Properties();
		pro.load(fis);
		//Registration data
		fname=pro.getProperty("First_name");
		lname=pro.getProperty("Last_name");
		password=pro.getProperty("password");
		email=pro.getProperty("email");
		phone=pro.getProperty("phone");
		add1=pro.getProperty("address1");
		add2=pro.getProperty("address2");
		city=pro.getProperty("city");
		state=pro.getProperty("state");
		pincode=pro.getProperty("pincode");
		country=pro.getProperty("country");
		}
		catch(Exception e)
		{
			System.out.println("data not provided");
		}
	}
	
	public static void ExcelData() throws IOException
	{
		FileInputStream excel=new FileInputStream("C:\\Users\\mouli\\eclipse-workspace\\CapstonProject\\src\\main\\java\\base_Works\\Shipping_Details.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(excel);
		XSSFSheet sheet=workbook.getSheet("Shipping");
		ship_Fname=sheet.getRow(1).getCell(0).getStringCellValue();
		ship_Lname=sheet.getRow(1).getCell(1).getStringCellValue();
		ship_add1=sheet.getRow(1).getCell(2).getStringCellValue();
		ship_add2=sheet.getRow(1).getCell(3).getStringCellValue();
		ship_city=sheet.getRow(1).getCell(4).getStringCellValue();
		ship_state=sheet.getRow(1).getCell(5).getStringCellValue();
		ship_zip=sheet.getRow(1).getCell(6).getStringCellValue();
		ship_country=sheet.getRow(1).getCell(7).getStringCellValue();
		
		// Close workbook and input stream
	    
	}
	
	// Explicit Wait Utility
    public static void waitForElementToBeClickable(WebElement element, int timeout) throws Exception {
        WebDriverWait wait = new WebDriverWait(web, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Explicit Wait for Element Visibility
    public static void waitForElementToBeVisible(WebElement element, int timeout) throws Exception {
        WebDriverWait wait = new WebDriverWait(web, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    
	public static void closeBrowser() throws InterruptedException
	{
		//closing the browser, when browser is not null.
		System.out.println("Browser Is Closed");
		if (web != null) {
			Thread.sleep(2000);
			web.quit();
        }
	}
}

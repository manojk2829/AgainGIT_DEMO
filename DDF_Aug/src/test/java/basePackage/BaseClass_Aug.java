package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import excelReader_Package.Xls_Reader;
import extentReport_Aug.ExtentReport_Class;

public class BaseClass_Aug {
	public Properties pro;
	public WebDriver dr;
	public Xls_Reader xls;
	public ExtentReports ext=ExtentReport_Class.getReporting();
	public ExtentTest test;
	public BaseClass_Aug(){
		init();
		xls=new Xls_Reader(pro.getProperty("ExcelPath"));
	}
	
	public void init(){
		pro=new Properties();
		try{
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
					"\\src\\test\\java\\config\\OR.properties");
		    pro.load(fis);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public void openBro(String b){
		if(b.equalsIgnoreCase("chrome")){
			ChromeOptions op=new ChromeOptions();
			op.addArguments("--start-maximized");
			op.addArguments("--disable-infobars");
			dr=new ChromeDriver(op);
			dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}else{
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "Null");
			dr=new FirefoxDriver();
			dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}
	
	public void clickLink(String locator){
		getElement(locator).click();
		test.log(LogStatus.INFO, "Element Found for Link" + "Click Link");
	}
	
	public void wait(int s){
		try{
			Thread.sleep(s*1000);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	public void navigateURL(String url){
		dr.navigate().to(url);
	}
	
	public WebElement getElement(String loc){
		WebElement w = null;
		if(loc.endsWith("_id"))
			w=dr.findElement(By.id(pro.getProperty(loc)));
		else if(loc.endsWith("_name"))
			w=dr.findElement(By.name(pro.getProperty(loc)));
		else if(loc.endsWith("_xpath"))
			w=dr.findElement(By.xpath(pro.getProperty(loc)));
		else{
			System.out.println("Locater not found...");
		}
		return w;
	}
	
	public void screenshot(){
		Date d=new Date();
		String FN=d.toString().replace(" ", "_").replace(":", "_")+".jpg";
		File src = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
	try{
		 FileHandler.copy(src, new File("C://Manoj_Data//report//"+FN));
	   }catch(Exception ex){
		   System.out.println(ex.getMessage());
	   }
	test.log(LogStatus.INFO, "Take screenshot -- > " + test.addScreenCapture("C://Manoj_Data//report//"+FN));
	}

}

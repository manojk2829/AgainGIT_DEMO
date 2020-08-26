package base_july_packge;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import excelReader_Package.Xls_Reader;
import extentReport_Package.ExtentReport_Class;

public class BaseClass {
	public Properties pro;
	public WebDriver dr;
	public ExtentReports ext=ExtentReport_Class.getReporting();
	public ExtentTest test;
	public Logger log=Logger.getLogger(BaseClass.class);
	public Xls_Reader xls;
	
	public BaseClass(){
		//Done BaseClass My Project in GIT hub.
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\config_package\\Log4j_File.properties");
		init();
		xls = new Xls_Reader(pro.getProperty("Excel_data_Path"));
		log.info("Initialization Done....");
		System.out.println(pro.getProperty("Excel_data_Path"));
	}
	
	public BaseClass(WebDriver dr,ExtentTest test){
		this.dr=dr;
		this.test=test;
	}
	
	public void init(){
		pro=new Properties();
		try{
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\config_package\\OR.properties");
			pro.load(fis);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		System.out.println(pro.getProperty("appurl"));
		log.info("Property File Initialized");
	}
	
	public void openBrowser(String bName){
		if(bName.equalsIgnoreCase("chrome")){
			ChromeOptions op=new ChromeOptions();
			op.addArguments("--start-maximized");
			op.addArguments("--disable-notifications");
			op.addArguments("--disable-infobars");
			dr=new ChromeDriver(op);
			dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}else{
			FirefoxOptions fop=new FirefoxOptions();
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "Null");
			fop.addArguments("--disable-notifications");
			fop.addArguments("--start-maxmized");
			fop.setPageLoadStrategy(PageLoadStrategy.NONE);
			dr=new FirefoxDriver(fop);
			dr.manage().window().maximize();
			dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
	}
	
	public void navigateURL(String url){
		dr.navigate().to(url);
		log.debug("URL navigated successfully");
		
	}
	
	public void reportFail(String msg){
		screenshot();
		System.out.println("Unable to get Element on page");
	}
	
	public void screenshot(){
		Date d=new Date();
		String FN=d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		File src=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		try{			
		    FileHandler.copy(src, new File(System.getProperty("user.dir")+"\\report\\"+FN));
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		test.log(LogStatus.INFO, "Take a Screenshot --> " + test.addScreenCapture(System.getProperty("user.dir")+"\\report\\"+FN));
	}
	
	public WebElement getElement(String locator){
		WebElement w=null;
		if(locator.endsWith("_id"))
			w=dr.findElement(By.id(pro.getProperty(locator)));
		else if(locator.endsWith("_name"))
			w=dr.findElement(By.name(pro.getProperty(locator)));
		else if(locator.endsWith("_xpath"))
			w=dr.findElement(By.xpath(pro.getProperty(locator)));
		else{
			reportFail("Element Not Found on Page");
			System.out.println();
		}
		return w;
	}
	
	public void inputType(String loc,String value){
		getElement(loc).sendKeys(value);
	}
	
	public void input_Click(String loc){
		getElement(loc).sendKeys(Keys.ENTER);
	}
	
	public void click_BTN(String loc){
		getElement(loc).click();
	}
	
	public void click_LINK(String loc){
		getElement(loc).click();
	}
	
	public void wait(int sec){
		try{
			Thread.sleep(sec*1000);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public void quiteBrowser(int sec){
		try{
			Thread.sleep(sec*1000);
			dr.quit();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public void select_DropDownValue(String loc,String value){
		Select DropDownValue=new Select(getElement(loc));
		DropDownValue.selectByVisibleText(value);
	}
	
	public void RadioBTN(String loc){
		WebElement radioBTN=getElement(loc);
		  if(!radioBTN.isSelected()){
			  radioBTN.click();
		  }else{
			  System.out.println("Already clicked.");
			  screenshot();
		  }	
	}
	
	
	

	
}

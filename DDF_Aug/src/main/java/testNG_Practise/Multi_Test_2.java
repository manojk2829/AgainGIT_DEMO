package testNG_Practise;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Multi_Test_2 {
	public WebDriver dr;
	public ExtentReports ext=ExtentReport_Class.getReporting();
	public ExtentTest test;
	
	@Test(dependsOnMethods="Registration")
	public void LoginTest(){
	  test=ext.startTest("Start Test");
	  
	  System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "Null");
	  dr=new FirefoxDriver();
	  dr.manage().window().maximize();
	  dr.navigate().to("http://aajtak.com/");
	  System.out.println("Test Login start 1");	
	}
	
	@Test(dependsOnMethods="LoginTest")
	public void PasswordUpdate() throws Exception{
	  System.out.println("Test Password Updated start 2");
	  File src=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
	  try{
		  FileHandler.copy(src, new File("C:\\Manoj_Data\\report\\Manoj_AajTak.jpg"));
	  }catch(Exception e){
		  System.out.println(e.getMessage());
	  }
	  test.log(LogStatus.INFO,"Take Screenshot -- > "+ test.addScreenCapture("C:\\Manoj_Data\\report\\Manoj_AajTak.jpg"));
	  
	}
	
	@Test
	public void Registration(){
	  System.out.println("Test Registration start 3");	
	  
	}
	
	@AfterTest
	public void tearDown() throws Exception{
		ext.endTest(test);
		ext.flush();
		Thread.sleep(3000);
		  dr.quit();
	}

}

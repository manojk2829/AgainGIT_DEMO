package testNG_Practise;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Multi_Test_1{
	
	public WebDriver dr;
	public ExtentReports ext=ExtentReport_Class.getReporting();
	public ExtentTest test;
	
	
	@BeforeMethod
	public void beforeMethod(){
		test=ext.startTest("Start Test");
		test.log(LogStatus.INFO,"Test Start to Execute");
		System.out.println("Open Browser");
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--start-maximized");
		op.addArguments("--disable-notifications");
		op.addArguments("--disable-infobars");
		dr=new ChromeDriver(op);
		dr.navigate().to("http://www.facebook.com/");
		
	}
	
	@Test
	public void login() throws Exception{
		dr.findElement(By.name("email")).sendKeys("manojk2829@gmail.com");
		dr.findElement(By.name("pass")).sendKeys("maurya@282920");
		dr.findElement(By.id("u_0_a")).click();
		test.log(LogStatus.PASS, "Test Login Successfully....");
		Thread.sleep(3000);
		
		Date d=new Date();
		String FN=d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		File src=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		  try{
			  FileHandler.copy(src, new File("C:\\Manoj_Data\\report\\"+FN));
		  }catch(Exception e){
			  System.out.println(e.getMessage());
		  }
		  test.log(LogStatus.INFO,"Take Screenshot Facebook-- > http://www.facebook.com/ " + test.addScreenCapture("C:\\Manoj_Data\\report\\"+FN));
		  
		}
	
	@AfterTest
	public void Logout() throws Exception{
		Thread.sleep(5000);
		ext.endTest(test);
		ext.flush();
		dr.quit();
		System.out.println(" After method Logout");
	}

}

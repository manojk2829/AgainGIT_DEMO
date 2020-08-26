package selenium_Practise_pack;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FileUpload_Class {
    public static WebDriver dr;
	public static void main(String[] args) {
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--start-maximized");
		co.addArguments("--disable-infobars");
		co.addArguments("--disable-notifications");
		dr=new ChromeDriver(co);
		dr.manage().deleteAllCookies();
		FirefoxOptions fo=new FirefoxOptions();
		//System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "Null");
		//dr=new FirefoxDriver();
		dr.navigate().to("https://html.com/input-type-file/");
		System.out.println(dr.getTitle());
		wait(3);
    //	Alert alt=dr.switchTo().alert();
	//	alt.dismiss();
	//  wait(2);
		
		dr.findElement(By.name("fileupload")).sendKeys("C:\\Users\\manoj\\Downloads\\Document_Hill.docx");
		wait(3);
		dr.quit();

	}
	
	public static void wait(int s){
		try{
			Thread.sleep(s*1000);
		}catch(Exception ex){
			System.out.println(ex.getMessage()); 
			
		}
	}
}

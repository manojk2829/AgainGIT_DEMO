package selenium_Practise_pack;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OpenBrowser {

	public static WebDriver dr;
	public static void main(String[] args) {
		//I have set Chrome Exe driver path in Environment variable.
		/*ChromeOptions co=new ChromeOptions();
		co.addArguments("--start-maximized");
		co.addArguments("--disable-infobars");
		co.addArguments("--disable-notifications");
		WebDriver dr=new ChromeDriver(co);*/
		
		FirefoxOptions fo=new FirefoxOptions();
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "Null");
		dr=new FirefoxDriver();
		dr.navigate().to("https://mail.rediff.com/cgi-bin/login.cgi");
		System.out.println(dr.getTitle());
		wait(3);
		dr.findElement(By.name("proceed")).click();
		wait(1);
		Alert alert = dr.switchTo().alert();
		String alertmessage = alert.getText();
		if(alertmessage.equalsIgnoreCase("Please enter a valid user name")){
			System.out.println("Correct Popup Text");
		}else{
			System.out.println("Not Correct -- >  :(");
		}
		System.out.println(alertmessage);
		alert.accept();
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

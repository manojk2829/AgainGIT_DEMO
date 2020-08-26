package testing_Sep;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChromeLog {
	public WebDriver dr;
	public Properties pro;
	@BeforeClass
	public void beforeMethod(){
		pro=new Properties();
		try{
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\or.properties");
			pro.load(fis);
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public void navigate(String url){
		dr.navigate().to(url);
	}
	
	@Test
	public void testing(){
		openBrowser("chrome");
		navigate(pro.getProperty("appurl"));
	}
	
	
	public void openBrowser(String broName){
		if(broName.equalsIgnoreCase("chrome")){
		   ChromeOptions op=new ChromeOptions();
		   op.addArguments("--start-maximized");
		   op.addArguments("--disable-notifications");
		   op.addArguments("--disable-infobars");
		   dr=new ChromeDriver();
		   dr.manage().window().maximize();
		   
      }
		else{
			System.setProperty("webdriver.gecko.driver", pro.getProperty("Firefox_Browser_exe"));
			dr=new FirefoxDriver();
			dr.manage().window().maximize();
		}
     }
}

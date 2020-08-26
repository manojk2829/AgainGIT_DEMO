package selenium_Practise_pack;

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

public class BasePractise {
	public WebDriver dr;
    public Properties pro;
    
    public BasePractise(){
    	init();
    }
    
	public void init(){
		pro=new Properties();
		try{
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\selenium_Practise_pack\\OR.properties");
            pro.load(fis);		
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	   System.out.println("Properties file Initialized..");
	}
	
	public void openBrowser(String bName){
		
		if(bName.equalsIgnoreCase("chrome")){
			ChromeOptions co=new ChromeOptions();
		
		co.addArguments("--start-maximized");
		co.addArguments("--disable-infobars");
		co.addArguments("--disable-notifications");
		dr=new ChromeDriver(co);
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dr.manage().deleteAllCookies();
		}else{
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "Null");
			dr=new FirefoxDriver();
			dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			dr.manage().deleteAllCookies();
		}
	}
	
	public void navigate(String url){
		dr.navigate().to(url);
	}
	
	public void wait(int s){
		try{
			Thread.sleep(s*1000);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}

	public void quiteBrowser(int s){
		try{
			Thread.sleep(s*1000);
			dr.quit();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public void Screenshot(){
		Date d=new Date();
		String FN=d.toString().replace(":", " ").replace(" ", "_")+".jpg";
		File src=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		try{
			FileHandler.copy(src, new File(System.getProperty("user.dir")+"//report//"+FN)); 
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public void inputType(String locator, String data){
		getElementLocation(locator).sendKeys(data);
	}
	
	public void clickBTN(String locator){
		getElementLocation(locator).click();
	}
	
	public WebElement getElementLocation(String loc){
		WebElement w=null;
		if(loc.endsWith("_id"))
			w=dr.findElement(By.id(pro.getProperty(loc)));
		else if(loc.endsWith("_name"))
			w=dr.findElement(By.name(pro.getProperty(loc)));
		else if(loc.endsWith("_xpath"))
			w=dr.findElement(By.xpath(pro.getProperty(loc)));
		else{
			System.out.println("Locater not found....");
		}
		return w;
	}
	
}

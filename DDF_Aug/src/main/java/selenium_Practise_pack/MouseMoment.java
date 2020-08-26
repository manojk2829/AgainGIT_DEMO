package selenium_Practise_pack;

import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class MouseMoment {
    public static WebDriver dr;
	public static void main(String[] args) {
		        //I have set Chrome Exe driver path in Environment variable.
				ChromeOptions co=new ChromeOptions();
				co.addArguments("--start-maximized");
				co.addArguments("--disable-infobars");
				co.addArguments("--disable-notifications");
				dr=new ChromeDriver(co);
				dr.manage().deleteAllCookies();
				dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				dr.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
				dr.navigate().to("https://www.spicejet.com/");
				System.out.println(dr.getTitle());
				wait(3);
				
				WebElement radiobtn = dr.findElement(By.xpath("//*[@id='ctl00_mainContent_rbtnl_Trip_2']"));
				
				if(radiobtn.isSelected()!=true){
				  radiobtn.click();
				}else{
					System.out.println("Already clicked");
				}
				
				wait(2);
				
				dr.findElement(By.xpath("//*[@id='MultiCityModelAlert']")).click();
				
				wait(2);
				
				/*boolean radibtn_Main = radiobtn.isSelected();
				
				if(radibtn_Main!=true){
					radiobtn.click();
				}else{
					System.out.println("Already clicked....");
				}*/
				
				Actions action=new Actions(dr);
				action.moveToElement(dr.findElement(By.xpath("//*[@id='highlight-addons']"))).build().perform();
				wait(1);
				screenshot();
							
				dr.findElement(By.xpath("//a[contains(text(),'Visa Services')]")).click();
				//action.dragAndDrop(source, target)
				wait(2);
				screenshot();
				dr.quit();
			}
			
	
	       public static void screenshot(){
	           Date d=new Date();
	           String FileName = d.toString().replace(" ", "_").replace(":", "_")+".jpg";
	    	   File src= ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
				try{
					FileHandler.copy(src, new File(System.getProperty("user.dir")+"//report//"+FileName));
				}catch(Exception ex){
					System.out.println(ex.getMessage());
				}
	       }
	
			public static void wait(int s){
				try{
					Thread.sleep(s*1000);
				}catch(Exception ex){
					System.out.println(ex.getMessage()); 
					
				}
				
			}
	}


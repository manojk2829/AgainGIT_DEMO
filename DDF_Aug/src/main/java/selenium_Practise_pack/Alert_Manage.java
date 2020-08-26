package selenium_Practise_pack;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.taskdefs.Get;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class Alert_Manage {
    public static WebDriver dr;
	public static void main(String[] args) throws Exception {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "Null");
		dr=new FirefoxDriver();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dr.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		dr.manage().window().maximize();
        dr.navigate().to("http://www.naukri.com/");
        Set<String> win= dr.getWindowHandles();
        System.out.println("Total available window size -- > " + win.size());
        Iterator<String> it =win.iterator();
        String firstWin = it.next();
        String SecWin = it.next();
        Thread.sleep(2000);
        System.out.println(firstWin +"  "+ SecWin);
        dr.switchTo().window(SecWin);
        dr.close();
        dr.switchTo().window(firstWin);
        
        Actions act=new Actions(dr);
        act.moveToElement(dr.findElement(By.xpath("//a[@title='Search Jobs']"))).build().perform();
        dr.findElement(By.xpath("//*[text()='Jobs by Skill']")).click();
        Thread.sleep(2000);
        win = dr.getWindowHandles();
        it=win.iterator();
        String tab1 = it.next();
        String tab2 = it.next();
        dr.switchTo().window(tab2);
          
        dr.findElement(By.id("qsbFormBtn")).click();
        Thread.sleep(2000);
        dr.close();
        dr.switchTo().window(tab1);
        
        File src=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		try{
			FileHandler.copy(src, new File("C://Manoj_Data//report//ABC.jpg"));
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
        
        Thread.sleep(20000);
        
        dr.quit();
	}

}

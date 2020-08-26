package selenium_Practise_pack;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class Naukri_Popup {
    public static WebDriver dr;
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "Null");
		dr=new FirefoxDriver();
		dr.manage().window().maximize();
		Set<String> win = dr.getWindowHandles();
		
		dr.navigate().to("http://naukri.com/");
		System.out.println("Get window size -- > "+win.size());
		win = dr.getWindowHandles();
		Iterator<String> it = win.iterator();

		//it=win.iterator();
		
		String first = it.next();
		String sec = it.next();
		Thread.sleep(2000);
		System.out.println("First Window "+ first);
		System.out.println("Second Window "+ sec);		
		
		dr.switchTo().window(sec);
		dr.close();
		dr.switchTo().window(first);
		Thread.sleep(2000);
		System.out.println(dr.getCurrentUrl());
		System.out.println(dr.getTitle());
		
		Actions act=new Actions(dr);
		act.moveToElement(dr.findElement(By.xpath("//a[@title='Search Jobs']"))).build().perform();
		
		dr.findElement(By.xpath("//a[text()='Register Now']")).click();
		
		Thread.sleep(3000);
		
		String newWin=it.next();
		System.out.println(newWin);
		
		dr.switchTo().window(newWin);
		
		
		
		File src=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		try{
			FileHandler.copy(src, new File("D://report//ABC.jpg"));
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		Thread.sleep(4500);
		
		dr.quit();
	}

}

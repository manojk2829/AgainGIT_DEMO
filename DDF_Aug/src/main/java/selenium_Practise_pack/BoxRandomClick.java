package selenium_Practise_pack;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class BoxRandomClick {
    
	public static void main(String[] args) throws Exception {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "Null");
		WebDriver dr=new FirefoxDriver();
		dr.manage().window().maximize();
		dr.navigate().to("http://www.naukri.com/");
        dr.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
        Set<String> win = dr.getWindowHandles();
        Iterator<String> it = win.iterator();
        String first = it.next();
        String sec = it.next();
        System.out.println(first+ " "+ sec);
        dr.switchTo().window(sec).close();
        dr.switchTo().window(first);
        Thread.sleep(2000);
        
        Actions act = new Actions(dr);
		act.moveToElement(dr.findElement(By.xpath("//*[text()='Jobs']"))).build().perform();
		WebElement box = dr.findElement(By.xpath("//div[@class='subMenu c2']"));
		List<WebElement> boxElement = box.findElements(By.tagName("a"));
		System.out.println("Total Number of link -- > " + boxElement.size());
		for(int i=0;i<boxElement.size();i++){
			System.out.println(boxElement.get(i).getText());
			//boxElement.get(i).click();
		}
		Random r = new Random();
		int rNum = r.nextInt(boxElement.size());
		boxElement.get(rNum).getText();
		boxElement.get(rNum).click();
		
	
		Thread.sleep(20000);
	    dr.quit();
	}

}

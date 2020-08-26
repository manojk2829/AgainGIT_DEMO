package selenium_Practise_pack;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Select_DropDown {
    public WebDriver dr;
	@Test
    public void TestSelectDropDown() throws Exception{
    	dr=new ChromeDriver();
    	dr.manage().window().maximize();
    	dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	dr.manage().deleteAllCookies();
    	
    	
    	dr.navigate().to("https://www.facebook.com/");
    	System.out.println(dr.getTitle());
    	dr.findElement(By.name("firstname")).sendKeys("manoj");
    	dr.findElement(By.name("lastname")).sendKeys("manoj");
    	Thread.sleep(2000);
    	dr.findElement(By.id("day")).sendKeys("17");
    	WebElement selectMonth = dr.findElement(By.id("month"));
    	Select dropvalue = new Select(selectMonth);
    	dropvalue.selectByVisibleText("Jan");
    	Thread.sleep(2);
      	System.out.println(selectMonth.getText());
    	
    	Thread.sleep(2000);
    	
    	WebElement selectYear = dr.findElement(By.xpath("//*[@id='year']"));
    	Select Yearvalue = new Select(selectYear);
    	Yearvalue.selectByVisibleText("2017");
    	Thread.sleep(3000);
    	dr.quit();
    	
    	
    	
    	
    }
}

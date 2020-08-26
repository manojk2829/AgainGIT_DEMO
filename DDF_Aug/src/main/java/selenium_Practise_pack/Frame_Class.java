package selenium_Practise_pack;

import java.beans.Visibility;
import java.io.File;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Frame_Class {
    public static WebDriver dr;
	public static void main(String[] args) throws Exception {
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--start-maximized");
		op.addArguments("--disable-notifications");
		op.addArguments("--disable-infobars");
		dr=new ChromeDriver(op);
		dr.navigate().to("http://www.paytm.com/");
		Thread.sleep(2000);
		File src=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		try{
			FileHandler.copy(src, new File("C://Manoj_Data//report//ABC.jpg"));
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		Thread.sleep(2000);
		
		dr.findElement(By.xpath("//div[@class='_3ac-']")).click();
		
		System.out.println(dr.getTitle());
		int frameSize = dr.findElements(By.tagName("iframe")).size();
		
		System.out.println(frameSize);
         
		for(int i=0;i<=frameSize;i++){
			dr.switchTo().frame(i);
			int s = dr.findElements(By.xpath("//a[@class='dontClosePopup']")).size();
		    System.out.println("Size -- > " + s);
		if(s==0)
			dr.switchTo().defaultContent();
		else
			break;
		
	}
		dr.findElement(By.xpath("//a[@class='dontClosePopup']")).click();
		Thread.sleep(20000);
		dr.quit();
	}
}

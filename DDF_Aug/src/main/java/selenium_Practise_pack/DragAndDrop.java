package selenium_Practise_pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDrop {
    public static WebDriver dr;
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--start-maximized");
		op.addArguments("--disable-notifications");
		op.addArguments("--disable-infobars");
		dr=new ChromeDriver(op);
		dr.navigate().to("https://jqueryui.com/droppable/");
		dr.switchTo().frame(0);
		Thread.sleep(1000);
		WebElement source = dr.findElement(By.id("draggable"));
		
		WebElement target = dr.findElement(By.id("droppable"));
		
		Actions act = new Actions(dr);
		act.dragAndDrop(source, target).build().perform();
		
		
	}

}

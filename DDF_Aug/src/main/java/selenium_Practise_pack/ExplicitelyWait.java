package selenium_Practise_pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ExplicitelyWait extends BasePractise{
    @Test
	public void mainCallingMethod() {
		openBrowser("chrome");
		navigate(pro.getProperty("appurl"));
		
		WebDriverWait wait=new WebDriverWait(dr, 10);
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("websubmit")));
		boolean elementPresent = ele.isDisplayed(); 
		if(elementPresent){
			System.out.println("Element present");  
		}else{
			System.out.println("Element Not Present");
		}
    }	
    
    @AfterTest
    public void tearDown(){
    	Screenshot();
    	quiteBrowser(7);
    }

}

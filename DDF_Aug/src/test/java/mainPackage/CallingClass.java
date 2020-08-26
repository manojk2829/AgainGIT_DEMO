package mainPackage;

import java.util.Hashtable;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseClass_Aug;
import excelReader_Package.Excel_Data_Read;

public class CallingClass extends BaseClass_Aug {
	String sheetName = "Sheet1";
	String testcases="TC_01";
	@Test(dataProvider="getData")
	public void mainMethod(Hashtable<String, String> data){
	   test=ext.startTest("Calling Class");
	   openBro(data.get("Browser"));
	   navigateURL(data.get("URL"));
	   wait(2);
	   clickLink("SignUP_xpath");
	   wait(3);
	   screenshot();
	}
	
	@AfterTest
	public void tearDown(){
		ext.endTest(test);
		ext.flush();
		wait(10);
		dr.quit();
	}
	
	@DataProvider
	public Object[][] getData(){
		return Excel_Data_Read.getExcelData(xls, sheetName, testcases);
	}
}

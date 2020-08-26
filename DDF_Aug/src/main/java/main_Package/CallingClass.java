package main_Package;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base_july_packge.BaseClass;
import excelReader_Package.NewExcel_Reader_class;
import excelReader_Package.Read_Excel_Data;
import selenium_Practise_pack.Select_DropDown;


public class CallingClass extends BaseClass{
	  String testCaseName ="TC_01";
	  String sheetName ="Sheet1";
      @Test(dataProvider="getData")
      public void mainMethod(Hashtable<String,String> dada){
    	  test=ext.startTest("CallingClass");
    	  test.log(LogStatus.INFO, "Data Start to reporting");
    	  openBrowser(dada.get("Browser"));
    	  navigateURL(pro.getProperty("appurl"));
    	  test.log(LogStatus.INFO, "Application get Open");
    	  wait(2);
    	  screenshot();
    	  //log.info("Logging is also working..");
    	  click_BTN("signIN_xpath");
    	  wait(1);
    	  test.log(LogStatus.PASS, "Application open and Screenshot taken successfully...");
    	  screenshot();
    	  inputType("fullName_name", "skushwaha");
    	  inputType("email_id", "skushwaha2829@gmail.com");
    	  inputType("password_id", "2829@gmail.com");
    	  inputType("repassword_name", "2829@gmail.com");
    	  
    	  select_DropDownValue("Day_name",dada.get("Day"));
    	  select_DropDownValue("Month_name",dada.get("Month"));
    	  select_DropDownValue("Year_name",dada.get("Year"));
    	  
    	  RadioBTN("radioBTN_xpath");
    	  select_DropDownValue("I_LiveIn_id", dada.get("Country"));
    	  select_DropDownValue("city_name", dada.get("City"));
    	  
    	  
    	  
    	  
      }
      @AfterMethod
      public void getDown(){
    	 ext.endTest(test);
    	 ext.flush();
    	 //quiteBrowser(5);
      }
      
      @DataProvider
      public Object[][] getData(){
    	  //return NewExcel_Reader_class.getExcelData(xls, testCaseName, sheetName);
    	  return Read_Excel_Data.getExcelData(xls, testCaseName, sheetName);
      }
}

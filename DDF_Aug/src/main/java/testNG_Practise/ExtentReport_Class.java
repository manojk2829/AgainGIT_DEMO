package testNG_Practise;

import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReport_Class {
	
	public static ExtentReports ext;
	public static ExtentReports getReporting(){
		Date d=new Date();
		String FN=d.toString().replace(" ", "_").replace(":", "_")+".html";
		ext=new ExtentReports("C://Manoj_Data//report//"+FN,true,DisplayOrder.NEWEST_FIRST);
		ext.addSystemInfo("QA Manoj Kushwaha", "Testing Machin");
		
		return ext;
	}

}

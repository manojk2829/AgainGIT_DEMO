package extentReport_Aug;

import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReport_Class {
	public static ExtentReports ext;
	public static ExtentReports getReporting(){
		if (ext ==null){
		Date d =new Date();
		String FN = d.toString().replace(" ", "_").replace(":", "_")+".html";
		ext=new ExtentReports("C://Manoj_Data//report//"+FN,true,DisplayOrder.NEWEST_FIRST);
		ext.addSystemInfo("QA ", "Manoj Kushwaha")
		.addSystemInfo("Test Environment","10.67.175.45");
		}
		return ext;
	}
}

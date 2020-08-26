package testNG_Practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {
   @Test(dataProvider="getData")
   public void calling_method(String username,String pass,double sal,int profite){
	   System.out.println(username + " --- "+ pass +" ---- "+ sal+" ---- "+profite);
   }
   
   
   @DataProvider
   public Object[][] getData(){
	   Object[][] o=new Object[3][4];
	   o[0][0] = "u1";
	   o[0][1] = "p1";
	   o[0][2] = 12.4543;
	   o[0][3] = 12343;
	   
	   o[1][0] = "u2";
	   o[1][1] = "p2";
	   o[1][2] = 122.4543;
	   o[1][3] = 123423;
	   
	   o[2][0] = "u3";
	   o[2][1] = "p3";
	   o[2][2] = 123.4543;
	   o[2][3] =  43;
	   return o;
			   
   }
}

package resourses;

import java.util.ArrayList;
import java.util.List;

import pojo.BaseClass_Post_Body;
import pojo.Location;

public class TestData_PayLoad {
	public BaseClass_Post_Body bp;
	public BaseClass_Post_Body testData_PayLoad(String name,String language,String address,String phoneNumber){
		   bp=new BaseClass_Post_Body();
		   bp.setAccuracy(50);
		   bp.setLanguage(language);
		   bp.setAddress(address);
		   bp.setName(name);
		   bp.setPhone_number(phoneNumber);
		   bp.setWebsite("ApiTes eee t");		   
		   List<String> mylist=new ArrayList<String>();
		   mylist.add("Park");
		   mylist.add("Shop");
		   bp.setTypes(mylist);		   
		   Location l=new Location();
		   l.setLat(-15.25866);
		   l.setLng(145.25866);		   
		   bp.setLocation(l);		   
		   return bp;
	}
	
	public static String delete_method_payLoad(String provide_Value){
		String delete_Data="{\r\n" + 
				"	\"place_id\":\""+provide_Value+"\"\r\n" + 
				"}";
		return delete_Data;
	}

}

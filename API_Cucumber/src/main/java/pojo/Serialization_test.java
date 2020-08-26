package pojo;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Serialization_test {
	
	@Test
	public void serialization_TestMethod(){
		 BaseClass_Post_Body bp=new BaseClass_Post_Body();
		   bp.setAccuracy(50);
		   bp.setLanguage("English");
		   bp.setAddress("Noida 201301");
		   bp.setName("Manoj Kushwaha");
		   bp.setPhone_number("9311245574");
		   bp.setWebsite("ApiTest");
		   
		   List<String> mylist=new ArrayList<String>();
		   mylist.add("Park");
		   mylist.add("Shop");
		   
		   bp.setTypes(mylist);
		   
		   Location l=new Location();
		   l.setLat(-15.25866);
		   l.setLng(145.25866);
		   
		   bp.setLocation(l); 
		   
		   //Precondition Bease URI --
		   RestAssured.useRelaxedHTTPSValidation();
	       RequestSpecification req_Specification=new RequestSpecBuilder()
	    		   
	       .setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
	       .addHeader("Content-Type", "application/json").setContentType(ContentType.JSON).build();
	       
	       ResponseSpecification res_Specification = new ResponseSpecBuilder()
	       
	       .expectStatusCode(200).expectContentType(ContentType.JSON).build();
	       
	       //Given Code -- Sending the request
	       
	       RequestSpecification req_given=given().spec(req_Specification).body(bp);
	       Response response = req_given.when().post("maps/api/place/add/json").then().assertThat().spec(res_Specification).extract().response();
	       
	       
	       String response_String = response.asString();
	       
	       System.out.println("))))))))))))))))))))))))))))))))))))))))))))))))))))");
	       
	       System.out.println(response_String);
	       JsonPath js=new JsonPath(response_String);
	       String placeId=js.getString("place_id");
	       String Id=js.getString("id");
	       
	       System.out.println("))))))))))))))))))))))))))))))))))))))))))))))))))))");
	       System.out.println(Id);
	       
	       System.out.println("))))))))))))))))))))))))))))))))))))))))))))))))))))");
	       System.out.println(placeId);

	}

}

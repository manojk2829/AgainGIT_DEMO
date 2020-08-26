package resourses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Properties;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class UtilsClass {
	public Properties pro;
	public static RequestSpecification req_Specification;
	public ResponseSpecification response_specification;
	public Response response;
	public String response_Json;
	
	public UtilsClass(){
		init_global_File();
	}
	
	public void init_global_File(){
		pro=new Properties();
		try{
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\resourses\\or.properties");
			pro.load(fis);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		System.out.println("BaseURI --> "+ pro.getProperty("BaseURI_path"));
		System.out.println();
	}
	
	public RequestSpecification baseURI_method(){
		
		if(req_Specification==null){
		try
		{
			PrintStream log=new PrintStream(new FileOutputStream("logging_API.txt"));
		    RestAssured.useRelaxedHTTPSValidation();
		    req_Specification=new RequestSpecBuilder()	    		   
				.setBaseUri(pro.getProperty("BaseURI_path")).addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.addHeader("Content-Type", "application/json").setContentType(ContentType.JSON).build();
		return req_Specification;
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		}
		return req_Specification;
	}
	
	public ResponseSpecification response_sepecification_Code(){		
		response_specification = new ResponseSpecBuilder()	       
			    .expectStatusCode(200).expectContentType(ContentType.JSON).build();
		return response_specification;
	}
	
	public String get_json_Path_method(Response response,String key){
		 response_Json=response.asString();
		 JsonPath js=new JsonPath(response_Json);
		 return js.getString(key).toString();
		 
	}
}

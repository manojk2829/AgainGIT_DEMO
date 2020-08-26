package stepDefinition;

import static io.restassured.RestAssured.given;
import java.io.FileNotFoundException;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resourses.API_resorces;
import resourses.TestData_PayLoad;
import resourses.UtilsClass;

public class StepDefinition_Place extends UtilsClass{
	public Response response;
	public RequestSpecification request_given;
	public static String response_place_id;
	public JsonPath js;
	TestData_PayLoad data=new TestData_PayLoad();
	@Given("Add Place PlayLoad {string},{string},{string},{string}")
	public void add_Place_PlayLoad(String name,String language, String address,String phoneNumber) throws FileNotFoundException {
		request_given=given().spec(baseURI_method()).body(data.testData_PayLoad(name,language,address,phoneNumber));
	}

	@When("user calls {string} with {string} HTTP request")
	public void user_calls_method_with_HTTP_request(String resourse_,String methodName) {

		System.out.println("user calls ---> ("+resourse_+") with ("+methodName+") HTTP request");		 
		API_resorces resourseAPI = API_resorces.valueOf(resourse_);

		if(methodName.equalsIgnoreCase("Post")){
			response = request_given.when().post(resourseAPI.getResorce());
		}else if(methodName.equalsIgnoreCase("Get")){
			response = request_given.when().get(resourseAPI.getResorce());
		}else if(methodName.equalsIgnoreCase("Delete")){
			response = request_given.when().post(resourseAPI.getResorce());
		}else if(methodName.equalsIgnoreCase("Put")){
			response = request_given.when().post(resourseAPI.getResorce());
		}else{
			System.out.println("Method Not found......");
		}
	}

	@Then("API returned success response status cosde {int}")
	public void add_Place_API_returned_success_response_status_cosde(Integer int1) {
		response.then().assertThat().spec(response_sepecification_Code())
		.extract().response();
		Assert.assertEquals(response.getStatusCode(),200);
	}

	@And("{string} Code returned {string}")
	public void code_returned(String keyvalue,String expectedValue) {
		System.out.println(keyvalue+ " Code returned ----->  "+expectedValue);
		Assert.assertEquals(get_json_Path_method(response, keyvalue), expectedValue);
	}

	@And("verify that place_id which I created and maps to {string} using {string}")
	public void verify_that_place_id_by_get_place_id(String response_key_String, String method_Name){
		response_place_id=get_json_Path_method(response, "place_id");
		System.out.println();
		System.out.println(response_place_id);

		request_given=given().spec(baseURI_method()).queryParam("place_id", response_place_id);
		user_calls_method_with_HTTP_request(method_Name,"Get");

		String response_name=get_json_Path_method(response, "name");
		System.out.println("I got Name when get Method Executed ----- >  "+response_name);
		
		System.out.println("I got Place ID when get Method Executed ----- >  "+response_place_id);
	}


	@Given("Delete PlaceId with placePayLoad_body")
	public void delete_PlaceId_with_placePayLoad_body() {
		request_given=given().spec(baseURI_method()).body(TestData_PayLoad.delete_method_payLoad(response_place_id));
		System.out.println("Place ID  -- > " +response_place_id +" Deleted successfully" );
	}
}

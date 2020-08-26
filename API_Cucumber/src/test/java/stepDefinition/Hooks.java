package stepDefinition;

import java.io.FileNotFoundException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void preconditionTest() throws FileNotFoundException{
		
		StepDefinition_Place sp=new StepDefinition_Place();
		if(StepDefinition_Place.response_place_id==null){
			sp.add_Place_PlayLoad("deepak", "KOKO", "Simla", "454657642343");
			sp.user_calls_method_with_HTTP_request("add_Place_API","Post");
			sp.verify_that_place_id_by_get_place_id("deepak", "get_Place_API");
			sp.delete_PlaceId_with_placePayLoad_body();
		}
		
	}

}

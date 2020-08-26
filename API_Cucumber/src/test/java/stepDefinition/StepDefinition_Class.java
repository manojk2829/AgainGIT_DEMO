package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition_Class {
	
	@Given("^User is Banking Login landing page$")
	public void user_is_Banking_Login_landing_page(){
		System.out.println("^User is Banking Login landing page$");
	}

	@And("^Login Page displayed$")
	public void login_Page_displayed(){
		System.out.println("^Login Page displayed$");
	}

	@When("^Enter username \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void enter_username_and_Password(String arg1, String arg2){
		System.out.println("User Name --- > " + arg1);
		System.out.println("User Password --- > " + arg2);
	}

	@And("^click on Submit button$")
	public void click_on_Submit_button(){
		System.out.println("Click on Submit button");
	}

	@Then("^Welcome page is getting opened$")
	public void welcome_page_is_getting_opened(){
		System.out.println("Welcome Page is opened.");
	}

	@And("^Cards are displayed \"([^\"]*)\"$")
	public void cards_are_displayed(String arg1){
       System.out.println("Card are displayed --- " + arg1);

	}


}

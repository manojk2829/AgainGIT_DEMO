package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\java\\featurePack\\Login_.feature", 
glue={"stepDefinition"})
public class Test_Runner_Login {

}

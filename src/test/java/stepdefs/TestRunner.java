package stepdefs;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome=true,
		plugin= {"pretty","html:target/cucumber-html","json:target/cucumber.json"},
		features = "src/test/java/features",
		//tags= {"@Regression,@sanity"},// OR condition
        //tags= {"@Regression","@sanity"},// And condition
		//tags= {"~@DataTable"},//To Ignore Scenario
		tags= {"@Regression"},
        glue= {"stepdefs"}
 )
		
public class TestRunner {

}

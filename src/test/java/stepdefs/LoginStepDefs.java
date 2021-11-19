package stepdefs;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class LoginStepDefs {

	WebDriver driver = Baseclass.driver;
	   

    @Given("^User has navigated to the login page$")
    public void user_has_navigated_to_the_login_page() throws Throwable {
        
        driver.get("https://www.simplilearn.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
        
        WebElement LoginLink = driver.findElement(By.linkText("Log in"));
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(LoginLink));
        
        LoginLink.click();
          
    }

    @When("^User eneters correct username and password$")
    public void user_eneters_correct_username_and_password() throws Throwable {

        WebElement UserName = driver.findElement(By.name("user_login"));
        UserName.sendKeys("abc@xyz.com");
        
        WebElement Password = driver.findElement(By.id("password"));
        Password.sendKeys("Abcd@1234");
        
    }

    @Then("^User should be navigated to the Home Page$")
    public void user_should_be_navigated_to_the_home_page() throws Throwable {
      
    }

    @And("^User clicks on the Login Button$")
    public void user_clicks_on_the_login_button() throws Throwable {
        WebElement LoginButton = driver.findElement(By.name("btn_login"));
        LoginButton.click();
    }
    

    @When("^User eneters correct username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_eneters_correct_username_something_and_password_something(String UserNameval, String Passwordval) throws Throwable {
        WebElement UserName = driver.findElement(By.name("user_login"));
        UserName.sendKeys(UserNameval);
        
        WebElement Password = driver.findElement(By.id("password"));
        Password.sendKeys(Passwordval);
    }
    
    @Then("^User should be getting the error message \"([^\"]*)\"$")
    public void user_should_be_getting_the_error_message_something(String ExpMsg) throws Throwable {
         
        WebElement Error = driver.findElement(By.id("msg_box")) ;
        String ActualMsg = Error.getText();
        Assert.assertEquals(ActualMsg, ExpMsg);
        
    }
    @When("^User eneters correct credentials$")
    public void user_eneters_correct_credentials(DataTable table) throws Throwable {
    	String UserNameval= table.cell(1, 1);
    	String Passwordval= table.cell(2, 1);
    	
    	WebElement UserName = driver.findElement(By.name("user_login"));
        UserName.sendKeys(UserNameval);
        
        WebElement Password = driver.findElement(By.id("password"));
        Password.sendKeys(Passwordval);
    	
    }
}
package stepdefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class Login extends Base {
	
	WebDriver driver;
	LandingPage landingPage;
	LoginPage loginpage;
	AccountPage accountpage;

    @Given("^Open any Browser$")
    public void open_any_browser() throws IOException {
    	
    	driver = initializeDriver();
    	
    }
    
    @And("^Navigate to Login page$")
    public void navigate_to_login_page() throws InterruptedException {
       
    	driver.get(prop.getProperty("url"));
    	landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		
		Thread.sleep(3000);
		
		
		
		
		
		
    }

	@When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
	public void user_enters_username_as_something_and_password_as_something_into_the_fields(String email, String password) {
		
		loginpage = new LoginPage(driver);
		
		loginpage.emailAddressField().sendKeys(email);
		loginpage.passwordField().sendKeys(password);
	    
	}
	
    @And("^User clicks on Login button$")
    public void user_clicks_on_login_button() {
    	
    	accountpage = new AccountPage(driver);
    	loginpage.loginButton().click();
       
    }

    @Then("^Verify user is able to successfully login$")
    public void verify_user_is_able_to_successfully_login() {
       
    	
    	Assert.assertTrue(accountpage.editinformationLink().isDisplayed());
    }
    
    @After
    public void closeBrowser() {
    	
    	driver.close();
    }





}

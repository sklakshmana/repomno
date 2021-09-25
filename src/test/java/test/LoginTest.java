package test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base{
	
	WebDriver driver;
	Logger log;
	
	@Test(dataProvider="getLoginData")
	public void login(String email, String password, String expectedStatus) throws IOException, InterruptedException {
		
		
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		log.debug("Clicked on MyAccount dropdown");
		landingPage.loginOption().click();
		log.debug("Clicked on login option");
		
		Thread.sleep(3000);
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.emailAddressField().sendKeys(email);
		log.debug("Email address got entered");
		loginpage.passwordField().sendKeys(password);
		log.debug("password got entered");
		loginpage.loginButton().click();
		log.debug("Clicked on login Button");
		
		AccountPage accountpage = new AccountPage(driver);
		
		String actualResult=" ";
		
		try {
			
			if(accountpage.editinformationLink().isDisplayed()) {
			log.debug("User got logged in");
			actualResult = "Successfull";
			}
			
		} catch(Exception e) {
			log.debug("User doesn't log in");
			actualResult = "Failure";
		}
		
		Assert.assertEquals(actualResult, expectedStatus);	
		System.out.println("LoginTest");
		log.info("Login Test got passed");
	}
	
	@BeforeMethod
	public void openApplication() throws IOException {
		
		log = LogManager.getLogger(LoginTest.class.getName());
		
		driver = initializeDriver();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to the application URL");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		
		Object [][] data = { {"arun.selenium@gmail.com","Second@123" ,"Successfull"} , {"dummy@test","dummy","Failure"} };
		return data;
	}

}

package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class FourTest extends Base {
	
	WebDriver driver;
	
	@Test
	public void fourTest() throws IOException, InterruptedException {
		
		System.out.println("fourTest");
		
		driver = initializeDriver();
		
		driver.get(prop.getProperty("url"));
		
		Thread.sleep(2000);
		
		Assert.assertTrue(true);
		
		
	}
	
	@AfterMethod
	public void closingBrowser() {
		
		driver.close();
	}

}

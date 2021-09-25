package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class ThreeTest extends Base{
	
	@Test
	public void testFour() throws IOException, InterruptedException {
		System.out.println("ThreeTest");
		
		WebDriver driver = initializeDriver();
		
		driver.get(prop.getProperty("url"));
		
		Thread.sleep(2000);
		
		driver.close();
	}

}

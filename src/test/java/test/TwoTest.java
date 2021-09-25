package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import resources.Base;

public class TwoTest extends Base {

	@Test
	public void twoTest() throws IOException, InterruptedException {
		System.out.println("twoTest");
		
		WebDriver driver = initializeDriver();
		
		driver.get(prop.getProperty("url"));
		
		Thread.sleep(2000);
		
		driver.close();
	}
}

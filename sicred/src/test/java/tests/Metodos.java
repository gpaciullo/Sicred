package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Metodos {
	
	private WebDriver driver;
	
	public void verificaAssert(String xpat, String text) throws InterruptedException {

		Thread.sleep(3000);
		String actualString = driver.findElement(By.xpath(xpat)).getText();
		assertTrue(actualString.contains(text));
		Thread.sleep(3000);
	}

}

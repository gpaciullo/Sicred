package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestePadrao2 {
	
	private WebDriver driver;


	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	public void verificaAssert(String xpat, String text) throws InterruptedException {

		Thread.sleep(3000);
		String actualString = driver.findElement(By.xpath(xpat)).getText();
		assertTrue(actualString.contains(text));
		Thread.sleep(3000);
	}

	@Test
	public void test() throws InterruptedException {
		
		//STEP 1 - Carrega o site
		driver.get("https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap");
		Thread.sleep(3000);
		
		//STEP 2 - Seleciona o DDL V4
		driver.findElement(By.xpath("//*[@id=\"switch-version-select\"]")).sendKeys("Bootstrap V4 Theme");

		//STEP 3 - Preenche os valores
		driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[1]/div[1]/a")).click();	
		driver.findElement(By.xpath("//*[@id=\"field-customerName\"]")).sendKeys("Teste Sicredi");		
		driver.findElement(By.xpath("//*[@id=\"field-contactLastName\"]")).sendKeys("Teste");		
		driver.findElement(By.xpath("//*[@id=\"field-contactFirstName\"]")).sendKeys("Gabriel");		
		driver.findElement(By.xpath("//*[@id=\"field-phone\"]")).sendKeys("51 9999-9999");		
		driver.findElement(By.xpath("//*[@id=\"field-addressLine1\"]")).sendKeys("Av Assis Brasil, 3970");		
		driver.findElement(By.xpath("//*[@id=\"field-addressLine2\"]")).sendKeys("Torre D");		
		driver.findElement(By.xpath("//*[@id=\"field-city\"]")).sendKeys("Porto Alegre");		
		driver.findElement(By.xpath("//*[@id=\"field-state\"]")).sendKeys("RS");
		driver.findElement(By.xpath("//*[@id=\"field-postalCode\"]")).sendKeys("91000-000");		
		driver.findElement(By.xpath("//*[@id=\"field-country\"]")).sendKeys("Brasil");			
		driver.findElement(By.xpath("//*[@id=\"field-salesRepEmployeeNumber\"]")).sendKeys("Fixter");					
		driver.findElement(By.xpath("//*[@id=\"field-creditLimit\"]")).sendKeys("200");	
		
		//STEP 4 - Clica no bot?o salvar	
		driver.findElement(By.xpath("//*[@id=\"form-button-save\"]")).click();

		//STEP 5 - Valida retorno de salvo		
		verificaAssert("//*[@id=\"report-success\"]/p", "Your data has been successfully stored into the database.");
		
		driver.findElement(By.xpath("//*[@id=\"report-success\"]/p/a[2]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[3]/input")).sendKeys("Teste Sicredi");
		
		driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[1]/div/input")).click();
		
		
		driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[2]/div[1]/a/span")).click();
		
		verificaAssert("/html/body/div[2]/div[2]/div[3]/div/div/div[2]/p[2]", "Are you sure that you want to delete this 1 item?");
		
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[3]/button[2]")).click();
		
		
		verificaAssert("/html/body/div[3]", "Your data has been successfully deleted from the database.");
		
		
		
		Thread.sleep(3000);
		
		
	}

}

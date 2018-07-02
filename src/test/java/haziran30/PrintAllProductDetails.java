package haziran30;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintAllProductDetails {

	WebDriver driver;

	@BeforeClass // runs once for all tests
	public void setUp() {
		System.out.println("Setting up WebDriver in BeforeClass...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		driver.quit();
	}
	
	@Test
	public void getAllProducts() {
		driver.get("https://www.amazon.com/s/ref=nb_sb_ss_i_3_7?url=search-alias%3Daps&field-keywords=wooden+spoons&sprefix=wooden+%2Caps%2C137&crid=1KG5K4AKV4QX");
		
		List<WebElement> descriptions = driver.findElements(By.xpath("//h2"));
		
		for (WebElement items : descriptions) {
			System.out.println(items.getText());	
		}
		
		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='sx-price sx-price-large']"));
		
		for (WebElement price : prices) {
			System.out.println(price.getText());
		}
		
		for(int i =0; i<descriptions.size(); i++ ) {
			System.out.println(descriptions.get(i).getText());
			System.out.println(prices.get(i).getText());
			System.out.println("===========");
		}
		
		List<WebElement> wholeItems = driver.findElements(By.xpath("//div[@class='s-item-container']"));
		
		System.out.println("wholeItems.size():" + wholeItems.size());
		
		for (int i = 0; i < wholeItems.size(); i++) {
			if(wholeItems.get(i).getText().isEmpty()) continue;
			
			String desXpath = "(//div[@class='s-item-container'])[" + (i+1) + "]//h2";
			String priceXpath = "(//div[@class='s-item-container'])[" + (i+1) + "]//span[@class='sx-price sx-price-large']";
			
			System.out.println(driver.findElement(By.xpath(desXpath)).getText());
			System.out.println(driver.findElement(By.xpath(priceXpath)).getText());
			System.out.println("------------");
			
		}
	
		
		
	}
}

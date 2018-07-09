package pomdesign;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AllOrdersPage;
import pages.OrderPage;
import pages.ProductsPage;
import pages.WebOrdersLoginPage;

public class WebOrderTests {

	WebDriver driver;
	WebOrdersLoginPage loginPage;
	AllOrdersPage allOrdersPage;
	ProductsPage productsPage;
	String userId = "Tester";
	String password = "test";
	OrderPage orderPage;
	Select select;

	@BeforeClass // runs once for all tests
	public void setUp() {
		System.out.println("Setting up WebDriver in BeforeClass...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void setUpApplication() {
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		loginPage = new WebOrdersLoginPage(driver);
	}

	@Test(description = "Verify labels and tab links are displayed", priority = 1)
	public void labelsVerication() {
		assertEquals(driver.getTitle(), "Web Orders Login", "LoginPage is not displayed. Application is down.");
		/*
		 * loginPage.userName.sendKeys(userId); loginPage.password.sendKeys(password);
		 * loginPage.loginButton.click();
		 */
		loginPage.login(userId, password);

		allOrdersPage = new AllOrdersPage(driver);
		assertTrue(allOrdersPage.webOrders.isDisplayed(), "Web Orders is not displayed");
		assertTrue(allOrdersPage.listOfAllOrders.isDisplayed(), "List Of All Orders label is not displayed");
		assertEquals(allOrdersPage.welcomeMsg.getText().replace(" | Logout", ""), "Welcome, " + userId + "!");
		assertTrue(allOrdersPage.viewAllOrders.isDisplayed(), "viewAllOrders is not displayed");
		assertTrue(allOrdersPage.orderTab.isDisplayed(), "orderTab is not displayed");
	}

	@Test(description = "Veerify default Products and Prices")
	public void availableProductsTest() {
		assertEquals(driver.getTitle(), "Web Orders Login", "LoginPage is not displayed. Application is down.");
		loginPage.login(userId, password);
		allOrdersPage = new AllOrdersPage(driver);
		allOrdersPage.viewAllProducts.click();
		productsPage = new ProductsPage(driver);
		List<String> expProducts = Arrays.asList("MyMoney", "FamilyAlbum", "ScreenSaver");
		List<String> actProducts = new ArrayList<>();

		// lambda
		// productsPage.productNames.forEach(elem-> actProducts.add(elem.getText()));

		// foreach
		for (WebElement prod : productsPage.productNames) {
			actProducts.add(prod.getText());
		}

		assertEquals(actProducts, expProducts);

		for (WebElement row : productsPage.productsRows) {

			System.out.println(row.getText());
			String [] prodData = row.getText().split(" ");
			switch(prodData[0]) {
				case "MyMoney":
					assertEquals(prodData[1], "$100");
					assertEquals(prodData[2], "8%");
					break;
				case "FamilyAlbum":
					assertEquals(prodData[1], "$80");
					assertEquals(prodData[2], "15%");
					break;
				case "ScreenSaver":
					assertEquals(prodData[1], "$20");
					assertEquals(prodData[2], "10%");
					break;
			}
		}
		
	}
	
	@Test
	public void orderTest() {
		assertEquals(driver.getTitle(), "Web Orders Login");
		loginPage.login(userId, password);
		allOrdersPage = new AllOrdersPage(driver);
		allOrdersPage.orderTab.click();
		orderPage=new OrderPage(driver);
		
		WebElement mySelectElement = orderPage.findProduct;
		Select dropdown = new Select(mySelectElement);
		dropdown.selectByIndex(2);
		orderPage.findQuantity.clear();
		orderPage.findQuantity.sendKeys("2");
		orderPage.clickCalculate.click();
		String name="Eva Smith";
		orderPage.findName.sendKeys(name);
		orderPage.findStreet.sendKeys("123 Main St.");
		orderPage.findCity.sendKeys("Columbia");
		orderPage.findState.sendKeys("Maryland");
		orderPage.findZip.sendKeys("21212");
		orderPage.findCard.click();
		orderPage.findCardNumber.sendKeys("1234567891011");
		orderPage.findExpire.sendKeys("11/22");
		orderPage.clickProcess.click();
		assertTrue(driver.findElement(By.tagName("strong")).isDisplayed(),"New order has been successfully added. is not displayed");
		allOrdersPage.viewAllOrders.click();
		allOrdersPage=new AllOrdersPage(driver);
		System.out.println(allOrdersPage.tableName.getText());
		assertEquals(allOrdersPage.tableName.getText(),name);
		
	}

	// logout after each test
	@AfterMethod
	public void logout() {
		allOrdersPage.logout();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}

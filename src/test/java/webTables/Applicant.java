package webTables;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Applicant {

	//1) goto https://forms.zohopublic.com/murodil/report/Applicants/reportperma/DibkrcDh27GWoPQ9krhiTdlSN4_34rKc8ngubKgIMy8
	String url ="https://forms.zohopublic.com/murodil/report/Applicants/reportperma/DibkrcDh27GWoPQ9krhiTdlSN4_34rKc8ngubKgIMy8";
	WebDriver driver;

	@BeforeClass // runs once for all tests
	public void setUp() {
		System.out.println("Setting up WebDriver in BeforeClass...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(url);
	}

	
	// 2) Create a HashMap
	//3) change row number to 100, read all data on first page and put uniquID as a KEY 
	//and Applicant info as a Value to a map. 

	//applicants.put(29,"Amer, Sal-all@dsfdsf.com-554-434-4324-130000")

	@Test
	public void test1() {
		driver.findElement(By.xpath("//select[@id='recPerPage']")).click();
		driver.findElement(By.xpath("//option[.='100']")).click();
		
		int a=driver.findElement(By.xpath("//table[@id='" + id + "']/tbody/tr"));
		int b =driver.findElement(By.xpath("//table[@id='" + id + "']/tbody/tr"));
		
		Map<Integer, String> map = new HashMap<>();
		for(int i = 0; i < 100; i++) {
			
			map.put(a, b)
		}
		
		public void printTableData(String id) {
			int rowsCount = driver.findElements(By.xpath("//table[@id='" + id + "']/tbody/tr")).size();
			int colsCount = driver.findElements(By.xpath("//table[@id='" + id + "']/thead/tr/th")).size();

			System.out.println("===============");

			for (int rowNum = 1; rowNum <= rowsCount; rowNum++) {
				for (int col = 1; col <= colsCount; col++) {
					String xpath = "//table[@id='" + id + "']/tbody/tr[" + rowNum + "]/td[" + col + "]";
					String tdData = driver.findElement(By.xpath(xpath)).getText();
					System.out.print(tdData + "  \t");
				}
				System.out.println();
			}
		}
	}
	
}
/*
 * 2) Create a HashMap
3) change row number to 100, read all data on first page and put uniquID as a KEY 
and Applicant info as a Value to a map. 

applicants.put(29,"Amer, Sal-all@dsfdsf.com-554-434-4324-130000")

4) Click on next page , repeat step 3
5) Repeat step 4 for all pages 
6) print count of items in a map. and assert it is matching
with a number at the buttom
 * 
 * */
 
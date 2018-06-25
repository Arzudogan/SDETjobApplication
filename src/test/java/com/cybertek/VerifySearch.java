package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifySearch {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://etsy.com");
		String searchTerm = "fathers day gifts";
		
		WebElement input = driver.findElement(By.id("search-query"));
		
		input.sendKeys(searchTerm + Keys.ENTER);
		
		String actual = input.getAttribute("value");
		
		System.out.println(actual);
		
		if (actual.equals(searchTerm)) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
			System.out.println("expected:\t"+searchTerm);
			System.out.println("found:\t"+ actual);
		}
		
		
		

	}

}
/*
Verify Search term

1.Open browser
2.Open Etsy homepage
3.Enter search term
4.Verify the results page title contains the search term
5.Verify search entry is still saved in the search bar
*/
package com.cybertek;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownDemo {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://tutorialehtml.com/en/html-tutorial-drop-down-lists-menu/");
		
//		1. find select tag
		WebElement selectTag = driver.findElement(By.name("my_html_select_box"));
		
//		2. create select object from the select tag
		Select list = new Select(selectTag);
		//getFirstSelectedOption()----> RETURNS THE selected element
		
		// print the selected value: option 2
		
		System.out.println(list.getFirstSelectedOption().getText());
		
		//print the all available options
		//returns a list of all options(selected an dnot selected, everything)
		
		List<WebElement> options = list.getOptions();
		System.out.println("------------");
		for (WebElement webElement : options) {
			System.out.println(webElement.getText());
		}
		System.out.println("------------");
		// select using the visible text
		list.selectByVisibleText("Bucharest");
		
		System.out.println("selected:\t" + list.getFirstSelectedOption().getText());
		
		// select using the index
		// count starts from 0
		list.selectByIndex(0);
		System.out.println("selected:\t" + list.getFirstSelectedOption().getText());
		
		System.out.println("************");
		
		Select secondList = new Select(driver.findElement(By.cssSelector("select[multiple='yes']")));
		
		secondList.selectByVisibleText("New York");
		secondList.selectByVisibleText("Madrid");
		
		List<WebElement> allSelectedOptions = secondList.getAllSelectedOptions();
		
		for (WebElement webElement : allSelectedOptions) {
			System.out.println(webElement.getText());
		}
		System.out.println(allSelectedOptions.size());
		secondList.deselectAll();
		allSelectedOptions = secondList.getAllSelectedOptions();
		System.out.println(allSelectedOptions.size());
	}
}


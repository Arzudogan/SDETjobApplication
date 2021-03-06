package pomdesign;

public class Notes {

}
/*
 *07/08/2018
----------

Selenium Class.
--------------
POM design -> Page Object Model
-------------------------------

Selenium Basics:
	methods that work with page as a whole:
		get,navigate().to().
		navigate().forward()
		navigate().back()
		navigate().refresh()
		getTitle()
		getPageSource()
		getCurrentUrl()
		close(), quit()
	Weblements:
		findElement
		findElements
		By class
			By.id()
			By.name()
			By.className()
			By.tagName()
			By.xpath()
			By.css()
			By.linkText()
			By.partialLinkText()

	After finding Element:
		click()
		sendKeys()
		clear()
		getText()
		getAttribute()
		isDisplayed()
		isEnabled()
		isSelected() -> checkbox and radio
		getLocation()
		Select class
			-> selectByIndex/visibletext/value
			-> getOptions -> ListOfoptions etc
			-> getFirstSelectedOption
		.......
	More actions on WebElements:
		Actions class.

	MULTIPLE WINDOWS/TABS/ Alerts

	-> getWindowHandle() -> 
	-> getWindowHandles() -> Set of strings
	driver.switchTo().window()

	-> Alert al = driver.switchTo().alert()
	al.accept/dismiss/getText/sendKeys etc

	IFRAMES:
		driver.switchTo().frame()
			-> WebElement
			-> id
			-> name
			-> index

--------------------------------
	PageFactory, Page object model design

	WAITS -> Implicit /Explicit / Fluent
================================

TestNG -> For testing
Maven -> build management
	  -> dependency management

Git + GitHub -> VC
=================

Selenium/TestNG Listeners.
------------------

Our Project is in GitHub.

git clone repo_url

clone -> goto GitHub repository and
copy everything to local git repository.

-create folder
selenium-maven-automation
===============================

http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx

Page object model design:
	It is very popular design in Selenium Automation.
	For each page in web application, we create dedicated Java class.

	Normal java class:
		Fields/Variables/Data
		Methods/Behavior

	In POM design:
		We store WebElements on that page as Fields/Variables
		We write methods in Page classes for the actions that you do on that page.
=================================

Step 1) enter userName
Step 2) enter password
Step 3) click login

=================================


Step 1) enter valid userName
Step 2) enter valid password
Step 3) click login
Step 4) "Welcome, Tester!" label should be displayed 
===================

Benefits of POM design:
	-> reusable code
	-> centralized maintenance of all element locators
	-> easy to read the code/readable
	-> easy to maintain the code
	-> can create new tests efficiently
------------------------

Step 1) enter invalid userName
Step 2) enter valid password
Step 3) click login
Step 4) "Invalid Login or Password." message should be displayed

======================
public WebOrdersLoginPage(WebDriver driver) {
		//using the driver initialize or locate all elements in this class
 PageFactory.initElements(driver, this);	
}

 PageFactory.initElements(driver, this);
 is a special class in Selenium that is written to support page object model design.

 The above line, initializes(locates/finds) all elements using the driver provided.
 ----------------------------------

PAGE OBJECT MODEL DESIGN.
------------------------

When you have a test case to automate.

1) Manually execute it and make sure it is working/passing. Understand the test case
2) Automation:
		- create page object classes ,if not already exists. For each page that is part of the test case
		- add all elements that are affected by the test as variables for the page object class
		- specify locators using @FindBy annotation.
		- create a TestNG test and use page objects and elements according to test case.
		- Execute TestNG tests
==================================

Step 1. Navigate to loginpage
Step 2. Assert that you are on loginpage
Step 3. Login using valid credentials
Step 4. Verify following labels are displayed:
	- Web Orders
	- List of All Orders
	- Welcome, Tester!
	- View All orders
	- View All products
	- Order

======================
In programming there are different patterns:
- singletons
- factory pattern
- builder pattern
....

In selenium test automation we use:
	POM -> page object model design pattern
	Singletons -> Driver class
	Factory -> for utilities
------------------------


Step 1. Navigate to loginpage
Step 2. Assert that you are on loginpage
Step 3. Login using valid credentials
Step 4. Click on view all products
Step 5. Verify following products are displayed:
	MyMoney
	FamilyAlbum
	ScreenSaver

Step 6. Verify prices and discounts :
	MyMoney	    $100 8%
	FamilyAlbum	$80	15%
	ScreenSaver	$20	10% 
 * */
 
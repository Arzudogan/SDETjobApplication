package haziran30;

public class ClassNotes {

}
/*
 *06/30/2018
----------

Saturday. 
Selenium Automation.

Tomorrow is Sunday.
Java data structures wrap up with Akbar.
========================================

FINDELEMENTS:

Warm up task with FindElements:

Navigate to https://www.amazon.com/s/ref=nb_sb_noss_1?url=search-alias%3Daps&field-keywords=wooden+spoon
Print all item Descriptions and prices 
ex:
Wood Spoons Soup Spoon 5 Pieces Eco friendly 
Japanese Tableware Natural Ellipse Wooden Coffee 
Demitasse Tea Dessert Spoon Ladle Set with Case

10.99
------------------
Wood Spoons Soup Spoon 5 Pieces Eco friendly 
Japanese Tableware Natural Ellipse Wooden Coffee 
Demitasse Tea Dessert Spoon Ladle Set with Case

16.99
================================
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
	=========================

ASSERT VS VERIFY.

Selenium IDE -> we have assertEquals, verifyEquals etc 

In testNG, or Junit -> assertEquals, assertTrue ...

If ASSERT step fails, execution stops at that point.
If VERIFY step fails, it will report a fail but will continue
execution to upcoming steps.
===================

TestNG test:

@Test
public void test1() {
  int n = 10;
  int k = 5;

  Assert.assertEquals(n,k);
  print "next step";
  Assert.assertTrue(n>k);  
}

@Test
public void test2() {
  int n = 10;
  int k = 5;

  Assert.assertNotEquals(n,k);
  print "next step";
  Assert.assertTrue(n>k);  
}

In TestNG:
  If a step(assertion, exception) fails it will only stop 
  execution for that current @Test.
  If there are more tests, it will continue to execute them.
==========================
Whenever an assertion fails , code execution will stop at that point.
and it will continue to next test if there is one.
===========
  
in TESTNG 2 types of Assetions.

HARD and SOFT 
So far we have been using HARD assertions.

HARD assertions make code execution stop at that point.
SOFT assertions is used to achieve VERIFY steps and 
code will still keep running even if assertion fails.

ASSERT VS VERIFY in general automation.

SoftAssert softAssert = new SoftAssert();
softAssert.

==================

WEBTABLES in HTML.

How to work with WEBTABLES using Selenium WebDriver

K,V

Map<Integer, String> applicants = new HashMap<>();
applicants.put(uniquID, John, Smith-sample@gmail.com-17777777777-0)

1) goto https://forms.zohopublic.com/murodil/report/Applicants/reportperma/DibkrcDh27GWoPQ9krhiTdlSN4_34rKc8ngubKgIMy8
2) Create a HashMap
3) change row number to 100, read all data on first page and put uniquID as a KEY 
and Applicant info as a Value to a map. 

applicants.put(29,"Amer, Sal-all@dsfdsf.com-554-434-4324-130000")

4) Click on next page , repeat step 3
5) Repeat step 4 for all pages 
6) print count of items in a map. and assert it is matching
with a number at the buttom
====================================== 
 * 
 * */
 
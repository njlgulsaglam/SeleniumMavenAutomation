package com.dice;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearch {
public static void main(String[] args) {
	
	//set up crome driver path
	WebDriverManager.chromedriver().setup();
	//invoke selenium webdriver
	WebDriver driver = new ChromeDriver();
	
	//fulscreen
	driver.manage().window().fullscreen();
	
	//set universal wait time in case web page is slow
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	  /*Step 1. Launch browser and navigate to https://dice.com 
    Expected: dice home page should be displayed
*/
String url = "https://dice.com";
driver.get(url);
String actualTitle=driver.getTitle();
String expectedTitle="Job Search for Technology Professionals | Dice.com";
     if(actualTitle.equals(expectedTitle)) {
	System.out.println("Step pass");
    }else {
	System.out.println("Step Fail");
}
String keyword="java developer";
driver.findElement(By.id("search-field-keyword")).clear();
driver.findElement(By.id("search-field-keyword")).sendKeys(keyword);

String location="22102";
driver.findElement(By.id("search-field-location")).clear();
driver.findElement(By.id("search-field-location")).sendKeys(location);

driver.findElement(By.id("findTechJobs")).click();

String count= driver.findElement(By.id("posiCountId")).getText();
System.out.println(count);
//ensure count is more than 0
int countResult = Integer.parseInt(count.replace(",",""));

if(countResult > 0) {
				System.out.println( "Step PASS: Keyword : " + keyword +" search returned " +
				countResult +" results in " + location);
			}else {
				System.out.println( "Step FAIL: Keyword : " + keyword +" search returned " +
						countResult +" results in " + location);
			}
driver.close();
System.out.println("test completed-" + LocalDateTime.now());
}
}
/*	   Test case:
Title: dice job search 

Step 1. Launch browser and navigate to https://dice.com 
    Expected: dice home page should be displayed

Step 2. Insert search keyword and location then click on find tech job
  Expected: -Search results page should be loaded.
            -Page title should contain count of results , 
            along with search keyword.
  -Count of results should be displayed on the page.
  ====================
  Steps to automate:
    -Make sure you understand what functionality is being tested 
    and each step. What is expected, what is being tested.

    If you don't understand:  Ask manual tester/person who wrote it.
    BAs, Developers, Lead 

    -Manually test it and make sure , it is passing manually.
    And make sure no defects/bugs around it.
    -if a test case is failing manually, it does not qualify 
    for automation.

    --> starts automating:
    Java + Selenium + Maven + Git > Github
  =========================

*/

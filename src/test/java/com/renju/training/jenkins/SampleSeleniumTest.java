package com.renju.training.jenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class SampleSeleniumTest {
	
	WebDriver driver;
	
	@BeforeClass
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pkprashant\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOptions);
	}
	
	
	
	@Test
	public void validateGoogleId() throws Exception {
		System.out.println("Opening Browser");
		driver.get("http://www.google.com");
		System.out.println("Clicking Gmail Link");
		driver.findElement(By.xpath("//*[@id='gb']/div/div[1]/div/div[1]/a")).click();
		System.out.println("Clicking Sign In link");
		//Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[5]/ul/li[2]/a")).click();
		//driver.findElement(By.linkText("sign in")).click();
		
		
		Thread.sleep(3000);
		System.out.println("Entering username");
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("renju.jenkins.training");
		System.out.println("Clicking Next button");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span")).click();
		Thread.sleep(5000);
		boolean textFound = driver.getPageSource().contains("Forgot password");
		AssertJUnit.assertTrue(textFound);
	}
	
	/*
	 * @AfterClass public void closeBrowser() { driver.quit(); }
	 */
}

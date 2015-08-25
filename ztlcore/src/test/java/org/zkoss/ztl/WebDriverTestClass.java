package org.zkoss.ztl;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverTestClass {
	public static void main(String a[]) throws InterruptedException {
		/*
		 * Firefox driver is cool, it supports javascript and offers a lot of
		 * features You can also use the below drivers WebDriver driver = new
		 * InternetExplorerDriver(); WebDriver driver = new HtmlUnitDriver();
		 */

		WebDriver driver = new FirefoxDriver();

		try {
			// Go to Google Home Page
			driver.get("http://www.google.com");

			// Look for search textbox and enter search term there
			WebElement searchBox = driver.findElement(By.name("q"));
			searchBox.sendKeys("WebDriver API");

			// Click on 'Search'
			WebElement searchButton = driver.findElement(By.name("btnG"));
			searchButton.click();

			// Not required or recommended any where, but just wait for the last
			// click()
			// operation to get completed fine
			Thread.sleep(2000);

			System.out.println("What's the current Url: "
					+ driver.getCurrentUrl());

			// if you wish to take screenshot of this page, you can!
			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(
					"c:\\screenshot\\googlesearch-webdriverapi.png"));

			// Close the driver, once you're done.
			driver.close();
		} catch (Exception e) {
			e.printStackTrace(); // For debugging purposes
		}

	}

}

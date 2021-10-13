package com.harshita.selenium.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.harshita.selenium.util.ExcelUtility;



public class BasePage {
	public static WebDriver driver = null;
	// To read test data from properties file
	public static Properties prop = null;
	public static File file = null;
	public static FileInputStream fis = null;
	
	static {
		
		file = new File( System.getProperty("user.dir")+"/src/test/java/com/harshita/selenium/testdata/TestConfig.properties");
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	// To read test data from excel
	public static ExcelUtility xls = new ExcelUtility(
			System.getProperty("user.dir") + prop.getProperty("TestInputSheetPath"));

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// Default constructor
	public BasePage() {

	}

	// Parameterized constructor to initialize the the browsers

	public BasePage(String browser, String AppURL) {

		
		if ("Chrome".equalsIgnoreCase(browser)) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"/src/main/java/com/harshita/selenium/resources/chromedriver");

			driver = new ChromeDriver();

		} // End of If

		else if ("FF".equalsIgnoreCase(browser)) {

			
		}

		driver.navigate().to(AppURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	} // End of If

}// End Of Constructor
package com.harshita.selenium.util;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.harshita.selenium.pages.BasePage;
import com.harshita.selenium.pages.HomePage;
import com.harshita.selenium.pages.LoginPage;
import org.apache.commons.io.FileUtils;

public class TestLibrary extends BasePage {
	public static HomePage homePage = null;
	public static LoginPage loginPage = null;

	public static HomePage navigateToHomePage(Hashtable<String, String> testData) {

		try {
			loginPage = new LoginPage(BasePage.prop.getProperty("Browser"), BasePage.prop.getProperty("TestSiteURL"));
			homePage = loginPage.doLogin(testData.get("UserName"), testData.get("Password"));
			return homePage;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return null;
		}

	}

	public static void reportErrorAndtakeScreenshot(String methodName){

		// The below method will save the screen shot in d drive with test method name
		try {
			// Convert web driver object to TakeScreenshot
			File scrFile = ((TakesScreenshot) BasePage.driver).getScreenshotAs(OutputType.FILE);
			// Move image file to new destination
			String path = System.getProperty("user.dir") + "/src/test/java/com/harshita/selenium/resources/";
			// Copy file at destination
			FileUtils.copyFile(scrFile, new File(path + methodName + ".png"));
			System.out.println("Placed screenshot in " + path + ".");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void assertForSomeErrorOccur(String message) {

		// return homePage;

	}

}

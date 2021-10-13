package com.harshita.selenium.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.harshita.selenium.pages.BasePage;
import com.harshita.selenium.pages.HomePage;
import com.harshita.selenium.util.TestLibrary;
import com.harshita.selenium.util.UtilityFunctions;

public class HomePageTest {

	HomePage homePage = null;
	Hashtable<String, String> testData = new Hashtable<String, String>();

	// Log into any email account and check if there is an email.
	@Test(dataProvider = "TC_001DataProvider")
	public void TC_01(Hashtable<String, String> testData1) throws InterruptedException {

		// navigate to home page
		homePage = TestLibrary.navigateToHomePage(testData1);

		if (!homePage.verifyEmailIsPresent()) {
			Assert.assertEquals("There is no email in the account", "Email should be present in the account");
		}
	}

	// Verify that the subject and body of the email contains a predefined string.
	@Test
	public void TC_02() throws InterruptedException {
		testData = new Hashtable<String, String>();
		testData.put("UserName", "harshitaTest123");
		testData.put("Password", "Test@5654");

		// navigate to home page
		homePage = TestLibrary.navigateToHomePage(testData);

		if (!homePage.enterSearchCriteria("Test", "Test")) {
			Assert.assertEquals("There is no email in the account with the entered search text",
					"Email should be present in the account with the entered search text");

		}
	}

	@DataProvider
	public Object[][] TC_001DataProvider() {

		return UtilityFunctions.getData("TC_001", BasePage.xls);
	}

	@AfterMethod
	public void pageObjectsDeinitialisation() {

		testData = null;
		homePage = null;
		BasePage.driver.close();

	}

	@AfterSuite
	public void driverDeinitialisation() {

		BasePage.driver.quit();

	}

}

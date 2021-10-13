package com.harshita.selenium.pages;

import org.openqa.selenium.By;

import com.harshita.selenium.util.LibraryFunctions;

/**
 * Hello world!
 *
 */
public class LoginPage extends BasePage {
	// Object Declaration Of Page Classes
	HomePage homePage = null;

	// Private Class Members
	// Text Fields
	private final String xPath_txtUserName = "//input[@id='identifierId']";
	private final String xPath_txtPassword = "//input[@name='password']";

	// Buttons
	private final String xPath_btnNextUsernameScreen = "//div[@id='identifierNext']";
	private final String xPath_btnNextPasswordScreen = "//div[@id='passwordNext']";

	// Class Constructors

	// Default constructor
	public LoginPage() {
		super();
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	// Parameterized constructor. Will take Browser Name and the url of the
	// applications(as set in the configuration file)
	public LoginPage(String browser, String appURL) {
		super(browser, appURL);
	}

	// --------------------------------------------------------------------------------------------------------------------------------

	// Class Methods

	// --------------------------------------------------------------------------------------------------------------------------------
	// Login the application with the provided User name and Password
	public HomePage doLogin(String userName, String password) throws Exception {

		try {
			LibraryFunctions.clearElement(xPath_txtUserName);
			LibraryFunctions.enterText(xPath_txtUserName, userName);

			LibraryFunctions.clickElement(xPath_btnNextUsernameScreen);

			if (LibraryFunctions.isElementVisible(xPath_txtPassword)) {
				LibraryFunctions.enterText(xPath_txtPassword, password);
				LibraryFunctions.clickElement(xPath_btnNextPasswordScreen);

			}

			if (LibraryFunctions.isElementPresentFromFindElements("//div[contains(text(),'" + userName + "')]")) {

				return new HomePage();
			}

			else {

				return null;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

}

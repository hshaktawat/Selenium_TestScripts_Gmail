package com.harshita.selenium.pages;

import com.harshita.selenium.util.LibraryFunctions;

public class HomePage extends BasePage {

	HomePage homePage = null;

	private static String xPath_lblEmailRow = "//tr[@class='zA zE']";
	private static String xPath_lblNoSearchResultsFound = "//td[contains(text(),'No messages matched your search.')]";
	private static String xPath_lblCountOfMatchingEmail = "//div[@aria-label='Show more messages']//span[contains(text(),'of')]//span[2]";

	private static String xPath_btnSearchOptions = "//button[@data-tooltip='Show search options']";
	private static String xPath_btnSearch = "//div[@role='button'][contains(text(),'Search')]";

	private static String xPath_textSubject = "//span//label[contains(text(),'Subject')]//following::span//input";
	private static String xPath_textContent = "//span//label[contains(text(),'Has the words')]//following::span//input";

	public boolean verifyEmailIsPresent() {
		try {
			return LibraryFunctions.isElementPresentFromFindElements(xPath_lblEmailRow);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return false;

	}

	public boolean enterSearchCriteria(String searchSubject, String searchContent) {

		try {

			LibraryFunctions.clickElement(xPath_btnSearchOptions);
			LibraryFunctions.enterText(xPath_textSubject, searchSubject);
			LibraryFunctions.enterText(xPath_textContent, searchContent);
			LibraryFunctions.clickElement(xPath_btnSearch);

			if (LibraryFunctions.isElementVisible(xPath_lblNoSearchResultsFound)) {
				return false;
			} else {

				if (LibraryFunctions.isElementPresentFromFindElements(xPath_lblCountOfMatchingEmail))
					return true;
				else
					return false;

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

}

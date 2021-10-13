package com.harshita.selenium.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.harshita.selenium.pages.BasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LibraryFunctions extends BasePage {

	WebElement element;

	public static boolean enterText(String xPath, String text) {
		try {
			if (isElementVisible(xPath)) {
				BasePage.driver.findElement(By.xpath(xPath)).sendKeys(text);

				if (BasePage.driver.findElement(By.xpath(xPath)).getText().equalsIgnoreCase(text)) {
					return true;
				} else {
					return false;
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;

	}

	public static boolean isElementVisible(String xPath) {

		try {
			WebDriverWait wait = new WebDriverWait(BasePage.driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public static boolean clickElement(String xPath) {

		try {
			if (isElementVisible(xPath)) {
				BasePage.driver.findElement(By.xpath(xPath)).click();
				return true;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;

	}

	public static boolean clearElement(String xPath) {

		try {
			if (isElementVisible(xPath)) {
				BasePage.driver.findElement(By.xpath(xPath)).clear();
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;

	}

	public static String getText(String xPath) {

		try {
			if (isElementVisible(xPath)) {
				return BasePage.driver.findElement(By.xpath(xPath)).getText();

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		return null;

	}

	public static boolean isElementPresentFromFindElements(String xPath) {

		try {
			if (BasePage.driver.findElements(By.xpath(xPath)).size() > 0) {
				return true;

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;

	}

	public static void reloadWebPage() {

		try {
			BasePage.driver.navigate().refresh();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}

}

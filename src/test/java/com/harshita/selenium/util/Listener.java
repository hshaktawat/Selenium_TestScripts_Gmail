package com.harshita.selenium.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Error " + result.getName() + " test has failed.");
		String methodName = result.getName().toString().trim();
		TestLibrary.reportErrorAndtakeScreenshot(methodName);

	}

	public void onFinish(ITestContext context) {
	}

	public void onTestStart(ITestResult result) {
		System.out.println("Test case " + result.getName() + " execution has started.");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case " + result.getName() + " has executed successfully.");
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onStart(ITestContext context) {
	}
}
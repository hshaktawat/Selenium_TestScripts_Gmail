package com.harshita.selenium.util;

import java.util.Hashtable;

public class UtilityFunctions {
	// --------------------------------------------------------------------------------------------------------------------------------
	// Read data from the excel file. Takes two arguments - Test Case Name and
	// XLS_Reader object. Reads the test data from the Test Data excel and
	// return the test data in 2 D object array form
	public static Object[][] getData(String TestCaseName, ExcelUtility xls) {
		// find test in the excel file
		// find number of columns in the test
		// find number of rows in the test
		// print the data of the test
		// put the data in object array

		// Get the start row index for the test data of the given Test Case name
		int testCaseStartIndex = 0;

		for (int rNum = 1; rNum <= xls.getRowCount("TestData"); rNum++) {
			if (TestCaseName.equals(xls.getCellData("TestData", 1, rNum))) {
				testCaseStartIndex = rNum;
				break;
			} // end of if
		} // end of for

		// Get the number of columns in the test data (which is available column
		// wise) for the given test case
		int testCaseDataColumnNamesStartIndex = testCaseStartIndex + 1;

		int colsOffset = 2;
		int Cols = colsOffset;
		while (!(xls.getCellData("TestData", Cols, testCaseDataColumnNamesStartIndex).equals(""))) {
			Cols++;
		} // end of while

		int numberOfTestDataColumns = Cols - colsOffset;

		int testCaseDataStartIndex = testCaseStartIndex + 2;

		int rows = 0;
		while (!xls.getCellData("TestData", colsOffset, (testCaseDataStartIndex + rows)).equals("")) {
			rows++;
		} // end of while
		int numberofTestDataSets = rows;

		// Store the test data sets of a single test case in an array of
		// HashTable. Each HasTable will contain one test data set
		Object[][] dataSetCollection = new Object[numberofTestDataSets][1];

		Hashtable<String, String> TestDataSet = null;
		String Datakey = "'";
		String Keyvalue = "";
		int index = 0;
		for (int r = testCaseDataStartIndex; r < (testCaseDataStartIndex + numberofTestDataSets); r++) {
			TestDataSet = new Hashtable<String, String>();

			for (int c = colsOffset; c < (numberOfTestDataColumns + colsOffset); c++) {

				Datakey = xls.getCellData("TestData", c, testCaseDataColumnNamesStartIndex);
				Keyvalue = xls.getCellData("TestData", c, r);
				TestDataSet.put(Datakey, Keyvalue);

			} // end of for
				// Once all the Column Name Value pair is stored in the
				// HashTable for a row, add this Hash Table in the 2 D array of
				// Objects
			dataSetCollection[index][0] = TestDataSet;
			index++;
		} // end of for

		return dataSetCollection;

	}// end of function

}

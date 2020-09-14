package amazon.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;

import amazon.base.pages.BasePage;
import amazon.base.pages.Constants;

public class Xls_Reader extends BasePage {

	public List<String> readingFromExcel(String sheetName, String columnName) throws IOException {

		List<String> data = new ArrayList<String>();

		Workbook wb = null;
		try {
			FileInputStream fis = new FileInputStream(Constants.DATAFILE_PATH);
			wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Iterator<Row> rowIterator = sh.iterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.toString().equalsIgnoreCase(columnName)) {
						int rowNum = cell.getRowIndex();
						for (int i = rowNum; i <= rowNum; i++) {
							for (int j = 1; j < sh.getRow(rowNum).getLastCellNum(); j++) {
								Row row1 = sh.getRow(i);
								Cell cell1 = row1.getCell(j);
								data.add(cell1.toString());

							}
						}
					}
				}
			}
		} catch (Exception e) {

		} finally {
			wb.close();
		}
		return data;
	}

	public static List<String> readRunMode(String sheetName) throws IOException {

		String path = System.getProperty("user.dir") + "\\TestData.xlsx";

		List<String> data = new ArrayList<String>();

		Workbook wb = null;
		try {
			FileInputStream fis = new FileInputStream(path);
			wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Iterator<Row> rowIterator = sh.iterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					data.add(cell.toString());

				}
			}
		} catch (Exception e) {

		} finally {

			wb.close();
		}

		return data;
	}

	public static Object[][] getDataFromExcel(String testSheetName) throws IOException {
		List<String> s = new ArrayList<String>();

		Object[][] obj = new Object[3][2];
		s = readRunMode(testSheetName);
		int a = s.size();

		for (int i = 2; i < s.size(); i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 2; k++) {
					obj[j][k] = s.get(i);
					i++;
				}

			}
		}

		return obj;

	}

	public static Object[][] getData1(String testCaseName) throws IOException {
		String sheetName = "BrowserInfo";
		int testStartRowNum = 1;
		Xls_Reader xls1 = new Xls_Reader();
		// while(!xls.getCellData())

		List<String> s = new ArrayList<String>();

		Object[][] obj = new Object[3][2];
		s = readRunMode("BrowserInfo");
		int a = s.size();

		obj[0][0] = s.get(2);
		obj[0][1] = s.get(3);
		obj[1][0] = s.get(4);
		obj[1][1] = s.get(5);
		obj[2][0] = s.get(6);
		obj[2][1] = s.get(7);

		return obj;

	}

	public List<String> fetchTestData_IfExceuteTestCaseYes(String testCaseName, String[] strArray1) throws IOException {
		List<String> data = new ArrayList<String>();
		List<String> retData = new ArrayList<String>();
		Xls_Reader readExcel = new Xls_Reader();
		String executeTC = "N";

		data = readingFromExcel("TestCase", testCaseName);
		executeTC = data.get(0);
		String[] strArray2 = null;

		if (executeTC.equals("Y")) {
			for (String str1 : strArray1) {

				data = readingFromExcel("TestDataSheet", str1);
				retData.add(data.get(0));
			}
			return retData;
		}

		else {
			getSession().skipTest("Skipping the test case as runMode for " + testCaseName + " is NO");
			throw new SkipException("Skipping the test case as runMode for " + testCaseName + " is NO");

		}
	}

}

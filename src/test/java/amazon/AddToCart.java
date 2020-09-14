package amazon;

import java.io.IOException;
import java.util.List;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import amazon.base.pages.Constants;
import amazon.base.pages.genericPage;
import amazon.session.amazonTestSession;
import amazon.test.pages.AddToCartPage;
import amazon.test.pages.CartListPage;
import amazon.test.pages.ResultDisplayedPage;
import amazon.test.pages.SearchProductPage;
import amazon.util.Xls_Reader;

public class AddToCart {

	amazonTestSession session;
	Xls_Reader readExcel;
	String testCaseName = "AddToCart";
	String testSheetName = "BrowserInfo";

	@BeforeMethod
	public void init() {
		session = new amazonTestSession();
		session.init(testCaseName);
	}

	@AfterMethod
	public void quit() {

		session.generateReports();
	}

	@Test(dataProvider = "getData",groups="regression")
	public void searchProduct(String bName, String runMode) throws InterruptedException {
	
		String browserName = bName;
		String executeTC;
		List<String> data = null;
		if (runMode.equals("Y")) {
			try {
				readExcel = new Xls_Reader();
				data = readExcel.readingFromExcel("TestCase", testCaseName);
				executeTC = data.get(0);
				if (executeTC.equals("Y")) {
					session.log("Ready to run test: " + testCaseName + "on broswer: " + bName);
				} else {
					session.skipTest("Skipping the test case as runMode for " + testCaseName + " is NO");
					throw new SkipException("Skipping the test case as runMode for " + testCaseName + " is NO");
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			session.skipTest("Skipping the test case as runMode for " + browserName + " is NO");
			throw new SkipException("Skipping the test case as runMode for " + browserName + " is NO");
		}

		genericPage page = new AddToCartPage().goToAddToCart();

		if (page instanceof AddToCartPage) {
			page.validator(true).fail("Item not added to cart ", "Error on page");
		} else if (page instanceof CartListPage) {
			page.validator(false).validateElementPresence(Constants.cartBtn_locator);
			page.validator(false).pass("Successful. " + testCaseName + " PASSED");
		}

		session.sessionEnd();

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		return Xls_Reader.getDataFromExcel(testSheetName);
	}

}

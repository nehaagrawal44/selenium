package amazon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import amazon.base.pages.BasePage;
import amazon.base.pages.Constants;
import amazon.base.pages.genericPage;
import amazon.reports.reports;
import amazon.session.amazonTestSession;
import amazon.test.pages.EnterPasswordPage;
import amazon.test.pages.EnterUsernamePage;
import amazon.test.pages.LaunchPage;
import amazon.util.Xls_Reader;

public class LoginTest {

	amazonTestSession session;
	Xls_Reader readExcel;
	String testCaseName = "LoginTest";
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

	
	@Test(dataProvider = "getData",groups= {"smoke","regression"},priority=1)
	public void loginTest(String bName, String runMode) throws InterruptedException  {

		String browserName = bName;
		String executeTC;
		List<String> data = null;
		
		String[] strArray2 = { "Username", "Password" };
		if (runMode.equals("Y")) {
			try {
				 readExcel=new Xls_Reader();
				data = readExcel.fetchTestData_IfExceuteTestCaseYes(testCaseName, strArray2);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			session.skipTest("Skipping the test case as runMode for " + browserName + " is NO");
			throw new SkipException("Skipping the test case as runMode for " + browserName + " is NO");
		}
		String username = data.get(0);
		String password = data.get(1);

		genericPage page = new LaunchPage()
				.openBrowser(browserName).gotoHomePage().validator(false).validateTitle(Constants.HOME_PAGE_TITLE)
				.gotoEnterUsernamePage().submitUsername(username);

		if (page instanceof EnterUsernamePage) {
			page.validator(true).fail("Couldnot login with given credentials", "entered username is :" + username);
		} else if (page instanceof EnterPasswordPage) {
			page.submitPassword(password);
			page.validator(false).pass("Successfully logged In. " + testCaseName + " PASSED");
		}
		session.sessionEnd();

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		return Xls_Reader.getDataFromExcel(testSheetName);
	}
	
	
}

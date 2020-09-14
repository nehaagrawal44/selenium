package amazon.base.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import amazon.session.amazonTestSession;
import amazon.web.WebConnector;

public class BasePage implements genericPage {
//	public ExtentReports rep;
//	public ExtentTest test;

	public BasePage() {

		PageFactory.initElements(getCurrentDriver(), this);
		getSession().setCurrentPage(this);
	}

	public genericPage openBrowser(String browser) {
		// TODO Auto-generated method stub
		return null;

	}

	public amazonTestSession getSession() {
		return (amazonTestSession) Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
	}

	public WebConnector getDriver() {
		return getSession().getCon();
	}

	public genericPage gotoHomePage() {
		// TODO Auto-generated method stub
		return null;

	}

	public EventFiringWebDriver getCurrentDriver() {
		return getDriver().getCurrentDriver();
	}

	public void logInfoInReports(String message) {
		getSession().log(message);
	}

	public void waitForPageToLoad() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) getCurrentDriver();
		int i = 1;

		// check for page load 100%
		while (i != 10) {
			String state = (String) js.executeScript("return document.readyState;");
			if (state.equals("complete"))
				break;
			else
				Thread.sleep(2000);

			i++;
		}
		/*
		 * //check for ajax i=1; while(i!=10) { Long
		 * d=(Long)js.executeScript("return jQuery.active;"); if(d.longValue()==0)
		 * break; else Thread.sleep(2000); }
		 */
	}

	public genericPage gotoEnterUsernamePage() {
		// TODO Auto-generated method stub
		return null;
	}

	public void quit() {
		// TODO Auto-generated method stub

	}

	public void getTotalWindows() {
		// TODO Auto-generated method stub

	}

	public genericPage submitUsername(String userId) {
		// TODO Auto-generated method stub
		return null;

	}

	public WebConnector validator(boolean stopExecution) {
		 getSession().getCon().setStopExecution(stopExecution);
		return getSession().getCon();

	}

	public void addToCart() {
		// TODO Auto-generated method stub

	}

	public void logout() {
		// TODO Auto-generated method stub

	}

	public genericPage submitPassword(String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> readingFromExcel(String sheetName, String columnName) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}

package amazon.web;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import amazon.base.pages.genericPage;
import amazon.session.amazonTestSession;

public abstract class ValidationDriver implements WebConnector {

	EventFiringWebDriver driver;
	SoftAssert softAssert = new SoftAssert();

	public SoftAssert getSoftAssert() {
		return softAssert;
	}

	public void setSoftAssert(SoftAssert softAssert) {
		this.softAssert = softAssert;
	}

	boolean stopExecution;

	public boolean isStopExecution() {
		return stopExecution;
	}

	public void setStopExecution(boolean stopExecution) {
		this.stopExecution = stopExecution;
	}

	public void validateLogin() {

	}

	public genericPage validateTitle(String expTitle) {

		if (!expTitle.contains(driver.getTitle())) {
			fail(expTitle, driver.getTitle());
		} else
			logInfoInReports("title is verified" + expTitle);

		return getSession().getCurrentPage();
	}

	public amazonTestSession getSession() {
		return (amazonTestSession) Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
	}

	public genericPage validateText(String locator, String txt) {

		return getSession().getCurrentPage();
	}

	public genericPage validateElementPresence(By elementLocator) {
		if (!isElementPresent(elementLocator)) {
			fail("expected element is :" + elementLocator, "Expected element not found");
			return null;
		} else {
			logInfoInReports("expected element is  found:" + elementLocator);}
		return getSession().getCurrentPage();
	}

	public boolean isElementPresent(By elementLocator) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
			wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
			return true;
		} catch (TimeoutException e) {
			return false;
		}

	}

	public genericPage validateResultsOnPage() {
		By elementLocator = By.xpath("//h1/div[1]/div[1]/div[1]/div/span[1][contains(text(),'results')]");

		if (!isElementPresent(elementLocator)) {
			fail("expected element is :" + elementLocator, "Expected element not found");
			return null;
		} else
			return getSession().getCurrentPage();

	}

	public void assertAll() {
		
		softAssert.assertAll();
	}

	public void logInfoInReports(String message) {
		getSession().log(message);
	}

	public void fail(String expected, String actual) {

		getSession().failTest("Test Failed:" + expected + " and " + actual);
		softAssert.fail("Test Failed:" + expected + " and " + actual);
		if (isStopExecution())
			assertAll();

	}

	public void pass(String message) {
		getSession().logPass(message);
		softAssert.assertTrue(true, message);
	}
	
	public void closeAllBroswers()
	{
		driver.quit();
	}

}

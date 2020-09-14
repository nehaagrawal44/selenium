package amazon.web;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import amazon.session.amazonTestSession;

public interface WebConnector extends amazonWebConnector{
	
	 void openBrowser(String browser);
	 void navigate(String url);
	 void switchTab(int tabIndex);
	 void closeAllBroswers();
	 EventFiringWebDriver getCurrentDriver();
	 void waitForElementLoad();
	 amazonTestSession getSession();
	 boolean isStopExecution();
	 boolean isElementPresent(By elementLocator);
	// void setStopExecution();
	 void assertAll();
	 SoftAssert getSoftAssert() ;
	 void setSoftAssert(SoftAssert softAssert);
	 void logInfoInReports(String message);
	 void fail(String expected , String actual);
	 void pass(String expected);
	void setStopExecution(boolean stopExecution);
}


package amazon.base.pages;

import java.io.IOException;
import java.util.List;

import amazon.session.amazonTestSession;
import amazon.web.WebConnector;

public interface genericPage {
	
	//normal browser operations
	genericPage openBrowser(String browser);
	amazonTestSession getSession();
	void quit();
	void getTotalWindows();
	
	//application based operations
	genericPage gotoHomePage();
	genericPage gotoEnterUsernamePage();
	genericPage submitUsername(String userId);
	genericPage submitPassword(String password);
	WebConnector validator(boolean flagAssertionType);
	List<String> readingFromExcel(String sheetName, String columnName) throws IOException ;
	//session based
	void addToCart();
	void logout();
	
	//reports logging
	void logInfoInReports(String message);
	

}

package amazon.web;

import org.openqa.selenium.By;

import amazon.base.pages.genericPage;

public interface amazonWebConnector{
	
	//void logout();
	genericPage validateTitle(String expTitle);
	genericPage validateText(String locator,String txt);
	genericPage validateElementPresence(By elementLocator);
	genericPage validateResultsOnPage();
	void validateLogin();
	
}

package amazon.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import amazon.base.pages.BasePage;
import amazon.base.pages.Constants;
import amazon.base.pages.genericPage;

public class EnterUsernamePage extends BasePage {
	
	@FindBy(id=Constants.enterUserName)
	WebElement username;
	
	@FindBy(id=Constants.enterPassword)
	WebElement pwd;
	
	@FindBy(id=Constants.continueBtn)
	WebElement continueBtn;
	
	public genericPage submitUsername(String userId)
	{
		username.sendKeys(userId);
		continueBtn.click();
		boolean resLocator=validator(false).isElementPresent(Constants.enterPassword_locator);
		if(!resLocator)
			return this;
		else
		{
			logInfoInReports("Username entered successfully: "+userId);
			return new EnterPasswordPage();
		}
	}
	

}

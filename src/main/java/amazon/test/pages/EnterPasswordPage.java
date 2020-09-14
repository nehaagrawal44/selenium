package amazon.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import amazon.base.pages.BasePage;
import amazon.base.pages.Constants;
import amazon.base.pages.genericPage;

public class EnterPasswordPage extends BasePage{
	
	@FindBy(id=Constants.enterPassword)
	WebElement pswdText;
	
	@FindBy(id=Constants.signInSubmit)
	WebElement signInSubmit;
	
	public genericPage submitPassword(String userId)
	{
		pswdText.sendKeys(userId);
		signInSubmit.click();
		boolean resLocator=validator(false).isElementPresent(Constants.logo_locator);
		if(resLocator)	
			return new EnterPasswordPage();
		else
		{
			logInfoInReports("User logged in successfully");
			return new SearchProductPage();
		}
	}
	

}

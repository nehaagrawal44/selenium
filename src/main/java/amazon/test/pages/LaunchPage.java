package amazon.test.pages;

import org.openqa.selenium.support.PageFactory;

import amazon.base.pages.BasePage;
import amazon.base.pages.Constants;
import amazon.base.pages.genericPage;
import amazon.session.amazonTestSession;

public class LaunchPage extends BasePage{

	
	public genericPage openBrowser(String browser) {
	
		getDriver().openBrowser(browser);
		return this;
	}
	
	public genericPage gotoHomePage()
	{

		getDriver().navigate(Constants.APP_URL);
		getDriver().getCurrentDriver().manage().window().maximize();
		return new HomePage();
	}

}

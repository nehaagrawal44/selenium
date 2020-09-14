package amazon.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import amazon.base.pages.BasePage;
import amazon.base.pages.Constants;
import amazon.base.pages.genericPage;

public class LogoutPage extends BasePage{
	
	@FindBy(xpath=Constants.SignOutLink)
	WebElement SignOutLink;
	
	@FindBy(id=Constants.MouseHoverSignInLInk)
	WebElement MouseHoverSignInLInk;
	
	public genericPage gotoSignOutLink()
	{
		
		try {
		logInfoInReports("Going to logout from account");
		Thread.sleep(2000);
		
		mouseHover(MouseHoverSignInLInk);
    	
		SignOutLink.click();
		
		return new LogoutPage();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new CartListPage();
		}
		
		
	}
	
	public void mouseHover(WebElement ele)
	{
		Actions actions = new Actions(getSession().getCon().getCurrentDriver());
  
    	actions.moveToElement(ele).perform();
    	System.out.println("Done Mouse hover on 'Music' from Menu");
		
	}

}

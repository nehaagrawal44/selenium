package amazon.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.base.pages.BasePage;
import amazon.base.pages.Constants;
import amazon.base.pages.genericPage;

public class HomePage extends BasePage{
	
	@FindBy(xpath=Constants.SignInLink)
	WebElement SignInLink;
	
	@FindBy(id=Constants.MouseHoverSignInLInk)
	WebElement MouseHoverSignInLInk;
	
	public genericPage gotoEnterUsernamePage()
	{
		
		try {
		logInfoInReports("Navigating to signIN page");
		Thread.sleep(2000);
		
		mouseHover(MouseHoverSignInLInk);
    	
		SignInLink.click();
		
		return new EnterUsernamePage();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public void mouseHover(WebElement ele)
	{
		Actions actions = new Actions(getSession().getCon().getCurrentDriver());
  
    	actions.moveToElement(ele).perform();
    	System.out.println("Done Mouse hover on 'Music' from Menu");
		
	}

}

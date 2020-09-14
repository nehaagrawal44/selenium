package amazon.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import amazon.base.pages.BasePage;
import amazon.base.pages.Constants;
import amazon.base.pages.genericPage;

public class CartListPage extends BasePage{
	
	 @FindBy(xpath = Constants.cartBtn)
     WebElement cartBtn;

     @FindBy(id = Constants.addToCartLink)
     WebElement addToCartLink;
    
      
public genericPage goToCartList() throws InterruptedException
{
	    cartBtn.click();
	
		logInfoInReports("User has navigated to Cart list page");
		
		
      boolean resLocator=validator(false).isElementPresent(Constants.shoppingCartElement_locator);
		if(resLocator)
		{
			logInfoInReports("Shopping cart is listed successfully");
			return new CartListPage();
		}
		else
			return null;
		
		}
		

}

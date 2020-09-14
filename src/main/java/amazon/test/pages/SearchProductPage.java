package amazon.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import amazon.base.pages.BasePage;
import amazon.base.pages.Constants;
import amazon.base.pages.genericPage;

public class SearchProductPage extends BasePage{

	      @FindBy(xpath = Constants.searchDropdownBox)
	      WebElement drpSearch;
	
	      @FindBy(id = Constants.searchBox)
	      WebElement searchBox;
	      @FindBy(xpath = Constants.gobtn)
	      WebElement goBtn;
	      @FindBy(xpath = Constants.resultWebElement)
	      WebElement resultWebElement;
	       
	public genericPage searchProductInSearchBox(String productName) throws InterruptedException
	{
		
			waitForPageToLoad();
			
            searchBox.sendKeys(productName);
            
            searchBox.sendKeys(Keys.ENTER);
          
            boolean resLocator=validator(false).isElementPresent(Constants.resultWebElement_locator);
    		if(resLocator)
    		{
    			logInfoInReports("Item searched successfully: "+productName);
    			return new ResultDisplayedPage();
    		
    		}
    		else
    		
    			
    			return new SearchProductPage();
    		
			
			}
			
			
	
	}



package amazon.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import amazon.base.pages.BasePage;
import amazon.base.pages.Constants;
import amazon.base.pages.genericPage;

public class AddToCartPage extends BasePage {

	@FindBy(xpath = Constants.productLink)
	WebElement productLink;

	@FindBy(id = Constants.addToCartLink)
	WebElement addToCartLink;

	public genericPage goToAddToCart() throws InterruptedException {
		productLink.click();
		validator(false).switchTab(1);
		logInfoInReports("User has navigated to Product detail page");
		waitForPageToLoad();
		addToCartLink.click();

		boolean resLocator = validator(false).isElementPresent(Constants.addedToCartElement_locator);
		if (resLocator) {
			logInfoInReports("Item added to cart successfully");
			return new CartListPage();
		} else
			return new AddToCartPage();

	}

}

package amazon.base.pages;

import org.openqa.selenium.By;

public class Constants {
	
  //application 
  public static final String MouseHoverSignInLInk="nav-link-accountList";
  public static final By MouseHoverSignInLInk_Locator=By.id(MouseHoverSignInLInk);
  
  public static final String SignInLink="//*[@id='nav-flyout-ya-signin']/a/span";
  public static final By SignInLink_Locator=By.xpath(SignInLink);
  
  public static final String SignOutLink="//*[@id='nav-item-signout']/span";
  
  public static final String enterUserName="ap_email";
  public static final By username_locator =By.id(enterUserName);
  
  public static final String enterPassword="ap_password";
  public static final By enterPassword_locator=By.id(enterPassword);
  
  public static final By logo_locator=By.xpath("//*[@id='nav-logo']/a");
  
  public static final String continueBtn="continue";
  public static final String signInSubmit="signInSubmit";
  
  public static final String searchDropdownBox="//*[@id='searchDropdownBox']";
  public static final String searchBox="twotabsearchtextbox";
  
  public static final String gobtn="//*[@id='nav-search']/form/div[2]/div/input";
  public static final String resultWebElement1="//*[@id='search']/span/div/span/h1/div/div[1]/div/div/span[1]";
  public static final String resultWebElement="//h1/div[1]/div[1]/div[1]/div/span[1][contains(text(),'results')]";
  public static final By resultWebElement_locator=By.xpath(resultWebElement);
  
  public static final String productLink="(//h2/a)[1]";
  public static final String addToCartLink="add-to-cart-button";
  
  public static final By addedToCartElement_locator=By.xpath("//h1[contains(text(),'Added to Cart')]");
  
  public final static String cartBtn="//*[@id='hlb-view-cart-announce']";
  public final static By cartBtn_locator=By.xpath(cartBtn);
  
  public static final By shoppingCartElement_locator=By.xpath("//*[@id='sc-active-cart']/div[1]/div/h2");
  
  
  //Chrome
  public static final String CHROMEFILE_PATH=System.getProperty("user.dir")+"\\chromedriver.exe";
  
  
  //titles
  public static final String APP_URL="https://www.amazon.in";
  public static final String HOME_PAGE_TITLE="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
  
  //reprots
  public static final String REPORTS_PATH=System.getProperty("user.dir")+"//reports//";
  
  //Data
  public static final String DATAFILE_PATH=System.getProperty("user.dir")+"\\TestData.xlsx";
  
  public static final String SIGNOUT_TITLE="Amazon Sign In";
  
}

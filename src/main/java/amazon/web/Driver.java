package amazon.web;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;

import amazon.base.pages.Constants;
import amazon.base.pages.genericPage;
import amazon.listener.eventListener;
import amazon.session.amazonTestSession;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver extends ValidationDriver{
	
	
	
	public void openBrowser(String browser)
	{
		logInfoInReports("Opening browser "+browser);
		
		//setup the chromedriver using WebDriverManager
		if(browser.equalsIgnoreCase("Chrome"))
		 {
          WebDriverManager.chromedriver().setup();
		  //System.setProperty("webdriver.chrome.driver", Constants.CHROMEFILE_PATH);
		  driver=new EventFiringWebDriver(new ChromeDriver());}
		  else if(browser.equalsIgnoreCase("IE"))
			{
			WebDriverManager.iedriver().setup();
		//	driver=new EventFiringWebDriver(new IEDriver());
			}else if(browser.equalsIgnoreCase("Mozilla"))
			       {
		
			WebDriverManager.firefoxdriver().setup();
		//	driver=new EventFiringWebDriver(new firefoxDriver());
			
		}
		driver.register(new eventListener());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
	}
	public void navigate(String url)
	{
		logInfoInReports("navigating to url: "+url);
		driver.get(url);
	}
	
/*	public void logout()
	{
		
	}*/
	
	
	public EventFiringWebDriver getCurrentDriver()
	{
		return driver;
	}
	public void waitForElementLoad() {
		// TODO Auto-generated method stub
		
	}
	/*public void setStopExecution() {
		// TODO Auto-generated method stub
		
	}
	*/
	 public  void switchTab(int tabIndex) 
     {
         try
         {
             Thread.sleep(1000);
             Set<String> handles = driver.getWindowHandles();
             Iterator < String > ite = handles.iterator();
             int i = 0;
             while (ite.hasNext() && i < 10) {
                 String popupHandle = ite.next().toString();
                 driver.switchTo().window(popupHandle);
                 if (i == tabIndex) break;
                 i++;
             }
         }
         catch (Exception e)
         {
             fail("Window should switch to new window","could not switch to new window: "+e);
             
         }
     }
	
}

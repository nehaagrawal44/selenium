package amazon.session;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import amazon.base.pages.Constants;
import amazon.base.pages.genericPage;
import amazon.reports.reports;
import amazon.test.pages.LaunchPage;
import amazon.web.Driver;
import amazon.web.WebConnector;

public class amazonTestSession extends reports{
	
	WebConnector con;
	//one session per test
	genericPage currentPage;
//	ExtentTest test;
  //  ExtentReports rep;
	
	public genericPage getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(genericPage currentPage) {
		this.currentPage = currentPage;
	}

	public amazonTestSession()
	{
		con=new Driver();
	}
	 
    //Session Functions
	
	public genericPage init(String testName)
	{
		if(Reporter.getCurrentTestResult().getTestContext().getAttribute("session")==null)
			Reporter.getCurrentTestResult().getTestContext().setAttribute("session", this);
		
		rep=reports.getInstance(Constants.REPORTS_PATH);
		test=rep.createTest(testName);

		return getCurrentPage();
	}
	
	public WebConnector getCon() {
		return con;
	}
	public void sessionEnd()
	{
		getCon().assertAll();
	}
	
	//reporting function
	
	public void log(String message)
	{
		test.log(Status.INFO, message);
	}
	
	public void logPass(String message)
	{
		test.log(Status.PASS, message);
	}
	
	public void generateReports()
	{
		if(rep!=null)
		rep.flush();
	}
	
	public void failTest(String message)
	{
		takeScreenshot();
		test.log(Status.FAIL, message);
		
	}
	
	public void takeScreenshot()
	{
		
		Date d= new Date();
		String screenshotFile=d.toString().replace(":", "_").replace("", "_")+".png";
	
		File srcFile = ((TakesScreenshot) getCon().getCurrentDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(reports.screenshotFolderPath+screenshotFile));
			test.log(Status.INFO, "Screenshot-> "+test.addScreenCaptureFromPath(reports.screenshotFolderPath+screenshotFile));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void skipTest(String message)
	{
		test.log(Status.SKIP, message);
	}
	

}

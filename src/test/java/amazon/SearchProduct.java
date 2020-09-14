package amazon;

import java.io.IOException;
import java.util.List;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import amazon.base.pages.Constants;
import amazon.base.pages.genericPage;
import amazon.session.amazonTestSession;
import amazon.test.pages.EnterPasswordPage;
import amazon.test.pages.EnterUsernamePage;
import amazon.test.pages.LaunchPage;
import amazon.test.pages.ResultDisplayedPage;
import amazon.test.pages.SearchProductPage;
import amazon.util.Xls_Reader;

public class SearchProduct {
	
	amazonTestSession session;
	Xls_Reader readExcel;
	String testCaseName="SearchItem";
	String testSheetName="BrowserInfo";
	
	@BeforeMethod
	public void init()
	{
		session=new amazonTestSession();
		session.init(testCaseName);
	}

	@AfterMethod
	public void quit()
	{
		
		session.generateReports();
	}
	
	@Test(dataProvider="getData",groups="regression")
	public void searchProduct(String bName,String runMode) throws InterruptedException
	{
		String browserName = bName;
		String executeTC;
		List<String> data = null;
		
		String[] strArray2 = {"ProductName"};
		if (runMode.equals("Y")) {
			try {
				readExcel=new Xls_Reader();
				data = readExcel.fetchTestData_IfExceuteTestCaseYes(testCaseName, strArray2);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			session.skipTest("Skipping the test case as runMode for " + browserName + " is NO");
			throw new SkipException("Skipping the test case as runMode for " + browserName + " is NO");
		}
		String productName = data.get(0);
		
	
		 genericPage page=new SearchProductPage() 
				 		 .searchProductInSearchBox(productName);
				 	
		 
		 if(page instanceof SearchProductPage)
		 {
			 page.validator(true).fail("Search failed for item :"+productName, "Not found");
		 }else if(page instanceof ResultDisplayedPage)
		 {
			 page.validator(false).validateElementPresence(Constants.resultWebElement_locator);
			 page.validator(false).pass("Successful. "+testCaseName+" PASSED");
		 }
		 				 
		 				  session.sessionEnd();	
		 
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		return Xls_Reader.getDataFromExcel(testSheetName);
	}
	


}

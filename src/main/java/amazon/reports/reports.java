package amazon.reports;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public  class reports {
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports rep;
	 public static ExtentTest test;
	 public static String screenshotFolderPath;
	 
	public static ExtentReports getInstance(String repPath)
	{
		if(rep==null)
     	{
			//report folder generation
			Date d=new Date();
			String reportFolder=d.toString().replaceAll(":", "-");
			 String path=repPath+reportFolder+"\\screenshots\\";
			 screenshotFolderPath=path; 	
			File file=new File(path);
			
			file.mkdirs();
			
		htmlReporter=new ExtentHtmlReporter(repPath+reportFolder+"//result.html");
		//repPath+reportFolder+"//result.html"
		rep=new ExtentReports();
		rep.attachReporter(htmlReporter);
		htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir") + "//extent-config.xml"));
		return rep;
     	}
		return rep;
	}
	

}

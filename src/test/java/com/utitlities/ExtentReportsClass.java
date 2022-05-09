/**
 * 
 */
package com.utitlities;

import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


/**
 * @author nagaraj.k
 *
 */
public class ExtentReportsClass {
	
	public static ExtentReports extentReport;
	
	public static ExtentReports reportGenerator()
	{
		String date=String.valueOf(new Date());
		String formattedDate=date.replace(" ", "_").replace(":", "-");
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"\\ExtentReports\\"+"Report_"+formattedDate+".html");
		sparkReporter.config().setDocumentTitle("Report Of Execution");
		sparkReporter.config().setReportName("Sample Report");
		/*
		 * try { sparkReporter.loadXMLConfig("./extent-config.xml"); } catch
		 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
			
		
		extentReport=new ExtentReports();
		extentReport.attachReporter(sparkReporter);
		extentReport.setSystemInfo("QA Engineer", "Nagaraj K");
		return extentReport;
	}

}

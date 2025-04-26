package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility 
{

	public static final ExtentReports extentReports = new ExtentReports();   
	public synchronized static ExtentReports createExtentReports() 
	{    

		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html"); 
		
		reporter.config().setReportName("Grocery application");  
		extentReports.attachReporter(reporter);   
		extentReports.setSystemInfo("Organization", "Obsqura");  //add system level information
		extentReports.setSystemInfo("Name", "Nifla beevi A J ");	//add system level information
		return extentReports;   	// return report
	}
}

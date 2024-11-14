package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ExtentReportExecutor implements ITestListener 

{
	
	
	
	public ExtentSparkReporter sparkReporter;  //UI of the Report and path configuration
	public ExtentReports extentReport; // Populate common Information
	public ExtentTest test; // updates the test reports status and other info.
	
	
	
	
	public void onStart(ITestContext context) {
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\myReport2.html"); //Path configuration
		sparkReporter.config().setDocumentTitle("Selenium Automation Extent Report");  // Report Title name
		sparkReporter.config().setReportName("UAT Testing");  // Report name
		sparkReporter.config().setTheme(Theme.DARK);  // Theme
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(sparkReporter);   // Linking Spark with Report
		extentReport.setSystemInfo("Environment", "Test");  // Giving info about the report in (Key, Value) pair
		extentReport.setSystemInfo("OS", "Windows");
		extentReport.setSystemInfo("User", "Keshav");
		extentReport.setSystemInfo("browser", "chrome");
		
	  }
	
	

	 public void onTestSuccess(ITestResult result) {
		 test = extentReport.createTest(result.getName());  //Create a new entry in the report
		 test.log(Status.PASS, "Test Pass :" + result.getName());  // Update status in the report
		 
		 String ScreenshotPath = System.getProperty("user.dir")+"\\screenshots\\"+result.getName()+".jpeg";
		 // to create file in this path
		 File screenShotFile = new File (ScreenshotPath);
		 if(screenShotFile.exists())
		 {
			 test.pass("Captured Success Screenshot "+ test.addScreenCaptureFromPath(ScreenshotPath));
		 }
		 
		  }
	 
	 
	 //D:\Selenium_Tuts\SeleniumWebDriver\automationEshop_V1\screenshots
	 public void onTestFailure(ITestResult result) {
		 test = extentReport.createTest(result.getName());
		 test.log(Status.FAIL, "Test got Failed : " + result.getName());
		 test.log(Status.FAIL, "Failed Reason : "+ result.getThrowable());  // Capturing the failed reason
		 String ScreenshotPath = System.getProperty("user.dir")+"\\screenshots\\"+result.getName()+".jpeg";
		 // to create file in this path
		 File screenShotFile = new File (ScreenshotPath);
		 if(screenShotFile.exists())
		 {
			 test.fail("Captured Failed Screenshot "+ test.addScreenCaptureFromPath(ScreenshotPath));
		 }
		}

	 public void onTestSkipped(ITestResult result) {
		 test = extentReport.createTest(result.getName());
		 test.log(Status.SKIP, "Test Skipped"+ result.getName());
		 }
	 
	/* 
	 public void onFinish(ITestContext context) {
		 extentReport.flush();
		  }
		  */
	 
	 public void onFinish(ITestContext context) {
		    extentReport.flush(); // Flush the report to ensure all information is written

		    // Automatically open the report in the system's default browser
		    File reportFile = new File(System.getProperty("user.dir") + "\\reports\\myReport2.html"); // Path to your report file
		    if (reportFile.exists()) {
		        try {
		            Desktop.getDesktop().browse(reportFile.toURI()); // Opens the file in the default system editor/browser
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		}

}

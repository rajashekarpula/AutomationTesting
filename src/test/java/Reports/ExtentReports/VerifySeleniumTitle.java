package Reports.ExtentReports;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

import junit.framework.Assert;

public class VerifySeleniumTitle{
	private static ExtentReports extent;
	
	@Test
	public void verifyTitle() {
		
		report();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://learn-automation.com");
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Selenium"));
		driver.quit();
		//test.addScreenCapture("F:/Automation/Selenium/sample.png");
		// end test

	}
	public static void report(){
		String report = "ExtentReports/src/test/report.html";
		extent = new ExtentReports(report, true);
		ExtentTest test = extent.startTest("My First Test", "Sample description");
		
		 // log(LogStatus, details)
       test.log(LogStatus.INFO, "This step shows usage of log(logStatus, details)");

       // report with snapshot
       //String img = test.addScreenCapture("img-path");
      // test.log(LogStatus.INFO, "Browser is up and Running", "Application is Up and Running" + img);
       test.log(LogStatus.INFO, "title captured");
       test.log(LogStatus.PASS, "title is verified");
       extent.endTest(test);
       
       // calling flush writes everything to the log file
       extent.flush();
		
	}
}

package Testcases;


import java.util.Arrays;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class testcase1 {

	public ExtentHtmlReporter htmlReporter;
	public ExtentTest test;
	public ExtentReports extent;
	
	@BeforeTest
	public void setReports() {
		htmlReporter=new ExtentHtmlReporter("C:\\Users\\puppy\\eclipse-workspace\\ExtentReports4\\ReportsDestination\\reportextent.html");
		
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation of HTML Reports");
		htmlReporter.config().setReportName("HTML Test Results");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("way2automation","RRR");
		extent.setSystemInfo("Organization","cts");
		extent.setSystemInfo("HTMLresults","results");
		
		
		
	}
	@AfterTest
	public void unSetReports() {
		extent.flush();
		
	}
	@Test
	public void doLogin() {
		test=extent.createTest("Login Test");
		System.out.println("Login test is sucessfull");
		
	}
	
	@Test
	public void doUserRegister() {
		test=extent.createTest("User Register Test");
		Assert.fail("User Register failed");
		
	}
	
	@Test
	public void isSkip() {
		test=extent.createTest("Skip Test");
		throw new SkipException("Skipping the last test");
		
	}
	
	@AfterMethod
	public void teardown(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			

			String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
			test.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
					+ "</font>" + "</b >" + "</summary>" + excepionMessage.replaceAll(",", "<br>") + "</details>"
					+ " \n");
			
		
			/*try {

				ExtentManager.captureScreenshot();
				TestReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
						MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName)
								.build());
			} catch (IOException e) {
				
			}*/
			String methodname=result.getMethod().getMethodName();
			String text="<b>"+"TEST CASE :- "+methodname.toUpperCase()+" IS Failed"+"</b>";
			Markup m=MarkupHelper.createLabel(text, ExtentColor.RED);
			
			test.fail(m);
			
			
		}else if(result.getStatus() == ITestResult.SKIP) {
			String methodname=result.getMethod().getMethodName();
			
			String text="<b>"+"TEST CASE :- "+methodname.toUpperCase()+" IS SKIPPED"+"</b>";
			Markup m=MarkupHelper.createLabel(text,ExtentColor.ORANGE );
			test.skip(m);
			
			
			
		}else if(result.getStatus() == ITestResult.SUCCESS) {
			String methodname=result.getMethod().getMethodName();
			
			String text="<b>"+"TEST CASE :- "+methodname.toUpperCase()+" IS PASSED"+"</b>";
			Markup m=MarkupHelper.createLabel(text,ExtentColor.GREEN );
			test.pass(m);
			
		}
		
	}
}


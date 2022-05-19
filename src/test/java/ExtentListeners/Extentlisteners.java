package ExtentListeners;

import java.util.Arrays;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class Extentlisteners implements ITestListener {
	
	static Date d=new Date();
	static String filename="Extent_"+d.toString().replace(":", "_").replace(" ", "_")+".html";
	
	
	
	private static ExtentReports extent=ExtentManager.createInstance("C:\\Users\\puppy\\eclipse-workspace\\ExtentReports4\\ReportsDestination\\"+filename);
	
	public static ThreadLocal<ExtentTest> testreport=new ThreadLocal<ExtentTest>();
	
	

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentTest test=extent.createTest(result.getClass().getName()+" @TEST CASE : "+ result.getMethod().getMethodName());
		testreport.set(test);
		
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String Methodname=result.getMethod().getMethodName();
		String text="<b>"+"Test is success for "+Methodname.toUpperCase()+"</b>";
		Markup m=MarkupHelper.createLabel(text, ExtentColor.GREEN);
		testreport.get().pass(m);
		
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		String exceptionmsg;
		
			exceptionmsg = Arrays.toString(result.getThrowable().getStackTrace());
		
		testreport.get().fail("<details>"+"<summary>"+"<b>"+"<font color"+"red>"+"Exception occured:click to see"
					+"</font>"+"</b>"+"</summary>"+exceptionmsg.replace(",", "<br>")+"</details>"+"\n");
		
		
		String Methodname=result.getMethod().getMethodName();
		String text="<b>"+"Test is failed "+Methodname.toUpperCase()+"</b>";
		Markup m=MarkupHelper.createLabel(text, ExtentColor.RED);
		testreport.get().log(Status.FAIL, m);
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

		String Methodname=result.getMethod().getMethodName();
		String text="<b>"+"Test is skipped "+Methodname.toUpperCase()+"</b>";
		Markup m=MarkupHelper.createLabel(text, ExtentColor.ORANGE);
		testreport.get().skip(m);
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		if(extent!=null) {
			extent.flush();
		}
		
	}
	
	

}

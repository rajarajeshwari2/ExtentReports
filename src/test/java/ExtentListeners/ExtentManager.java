package ExtentListeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	private static ExtentReports extent;
	
	public static ExtentReports createInstance(String filename) {
		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter(filename);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automate the Reports using Listerners");
		htmlReporter.config().setReportName("Listerners Reports");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("automation","RRR");
		extent.setSystemInfo("Organization", "CTS");
		extent.setSystemInfo("Project", "Automation");
		
		return extent;
		
	}
	

}

package syklone.tundra;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportersNG {
	static ExtentReports extent;

	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("Web automation results");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "chaitu");
		return extent;
	}
}

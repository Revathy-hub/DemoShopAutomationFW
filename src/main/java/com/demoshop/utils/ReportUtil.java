package com.demoshop.utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.demoshop.context.Constants;

public class ReportUtil {
	public static ExtentReports generateReport() {
		String reportPath= Constants.EXTENTREPORT;
		ExtentSparkReporter reporter= new ExtentSparkReporter(reportPath);
		reporter.config().setReportName("Obsqura Automation");
		reporter.config().setDocumentTitle("Obsqura Zone");
		
		ExtentReports  extent =new  ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA", "Adithya");
		extent.setSystemInfo("Environment", "STAGING");
		return extent;
	}
}

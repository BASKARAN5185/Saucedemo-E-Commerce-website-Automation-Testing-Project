package utility;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import MyProject.saucedemo.BaseClass;

public class ExtentReportManager implements ITestListener {
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;
    String repName;

    @Override
    public void onStart(ITestContext testContext) {
        // Generate the timestamp for the report name
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        repName = "Saucedemo Test-Report-" + timeStamp + ".html";

        // Specify the absolute path for storing the report on the Desktop
        String reportPath = "C:\\Users\\xmedia\\Desktop\\Automation Test Report\\" + repName;
        sparkReporter = new ExtentSparkReporter(reportPath);

        // Set up report title and configuration
        sparkReporter.config().setDocumentTitle("Saucedemo Automation Report");
        sparkReporter.config().setReportName("Saucedemo Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Set system information for the report
        extent.setSystemInfo("Application", "Saucedemo");
        extent.setSystemInfo("All Module", "Admin");
        extent.setSystemInfo("Sub Module", "Customers");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");

        // Retrieve OS and Browser from the TestNG XML
      //  String os = testContext.getCurrentXmlTest().getParameter("os");
        extent.setSystemInfo("Operating System", "Window");

       // String browser = testContext.getCurrentXmlTest().getParameter("browser");
        extent.setSystemInfo("Browser", "Chrome");

        // Add any included groups to the report
        List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
        if (!includedGroups.isEmpty()) {
            extent.setSystemInfo("Groups", includedGroups.toString());
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups()); // Display groups in the report
        test.log(Status.PASS, result.getName() + " got successfully executed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups()); // Display groups in the report

        test.log(Status.FAIL, result.getName() + " failed");
        test.log(Status.INFO, result.getThrowable().getMessage());

        try {
            // Capture screenshot on failure and get the file path
            String imgPath = new MyProject.saucedemo.BaseClass().captureScreen(result.getName());
            
            // Attach the screenshot to the report
            test.addScreenCaptureFromPath(imgPath);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, result.getName() + " got skipped");
        test.log(Status.INFO, result.getThrowable().getMessage());
    }

    @Override
    public void onFinish(ITestContext testContext) {
        extent.flush(); // Write the report to file

        // Path to open the report after execution
        String pathOfExtentReport = "C:\\Users\\xmedia\\Desktop\\Automation Test Report\\"+repName;
        File extentReport = new File(pathOfExtentReport);

        try {
            // Open the report automatically in the default browser
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(extentReport.toURI());
            } else {
                System.out.println("Desktop is not supported, please manually open the report.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {}

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
}

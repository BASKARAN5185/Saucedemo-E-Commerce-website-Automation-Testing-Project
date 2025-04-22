package utility;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import MyProject.saucedemo.BaseClass;

public class EnhanceExtentReportManager implements ITestListener {
    private ExtentSparkReporter sparkReporter;
    private ExtentReports extent;
    private ExtentTest test;
    private String reportName;

    // Default directory where the report is stored
    private static final String REPORT_DIRECTORY = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "Automation Test Report" + File.separator;

    @Override
    public void onStart(ITestContext testContext) {
        // Generate timestamp for the report name
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        reportName = "Saucedemo Test-Report-" + timeStamp + ".html";

        // Setup the report path
        String reportPath = REPORT_DIRECTORY + reportName;
        initializeReport(reportPath);
    }

    private void initializeReport(String reportPath) {
        // Initialize ExtentSparkReporter and configure the report
        sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setDocumentTitle("Saucedemo Automation Report");
        sparkReporter.config().setReportName("Saucedemo Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Set system information
        setSystemInfo();
    }

    private void setSystemInfo() {
        extent.setSystemInfo("Application", "Saucedemo");
        extent.setSystemInfo("All Module", "Admin");
        extent.setSystemInfo("Sub Module", "Customers");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Operating System", "Windows");
        extent.setSystemInfo("Browser", "Chrome");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.PASS, result.getName() + " executed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.FAIL, result.getName() + " failed");
        test.log(Status.INFO, result.getThrowable().getMessage());

        try {
            String imgPath = captureScreenshot(result.getName());
            test.addScreenCaptureFromPath(imgPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String captureScreenshot(String testName) throws IOException {
        BaseClass base = new BaseClass();
        // Ensure captureScreen returns valid file path
        return base.captureScreen(testName);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, result.getName() + " was skipped");
        test.log(Status.INFO, result.getThrowable().getMessage());
    }

    @Override
    public void onFinish(ITestContext testContext) {
        extent.flush(); // Write the report to file

        String reportPath = REPORT_DIRECTORY + reportName;
        openReportInBrowser(reportPath);
    }

    private void openReportInBrowser(String reportPath) {
        File report = new File(reportPath);

        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(report.toURI());
            } else {
                System.out.println("Desktop is not supported. Please open the report manually.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Empty implementations for unused methods in ITestListener
    @Override
    public void onTestStart(ITestResult result) {}
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
}

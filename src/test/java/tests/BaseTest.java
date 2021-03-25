package tests;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import driverConfig.DriverFactory;
import driverConfig.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import reportConfig.ExtentReportConfig;

import java.io.IOException;
import java.lang.reflect.Method;

public class BaseTest {


    @BeforeSuite
    public void beforeSuite() {
        ExtentReportConfig.setUpExtentReport();
    }

    @AfterSuite
    public void afterSuite() throws IOException {
        ExtentReportConfig.closeReport();
    }

    @BeforeMethod
    public void openBrowser(Method method) throws Exception {
        ExtentReportConfig.createTest(method.getName());
        DriverFactory.initDriver();
    }

    @AfterMethod
    public void quitBrowser(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            Media screenShot = MediaEntityBuilder
                    .createScreenCaptureFromBase64String(((TakesScreenshot) DriverManager.getDriver())
                            .getScreenshotAs(OutputType.BASE64)).build();
            ExtentReportConfig.getTest().fail(screenShot);
        }
        DriverFactory.quitDriver();
    }

    void verifyPageTitle(String expected, String actual) {
        if (actual.contains(expected)) {
            ExtentReportConfig.getTest().pass("page title verified!");
        } else {
            ExtentReportConfig.getTest().fail("Page title is not as expected!");
        }
    }
}
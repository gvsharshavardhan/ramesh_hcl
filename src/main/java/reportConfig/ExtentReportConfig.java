package reportConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReportConfig {
    private static ExtentReports extent;

    public static void setUpExtentReport() {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/target/Spark-index.html");
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("MyReport");
        }
    }

    public static void createTest(String testName) {
        ExtentTest test = extent.createTest(testName);
        ExtentReportManager.setTest(test);
    }

    public static ExtentTest getTest() {
        return ExtentReportManager.getTest();
    }

    public static void closeReport() throws IOException {
        if (Objects.nonNull(extent)) {
            extent.flush();
        }
        //this line, opens report in the browser.
        Desktop.getDesktop().browse(new File(System.getProperty("user.dir") + "/target/Spark-index.html").toURI());
    }
}
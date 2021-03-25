package tests;

import driverConfig.DriverManager;
import org.testng.annotations.Test;
import pages.OmayoPage;
import reportConfig.ExtentReportConfig;
import utilities.PropertyUtil;

public class OmayoPageTest extends BaseTest {

    @Test
    public void testFileUpload() throws Exception {
        DriverManager.getDriver().get(PropertyUtil.getPropertyValue("omayopageurl"));
        ExtentReportConfig.getTest().info("landed on omayo  page!");
        OmayoPage omayo = new OmayoPage();
        String expected = "myfile";
        omayo.uploadFile(omayo.omayoPagescreenshotpath(expected));
        String actual = omayo.getFileUploadText();
        if (actual.contains(expected)) {
            ExtentReportConfig.getTest().info("Expected : " + expected);
            ExtentReportConfig.getTest().info("Actual : " + actual);
            ExtentReportConfig.getTest().pass("file uploaded!");
        } else {
            ExtentReportConfig.getTest().info("Expected : " + expected);
            ExtentReportConfig.getTest().info("Actual : " + actual);
            ExtentReportConfig.getTest().fail("file upload failed!");
        }
    }
}
package pages;

import com.google.common.io.Files;
import driverConfig.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reportConfig.ExtentReportConfig;

import java.io.File;
import java.io.IOException;

public class OmayoPage extends BasePage {
    private static final By UPLOAD_BUTTON_LOCATOR = By.cssSelector("#uploadfile");

    public void uploadFile(String filePath) {
        new WebDriverWait(DriverManager.getDriver(), 5)
                .until(ExpectedConditions.presenceOfElementLocated(UPLOAD_BUTTON_LOCATOR)).sendKeys(filePath);
        ExtentReportConfig.getTest().info("ulpaded file! : " + filePath);
    }

    public String getFileUploadText() {
        String path = new WebDriverWait(DriverManager.getDriver(), 5)
                .until(ExpectedConditions.presenceOfElementLocated(UPLOAD_BUTTON_LOCATOR))
                .getAttribute("value").trim();
        ExtentReportConfig.getTest().info("file path text from page : " + path);
        return path;
    }

    public String omayoPagescreenshotpath(String name) {
        File s = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        String p = System.getProperty("user.dir") + "/screenShots/"+name+".png";
        try {
            Files.move(s, new File(p));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }
}
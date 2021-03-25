package pages;

import driverConfig.DriverFactory;
import driverConfig.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reportConfig.ExtentReportConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BasePage {

    private final By HeaderTileLocator = By.cssSelector("h1.title");

    protected void goToPage(String url) {
        DriverManager.getDriver().get(url);
        ExtentReportConfig.getTest().info("logged into orange page!");
    }

    protected void click(By by, String element) {
        new WebDriverWait(DriverManager.getDriver(), 5)
                .until(ExpectedConditions.elementToBeClickable(by))
                .click();
        ExtentReportConfig.getTest().info("clicked " + element);
    }

    protected void sendKeys(By by, String value) {
        new WebDriverWait(DriverManager.getDriver(), 5)
                .until(ExpectedConditions.presenceOfElementLocated(by))
                .sendKeys(value);
        ExtentReportConfig.getTest().info("entered " + value);
    }

    protected String getTitle() {
        return DriverManager.getDriver().getTitle();
    }

    protected String getHeaderTitle(By by) {
        return new WebDriverWait(DriverManager.getDriver(), 5)
                .until(ExpectedConditions.presenceOfElementLocated(by))
                .getText().trim();
    }

    protected List<String> getAllWindowsHeaderTitles() {
        Set<String> windowHandles = DriverManager.getDriver().getWindowHandles();
        List<String> headerTitles = new ArrayList<>();
        for (String handle : windowHandles) {
            DriverManager.getDriver().switchTo().window(handle);
            headerTitles.add(getHeaderTitle(HeaderTileLocator));
        }
        return headerTitles;
    }
}
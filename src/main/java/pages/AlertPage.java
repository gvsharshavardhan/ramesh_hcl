package pages;

import driverConfig.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertPage extends BasePage {

    private static final By PROMPT_ALERT_LOCATOR = By.cssSelector("#prompt");
    private static final By MY_NAME_PROMPT_TEST_LOCATOR = By.cssSelector("#myName");

    public AlertPage clickTogetAlert() {
        click(PROMPT_ALERT_LOCATOR, "Prompt alert button!");
        return this;
    }

    public String getPromptNotificationText() {
        return DriverManager.getDriver().findElement(MY_NAME_PROMPT_TEST_LOCATOR).getText().trim();
    }

    public AlertPage enterTextIntoAlert(String value) {
        new WebDriverWait(DriverManager.getDriver(), 5)
                .until(ExpectedConditions.alertIsPresent()).sendKeys(value);
        return this;
    }

    public AlertPage acceptAlert() {
        new WebDriverWait(DriverManager.getDriver(), 5)
                .until(ExpectedConditions.alertIsPresent()).accept();
        return this;
    }
}

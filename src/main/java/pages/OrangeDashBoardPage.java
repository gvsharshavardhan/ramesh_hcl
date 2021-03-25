package pages;

import driverConfig.DriverFactory;
import driverConfig.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class OrangeDashBoardPage extends BasePage {
    private final String QUICK_LAUNCH_OPTIONS_CSS_SELECTOR = "table.quickLaungeContainer  span.quickLinkText";
    private final String DASHBOARD_PAGE_HEADER_XPATH = "//h1";
    private final By WELCOME_LINK = By.cssSelector("a#welcome");
    private final By LOGOUT_LINK = By.xpath("//a[.='Logout']");
    private final By SUBSCRIBE_LINK = By.cssSelector("#Subscriber_link");

    public List<String> getAllQuickLaunchOptions() {
        List<WebElement> optionElements = DriverManager.getDriver().findElements(By.cssSelector(QUICK_LAUNCH_OPTIONS_CSS_SELECTOR));
        List<String> options = new ArrayList<>();
        for (WebElement e : optionElements) {
            options.add(e.getText().trim());
        }
        return options;
    }

    public String getHeaderName() {
        return DriverManager.getDriver().findElement(By.xpath(DASHBOARD_PAGE_HEADER_XPATH)).getText().trim();
    }

    public OrangeDashBoardPage clickWelcomeLink() {
        click(WELCOME_LINK, "welcome link");
        return this;
    }

    public OrangeLoginPage clickLogoutLink() {
        click(LOGOUT_LINK, "log out link");
        return new OrangeLoginPage();
    }

    public boolean isSubscribeButtonEnabled() {
        return new WebDriverWait(DriverManager.getDriver(), 5)
                .until(ExpectedConditions.visibilityOfElementLocated(SUBSCRIBE_LINK)).isEnabled();
    }
}
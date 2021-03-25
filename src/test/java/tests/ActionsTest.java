package tests;

import driverConfig.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import reportConfig.ExtentReportConfig;

import static java.lang.Thread.sleep;

public class ActionsTest extends BaseTest {

    @Test
    public void mouseHoverTest() {
        DriverManager.getDriver().get("https://www.amazon.in/");
        WebElement signinele = DriverManager.getDriver().findElement(By.cssSelector("div.nav-signin-tt.nav-flyout"));
        WebDriverWait w = new WebDriverWait(DriverManager.getDriver(), 10);
        w.until(ExpectedConditions.invisibilityOf(signinele));

        WebElement acclist = DriverManager.getDriver()
                .findElement(By.cssSelector("[data-nav-ref='nav_ya_signin']"));
        Actions act = new Actions(DriverManager.getDriver());
        act.moveToElement(acclist).perform();
        DriverManager.getDriver().findElement(By.xpath("//span[text()='Your Wish List']/parent::a")).click();
        ExtentReportConfig.getTest().pass(DriverManager.getDriver().getTitle());
    }

    @Test
    public void testCaps() throws InterruptedException {
        DriverManager.getDriver().get("https://www.google.com/");
        WebElement searchbox = DriverManager.getDriver().findElement(By.cssSelector("[name='q']"));
        Actions act = new Actions(DriverManager.getDriver());
        act.keyDown(searchbox, Keys.SHIFT);
        act.sendKeys(searchbox, "apple mac book pro");
        act.keyUp(searchbox, Keys.SHIFT);
        Action a = act.build();
        sleep(5);
        a.perform();
        act.keyDown(searchbox, Keys.SHIFT).sendKeys("hello world").keyUp(searchbox, Keys.SHIFT).perform();
        sleep(2);
    }


}

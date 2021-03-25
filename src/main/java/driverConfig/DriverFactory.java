package driverConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.PropertyUtil;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class DriverFactory {


    private DriverFactory() {
    }

    public static void initDriver() throws Exception {
        if (Objects.isNull(DriverManager.getDriver())) {
            if (PropertyUtil.getPropertyValue("browser").equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                DriverManager.setDriver(new FirefoxDriver());
                DriverManager.getDriver().manage().window().maximize();
                DriverManager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            } else {
                WebDriverManager.chromedriver().setup();
                DriverManager.setDriver(new ChromeDriver());
                DriverManager.getDriver().manage().window().maximize();
                DriverManager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            }
        }
    }


    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
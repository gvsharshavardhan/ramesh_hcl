package driverConfig;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
    private static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

    private DriverManager() {

    }

    public static WebDriver getDriver() {
        return tdriver.get();
    }

    public static void setDriver(WebDriver driver) {
        tdriver.set(driver);
    }

    public static void unload() {
        tdriver.remove();
    }
}
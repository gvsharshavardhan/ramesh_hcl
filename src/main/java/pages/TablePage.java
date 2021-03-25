package pages;

import driverConfig.DriverFactory;
import driverConfig.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TablePage extends BasePage {
    private final By PRICES_LOCATOR = By.xpath("//*[@id='shopping']//td[1][not(contains(.,'Total'))]/following-sibling::td");
    private final By TOTAL_PRICE_LOCATOR = By.xpath("//*[@id='shopping']//td[1][contains(.,'Total')]/following-sibling::td");


    public List<String> getPricesList() {
        List<WebElement> priceElements = DriverManager.getDriver().findElements(PRICES_LOCATOR);
        List<String> pricesList = new ArrayList<>();
        for (WebElement element : priceElements) {
            pricesList.add(element.getText().trim());
        }
        return pricesList;
    }

    public String getTotalPriceFromTable() {
        return DriverManager.getDriver().findElement(TOTAL_PRICE_LOCATOR).getText().trim();
    }
}
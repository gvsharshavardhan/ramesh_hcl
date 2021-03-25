package pages;

import driverConfig.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class SelectPage {

    private static final By FRUIT_DROPDOWN = By.id("fruits");
    private static final By SUPER_HEROS_DROPDOWN = By.id("superheros");
    Select s1;
    Select s2;

    public void selectFruitfromDropDown(String fruit) {
        s1 = new Select(DriverManager.getDriver().findElement(FRUIT_DROPDOWN));
        s1.selectByVisibleText(fruit);
    }

    public String getSelctedOptionFromFruitDropDown() {
        return s1.getFirstSelectedOption().getText().trim();
    }

    public void selectMultipleHeros(List<String> heros) {
        s2 = new Select(DriverManager.getDriver().findElement(SUPER_HEROS_DROPDOWN));
        for (String hero : heros) {
            s2.selectByVisibleText(hero);
        }
    }

    public List<String> getAllHeros() {
        return s2.getAllSelectedOptions().stream().map(e -> e.getText().trim()).collect(Collectors.toList());
    }
}

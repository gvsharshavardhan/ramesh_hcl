package pages;

import org.openqa.selenium.By;

import java.util.List;

public class WindowPage extends BasePage {

    private static By MultipleWindowButton = By.id("multi");

    public String getPageTitle() {
        return getTitle();
    }

    public void clickMultipleWindows() {
        click(MultipleWindowButton, "multiple windows button");
    }

    public List<String> getAllWindowPageHeaders() {
        return getAllWindowsHeaderTitles();
    }
}
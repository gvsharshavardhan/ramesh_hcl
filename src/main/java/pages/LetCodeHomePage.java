package pages;

import org.openqa.selenium.By;

public class LetCodeHomePage extends BasePage {

    private final static By WindowsButtonLocator = By.id("win");
    private final static By SliderButtonLocator = By.id("slider");
    private final static By SELECTButtonLocator = By.id("select");
    private final static By AlertButtonLocator = By.id("alert");
    private final static By TableButtonLocator = By.id("simpletable");

    public TablePage goToTablePage() {
        click(TableButtonLocator, "table button");
        return new TablePage();
    }

    public SliderPage goToSliderPage() {
        click(SliderButtonLocator, "slider button");
        return new SliderPage();
    }

    public WindowPage goToWindowsPage() {
        click(WindowsButtonLocator, "windows button");
        return new WindowPage();
    }

    public SelectPage goToSelectPage() {
        click(SELECTButtonLocator, "select button");
        return new SelectPage();
    }

    public AlertPage goToAlertPage() {
        click(AlertButtonLocator, "alerts button");
        return new AlertPage();
    }


}

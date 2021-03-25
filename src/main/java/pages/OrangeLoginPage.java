package pages;

import driverConfig.DriverManager;
import org.openqa.selenium.By;
import utilities.PropertyUtil;

import java.util.Base64;

public class OrangeLoginPage extends BasePage {
    private final String CREDENTIALS_TEXT_XPATH = "//span[text()='( Username : Admin | Password : admin123 )']";
    private final String INPUT_FIELD_CSS_SELECTOR = "input[name='txtUsername']";
    private final String PASSWORD_FIELD_CSS_SELECTOR = "input[name='txtPassword']";
    private final String LOGIN_BUTTON_CSS_SELECTOR = "input[type='submit']";
    private final String FORGOT_PASSOWORD_LINK_TEXT = "Forgot your password?";

    public void goToOrangeLoginPage() throws Exception {
        goToPage(PropertyUtil.getPropertyValue("orangeloginpage"));
    }

    private String getCredentialsFromCredentialText() {
        return DriverManager.getDriver().findElement(By.xpath(CREDENTIALS_TEXT_XPATH)).getText().trim();
    }

    public String getUserName() throws Exception {
        return PropertyUtil.getPropertyValue("orangeusername");
    }

    public String getDecodedPassword() throws Exception {
        String encodedPassword = PropertyUtil.getPropertyValue("orangepassword");
        return new String(Base64.getDecoder().decode(encodedPassword));
    }

    public OrangeLoginPage enterUserName(String userName) {
        sendKeys(By.cssSelector(INPUT_FIELD_CSS_SELECTOR), userName);
        return this;
    }

    public OrangeLoginPage enterPassword(String password) {
        sendKeys(By.cssSelector(PASSWORD_FIELD_CSS_SELECTOR), password);
        return this;
    }

    public OrangeDashBoardPage clickLogin() {
        click(By.cssSelector(LOGIN_BUTTON_CSS_SELECTOR), "login button");
        return new OrangeDashBoardPage();
    }

    public void clickForgetPassword() {
        click(By.linkText(FORGOT_PASSOWORD_LINK_TEXT), "forget passowrd");
    }

    public String getPageTitle() {
        return getTitle();
    }
}
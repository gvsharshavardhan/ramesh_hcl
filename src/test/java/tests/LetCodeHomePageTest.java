package tests;

import driverConfig.DriverManager;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import reportConfig.ExtentReportConfig;
import utilities.PropertyUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LetCodeHomePageTest extends BaseTest {

    List<String> expectedHeaders = List.of("Windows Handling", "Alert", "Select");


    @Test
    public void testWindowHandling() throws Exception {
        DriverManager.getDriver().get(PropertyUtil.getPropertyValue("url"));
        ExtentReportConfig.getTest().info("landed on let code page!");
        LetCodeHomePage letCodeHomePage = new LetCodeHomePage();
        WindowPage windowPage = letCodeHomePage.goToWindowsPage();
        verifyPageTitle("Window handling", windowPage.getPageTitle());
        windowPage.clickMultipleWindows();
        List<String> actualHeaders = windowPage.getAllWindowPageHeaders();
        for (String header : expectedHeaders) {
            if (!actualHeaders.contains(header)) {
                ExtentReportConfig.getTest().fail("Headers are not as expected!!");
                Assert.fail("Headers are not as expected!!");
            }
        }
        ExtentReportConfig.getTest().pass("Window titles are as expected!");
    }

    @Test
    public void testPricesFromTable() throws Exception {
        DriverManager.getDriver().get(PropertyUtil.getPropertyValue("url"));
        ExtentReportConfig.getTest().info("landed on let code page!");
        LetCodeHomePage letCodeHomePage = new LetCodeHomePage();
        TablePage tablePage = letCodeHomePage.goToTablePage();
        int totalFromTable = Integer.parseInt(tablePage.getTotalPriceFromTable());
        int totalCalcFromTable = 0;
        for (String price : tablePage.getPricesList()) {
            totalCalcFromTable += Integer.parseInt(price);
        }
        if (totalCalcFromTable == totalFromTable) {
            ExtentReportConfig.getTest().pass("Price data matched form table!!");
        } else {
            ExtentReportConfig.getTest().fail("Price data did not match with table price count");
        }
    }

    @Test(dataProvider = "dataPump")
    public void testAlerts(String text) throws Exception {
        DriverManager.getDriver().get(PropertyUtil.getPropertyValue("url"));
        ExtentReportConfig.getTest().info("landed on let code page!");
        LetCodeHomePage letCodeHomePage = new LetCodeHomePage();
        AlertPage alertPage = letCodeHomePage.goToAlertPage();
        String actualText = alertPage.clickTogetAlert()
                .enterTextIntoAlert(text).acceptAlert().getPromptNotificationText().split(":")[1].trim();
        if (actualText.equals(text)) {
            ExtentReportConfig.getTest().info("Expected : " + text);
            ExtentReportConfig.getTest().info("Actual : " + actualText);
            ExtentReportConfig.getTest().pass("Alert text matched!");
        } else {
            ExtentReportConfig.getTest().info("Expected : " + text);
            ExtentReportConfig.getTest().info("Actual : " + actualText);
            ExtentReportConfig.getTest().fail("Alert text did not matched!");
        }
    }

    @DataProvider(name = "dataPump")
    public String[] dataPump() {
        return new String[]{"test me", "selenium in fun", "hello world!"};
    }

    @Test
    public void selectTest1() throws Exception {
        DriverManager.getDriver().get(PropertyUtil.getPropertyValue("url"));
        ExtentReportConfig.getTest().info("landed on let code page!");
        LetCodeHomePage letCodeHomePage = new LetCodeHomePage();
        SelectPage selectPage = letCodeHomePage.goToSelectPage();
        String expected = "Apple";
        selectPage.selectFruitfromDropDown(expected);
        String actual = selectPage.getSelctedOptionFromFruitDropDown();
        if (actual.equals(expected)) {
            ExtentReportConfig.getTest().info("Expected : " + expected);
            ExtentReportConfig.getTest().info("Actual : " + actual);
            ExtentReportConfig.getTest().pass("drop down option matched!");
        } else {
            ExtentReportConfig.getTest().info("Expected : " + expected);
            ExtentReportConfig.getTest().info("Actual : " + actual);
            ExtentReportConfig.getTest().fail("drop down option did not matched!");
        }
    }

    @Test
    public void MultiselectTest() throws Exception {
        DriverManager.getDriver().get(PropertyUtil.getPropertyValue("url"));
        ExtentReportConfig.getTest().info("landed on let code page!");
        LetCodeHomePage letCodeHomePage = new LetCodeHomePage();
        SelectPage selectPage = letCodeHomePage.goToSelectPage();
        List<String> expectedheros = List.of("Batman", "Aquaman");
        selectPage.selectMultipleHeros(expectedheros);
        List<String> actualHeros = selectPage.getAllHeros();
        Set<String> e = new HashSet<>(expectedheros);
        Set<String> a = new HashSet<>(actualHeros);
        if (a.equals(e)) {
            ExtentReportConfig.getTest().info("Expected : " + expectedheros);
            ExtentReportConfig.getTest().info("Actual : " + actualHeros);
            ExtentReportConfig.getTest().pass("drop down option matched!");
        } else {
            ExtentReportConfig.getTest().info("Expected : " + expectedheros);
            ExtentReportConfig.getTest().info("Actual : " + actualHeros);
            ExtentReportConfig.getTest().fail("drop down option did not matched!");
        }
    }
}
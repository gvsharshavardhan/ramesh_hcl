package tests;

import org.testng.annotations.Test;
import pages.OrangeDashBoardPage;
import pages.OrangeLoginPage;
import reportConfig.ExtentReportConfig;

public class OrangePageTest extends BaseTest {

    @Test
    public void testLoginAndButtonEnableStatus() throws Exception {
        OrangeLoginPage olp = new OrangeLoginPage();
        olp.goToOrangeLoginPage();
        OrangeDashBoardPage orangeDashBoardPage = olp.enterUserName(olp.getUserName())
                .enterPassword(olp.getDecodedPassword())
                .clickLogin();
        if (orangeDashBoardPage.isSubscribeButtonEnabled()) {
            ExtentReportConfig.getTest().pass("subscribe button is enabled!");
        } else {
            ExtentReportConfig.getTest().fail("subscribe button is not enabled!");
        }

        String title = orangeDashBoardPage.clickWelcomeLink()
                .clickLogoutLink()
                .getPageTitle();
        if (title.equals("OrangeHRM")) {
            ExtentReportConfig.getTest().pass("title matched!");
        } else {
            ExtentReportConfig.getTest().fail("title did not match");
        }
    }
}
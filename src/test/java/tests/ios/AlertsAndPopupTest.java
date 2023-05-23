package tests.ios;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ios.AlertViewPage;
import pages.ios.HomePage;
import utils.BaseTest;

public class AlertsAndPopupTest extends BaseTest {

    @Test
    public void verifyAlertsAndPopupHandling() {
        HomePage homepage = new HomePage(driver);

        AlertViewPage alertviews = homepage.selectAlertViews();
        alertviews.fillTextLabel("Hello World");
        String alertText = alertviews.getConfirmPopUpMessage();

        Assert.assertEquals(alertText, "A message should be a short, complete sentence.");
        alertviews.clickConfirm();
    }
}

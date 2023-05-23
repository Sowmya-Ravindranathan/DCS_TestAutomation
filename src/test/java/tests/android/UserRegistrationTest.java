package tests.android;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.android.HomePage;
import utils.BaseTest;

public class UserRegistrationTest extends BaseTest {

    @Test
    public void verifyErrorMessageOnInvalidPhoneNumber() {
        HomePage homePage = new HomePage(driver);
        homePage.startMessaging()
                .changeCountry("Germany")
                .clearAndEnterPhoneNumber("6788543")
                .clickPopUpOKButton()
                .clearAndEnterPhoneNumber("6788543789")
                .confirmPhoneNumber();

        String actualErrorMessage = homePage.checkErrorMessage();
        Assert.assertEquals(actualErrorMessage, "Invalid phone number. Please check the number and try again.");
    }
}

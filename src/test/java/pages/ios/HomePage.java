package pages.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

        Object driver;
        public HomePage(Object driver) {
            this.driver = driver;
            PageFactory.initElements(new AppiumFieldDecorator((SearchContext) driver),  this);
        }

        @iOSXCUITFindBy(accessibility = "Alert Views")
        private WebElement alertviews;



        public AlertViewPage selectAlertViews(){
            alertviews.click();
            return new AlertViewPage((IOSDriver) driver);
        }
}

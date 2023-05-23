package pages.android;

import Actions.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AndroidActions {
    Object driver;

    public HomePage( Object driver) {
        super((AndroidDriver) driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator((SearchContext) driver),  this);
    }
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Start Messaging']")
    private WebElement startButton;

    @AndroidFindBy(accessibility="Country")
    private WebElement CountryDropdown;

    @AndroidFindBy(xpath="//android.widget.EditText[@content-desc='Phone number']")
    private WebElement phoneNumberField;

    @AndroidFindBy(accessibility="Done")
    private WebElement Done;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='OK']")
    private WebElement invalidNumberOK;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Yes']")
    private WebElement confirmYesButton;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Sorry']")
    private WebElement titleTextSorry;

    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Invalid')]")
    private WebElement errorMessage;


    public HomePage startMessaging(){
        wait(6);
        startButton.click();
        return new HomePage(driver);
    }

    public HomePage changeCountry(String country) {
        wait(3);
        CountryDropdown.click();
        wait(6);
        scrollToText(country);
        return new HomePage(driver);
    }

    public HomePage clearAndEnterPhoneNumber(String Number){
        phoneNumberField.clear();
        phoneNumberField.sendKeys(Number);
        Done.click();
        return new HomePage(driver);
    }

    public HomePage clickPopUpOKButton(){
        wait(3);
        invalidNumberOK.click();
        return new HomePage(driver);
    }

    public HomePage confirmPhoneNumber(){
        confirmYesButton.click();
        return new HomePage(driver);
    }

    public String checkErrorMessage(){
        wait(3);
        waitForElementTextToVisible(titleTextSorry, "Sorry");
        String Message = errorMessage.getText();
        return Message;
    }
}

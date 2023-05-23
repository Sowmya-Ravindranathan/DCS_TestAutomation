package pages.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AlertViewPage {

    IOSDriver driver;

    public AlertViewPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),  this);
    }



    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Text Entry'`]")
    private WebElement textEntryMenu;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell")
    private WebElement textBox;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c]  'Confirm'")
    private WebElement confirmMenu;

    @iOSXCUITFindBy(accessibility = "OK")
    private WebElement acceptPopUp;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'A message'")
    private WebElement confirmMessage;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Confirm'")
    private WebElement submit;


    public void fillTextLabel(String text){
        textEntryMenu.click();
        textBox.sendKeys(text);
        acceptPopUp.click();
    }



    public String getConfirmPopUpMessage(){
        confirmMenu.click();
        return confirmMessage.getText();
    }

    public void clickConfirm(){
        submit.click();
    }
}

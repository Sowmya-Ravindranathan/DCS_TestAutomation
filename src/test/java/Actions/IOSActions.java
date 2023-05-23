package Actions;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

public class IOSActions {


    IOSDriver driver;

    public IOSActions(IOSDriver driver) {
        this.driver = driver;
    }


    public void longPress(WebElement element) {
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement)element).getId());
        params.put("duration", 5);
        driver.executeScript("mobile:touchAndHold", params);
    }

    public void scrollToText(WebElement element,String direction){
        Map <String, Object> params = new HashMap<>();
        params.put("direction", direction);
        params.put("element", ((RemoteWebElement)element).getId());
        driver.executeScript("mobile:scroll", params);
    }

    public void swipeLeft(){
        Map <String, Object> params = new HashMap<String, Object>();
        params.put("direction", "left");
        driver.executeScript("mobile:swipe", params);
    }

    public void slideAction(WebElement Slider, String percent){
        Slider.sendKeys(percent);
    }
}

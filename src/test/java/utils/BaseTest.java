package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public Object driver;
    public AppiumDriverLocalService service;


    @BeforeMethod(alwaysRun = true)
    @Parameters(value = {"platform", "deviceName", "platformVersion"})
    public void configureAppium(String platform, String deviceName, String platformVersion) throws IOException {
        startAppiumService();

        if (platform.equals("iOS"))
            driver = new IOSDriver(service.getUrl(), getIOSOptions(deviceName, platformVersion));
        else
            driver = new AndroidDriver(service.getUrl(), getAndroidOptions(deviceName));
    }

    public void startAppiumService() throws IOException {
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
        properties.load(file);
        String ipAddress = properties.getProperty("ipAddress");
        String port = properties.getProperty("port");

        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress(ipAddress).usingPort(Integer.parseInt(port))
                .build();
        service.start();
    }

    public static UiAutomator2Options getAndroidOptions(String deviceName) {
        String appUrl = System.getProperty("user.dir") + "/src/test/resources/apps/Telegram.apk";
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(deviceName);
        options.setApp(appUrl);
        options.autoGrantPermissions();
        return options;
    }


    public static XCUITestOptions getIOSOptions(String deviceName, String platformVersion) {
        String appUrl = System.getProperty("user.dir") + "/src/test/resources/apps/UIKitCatalog.app";
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName(deviceName);
        options.setApp(appUrl);
        options.setPlatformVersion(platformVersion);
        return options;
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        ((AppiumDriver) driver).quit();
    }

    @AfterSuite
    public void tearDown() {
        service.stop();
    }


}

package utils.core;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.stream.Collectors;

public class TestUtils {

    public Object driver;
    public ExtentTest report;

    public String getScreenshot(String testCaseName, Object driver) throws IOException {
        File source = ((AppiumDriver) driver).getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+ "//reports" + testCaseName +".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
    }

    public String runShellProcessCommand(String command){
        String data="";
        try {
            String formattedCommand = String.format("/users/sowmya/Library/Android/sdk/platform-tools/adb %s",command);
            Runtime run = Runtime.getRuntime();
            Process pr = run.exec(formattedCommand);
            pr.waitFor();
            BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            data = buf.lines().collect(Collectors.joining());
        }catch (InterruptedException | IOException exception){
            exception.printStackTrace();
        }
        return data;
    }

    public void log(String message) {
        report.pass(message);
    }
}

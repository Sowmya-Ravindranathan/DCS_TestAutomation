package utils.core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;


public class Listener extends TestUtils implements ITestListener {
    ExtentReports extent = ExtentReporterNG.getReporterObject();
    ExtentTest test;
    @Override
    public void  onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS,"Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
        try {
            driver =  result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        try {
            test.addScreenCaptureFromPath(getScreenshot(result.getMethod().getMethodName(),  driver), result.getMethod().getMethodName());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        // not implemented
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}

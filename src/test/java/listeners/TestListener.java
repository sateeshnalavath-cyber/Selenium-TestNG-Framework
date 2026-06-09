package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import utils.ExtentManager;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getReport();

    private static ThreadLocal<ExtentTest> extentTest =
            new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest test =
                extent.createTest(result.getName());

        extentTest.set(test);

        System.out.println("START : "
                + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        extentTest.get().pass("Test Passed");

        System.out.println("PASS : "
                + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        extentTest.get().fail("Test Failed");

        try {

            if (BaseTest.driver != null) {

                ScreenshotUtil.captureScreenshot(
                        BaseTest.driver,
                        result.getName());
            }

        } catch (Exception e) {

            System.out.println(
                    "Screenshot capture failed");
        }

        System.out.println("FAIL : "
                + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}
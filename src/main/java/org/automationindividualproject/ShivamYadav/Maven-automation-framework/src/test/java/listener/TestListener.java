package listener;


import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;
import utils.ScreenshotUtils;

public class TestListener extends BaseTest implements ITestListener{

    @Override
    public void onTestSuccess(ITestResult result){

        ScreenshotUtils.takeScreenshot(result.getName() + "_PASSED");

    }

    @Override
    public void onTestFailure(ITestResult result){
        ScreenshotUtils.takeScreenshot(result.getName() + "_FAILED");
    }
    
}

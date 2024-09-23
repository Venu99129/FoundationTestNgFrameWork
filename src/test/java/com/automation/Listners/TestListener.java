package com.automation.Listners;


import com.automation.utils.ExtendReportManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;


public class TestListener implements ITestListener {



    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        ExtendReportManager.createTest(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            ExtendReportManager.addScreenshot();
            ExtendReportManager.getTest().info(result.getThrowable().getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ExtendReportManager.initReport();
        ITestListener.super.onStart(context);

    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        ExtendReportManager.flush();

    }
}
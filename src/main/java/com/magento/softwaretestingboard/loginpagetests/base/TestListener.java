package com.magento.softwaretestingboard.loginpagetests.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    Logger log;
    String testName;
    String testMethodName;

    @Override
    public void onTestStart(ITestResult result){
        this.testMethodName = result.getMethod().getMethodName();
        log.info("[Starting " + testMethodName + "]");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("[Test " + testMethodName + " Passed]");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("[Test " + testMethodName + " Failed]");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("[Test " + testMethodName + " Skipped]");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        //ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
       // ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        this.testName = context.getCurrentXmlTest().getName();
        this.log = LogManager.getLogger(testName);
        log.info("[TEST " + testName + " STARTED]");
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("[ALL " + testName + " FINISHED]");
    }
}

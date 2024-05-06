package com.magento.softwaretestingboard.loginpagetests.base;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BaseTest {

    protected WebDriver driver;
    protected Logger log;

    protected String testMethodName;
    protected String testName;
    protected String testSuiteName;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method,  @Optional("chrome") String browser, ITestContext ctx){
        String testName = ctx.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);

       BrowserDriverFactory factory = new BrowserDriverFactory(browser, log);
       driver = factory.createDriver();

        this.testName = testName;
        this.testSuiteName = ctx.getSuite().getName();
        this.testMethodName = method.getName();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
       log.info("Close Driver");
       driver.quit();
    }
}

package com.magento.softwaretestingboard.loginpagetests.base;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class BaseTest {

    protected WebDriver driver;
    protected Logger log;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser, ITestContext ctx){
        String testName = ctx.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);

       BrowserDriverFactory factory = new BrowserDriverFactory(browser, log);
       driver = factory.createDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
       log.info("Close Driver");
       driver.quit();
    }
}

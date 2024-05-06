package com.magento.softwaretestingboard.loginpagetests.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtilities extends BaseTest{

    /** Take screenshot */
    protected void takeScreenshot(String fileName){
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir")
                + File.separator + "test-output"
                + File.separator + "screenshots"
                + File.separator + getTodaysDate()
                + File.separator + testSuiteName
                + File.separator + testName
                + File.separator + testMethodName
                + File.separator + getSystemTime()
                + " " + fileName + ".png";

        try {
            FileUtils.copyFile(scrFile, new File(path));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /** Get today's date in "yyyMMdd" format */
    private static String getTodaysDate (){
        return (new SimpleDateFormat("yyyMMdd").format(new Date()));
    }
    /** Get time in "HHmmss" format */
    private static String getSystemTime (){
        return (new SimpleDateFormat("HHmmss").format(new Date()));
    }
}

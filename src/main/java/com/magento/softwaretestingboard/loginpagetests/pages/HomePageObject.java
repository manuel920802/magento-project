package com.magento.softwaretestingboard.loginpagetests.pages;

import com.magento.softwaretestingboard.loginpagetests.base.BasePageObject;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends BasePageObject {

    private final String baseUrl = "https://magento.softwaretestingboard.com/";
    private final By signInLinkLocator = By.xpath("//a[contains(text(),'Sign In')]");

    public HomePageObject(WebDriver driver, Logger log){
       super(driver,log);
    }

    //Open Homepage wit its URL
    public void openHomePage(){
        log.info("Opening HomePage: " + baseUrl);
        openUrl(baseUrl);
        log.info("HomePage Opened!");
    }

    //Open SignIn page
    public SignInPage clickSignInLink(){
        log.info("Opening SignIn page on HomePage");
        click(signInLinkLocator);
        return new SignInPage(driver,log);
    }
}

package com.magento.softwaretestingboard.loginpagetests.pages;

import com.magento.softwaretestingboard.loginpagetests.base.BasePageObject;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class MyAccountPage extends BasePageObject {

    private final By myAccountLocator = By.xpath("//div[@class='customer-menu']//a[contains(text(),'My Account')]");
    private final By loggedMessageLocator = By.xpath("//span[@class='logged-in']");
    private final By dropdownLocator = By.xpath("//span[@data-toggle='dropdown']//button[@data-action='customer-menu-toggle']");

    public MyAccountPage(WebDriver driver, Logger log){
        super(driver,log);
    }

    //Verification if MyAccount link is visible on the page
    public boolean isMyAccountLinkVisible(){
        return find(myAccountLocator).isDisplayed();
    }

    //Wait for element to be visible on the page
    public void waitForLoggedMessage(){
        waitForVisibilityOf(loggedMessageLocator, Duration.ofSeconds(5));
    }

    //Return text from logged username
    public String getLoggedMessageText(){
        return find(loggedMessageLocator).getText();
    }

    //Click dropdown link
    public void clickDropdown(){
        click(dropdownLocator);
    }


}

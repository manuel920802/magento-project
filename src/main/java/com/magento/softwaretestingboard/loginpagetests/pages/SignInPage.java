package com.magento.softwaretestingboard.loginpagetests.pages;

import com.magento.softwaretestingboard.loginpagetests.base.BasePageObject;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePageObject {

    private final By emailFieldLocator = By.id("email");
    private final By passwordFieldLocator = By.id("pass");
    private final By signInButtonLocator = By.id("send2");
    private final By errorMessageLocator = By.xpath("//div[@data-ui-id='message-error']");

    public SignInPage (WebDriver driver, Logger log){
      super(driver,log);
    }

    //Execute login
    public MyAccountPage SignIn(String email, String password){
        log.info("Executing login with email : " + email + " and password: " + password);
        type(email,emailFieldLocator);
        type(password,passwordFieldLocator);
        click(signInButtonLocator);
        return new MyAccountPage(driver,log);
    }

    public String getErrorMessageText(){
        waitForVisibilityOf(errorMessageLocator);
        return find(errorMessageLocator).getText();
    }

}

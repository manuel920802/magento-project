package com.magento.softwaretestingboard.loginpagetests;


import com.magento.softwaretestingboard.loginpagetests.base.TestUtilities;
import com.magento.softwaretestingboard.loginpagetests.pages.HomePageObject;
import com.magento.softwaretestingboard.loginpagetests.pages.MyAccountPage;
import com.magento.softwaretestingboard.loginpagetests.pages.SignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.*;

public class NegativeLoginTests extends TestUtilities {

    @Parameters({"username","password","expectedMessage"})
    @Test(priority = 1)
    public void negativeLoginTest(String username, String password, String expectedErrorMessage){
        //Open main page
        HomePageObject homePage = new HomePageObject(driver,log);
        homePage.openHomePage();

        //Click SignIn link
        SignInPage signInPage = homePage.clickSignInLink();

        //Execute login
        signInPage.negativeLogin(username,password);

        //Wait for error message text to be visible
        signInPage.waitForErrorMessage();

        //Get error message text
        String actualErrorMessage = signInPage.getErrorMessageText();

        //Verifications
        assertThat(actualErrorMessage).withFailMessage("actualErrorMessage does not contain expectedErrorMessage" +
                "\nexpectedErrorMessage: " + expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage).contains(expectedErrorMessage);

    }

}

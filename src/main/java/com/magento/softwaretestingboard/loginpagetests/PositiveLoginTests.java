package com.magento.softwaretestingboard.loginpagetests;

import com.magento.softwaretestingboard.loginpagetests.base.TestUtilities;
import com.magento.softwaretestingboard.loginpagetests.pages.HomePageObject;
import com.magento.softwaretestingboard.loginpagetests.pages.MyAccountPage;
import com.magento.softwaretestingboard.loginpagetests.pages.SignInPage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.*;

public class PositiveLoginTests extends TestUtilities {

    @Test
    public void positiveLoginTest() {
        log.info("Starting login positive Test");

        //Open main page
        HomePageObject homePage = new HomePageObject(driver,log);
        homePage.openHomePage();

        //Click on SignIn link
        SignInPage signInPage = homePage.clickSignInLink();

        //Execute login
        MyAccountPage myAccountPage = signInPage.SignIn("manuel76046@hotmail.com", "Selenium123");

        //Verifications
        //My Account link is visible
        myAccountPage.clickDropdown();
        assertThat(myAccountPage.isMyAccountLinkVisible()).withFailMessage("MyAccount link is NOT displayed").isTrue();

        //Check logged-in username
        String expectedMessage = "Welcome, Manuel QA!";
        String actualMessage = myAccountPage.getLoggedMessageText();
        assertThat(actualMessage).withFailMessage("actualMessage does not contain expectedMessage" +
                "\nexpectedMessage: " + expectedMessage + "\nactualMessage: " + actualMessage).contains(expectedMessage);
    }

}

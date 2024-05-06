package com.magento.softwaretestingboard.loginpagetests;

import com.magento.softwaretestingboard.loginpagetests.base.TestUtilities;
import com.magento.softwaretestingboard.loginpagetests.pages.HomePageObject;
import com.magento.softwaretestingboard.loginpagetests.pages.MyAccountPage;
import com.magento.softwaretestingboard.loginpagetests.pages.SignInPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class PositiveLoginTests extends TestUtilities {

    @Test
    public void positiveLoginTest() {
        //Open main page
        HomePageObject homePage = new HomePageObject(driver,log);
        homePage.openHomePage();
        takeScreenshot("Home page opened");

        //Click on SignIn link
        SignInPage signInPage = homePage.clickSignInLink();
        takeScreenshot("Sign in page opened");

        //Execute login
        MyAccountPage myAccountPage = signInPage.SignIn("manuel76046@hotmail.com", "Selenium123");
        takeScreenshot("My Account page opened");

        //Verifications
        //My Account link is visible
        myAccountPage.clickDropdown();
        assertThat(myAccountPage.isMyAccountLinkVisible()).withFailMessage("MyAccount link is NOT displayed").isTrue();

        //Wait for logged message text element to be visible
        myAccountPage.waitForLoggedMessage();

        //Get logged-in username text
        String expectedMessage = "Welcome, Manuel QA!";
        String actualMessage = myAccountPage.getLoggedMessageText();

        //Check logged-in username
        assertThat(actualMessage).withFailMessage("actualMessage does not contain expectedMessage" +
                "\nexpectedMessage: " + expectedMessage + "\nactualMessage: " + actualMessage).contains(expectedMessage);
    }

}

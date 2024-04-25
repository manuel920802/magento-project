package com.magento.softwaretestingboard.loginpagetests;


import com.magento.softwaretestingboard.loginpagetests.base.TestUtilities;
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
        log.info("Starting login negative tests");

        String baseUrl = "https://magento.softwaretestingboard.com/";
        driver.get(baseUrl);
        log.info("Open main page");

        WebElement signIn = driver.findElement(By.xpath("//a[contains(text(),'Sign In')]"));
        signIn.click();

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(username);

        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys(password);

        WebElement signInButton = driver.findElement(By.id("send2"));
        signInButton.click();

        //Verifications
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String actualErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-ui-id='message-error']"))).getText();
        assertThat(actualErrorMessage).withFailMessage("actualErrorMessage does not contain expectedErrorMessage" +
                "\nexpectedErrorMessage: " + expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage).contains(expectedErrorMessage);

    }

}

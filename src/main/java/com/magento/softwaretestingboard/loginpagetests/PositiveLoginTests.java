package com.magento.softwaretestingboard.loginpagetests;

import com.magento.softwaretestingboard.loginpagetests.base.TestUtilities;
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
        WebElement signIn = driver.findElement(By.xpath("//a[contains(text(),'Sign In')]"));
        signIn.click();

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("manuel76046@hotmail.com");

        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys("Selenium123");

        WebElement signInButton = driver.findElement(By.id("send2"));
        signInButton.click();

        //Verification
        //Check logged-in username
        String expectedMessage = "Welcome, Manuel QA!";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String actualMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='logged-in']"))).getText();
        assertThat(actualMessage).withFailMessage("actualMessage does not contain expectedMessage" +
                "\nexpectedMessage: " + expectedMessage + "\nactualMessage: " + actualMessage).contains(expectedMessage);
    }

}

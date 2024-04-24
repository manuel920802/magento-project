package com.magento.softwaretestingboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class PositiveTests {
    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void setUp() {
        String baseUrl = "https://magento.softwaretestingboard.com/";
        driver.manage().window().maximize();
        driver.get(baseUrl);
        System.out.println("Open main page");
    }

    @Test
    public void loginTest() {
        System.out.println("Starting login Test");
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
        String actualMessage = driver.findElement(By.xpath("//span[@class='logged-in']")).getText();
        assertThat(actualMessage).withFailMessage("actualMessage does not contain expectedMessage" +
                "\nexpectedMessage: " + expectedMessage + "\nactualMessage: " + actualMessage).contains(expectedMessage);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        System.out.println("Finished login Test");
    }
}

package com.magento.softwaretestingboard;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.*;

public class NegativeTests {
    WebDriver driver;

    @Parameters({"browser"})
    @BeforeClass
    private void setUp(@Optional("chrome") String browser){
        //Create driver
        System.out.println("Create driver: " + browser );

        switch (browser){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Do not know how to start: " + browser + ", starting chrome.");
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
    }

    @Parameters({"username","password","expectedMessage"})
    @Test(priority = 1)
    public void negativeLoginTest1(String username, String password, String expectedErrorMessage){
        System.out.println("Starting login negative tests");

        String baseUrl = "https://magento.softwaretestingboard.com/";
        driver.get(baseUrl);
        System.out.println("Open main page");

        WebElement signIn = driver.findElement(By.xpath("//a[contains(text(),'Sign In')]"));
        signIn.click();

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(username);

        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys(password);

        WebElement signInButton = driver.findElement(By.id("send2"));
        signInButton.click();

        //Verifications
        String actualErrorMessage = driver.findElement(By.xpath("//div[@data-ui-id='message-error']")).getText();
        assertThat(actualErrorMessage).withFailMessage("actualErrorMessage does not contain expectedErrorMessage" +
                "\nexpectedErrorMessage: " + expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage).contains(expectedErrorMessage);

    }

    @AfterClass
    public void tearDown(){
        System.out.println("Close Driver");
        driver.quit();
    }

}

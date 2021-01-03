package com.mong.testing.tests;

import com.mong.testing.pages.HomePage;
import com.mong.testing.pages.LoginPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTests {
    private LoginPage loginPage;
    private HomePage homePage;
    public WebDriver driver;

    @Before
    public void logInTheApplication() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:4200");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithValidCredentials() throws InterruptedException {
       loginPage = new LoginPage(driver);
        loginPage.fiiInCredentials("popa@student.tuiasi.ro", "popa1235");


        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement messageElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("title"))
        );

        String message = messageElement.getText();
        String successMsg = "MONG";
        Assert.assertEquals(message, successMsg);
        driver.quit();
    }


    @Test
    public void validateWrongFormatEmail() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.fiiInCredentials("marin@student.ro", "marin@1998");


        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement messageElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("error-wrong-format"))
        );

        String message = messageElement.getText();
        String errorMsg= "Wrong format";
        Assert.assertEquals(message, errorMsg);
        driver.quit();
    }
}

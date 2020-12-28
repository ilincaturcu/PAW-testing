package com.mong.testing.tests;

import com.mong.testing.baseTest.BaseTest;
import com.mong.testing.pages.HomePage;
import com.mong.testing.pages.LoginPage;
import lombok.ToString;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTests extends BaseTest {


    private LoginPage loginPage;
    private HomePage homePage;

    @Test
    public void loginWithValidCredentials() throws InterruptedException {
        loginPage= new LoginPage(driver);
        loginPage.fiiInCredentials("marin@student.tuiasi.ro", "marin@1998");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement messageElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("title"))
        );

        String message = messageElement.getText();
        String successMsg = "MONG";
        Assert.assertEquals (message, successMsg);
    }
}

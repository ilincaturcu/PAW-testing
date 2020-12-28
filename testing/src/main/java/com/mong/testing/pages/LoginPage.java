package com.mong.testing.pages;

import com.mong.testing.basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id= "email")
    public WebElement emailField;

    @FindBy(id="password")
    protected WebElement passwordField;

    @FindBy(id="submit")
    protected WebElement submitButton;

    public HomePage fiiInCredentials(String email, String password) throws InterruptedException {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        wait(2000);
        submitButton.click();
        return new HomePage(driver);
    }
}

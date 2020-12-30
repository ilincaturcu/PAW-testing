package com.mong.testing.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    protected WebDriver driver;
    @FindBy(id= "email")
    public WebElement emailField;

    @FindBy(id="password")
    protected WebElement passwordField;

    @FindBy(id="submit")
    protected WebElement submitButton;

    public HomePage fiiInCredentials(String email, String password) throws InterruptedException {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        Thread.sleep(2000);
        submitButton.click();
        Thread.sleep(2000);
        return new HomePage(driver);
    }
}

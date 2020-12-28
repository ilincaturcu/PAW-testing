package com.mong.testing.webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWrapper {
    protected WebDriver driver;
    private WebDriverWait webDriverWait;
    private static final int WAIT = 4;

    public WebDriverWrapper(WebDriver driver){
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, WAIT);
        PageFactory.initElements(driver, this);
    }
}

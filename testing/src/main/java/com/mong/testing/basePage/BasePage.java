package com.mong.testing.basePage;

import com.mong.testing.webDriver.WebDriverWrapper;
import org.openqa.selenium.WebDriver;

public class BasePage{

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
    }


    public BasePage navigateTo(String url){
        driver.navigate().to(url);
        return new BasePage(driver);
    }
}

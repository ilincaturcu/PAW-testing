package com.mong.testing.baseTest;

import com.mong.testing.webDriver.WebDriverWrapper;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class BaseTest {

protected WebDriver driver;
    @BeforeTest
    public void before(){
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://localhost:4200");
    }
}

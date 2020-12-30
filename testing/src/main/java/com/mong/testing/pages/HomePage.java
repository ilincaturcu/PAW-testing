package com.mong.testing.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }
    protected  WebDriver driver;

    @FindBy(id= "volunteers")
    private WebElement volunteersTab;

    public VolunteersPage goToVolunteersPage()
    {
        volunteersTab.click();
        return new VolunteersPage(driver);
    }
}

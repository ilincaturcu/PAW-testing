package com.mong.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewVolunteer {
    public AddNewVolunteer(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }
    protected  WebDriver driver;

    @FindBy(id="addTitle")
    WebElement addNewVolunteerPageTitle;
    public String addTitle() {
        return addNewVolunteerPageTitle.getText();
    }
}

package com.mong.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditVolunteerPage {
    protected WebDriver driver;

    @FindBy(css = "//app-edit-dialog/div/div[1]/h1")
    private WebElement editTile;

    @FindBy(id = "editVolunteer")
    private WebElement confirmEditButton;

    @FindBy(id = "fname")
    private WebElement firstName;


    @FindBy(id = "cancel")
    private WebElement cancelEditButton;

    public EditVolunteerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public VolunteersPage confirmEditeAction() {
        confirmEditButton.click();
        return new VolunteersPage(driver);
    }

    public VolunteersPage cancelDeleteAction() {
        cancelEditButton.click();
        return new VolunteersPage(driver);
    }

    public String getTitlePage() {
        return editTile.getText();
    }

    public EditVolunteerPage setFirstName(String name) {
        firstName.clear();
        firstName.sendKeys(name);
        return new EditVolunteerPage(driver);
    }
}

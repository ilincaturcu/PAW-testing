package com.mong.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TasksPage {

    public TasksPage(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }
    protected  WebDriver driver;
    @FindBy(className = "titlu")
    private WebElement titlu;

    public String tasksTitle() {
        return titlu.getText();
    }
}

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
    @FindBy(id="username")
    private WebElement username;
    @FindBy(id="VizualizareVoluntari")
    private WebElement vizualizareTab;

    @FindBy(id="tasks")
    private WebElement tasksTab;

    @FindBy(id="home")
    private WebElement homeTab;
    @FindBy(className = "titlu")
    private WebElement titlu;

    @FindBy(xpath = "//mat-dialog-actions/button[1]/span[1]")
    private WebElement yesButtonDialogBoxLogout;
    @FindBy(xpath = "//app-nav-bar/ul/li[4]/button")
    private WebElement logoutButton;

    public String tasksTitle() {
        return titlu.getText();
    }

    public VolunteersPage goToVolunteersPage()
    {
        volunteersTab.click();
        return new VolunteersPage(driver);
    }

    public TasksPage goToTasksPage()
    {
        System.out.println("inainte");
        tasksTab.click();
        System.out.println("dupa");
        return new TasksPage(driver);
    }

    public String getUsername(){
        return username.getText();
    }

    public LoginPage validateLogout(){
        logoutButton.click();
        yesButtonDialogBoxLogout.click();
        return new LoginPage(driver);
    }
}

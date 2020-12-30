package com.mong.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class VolunteersPage {
    protected WebDriver driver;
    @FindBy(id = "adaugareVoluntar")
    private WebElement buttonAdaugareVoluntar;
    @FindBy(id = "delete")
    private List<WebElement> deleteAction;
    @FindBy(id = "create")
    private List<WebElement> editAction;
    @FindBy(id = "edit")
    private List<WebElement> viewTaskuri;
    @FindBy(id = "filtrare")
    private WebElement filtru;
    @FindBy(id = "facultate")
    private List<WebElement> faculties;
    @FindBy(id = "VizualizareVoluntari")
    private WebElement titlu;
    @FindBy(id = "nume")
    private List<WebElement> lastNames;
    @FindBy(id = "prenume")
    private List<WebElement> firstNames;
    @FindBy(xpath = "//table/thead/tr/th[2]/div/div[2]")
    private WebElement sortFirstName;
    @FindBy(xpath = "//table/thead/tr/th[1]/div/div[2]")
    private WebElement sortLastName;
    @FindBy(id = "lastName")
    private WebElement lastNameHeader;
    @FindBy(id = "firstName")
    private WebElement firstNamesHeader;
    @FindBy(id = "confirm")
    private WebElement confirmDeleteButton;
    @FindBy(id = "cancel")
    private WebElement cancelDeleteButton;
    @FindBy(xpath = "//app-dialog/h1")
    private WebElement dialogTasksTitle;
    @FindBy(xpath = "//mat-paginator//mat-select/div/div[2]/div")
    private WebElement itemsPerPage;
    @FindBy(id = "mesaj")
    private WebElement permissionMessage;

    public VolunteersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public VolunteersPage fillInFilterByFaculty(String faculty) throws InterruptedException {
        filtru.sendKeys(faculty);
        Thread.sleep(500);
        return new VolunteersPage(driver);
    }

    public String volunteersTitle() {
        return titlu.getText();
    }

    public List<String> getAllFacultiesFromTable() {
        List<String> facultiesFromTable = new ArrayList<>();
        for (WebElement faculty : faculties
        ) {
            facultiesFromTable.add(faculty.getText());
        }
        return facultiesFromTable;
    }

    public void sortAscendingLastNameColumn() {
        Actions builder = new Actions(driver);
        builder.moveToElement(lastNameHeader).build().perform();
        builder.moveToElement(sortLastName).click().build().perform();
    }

    public void sortDescendingLastNameColumn() throws InterruptedException {
        sortLastName.click();
        Thread.sleep(500);
        sortLastName.click();
    }

    public List<String> getAllLastNamesFromTable() {
        List<String> lastNamesFromTable = new ArrayList<>();
        for (WebElement lastName : lastNames
        ) {
            lastNamesFromTable.add(lastName.getText());
        }
        return lastNamesFromTable;
    }

    public void sortAscendingFirstNameColumn() {
        sortFirstName.click();
    }

    public void sortDescendingFirstNameColumn() throws InterruptedException {
        sortFirstName.click();
        Thread.sleep(500);
        sortFirstName.click();
    }

    public List<String> getAllFirstNamesFromTable() {
        List<String> firstNamesFromTable = new ArrayList<>();
        for (WebElement firstName : firstNames
        ) {
            firstNamesFromTable.add(firstName.getText());
        }
        return firstNamesFromTable;
    }

    public VolunteersPage deleteVolunteer(int number) throws InterruptedException {
        deleteAction.get(number).click();
        Thread.sleep(1000);
        return new VolunteersPage(driver);
    }

    public VolunteersPage confirmDeleteAction() {
        confirmDeleteButton.click();
        return new VolunteersPage(driver);
    }

    public VolunteersPage cancelDeleteAction() {
        cancelDeleteButton.click();
        return new VolunteersPage(driver);
    }

    public EditVolunteerPage editVolunteer(int number) throws InterruptedException {
        editAction.get(number).click();
        Thread.sleep(3000);
        return new EditVolunteerPage(driver);
    }

    public VolunteersPage viewTaskuri(int number) throws InterruptedException {
        viewTaskuri.get(number).click();
        Thread.sleep(1000);
        return new VolunteersPage(driver);
    }

    public String getTasksDialogTitle() {
        return dialogTasksTitle.getText();
    }
    public String getPermissionDeniedMessage() {
        return permissionMessage.getText();
    }

}

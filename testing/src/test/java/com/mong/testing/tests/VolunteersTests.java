package com.mong.testing.tests;

import com.mong.testing.pages.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.Collections;
import java.util.List;

public class VolunteersTests {
    public WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private VolunteersPage volunteersPagePage;
    private EditVolunteerPage editVolunteerPage;
    private AddNewVolunteer addNewVolunteer;
    //-----------------ADMIN---------------------
        private static String EMAIL = "popa@student.tuiasi.ro";
        private static String PASSWORD = "popa1235";

    //-----------------VOLUNTAR---------------------
//    private static String EMAIL = "popescu@student.tuiasi.ro";
//    private static String PASSWORD = "1234";

    private static String FILTER = "au";
    private static String TASKS_TITLE = "Taskuri";
    private static String PERMISSION_DENIED_MESSAGE = "You do not have rights to complete this action.";


    @Before
    public void logInTheApplication() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:4200");
        loginPage = new LoginPage(driver);
        homePage = loginPage.fiiInCredentials(EMAIL, PASSWORD);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("title"))
        );

        volunteersPagePage = homePage.goToVolunteersPage();
        wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("VizualizareVoluntari"))
        );
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void filterFaculties() throws InterruptedException {
        volunteersPagePage.fillInFilterByFaculty(FILTER);
        List<String> faculties = volunteersPagePage.getAllFacultiesFromTable();
        for (
                String faculty : faculties
        ) {
            Assert.assertEquals("The faculty does not match the filter!", "Automatic Control and Computer Engineering", faculty);
        }
        driver.quit();
    }

    //-pentru a trece nu trebuie sa avem mai multi voluntari decat items per page
    //-se poate adauga ca pas de a selecta nr max de items per page
    @Test
    public void sortAscendingFirstNameColumn() {
        List<String> firstNamesBeforeSort = volunteersPagePage.getAllFirstNamesFromTable();
        Collections.sort(firstNamesBeforeSort);
        volunteersPagePage.sortAscendingFirstNameColumn();
        List<String> firstNamesAfterSort = volunteersPagePage.getAllFirstNamesFromTable();
        boolean sorted = false;
        if (firstNamesBeforeSort.equals(firstNamesAfterSort)) {
            sorted = true;
        }
        Assert.assertTrue("The first names are not in ascending order!", sorted);
    }

    //-pentru a trece nu trebuie sa avem mai multi voluntari decat items per page
    //-se poate adauga ca pas de a selecta nr max de items per page
    @Test
    public void sortDescendingFirstNameColumn() throws InterruptedException {
        List<String> firstNamesBeforeSort = volunteersPagePage.getAllFirstNamesFromTable();
        Collections.sort(firstNamesBeforeSort, Collections.reverseOrder());
        volunteersPagePage.sortDescendingFirstNameColumn();
        List<String> firstNamesAfterSort = volunteersPagePage.getAllFirstNamesFromTable();
        boolean sorted = false;
        if (firstNamesBeforeSort.equals(firstNamesAfterSort)) {
            sorted = true;
        }
        Assert.assertTrue("The first names are not in ascending order!", sorted);
    }

    //-pentru a trece nu trebuie sa avem mai multi voluntari decat items per page
    //-se poate adauga ca pas de a selecta nr max de items per page
    @Test
    public void sortAscendingLastNameColumn() {
        List<String> lastNamesBeforeSort = volunteersPagePage.getAllFirstNamesFromTable();
        Collections.sort(lastNamesBeforeSort);
        volunteersPagePage.sortAscendingLastNameColumn();
        List<String> lastNamesAfterSort = volunteersPagePage.getAllFirstNamesFromTable();
        boolean sorted = false;
        if (lastNamesBeforeSort.equals(lastNamesAfterSort)) {
            sorted = true;
        }
        Assert.assertTrue("The last names are not in ascending order!", sorted);
    }

    //-pentru a trece nu trebuie sa avem mai multi voluntari decat items per page
    //-se poate adauga ca pas de a selecta nr max de items per page
    @Test
    public void sortDescendingLastNameColumn() throws InterruptedException {
        List<String> lastNamesBeforeSort = volunteersPagePage.getAllFirstNamesFromTable();
        Collections.sort(lastNamesBeforeSort, Collections.reverseOrder());
        volunteersPagePage.sortDescendingLastNameColumn();
        List<String> lastNamesAfterSort = volunteersPagePage.getAllFirstNamesFromTable();
        boolean sorted = false;
        if (lastNamesBeforeSort.equals(lastNamesAfterSort)) {
            sorted = true;
        }
        Assert.assertTrue("The last name are not in ascending order!", sorted);
    }

    @Test
    public void deleteSuccessfullyVolunteer() throws InterruptedException {
//        List<String> firstNamesBeforeDeleting = volunteersPagePage.getAllFirstNamesFromTable();
//        for (String name:firstNamesBeforeDeleting
//             ) {
//            System.out.println(name);
//        }
        volunteersPagePage.deleteVolunteer(2);
        volunteersPagePage.confirmDeleteAction();
//        List<String> firstNamesAfterDeleting = volunteersPagePage.getAllFirstNamesFromTable();

    }

    @Test
    public void cancelDeleteActionVolunteer() throws InterruptedException {
        List<String> firstNamesBeforeDeleting = volunteersPagePage.getAllFirstNamesFromTable();
        volunteersPagePage.deleteVolunteer(4);
        volunteersPagePage.cancelDeleteAction();
        List<String> firstNamesAfterDeleting = volunteersPagePage.getAllFirstNamesFromTable();
        boolean deleted = true;
        if (firstNamesBeforeDeleting.equals(firstNamesAfterDeleting)) {
            deleted = false;
        }
        Assert.assertFalse("A volunteer is missing from tabel !", deleted);
    }

    @Test
    public void cancelEditFirstNameActionVolunteer() throws InterruptedException {
        List<String> firstNamesBeforeDeleting = volunteersPagePage.getAllFirstNamesFromTable();
        editVolunteerPage = volunteersPagePage.editVolunteer(2);
        editVolunteerPage.setFirstName("IOANA");
        editVolunteerPage.cancelDeleteAction();
        List<String> firstNamesAfterDeleting = volunteersPagePage.getAllFirstNamesFromTable();
        Assert.assertEquals("The volunteer has not the same name!", firstNamesBeforeDeleting.get(2), firstNamesAfterDeleting.get(2));
    }

    @Test
    public void confirmEditFirstNameActionVolunteer() throws InterruptedException {
        List<String> firstNamesBeforeDeleting = volunteersPagePage.getAllFirstNamesFromTable();
        editVolunteerPage = volunteersPagePage.editVolunteer(2);
        editVolunteerPage.setFirstName("IOANA");
        editVolunteerPage.confirmEditeAction();
        List<String> firstNamesAfterDeleting = volunteersPagePage.getAllFirstNamesFromTable();
        Assert.assertNotEquals("The volunteer has the same name!", firstNamesBeforeDeleting.get(2), firstNamesAfterDeleting.get(2));
    }

    @Test
    public void viewTasksDialogForVolunteer() throws InterruptedException {
        volunteersPagePage.viewTaskuri(2);
        Assert.assertEquals("The dialog opened is not the task dialog!", TASKS_TITLE, volunteersPagePage.getTasksDialogTitle());
    }

    @Test
    public void permissionDeniedDeleteForVolunteer() throws InterruptedException {
        volunteersPagePage.deleteVolunteer(3);
        Assert.assertEquals("The permission denied message was not displayed!", PERMISSION_DENIED_MESSAGE, volunteersPagePage.getPermissionDeniedMessage());
    }

    @Test
    public void permissionDeniedEditVolunteer() throws InterruptedException {
        volunteersPagePage.editVolunteer(3);
        Assert.assertEquals("The permission denied message was not displayed!", PERMISSION_DENIED_MESSAGE, volunteersPagePage.getPermissionDeniedMessage());
    }

    @Test
    public void validateAccessToAddNewVolunteerButtonAsAdmin(){
        addNewVolunteer = volunteersPagePage.clickOnAddNewVolunteerButton();
        Assert.assertEquals(addNewVolunteer.addTitle(), "Add a New Volunteer");
    }

}

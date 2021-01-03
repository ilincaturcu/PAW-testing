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

public class HomeTests {
    public WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private TasksPage tasksPage;
    private VolunteersPage volunteersPagePage;
    private EditVolunteerPage editVolunteerPage;
    //-----------------ADMIN---------------------
    private static String EMAIL = "popa@student.tuiasi.ro";
    private static String PASSWORD = "popa1235";
    private static String USERNAME = "Magdalena";

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

    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void validateUsernameInNavbar(){
        String usernameNavbar = homePage.getUsername();
        Assert.assertEquals(USERNAME, usernameNavbar);
    }

    @Test
    public void validateRedirectFromNavBar1(){
        volunteersPagePage = homePage.goToVolunteersPage();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("VizualizareVoluntari"))
        );
        Assert.assertEquals(volunteersPagePage.volunteersTitle(), "VOLUNTEERS");
    }

    @Test
    public void validateLogout(){
       homePage.validateLogout();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("email"))
        );
    }

    //de facut testul in clasa cu user voluntar, nu la admin
//    @Test
//    public void validateRedirectFromNavBar2(){
//        tasksPage = homePage.goToTasksPage();
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(
//                ExpectedConditions.presenceOfElementLocated(By.id("tasksTitle"))
//        );
//        Assert.assertEquals(tasksPage.tasksTitle(), "TASKS");
//    }


}

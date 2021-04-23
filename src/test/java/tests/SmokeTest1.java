package tests;

import baseEntities.BaseTest;
import enums.ProjectType;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DashboardPage;
import pages.LoginPage;
import steps.LoginSteps;
import steps.ProjectSteps;
import wrappers.CheckBox;
import wrappers.UIElement;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


public class SmokeTest1 extends BaseTest {

    @Test(groups = {"smoke", "regression"}, timeOut = 5000l)
    public void LoginTest() {
/*
        1. Запустить драйвер
        2. Перейти на сайт
        3. Ввести логин
        4. Ввести пароль
        5. Нажать Login
        6. Dashboard page отобразился
*/
        LoginSteps loginSteps = new LoginSteps(browsersService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        Assert.assertEquals(browsersService.getDriver().getTitle(), "All Projects - TestRail");
    }

    @Test(groups = {"regression", "smoke"}, description = "Логин с некорректными данными")
    public void LoginTestWithIncorrectCredentials() {
/*
        1. Запустить драйвер
        2. Перейти на сайт
        3. Ввести логин
        4. Ввести пароль
        5. Нажать Login
        6. Dashboard page отобразился
*/
        LoginSteps loginSteps = new LoginSteps(browsersService);
        LoginPage loginPage = loginSteps.loginWithIncorrectCredentials("test@gmail.com", "qweqwe");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.getErrorText(),
                "Email/Login or Password is incorrect. Please try again.1");
        softAssert.assertEquals(loginPage.getErrorText(),
                "Email/Login or Password is incorrect. Please try again.2");
        softAssert.assertAll();
    }


    @Test
    public void AddProjectTest() {

        Project project1 = new Project();
        project1.setName("AZjablicev_01");
        project1.setAnnouncement("project1");
        project1.setShowAnnouncement(false);


        LoginSteps loginSteps = new LoginSteps(browsersService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        ProjectSteps projectsSteps = new ProjectSteps(browsersService);
        projectsSteps.addProject(project1);

        Assert.assertTrue(projectsSteps.getMessageSuccessAdd().isDisplayed());
    }

    @Test
    public void UpdateProject(){
        Project project1 = new Project();
        project1.setName("AZjablicev_01");
        project1.setNewName("AZjablicev_01");
        project1.setAnnouncement("project2");
        project1.setShowAnnouncement(false);
        project1.setProjectType(ProjectType.SINGLE_WITH_BASELINE);

        LoginSteps loginSteps = new LoginSteps(browsersService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        ProjectSteps projectsSteps = new ProjectSteps(browsersService);
        projectsSteps.updateProject(project1);

        Assert.assertTrue(projectsSteps.getMessageSuccessUpdate().isDisplayed());
    }

}

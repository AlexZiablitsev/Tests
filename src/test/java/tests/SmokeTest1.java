package tests;

import baseEntities.BaseTest;
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
    public void waitTest() {
        LoginPage loginPage = new LoginPage(browsersService, true);
        loginPage.getEmailInput().sendKeys("atrostyanko+0401@gmail.com");
        loginPage.getPasswordInput().sendKeys("QqtRK9elseEfAk6ilYcJ");
        loginPage.getLogInButton().click();

        long start = new Date().getTime();
        WebElement element = waits.waitForVisibility(new DashboardPage(browsersService, false).getSidebarProjectsAddButton());
        long stop = new Date().getTime();
        System.out.println("Duration: " + (stop - start));
        Assert.assertTrue(element.isDisplayed());

        browsersService.getDriver().navigate().refresh();
        Wait<WebDriver> fluent = new FluentWait<>(browsersService.getDriver())
                .withTimeout(20, TimeUnit.SECONDS)
                .pollingEvery(20, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        start = new Date().getTime();
        WebElement foo = fluent.until(driver -> browsersService.getDriver().findElement(By.id("sidebar-projects-add")));
        stop = new Date().getTime();
        System.out.println("Duration: " + (stop - start));
        Assert.assertTrue(foo.isDisplayed());
        browsersService.getDriver().navigate().refresh();
        WebElement foo1 = fluent.until(ExpectedConditions.visibilityOfElementLocated(By.id("sidebar-projects-add")));
        Assert.assertTrue(foo1.isDisplayed());


    }

    @Test
    public void actionTest() {
        LoginSteps loginSteps = new LoginSteps(browsersService);
        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        dashboardPage.getSidebarProjectsAddButton().click();

        WebElement icon = waits.waitForVisibility(By.className("icon-markdown-table"));
        Actions actions = new Actions(browsersService.getDriver());
        actions.moveToElement(icon).build().perform();
        Assert.assertTrue(waits.waitForAttributeContains(By.id("tooltip"), "style", "display: block"));

        WebElement anon = waits.waitForVisibility(By.id("announcement"));
        Actions actions1 = new Actions(browsersService.getDriver());
        actions.moveToElement(icon).build().perform();
        actions.moveToElement(anon)
                .click()
                .sendKeys("test")
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("a")
                .sendKeys("c")
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys("v")
                .keyUp(Keys.LEFT_CONTROL).build().perform();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void wrapperTest() {
        LoginSteps loginSteps = new LoginSteps(browsersService);
        DashboardPage dashboardPage = loginSteps
                .loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        browsersService.getDriver().get("https://aqa04onl02.testrail.io/index.php?/suites/edit/545/1");

        UIElement button = new UIElement(browsersService.getDriver(), By.className("icon-markdown-table"));
        UIElement button1 = new UIElement(browsersService.getDriver(), By.className("icon-markdown-table"));
        button.hover();
        button.dragAndDrop(button1);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

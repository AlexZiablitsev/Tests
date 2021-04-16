package tests;

import Steps.LoginSteps;
import Steps.ProjectSteps;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ProjectsPage;


public class Lesson7SmokeTest {


    @Test
    public void LoginTestWithCorrectCredentials() {
        /*
        1.Запустить драйвер
        2.Перейти на сайт
        3.Ввести логин
        4.Ввести пароль
        5.Нажать Login
        6.Dashboard page отобразился
        */
        BrowserService browserService = new BrowserService();
        WebDriver driver = browserService.getDriver();

        LoginSteps loginSteps = new LoginSteps(browserService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        Assert.assertEquals(driver.getTitle(), "All Projects - TestRail");


        driver.quit();
    }

    @Test
    public void LoginTestIncorrectCredentials() {
        /*
        1.Запустить драйвер
        2.Перейти на сайт
        3.Ввести логин
        4.Ввести пароль
        5.Нажать Login
        6.Dashboard page отобразился
        */
        BrowserService browserService = new BrowserService();
        WebDriver driver = browserService.getDriver();

        LoginSteps loginSteps = new LoginSteps(browserService);
        LoginPage loginPage = loginSteps.loginWithIncorrectCredentials("test@gmail.com", "qweqwe");

        Assert.assertEquals(loginPage.getErrorText(), "Email/Login or Password is incorrect. Please try again.");
        driver.quit();
    }

    @Test
    public void AddNewProjectType1() {
        BrowserService browserService = new BrowserService();
        WebDriver driver = browserService.getDriver();

        LoginSteps loginSteps = new LoginSteps(browserService);
        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        AddProjectPage addProject = new AddProjectPage(browserService, true);

        ProjectSteps project1 = new ProjectSteps(browserService);
        project1.addProjectType1("AZjablicev_01", "lalaal");
        Assert.assertEquals(project1.getMessageSuccessBy(), "Successfully added the new project.");
        Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'AZjablicev_01')]")).getText(), "AZjablicev_01");


        driver.quit();
    }

    @Test
    public void AddNewProjectType2() {
        BrowserService browserService = new BrowserService();
        WebDriver driver = browserService.getDriver();

        LoginSteps loginSteps = new LoginSteps(browserService);
        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        AddProjectPage addProject = new AddProjectPage(browserService, true);

        ProjectSteps project2 = new ProjectSteps(browserService);
        project2.addProjectType2("AZjablicev_02", "lalalala");
        Assert.assertEquals(project2.getMessageSuccessBy(), "Successfully added the new project.");
        Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'AZjablicev_02')]")).getText(), "AZjablicev_02");


        driver.quit();
    }

    @Test
    public void AddNewProjectType3() {
        BrowserService browserService = new BrowserService();
        WebDriver driver = browserService.getDriver();

        LoginSteps loginSteps = new LoginSteps(browserService);
        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        AddProjectPage addProject = new AddProjectPage(browserService, true);

        ProjectSteps project3 = new ProjectSteps(browserService);
        project3.addProjectType3("AZjablicev_03", "ulalaulala");
        Assert.assertEquals(project3.getMessageSuccessBy(), "Successfully added the new project.");
        Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'AZjablicev_03')]")).getText(), "AZjablicev_03");


        driver.quit();
    }

    @Test
    public void DeleteProjects() {
        BrowserService browserService = new BrowserService();
        WebDriver driver = browserService.getDriver();

        LoginSteps loginSteps = new LoginSteps(browserService);
        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        ProjectsPage projectsPage = new ProjectsPage(browserService, true);

        ProjectSteps projectSteps = new ProjectSteps(browserService);
        projectSteps.deleteProjects("AZjablicev");
        Assert.assertFalse(projectSteps.findMyProjectsBy());


        driver.quit();
    }
}

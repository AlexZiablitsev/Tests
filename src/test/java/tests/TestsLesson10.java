package tests;


import BaseEntities.BaseTest;
import enums.ProjectType;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import steps.LoginSteps;
import steps.ProjectsSteps;
import testData.Provider;

public class TestsLesson10 extends BaseTest {

    //Написать тесты на Логин страницу - 1 позитивный и 3 негативных
    //Написать тесты на создание/редактирование и удаление проектов (invocationCount)
    //Написать тесты на создание/редактирование и удаление ТестКейсов с использованием DataProvider
    //
    //Дополнительно:
    //Реализовать тесты, со всеми изученными атрибутами TestNG

    @Parameters({"email", "password"})
    @Test(priority = 1)
    public void LoginWithCorrectCredentials(String email, String password) {
        LoginSteps loginSteps = new LoginSteps(browserService);
        loginSteps.loginWithCorrectCredentials(email, password);

        Assert.assertEquals(browserService.getDriver().getTitle(), "All Projects - TestRail");
    }

    @Parameters({"incorrectEmail", "incorrectPassword"})
    @Test(priority = 2)
    public void LoginTestIncorrectCredentials(String incorrectEmail, String incorrectPassword) {
        LoginSteps loginSteps = new LoginSteps(browserService);
        LoginPage loginPage = loginSteps.loginWithIncorrectCredentials(incorrectEmail, incorrectPassword);

        Assert.assertEquals(loginPage.getErrorText(), "Email/Login or Password is incorrect. Please try again.");
    }

    @Parameters({"emptyEmail", "emptyPassword"})
    @Test(dependsOnMethods = "LoginTestIncorrectCredentials")
    public void LoginWithEmptyFields(String emptyEmail, String emptyPassword) {
        LoginSteps loginSteps = new LoginSteps(browserService);
        loginSteps.loginWithIncorrectCredentials(emptyEmail, emptyPassword);

        Assert.assertEquals(browserService.getDriver().getTitle(), "Login - TestRail");
    }

    @Test(dependsOnMethods = "LoginWithEmptyFields")
    public void LoginWithSymbols() {
        LoginSteps loginSteps = new LoginSteps(browserService);
        LoginPage loginPage = loginSteps.loginWithIncorrectCredentials("$$$$$$$$$$$", "@@@@@@@@@@@");

        Assert.assertEquals(loginPage.getErrorText(), "Email/Login or Password is incorrect. Please try again.");
    }

    @Test(dependsOnMethods = "LoginWithSymbols", invocationCount = 2)
    public void AddProjectTest() {

        Project project1 = new Project();
        project1.setName("AZjablicev_01");
        project1.setAnnouncement("project1");
        project1.setShowAnnouncement(false);


        LoginSteps loginSteps = new LoginSteps(browserService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        ProjectsSteps projectsSteps = new ProjectsSteps(browserService);
        projectsSteps.addProject(project1);

        Assert.assertTrue(projectsSteps.getMessageSuccessAdd().isDisplayed());
    }

    @Test(dependsOnMethods = "AddProjectTest")
    public void UpdateProjectTest() {
        Project project1 = new Project();
        project1.setName("AZjablicev_01");
        project1.setNewName("AZjablicev_02");
        project1.setAnnouncement("project2");
        project1.setShowAnnouncement(false);
        project1.setProjectType(ProjectType.SINGLE_FOR_ALL_BASELINE);

        LoginSteps loginSteps = new LoginSteps(browserService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        ProjectsSteps projectsSteps = new ProjectsSteps(browserService);
        projectsSteps.updateProject(project1);

        Assert.assertTrue(projectsSteps.getMessageSuccessUpdate().isDisplayed());
    }

    @Test(dependsOnMethods = "UpdateProjectTest")
    public void DeleteProjectsTest() {
        Project project1 = new Project();
        project1.setName("AZjablicev");

        LoginSteps loginSteps = new LoginSteps(browserService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        ProjectsSteps projectsSteps = new ProjectsSteps(browserService);
        projectsSteps.DeleteProjects(project1);
    }

    @Test(dependsOnMethods = "DeleteProjectsTest", dataProvider = "Create Project", dataProviderClass = Provider.class, invocationCount = 2)
    public void AddProjectTestParam(String projectName, String announcement, boolean show_announcement, ProjectType projectType) {

        Project project1 = new Project();
        project1.setName(projectName);
        project1.setAnnouncement(announcement);
        project1.setShowAnnouncement(show_announcement);
        project1.setProjectType(projectType);


        LoginSteps loginSteps = new LoginSteps(browserService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        ProjectsSteps projectsSteps = new ProjectsSteps(browserService);
        projectsSteps.addProject(project1);

        Assert.assertTrue(projectsSteps.getMessageSuccessAdd().isDisplayed());
    }

    @Test(dependsOnMethods = "AddProjectTestParam",dataProvider = "Update Project", dataProviderClass = Provider.class, invocationCount = 2)
    public void UpdateProjectTestParam(String projectName, String newName, String announcement, boolean show_announcement, ProjectType projectType) {
        Project project1 = new Project();
        project1.setName(projectName);
        project1.setNewName(newName);
        project1.setAnnouncement(announcement);
        project1.setShowAnnouncement(show_announcement);
        project1.setProjectType(projectType);

        LoginSteps loginSteps = new LoginSteps(browserService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        ProjectsSteps projectsSteps = new ProjectsSteps(browserService);
        projectsSteps.updateProject(project1);

        Assert.assertTrue(projectsSteps.getMessageSuccessUpdate().isDisplayed());
    }

    @Test(dependsOnMethods = "UpdateProjectTestParam",dataProvider = "Delete Project", dataProviderClass = Provider.class)
    public void DeleteProjectsTestParam(String name) {
        Project project1 = new Project();
        project1.setName(name);

        LoginSteps loginSteps = new LoginSteps(browserService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        ProjectsSteps projectsSteps = new ProjectsSteps(browserService);
        projectsSteps.DeleteProjects(project1);
    }
}

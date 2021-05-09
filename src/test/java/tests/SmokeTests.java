package tests;

import baseEntities.BaseTest;
import enums.ProjectType;
import io.qameta.allure.*;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import steps.LoginSteps;
import steps.ProjectSteps;

@Epic("Main epic")
public class SmokeTests extends BaseTest {

    @Feature("Feature 1")
    @Description("Проверка с корректными данными.")
    @Test(groups = {"smoke", "regression"}, description = "Тест логин.")
    @Severity(SeverityLevel.CRITICAL)
    public void loginTest() {
        LoginSteps loginSteps = new LoginSteps(browsersService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        Assert.assertEquals(browsersService.getDriver().getTitle(), "All Projects - TestRail");
    }

    @Feature("Feature 1")
    @Description("Проверка с некорректными данными и вывод сообщения ошибки.")
    @Test(groups = {"regression", "smoke"}, description = "Тест логин.")
    public void loginTestWithIncorrectCredentials() {
        LoginSteps loginSteps = new LoginSteps(browsersService);
        LoginPage loginPage = loginSteps.loginWithIncorrectCredentials("test@gmail.com", "qweqwe");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.getErrorText(),
                "Email/Login or Password is incorrect. Please try again.");
        softAssert.assertEquals(loginPage.getErrorText(),
                "Email/Login or Password is incorrect. Please try again.2");
        softAssert.assertAll();
    }

    @Feature("Feature 2")
    @Description("Добавление проекта.")
    @Test(description = "Тест добавление проекта.")
    public void addProjectTest() {

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

    @Feature("Feature 2")
    @Test(dependsOnMethods = "addProjectTest", description = "Тест изменения проекта.")
    public void updateProject() {
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

    @Feature("Feature 2")
    @Test(description = "Тест удаления проектов.")
    public void deleteProjects() {
        LoginSteps loginSteps = new LoginSteps(browsersService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        ProjectSteps projectsSteps = new ProjectSteps(browsersService);
        projectsSteps.deleteProjects("AZjablicev");
    }
}

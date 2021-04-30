package tests;

import baseEntities.BaseTest;
import enums.ProjectType;
import models.Project;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import steps.LoginSteps;
import steps.ProjectSteps;
import wrappers.RadioButton;
import wrappers.Table;
import wrappers.TableRow;


public class SmokeTest1 extends BaseTest {

    @Test(groups = {"smoke", "regression"}, timeOut = 5000l)
    public void LoginTest() {
        LoginSteps loginSteps = new LoginSteps(browsersService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        Assert.assertEquals(browsersService.getDriver().getTitle(), "All Projects - TestRail");
    }

    @Test(groups = {"regression", "smoke"}, description = "Логин с некорректными данными")
    public void LoginTestWithIncorrectCredentials() {
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
    public void UpdateProject() {
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

    @Test
    public void RadioButtonTest() {
        LoginSteps loginSteps = new LoginSteps(browsersService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        browsersService.getDriver().get("https://aqa04onl03.testrail.io/index.php?/admin/projects/add/1");


        RadioButton radioButton = new RadioButton(browsersService.getDriver(), By.name("suite_mode"));

        radioButton.selectByValue(3);
        radioButton.selectByText("Use a single repository with baseline support");
    }
}

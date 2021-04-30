package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AddProjectPage;
import pages.ProjectsPage;
import wrappers.CheckBox;

import java.util.List;

public class ProjectSteps extends BaseStep {
    private static final By messageSuccessAddBy = By.xpath("//*[text()='Successfully added the new project.']");
    private static final By messageSuccessUpdateBy = By.xpath("//*[text()='Successfully updated the project.']");

    public ProjectSteps(BrowsersService browsersService) {
        super(browsersService);
    }

    public WebElement getMessageSuccessAdd() {
        return browsersService.getDriver().findElement(messageSuccessAddBy);
    }

    public WebElement getMessageSuccessUpdate() {
        return browsersService.getDriver().findElement(messageSuccessUpdateBy);
    }

    public void addProject(Project project) {
        AddProjectPage addProjectPage = new AddProjectPage(browsersService, true);
        addProjectPage.getInputNameProject().sendKeys(project.getName());
        addProjectPage.getInputProjectAnnouncement().sendKeys(project.getAnnouncement());
        if (project.isShowAnnouncement()) {
            addProjectPage.getShowAnnouncement().click();
        }
        if (project.getProjectType() != null) {
            switch (project.getProjectType().toString()) {
                case "SINGLE_FOR_ALL_CASES":
                    addProjectPage.radioButton().selectByValue(1);
                    break;
                case "SINGLE_FOR_ALL_BASELINE":
                    addProjectPage.radioButton().selectByValue(2);
                    break;
                case "MULTIPLE":
                    addProjectPage.radioButton().selectByValue(3);
                    break;
            }
        }
        addProjectPage.getAcceptButton().click();
    }

    public void updateProject(Project project) {
        ProjectsPage projectsPage = new ProjectsPage(browsersService, true);
        List<WebElement> myProject = projectsPage.getFindMyProjects(project.getName());
        myProject.get(0).click();
        AddProjectPage editProject = new AddProjectPage(browsersService, false);
        editProject.getInputNameProject().clear();
        editProject.getInputNameProject().sendKeys(project.getNewName());
        editProject.getInputProjectAnnouncement().clear();
        editProject.getInputProjectAnnouncement().sendKeys(project.getAnnouncement());
        CheckBox checkBox =  editProject.getShowAnnouncement();
        if (project.isShowAnnouncement()) {
            if (!checkBox.checkboxOnOrOff())
                checkBox.click();
        }
        if (!project.isShowAnnouncement()) {
            if (checkBox.checkboxOnOrOff()) {
                checkBox.click();
            }
        }

        if (project.getProjectType() != null) {
            switch (project.getProjectType().toString()) {
                case "SINGLE_FOR_ALL_CASES":
                    editProject.radioButton().selectByValue(1);
                    break;
                case "SINGLE_FOR_ALL_BASELINE":
                    editProject.radioButton().selectByValue(2);
                    break;
                case "MULTIPLE":
                    editProject.
                    radioButton().selectByValue(3);
                    break;
            }
        }
        editProject.getAcceptButton().click();

    }

    public void DeleteProjects(Project project) {
        ProjectsPage projectsPage = new ProjectsPage(browsersService, true);
        while (projectsPage.findMyProjects()) {
            List<WebElement> list = browsersService.getDriver().findElements(By.xpath("//*[contains(text(),\"" + project.getName() + "\")]//ancestor-or-self::tr//*[@class='icon-small-delete']"));
            list.get(0).click();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            browsersService.getDriver().findElement(By.xpath("//*[@class='dialog-confirm-busy']/following::input")).click();

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            browsersService.getDriver().findElement(By.xpath("//*[@class='dialog-confirm-busy']/following::*[contains(text(),'OK')]")).click();

        }
    }
}
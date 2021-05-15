package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AddProjectPage;
import pages.ProjectsPage;
import wrappers.Button;
import wrappers.CheckBox;
import wrappers.RadioButton;

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
        addProjectPage.inputNameProject.sendKeys(project.getName());
        addProjectPage.inputProjectAnnouncement.sendKeys(project.getAnnouncement());
        CheckBox checkBox = new CheckBox(browsersService.getDriver(), addProjectPage.showAnnouncement);
        if (project.isShowAnnouncement()) {
            checkBox.selectCheckbox();
        }
        RadioButton radioButton = new RadioButton(browsersService.getDriver(), addProjectPage.radioButton);
        if (project.getProjectType() != null) {
            switch (project.getProjectType().toString()) {
                case "SINGLE_FOR_ALL_CASES":
                    radioButton.selectByValue(1);
                    break;
                case "SINGLE_FOR_ALL_BASELINE":
                    radioButton.selectByValue(2);
                    break;
                case "MULTIPLE":
                    radioButton.selectByValue(3);
                    break;
            }
        }
        addProjectPage.acceptButton.click();
    }

    public void updateProject(Project project) {
        ProjectsPage projectsPage = new ProjectsPage(browsersService, true);
        List<WebElement> myProject = projectsPage.getFindMyProjects(project.getName());
        myProject.get(0).click();
        AddProjectPage editProject = new AddProjectPage(browsersService, false);
        editProject.inputNameProject.clear();
        editProject.inputNameProject.sendKeys(project.getNewName());
        editProject.inputProjectAnnouncement.clear();
        editProject.inputProjectAnnouncement.sendKeys(project.getAnnouncement());

        CheckBox checkBox = new CheckBox(browsersService.getDriver(), editProject.showAnnouncement);
        switch (Boolean.toString(project.isShowAnnouncement())) {
            case "true":
            case "false":
                if (project.isShowAnnouncement() != checkBox.checkboxOnOrOff()) {
                    checkBox.selectCheckbox();
                }
                break;
        }
        RadioButton radioButton = new RadioButton(browsersService.getDriver(), editProject.radioButton);
        if (project.getProjectType() != null) {
            switch (project.getProjectType().toString()) {
                case "SINGLE_FOR_ALL_CASES":
                    radioButton.selectByValue(1);
                    break;
                case "SINGLE_WITH_BASELINE":
                    radioButton.selectByValue(2);
                    break;
                case "MULTIPLE":
                    radioButton.selectByValue(3);
                    break;
            }
        }
        editProject.acceptButton.click();
    }

    public void deleteProjects(String name) {
        ProjectsPage projectsPage = new ProjectsPage(browsersService, true);
        while (projectsPage.findMyProjects(name)) {
            Button deleteButton = projectsPage.getDeleteButton(name);
            deleteButton.click();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CheckBox checkBox = new CheckBox(browsersService.getDriver(), projectsPage.dialogCheckbox);
            checkBox.selectCheckbox();

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Button acceptButton = new Button(browsersService.getDriver(), projectsPage.dialogAccept);
            acceptButton.click();
        }
    }
}
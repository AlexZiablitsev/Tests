package Steps;


import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AddProjectPage;
import pages.ProjectsPage;

import java.util.List;

public class ProjectSteps {
    protected BrowserService browserService;

    public ProjectSteps(BrowserService browsersService) {
        this.browserService = browsersService;
    }

    public void addProject(String projectName, String Announcement, boolean showAnnouncement, int projectType) {
        AddProjectPage addProjectPage = new AddProjectPage(browserService, true);
        addProjectPage.getInputNameProject().sendKeys(projectName);
        addProjectPage.getInputProjectAnnouncement().sendKeys(Announcement);
        addProjectPage.chooseShowAnnouncement(showAnnouncement);
        addProjectPage.chooseProjectType(projectType);
        addProjectPage.getAcceptButton().click();
    }

    public void deleteProjects(String name) {
        ProjectsPage projectsPage = new ProjectsPage(browserService, true);

        while (projectsPage.findMyProjects(name)) {
            List<WebElement> list = projectsPage.getdeleteButton(name);
            list.get(0).click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            projectsPage.getCheckbox().click();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            projectsPage.getAcceptButton().click();
        }
    }

    public String messageSuccess() {
        ProjectsPage projectsPage = new ProjectsPage(browserService,false);
        return projectsPage.getMessage();
    }

    public boolean findMyProject(String name){
        ProjectsPage projectsPage = new ProjectsPage(browserService,false);
        return projectsPage.findMyProjects(name);
    }



}

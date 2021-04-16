package Steps;


import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProjectSteps {
    protected BrowserService browserService;
    private static final By inputNameProjectBy = By.id("name");
    private static final By inputProjectAnnouncementBy = By.name("announcement");
    private static final By showAnnouncementBy = By.id("show_announcement");
    private static final By acceptButtonBy = By.id("accept");
    private static final By messageSuccessBy = By.xpath("//*[text()='Successfully added the new project.']");
    private By findMyProjects = By.xpath("//*[contains(text(),'AZjablicev')]");

    public ProjectSteps(BrowserService browsersService) {
        this.browserService = browsersService;
    }

    public WebElement getInputNameProject() {
        return browserService.getDriver().findElement(inputNameProjectBy);
    }

    public WebElement getInputProjectAnnouncementBy() {
        return browserService.getDriver().findElement(inputProjectAnnouncementBy);
    }

    public WebElement getShowAnnouncementBy() {
        return browserService.getDriver().findElement(showAnnouncementBy);
    }

    public WebElement getAcceptButtonBy() {
        return browserService.getDriver().findElement(acceptButtonBy);
    }

    public String getMessageSuccessBy() {
        return browserService.getDriver().findElement(messageSuccessBy).getText();
    }

    public boolean findMyProjectsBy() {
        List<WebElement> list = browserService.getDriver().findElements(findMyProjects);
        if (list.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void addProjectType1(String projectName, String Announcement) {
        getInputNameProject().sendKeys(projectName);
        getInputProjectAnnouncementBy().sendKeys(Announcement);
        getShowAnnouncementBy().click();
        browserService.getDriver().findElement(By.id("suite_mode_single")).click();
        getAcceptButtonBy().click();
    }

    public void addProjectType2(String projectName, String Announcement) {
        getInputNameProject().sendKeys(projectName);
        getInputProjectAnnouncementBy().sendKeys(Announcement);
        getShowAnnouncementBy().click();
        browserService.getDriver().findElement(By.id("suite_mode_single_baseline")).click();
        getAcceptButtonBy().click();
    }

    public void addProjectType3(String projectName, String Announcement) {
        getInputNameProject().sendKeys(projectName);
        getInputProjectAnnouncementBy().sendKeys(Announcement);
        getShowAnnouncementBy().click();
        browserService.getDriver().findElement(By.id("suite_mode_multi")).click();
        getAcceptButtonBy().click();
    }

    public void deleteProjects(String name) {
        while (findMyProjectsBy()) {
            List<WebElement> list = browserService.getDriver().findElements(By.xpath("//*[contains(text(),\'" + name + "\')]//ancestor-or-self::tr//*[@class='icon-small-delete']"));
            list.get(0).click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            browserService.getDriver().findElement(By.xpath("//*[@class='dialog-confirm-busy']/following::input")).click();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            browserService.getDriver().findElement(By.xpath("//*[@class='dialog-confirm-busy']/following::*[contains(text(),'OK')]")).click();

        }
    }

}

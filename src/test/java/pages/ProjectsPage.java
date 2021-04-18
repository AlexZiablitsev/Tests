package pages;

import BaseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProjectsPage extends BasePage {
    private static String END_POINT = "index.php?/admin/projects/overview";
    private static final By listProjectsBy = By.id("content-inner");
    private By findMyProjects = By.xpath("//*[contains(text(),'AZjablicev')]");

    public ProjectsPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    public List<WebElement> getFindMyProjects(String projectName) {
        return driver.findElements(By.xpath("//*[contains(text(),\'" + projectName + "\')]"));
    }

    public boolean findMyProjects() {
        List<WebElement> list = browserService.getDriver().findElements(findMyProjects);
        if (list.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public WebElement getListProjects() {
        return driver.findElement(listProjectsBy);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl + END_POINT);
    }

    @Override
    public boolean isPageOpen() {
        try {
            return getListProjects().isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }
}
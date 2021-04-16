package pages;

import BaseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProjectsPage extends BasePage {
    private static String END_POINT = "index.php?/admin/projects/overview";
    private static final By listProjectsBy = By.id("content-inner");

    public ProjectsPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
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

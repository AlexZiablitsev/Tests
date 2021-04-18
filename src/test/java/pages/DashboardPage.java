package pages;

import BaseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
    private static String END_POINT = "index.php?/dashboard";
    protected static final By sidebarProjectsAddButtonBy = By.id("sidebar-projects-add");

    public DashboardPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }


    public WebElement getSidebarProjectsAddButton() {
        return driver.findElement(sidebarProjectsAddButtonBy);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl + END_POINT);
    }

    @Override
    public boolean isPageOpen() {
                try {
            return getSidebarProjectsAddButton().isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }
}

package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {
    private static String END_POINT = "index.php?/dashboard";
    @FindBy(id = "sidebar-projects-add")
    public WebElement sidebarProjectsAddButton;

    public DashboardPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl + END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return sidebarProjectsAddButton.isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }
}
package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wrappers.Button;

public class AddProjectPage extends BasePage {
    private static String END_POINT = "index.php?/admin/projects/add/1";
    @FindBy(id = "name")
    public WebElement inputNameProject;
    @FindBy(name = "announcement")
    public WebElement inputProjectAnnouncement;
    @FindBy(id = "show_announcement")
    public WebElement showAnnouncement;
    @FindBy(id = "accept")
    public WebElement acceptButton;
    @FindBy(name = "suite_mode")
    public WebElement radioButton;

    public AddProjectPage(BrowsersService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl + END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return new Button(driver, acceptButton).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }


}
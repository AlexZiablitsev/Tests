package pages;

import BaseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddProjectPage extends BasePage {
    private static String END_POINT = "index.php?/admin/projects/add/1";
    private static final By tableBy = By.cssSelector("div+div.table");
    private static final By inputNameProjectBy = By.id("name");
    private static final By inputProjectAnnouncementBy = By.name("announcement");
    private static final By showAnnouncementBy = By.id("show_announcement");
    private static final By acceptButtonBy = By.id("accept");

    private static final By typeProject1 = By.id("suite_mode_single");
    private static final By typeProject2 = By.id("suite_mode_single_baseline");
    private static final By typeProject3 = By.id("suite_mode_multi");

    public AddProjectPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    public WebElement getTypeProject1() {
        return driver.findElement(typeProject1);
    }

    public WebElement getTypeProject2() {
        return driver.findElement(typeProject2);
    }

    public WebElement getTypeProject3() {
        return driver.findElement(typeProject3);
    }


    public WebElement getInputNameProject() {
        return driver.findElement(inputNameProjectBy);
    }

    public WebElement getInputProjectAnnouncement() {
        return driver.findElement(inputProjectAnnouncementBy);
    }

    public WebElement getShowAnnouncement() {
        return driver.findElement(showAnnouncementBy);
    }

    public WebElement getAcceptButton() {
        return driver.findElement(acceptButtonBy);
    }




    public WebElement getTable() {
        return driver.findElement(tableBy);
    }

    public void chooseShowAnnouncement(boolean showAnnouncement) {
        if (showAnnouncement) {
            getShowAnnouncement().click();
        }
    }

    public void chooseProjectType(int projectType) {
        switch (projectType) {
            case 1:
                getTypeProject1().click();
                break;
            case 2:
                getTypeProject2().click();
                break;
            case 3:
                getTypeProject3().click();
                break;
        }
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl + END_POINT);
    }

    @Override
    public boolean isPageOpen() {
        try {
            return getTable().isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }
}

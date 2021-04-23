package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wrappers.Button;
import wrappers.CheckBox;
import wrappers.RadioButton;

import java.util.List;

public class AddProjectPage extends BasePage {
    private static String END_POINT = "index.php?/admin/projects/add/1";
    private static final By inputNameProjectBy = By.id("name");
    private static final By inputProjectAnnouncementBy = By.name("announcement");
    private static final By showAnnouncementBy = By.id("show_announcement");
    private static final By acceptButtonBy = By.id("accept");
    protected By suiteModeSingleSelectorBy = By.id("suite_mode_single");
    protected By suiteModeSingleBaselineSelectorBy = By.id("suite_mode_single_baseline");
    protected By suiteModeMultiSelectorBy = By.id("suite_mode_multi");
    private By radioButtonBy = By.name("suite_mode");

    public AddProjectPage(BrowsersService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    public Button getAcceptButton() {
        return new Button(driver, acceptButtonBy);
    }

    public WebElement getInputNameProject() {
        return driver.findElement(inputNameProjectBy);
    }

    public RadioButton radioButton() {
        return new RadioButton(driver, radioButtonBy);
    }

    public WebElement getInputProjectAnnouncement() {
        return driver.findElement(inputProjectAnnouncementBy);
    }

    public CheckBox getShowAnnouncement() {
        return new CheckBox(driver, showAnnouncementBy);
    }

    public WebElement getType1() {
        return driver.findElement(suiteModeSingleSelectorBy);
    }

    public WebElement getType2() {
        return driver.findElement(suiteModeSingleBaselineSelectorBy);
    }

    public WebElement getType3() {
        return driver.findElement(suiteModeMultiSelectorBy);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl + END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return new Button(driver, acceptButtonBy).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }
}
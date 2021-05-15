package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wrappers.Button;
import wrappers.CheckBox;
import wrappers.RadioButton;

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
    @FindBy(id = "suite_mode_single")
    public WebElement suiteModeSingleSelector;
    @FindBy(id = "suite_mode_single_baseline")
    public WebElement suiteModeSingleBaselineSelector;
    @FindBy(id = "suite_mode_multi")
    public WebElement suiteModeMultiSelector;
    @FindBy(name = "suite_mode")
    protected static final By radioButtonBy = By.name("suite_mode");

    public AddProjectPage(BrowsersService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    public Button getAcceptButton() {
        return new Button(driver, acceptButton);
    }

    public RadioButton radioButton() {
        return new RadioButton(driver, radioButtonBy);
    }

    public CheckBox getShowAnnouncement() {
        return new CheckBox(driver, showAnnouncement);
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
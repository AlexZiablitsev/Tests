package pages;

import BaseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddProject extends BasePage {
    private static String END_POINT = "index.php?/admin/projects/add/1";
    private static final By tableBy = By.cssSelector("div+div.table");
    private static final By inputNameProjectBy = By.cssSelector("input[id='name']");
    private static final By inputProjectAnnouncementBy = By.name("announcement");
    private static final By showAnnouncementBy = By.id("show_announcement");
    private static final By acceptButtonBy = By.id("accept");
    private static final By messageSuccessBy = By.xpath("//*[text()='Successfully added the new project.']");


    public AddProject(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    public WebElement getTable() {
        return driver.findElement(tableBy);
    }

    public WebElement getInputNameProject() {
        return driver.findElement(inputNameProjectBy);
    }

    public WebElement getInputProjectAnnouncementBy() {
        return driver.findElement(inputProjectAnnouncementBy);
    }

    public WebElement getShowAnnouncementBy() {
        return driver.findElement(showAnnouncementBy);
    }

    public WebElement getAcceptButtonBy() {
        return driver.findElement(acceptButtonBy);
    }

    public String getMessageSuccessBy() {

        return driver.findElement(messageSuccessBy).getText();
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

    public void addProjectType1() {
        getInputNameProject().sendKeys("AZjablicev_01");
        getInputProjectAnnouncementBy().sendKeys("lalalala");
        getShowAnnouncementBy().click();
        driver.findElement(By.id("suite_mode_single")).click();
        getAcceptButtonBy().click();
    }

    public void addProjectType2() {
        getInputNameProject().sendKeys("AZjablicev_02");
        getInputProjectAnnouncementBy().sendKeys("lalalala");
        getShowAnnouncementBy().click();
        driver.findElement(By.id("suite_mode_single_baseline")).click();
        getAcceptButtonBy().click();
    }

    public void addProjectType3() {
        getInputNameProject().sendKeys("AZjablicev_03");
        getInputProjectAnnouncementBy().sendKeys("ulalaulala");
        getShowAnnouncementBy().click();
        driver.findElement(By.id("suite_mode_multi")).click();
        getAcceptButtonBy().click();
    }
}

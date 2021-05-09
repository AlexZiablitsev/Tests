package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wrappers.Button;
import wrappers.CheckBox;
import wrappers.Table;

import java.util.List;

public class ProjectsPage extends BasePage {
    private static String END_POINT = "index.php?/admin/projects/overview";
    private static final By listProjectsBy = By.id("content-inner");
    private String findMyProjects = "//*[contains(text(),'projects')]";
    private static final By tableBy = By.className("grid");
    private String deleteButtonBy = "//*[contains(text(),'projectName')]//ancestor-or-self::tr//*[@class='icon-small-delete']";
    private static final By dialogCheckboxBy = By.xpath("//*[@class='dialog-confirm-busy']/following::input");
    private static final By dialogAcceptBy = By.xpath("//*[@class='dialog-confirm-busy']/following::*[contains(text(),'OK')]");

    public ProjectsPage(BrowsersService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    public List<WebElement> getFindMyProjects(String projectName) {
        return driver.findElements(By.xpath("//*[contains(text(),\'" + projectName + "\')]"));
    }

    public Button getDeleteButton(String projectName) {
        return new Button(driver, By.xpath(deleteButtonBy.replace("projectName", projectName)));
    }

    public CheckBox getCheckbox() {
        return new CheckBox(driver, dialogCheckboxBy);
    }

    public Button getAcceptDialog() {
        return new Button(driver, dialogAcceptBy);
    }

    public boolean findMyProjects(String projectName) {
        List<WebElement> list = browsersService.getDriver().findElements(By.xpath(findMyProjects.replace("projects", projectName)));
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
    public boolean isPageOpened() {
        try {
            return getListProjects().isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public Table projectTable = new Table(driver, tableBy);
}
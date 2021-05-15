package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wrappers.Button;
import wrappers.Table;

import java.util.List;

public class ProjectsPage extends BasePage {
    private static String END_POINT = "index.php?/admin/projects/overview";
    @FindBy(id = "content-inner")
    public WebElement listProjects;
    private String findMyProjects = "//*[contains(text(),'projects')]";
    private String deleteButtonBy = "//*[contains(text(),'projectName')]//ancestor-or-self::tr//*[@class='icon-small-delete']";
    @FindBy(className = "grid")
    public WebElement table;
    @FindBy(xpath = "//*[@class='dialog-confirm-busy']/following::input")
    public WebElement dialogCheckbox;
    @FindBy(xpath = "//*[@class='dialog-confirm-busy']/following::*[contains(text(),'OK')]")
    public WebElement dialogAccept;

    public ProjectsPage(BrowsersService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    public List<WebElement> getFindMyProjects(String projectName) {
        return driver.findElements(By.xpath("//*[contains(text(),\'" + projectName + "\')]"));
    }

    public Button getDeleteButton(String projectName) {
        return new Button(driver, By.xpath(deleteButtonBy.replace("projectName", projectName)));
    }


    public boolean findMyProjects(String projectName) {
        List<WebElement> list = browsersService.getDriver().findElements(By.xpath(findMyProjects.replace("projects", projectName)));
        if (list.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl + END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return listProjects.isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public Table projectTable = new Table(driver, table);
}
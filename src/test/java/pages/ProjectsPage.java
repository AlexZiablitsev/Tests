package pages;

import BaseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProjectsPage extends BasePage {
    private static String END_POINT = "index.php?/admin/projects/overview";
    private static final By listProjectsBy = By.id("content-inner");
    private String findMyProjects = "//*[contains(text(),'AZjablicev')]";
    private String deleteButton = ("//*[contains(text(),'AZjablicev')]//ancestor-or-self::tr//*[@class='icon-small-delete']");
    private By checkboxBy = By.xpath("//*[@class='dialog-confirm-busy']/following::input");
    private By acceptButtonBy = By.xpath("//*[@class='dialog-confirm-busy']/following::*[contains(text(),'OK')]");
    private static final By messageSuccessBy = By.xpath("//*[text()='Successfully added the new project.']");


    public ProjectsPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    public WebElement getListProjects() {
        return driver.findElement(listProjectsBy);
    }

    public List<WebElement> getdeleteButton(String name) {
        return driver.findElements(By.xpath(deleteButton.replace("AZjablicev", name)));
    }

    public WebElement getCheckbox() {
        return driver.findElement(checkboxBy);
    }

    public WebElement getAcceptButton() {
        return driver.findElement(acceptButtonBy);
    }

    public String getMessage() {
        return driver.findElement(messageSuccessBy).getText();
    }

    public boolean findMyProjects(String name) {
        List<WebElement> list = driver.findElements(By.xpath(findMyProjects.toString().replace("AZjablicev", name)));
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
    public boolean isPageOpen() {
        try {
            return getListProjects().isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }
}

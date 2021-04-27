package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProjectsPage extends BasePage {
    private static String END_POINT = "index.php?/admin/projects/overview";
    private static final By listProjectsBy = By.id("content-inner");
    private String findMyProjects = "//*[contains(text(),'AZjablicev')]";
    private String deleteButton = ("//*[contains(text(),'AZjablicev')]//ancestor-or-self::tr//*[@class='icon-small-delete']");

    public ProjectsPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }


    public List<WebElement> getFindMyProjects(String name) {
        return driver.findElements(By.xpath("//*[contains(text(),\'" + name + "\')]"));
    }

    public List<WebElement> getdeleteButton(String name) {
        return driver.findElements(By.xpath(deleteButton.replace("AZjablicev", name)));
    }

    public boolean findMyProjects(String name) {
        List<WebElement> list = driver.findElements(By.xpath(findMyProjects.replace("AZjablicev", name)));
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
}
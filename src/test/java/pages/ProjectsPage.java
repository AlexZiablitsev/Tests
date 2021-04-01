package pages;

import BaseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProjectsPage extends BasePage {
    private static String END_POINT = "index.php?/admin/projects/overview";
    private static final By listProjectsBy = By.id("content-inner");
    private String nameProjects;
    private By countsProjectsBy = By.xpath("//*[contains(text(),"+this.nameProjects+")]//ancestor-or-self::tr//div[@class='icon-small-delete']");

    public ProjectsPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    public WebElement getListProjects() {
        return driver.findElement(listProjectsBy);
    }

    public boolean getCountsProjects() {
        List<WebElement> list = driver.findElements(countsProjectsBy);
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

    public void deleteProjects(String name) {
        this.nameProjects = name;
        while (getCountsProjects()) {
            List<WebElement> list = driver.findElements(countsProjectsBy);
            list.get(0).click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.findElement(By.xpath("//*[@class='dialog-confirm-busy']/following::input")).click();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.findElement(By.xpath("//*[@class='dialog-confirm-busy']/following::*[contains(text(),'OK')]")).click();

        }
    }
}

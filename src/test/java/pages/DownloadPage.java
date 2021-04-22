package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

public class DownloadPage extends BasePage {
    private static final String END_POINT = "download";
    private static final By tittleBy = By.xpath("//*[contains(text(),'Powered by')]");
    protected static final By downloadFileBy = By.xpath("//*[text()= 'webdriverIO.png']");

    public DownloadPage(BrowsersService browsersService, boolean openPageByUrl,ChromeOptions options) {
        super(browsersService, openPageByUrl);
    }

    public WebElement getTittle() {
        return driver.findElement(tittleBy);
    }

    public WebElement getDownloadFile() {
        return driver.findElement(downloadFileBy);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl + END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getTittle().isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }
}

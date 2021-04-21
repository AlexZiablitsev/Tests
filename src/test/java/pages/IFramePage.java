package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class IFramePage extends BasePage {
    private static String END_POINT = "iframe";
    private static final By tittleBy = By.xpath("//*[contains(text(),'Powered by')]");

    public IFramePage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
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

    public WebElement getTittle() {
        return driver.findElement(tittleBy);
    }
}

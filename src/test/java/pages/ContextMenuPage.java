package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContextMenuPage extends BasePage {
    private static final String END_POINT = "context_menu";
    private static final By tittleBy = By.xpath("//*[contains(text(),'Powered by')]");
    protected static final By hotSpotBy = By.id("hot-spot");

    public ContextMenuPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    public WebElement getTittle() {
        return driver.findElement(tittleBy);
    }

    public WebElement getHotSpot() {
        return driver.findElement(hotSpotBy);
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

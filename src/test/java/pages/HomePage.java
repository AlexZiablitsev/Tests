package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    private static final By tittleBy = By.xpath("//*[contains(text(),'Powered by')]");

    public HomePage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    public WebElement getTittle() {
        return driver.findElement(tittleBy);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getTittle().isDisplayed();
        }
        catch (Exception ex){
            return false;
        }
    }
}

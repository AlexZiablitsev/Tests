package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class IFramePage extends BasePage {
    private static String END_POINT = "iframe";
    private static final By tittleBy = By.xpath("//*[contains(text(),'Powered by')]");
    private static final By inputTextBy = By.id("tinymce");
    private static final By alignCenterButtonBy = By.xpath("//*[@aria-label='Align center']");
    private static final By checkBy = By.xpath("//*[@id='tinymce']//child::p[@style='text-align: center;']");

    public IFramePage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    public WebElement getInputText() {
        return driver.findElement(inputTextBy);
    }

    public WebElement getAlignCenterButton() {
        return driver.findElement(alignCenterButtonBy);
    }

    public WebElement getCheck() {
        return driver.findElement(checkBy);
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

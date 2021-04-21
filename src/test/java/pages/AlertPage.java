package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AlertPage extends BasePage {
    private static String END_POINT = "javascript_alerts";
    private static final By tittleBy = By.xpath("//*[contains(text(),'Powered by')]");
    private static final By alertButtonBy = By.xpath("//*[text()= 'Click for JS Alert']");
    private static final By resultBy = By.id("result");
    private static final By confirmButtonBy = By.xpath("//*[text()= 'Click for JS Confirm']");
    private static final By promptButtonBy = By.xpath("//*[text()= 'Click for JS Prompt']");

    public AlertPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    public WebElement getAlertButton() {
        return driver.findElement(alertButtonBy);
    }

    public WebElement getResult() {
        return driver.findElement(resultBy);
    }

    public WebElement getConfirmButton() {
        return driver.findElement(confirmButtonBy);
    }

    public WebElement getPromptButton() {
        return driver.findElement(promptButtonBy);
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

package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Waits;

import java.util.List;

public class DynamicControlsPage extends BasePage {
    private static final String END_POINT = "dynamic_controls";
    private static final By tittleBy = By.xpath("//*[contains(text(),'Powered by')]");
    private static final By checkboxBy = By.xpath("//*[@id='checkbox-example']//child::input");
    private static final By removeButtonBy = By.xpath("//*[@id='checkbox-example']//child::button");
    private static final By checkboxMessageBy = By.xpath("//*[@id='checkbox-example']//child::p");
    private static final By inputBy = By.xpath("//*[@id='input-example']//child::input");
    private static final By enableButtonBy = By.xpath("//*[@id='input-example']//child::button");
    private static final By enableMessageBy = By.xpath("//*[@id='input-example']//child::p");

    public DynamicControlsPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    public WebElement getTittle() {
        return driver.findElement(tittleBy);
    }

    public WebElement getCheckbox() {
        return driver.findElement(checkboxBy);
    }

    public List<WebElement> getCountCheckbox() {
        return driver.findElements(checkboxBy);
    }

    public WebElement getRemoveButton() {
        return driver.findElement(removeButtonBy);
    }

    public WebElement getCheckboxMessage() {
        Waits waits = new Waits(browsersService.getDriver());
        return waits.waitForInVisibility(checkboxMessageBy);
    }

    public WebElement getInput() {
        return driver.findElement(inputBy);
    }

    public WebElement getEnableButton() {
        return driver.findElement(enableButtonBy);
    }

    public WebElement getEnableMessage() {
        Waits waits = new Waits(browsersService.getDriver());
        return waits.waitForInVisibility(enableMessageBy);
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

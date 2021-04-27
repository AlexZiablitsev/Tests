package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.DynamicControlsPage;
import utils.Waits;

import java.util.List;

public class DynamicControlsSteps extends BaseStep {
    public DynamicControlsSteps(BrowsersService browsersService) {
        super(browsersService);
    }

    public void workWithCheckbox() {
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(browsersService, true);
        dynamicControlsPage.getCheckbox().click();
        dynamicControlsPage.getRemoveButton().click();
        Waits wait = new Waits(browsersService.getDriver());
        WebElement element = wait.waitForVisibility(dynamicControlsPage.getCheckboxMessage());
    }

    public void workWithEnableButton() {
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(browsersService, true);
        dynamicControlsPage.getEnableButton().click();
        Waits wait = new Waits(browsersService.getDriver());
        WebElement element = wait.waitForVisibility(dynamicControlsPage.getEnableMessage());
    }

    public WebElement getCheckboxMessage() {
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(browsersService, false);
        return dynamicControlsPage.getCheckboxMessage();
    }

    public WebElement getCheckbox() {
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(browsersService, false);
        return dynamicControlsPage.getCheckbox();
    }

    public List<WebElement> getCountCheckbox() {
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(browsersService, false);
        return dynamicControlsPage.getCountCheckbox();
    }

    public WebElement getInput() {
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(browsersService, false);
        return dynamicControlsPage.getInput();
    }

    public WebElement getEnableButton() {
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(browsersService, false);
        return dynamicControlsPage.getEnableButton();
    }

    public WebElement getEnableMessage() {
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(browsersService, false);
        return dynamicControlsPage.getEnableMessage();
    }
}

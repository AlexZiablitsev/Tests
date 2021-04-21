package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import pages.AlertPage;


public class AlertSteps extends BaseStep {

    public AlertSteps(BrowsersService browsersService) {
        super(browsersService);
    }

    public void clickForAlertButton(){
        AlertPage alertPage = new AlertPage(browsersService,true);
        alertPage.getAlertButton().click();
        Alert alert = browsersService.getDriver().switchTo().alert();
        alert.accept();
    }

    public void clickForConfirmButton(){
        AlertPage alertPage = new AlertPage(browsersService, true);
        alertPage.getConfirmButton().click();
        Alert alert = browsersService.getDriver().switchTo().alert();
        alert.dismiss();
    }

    public void clickForPromptButton(){
        AlertPage alertPage = new AlertPage(browsersService,true);
        alertPage.getPromptButton().click();
        Alert alert = browsersService.getDriver().switchTo().alert();
        alert.sendKeys("Alert");
        alert.accept();
    }

    public WebElement getResult() {
        AlertPage alertPage = new AlertPage(browsersService,false);
        return alertPage.getResult();
    }
}

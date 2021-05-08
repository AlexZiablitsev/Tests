package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.ContextMenuPage;

public class ContextMenuSteps extends BaseStep {

    public ContextMenuSteps(BrowsersService browsersService) {
        super(browsersService);
    }

    public void clickHotSpot() {
        ContextMenuPage contextMenuPage = new ContextMenuPage(browsersService, true);
        Actions actions = new Actions(browsersService.getDriver());
        actions
                .moveToElement(contextMenuPage.getHotSpot())
                .contextClick()
                .build()
                .perform();
    }

    public WebElement hotSpot() {
        ContextMenuPage contextMenuPage = new ContextMenuPage(browsersService, false);
        return contextMenuPage.getHotSpot();
    }
}

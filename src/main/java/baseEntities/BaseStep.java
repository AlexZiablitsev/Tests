package baseEntities;

import core.BrowsersService;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseStep {
    protected BrowsersService browsersService;

    public BaseStep(BrowsersService browsersService) {
        this.browsersService = browsersService;
        PageFactory.initElements(browsersService.getDriver(),this);
    }
}
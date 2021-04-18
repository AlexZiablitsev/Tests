package BaseEntities;

import core.BrowserService;

public abstract class BaseSteps {
    protected BrowserService browserService;

    public BaseSteps(BrowserService browserService) {
        this.browserService = browserService;
    }
}

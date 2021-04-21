package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import pages.IFramePage;

public class IFrameSteps extends BaseStep {

    public IFrameSteps(BrowsersService browsersService) {
        super(browsersService);
    }

    public void workWithIframe() {
        IFramePage iFramePage = new IFramePage(browsersService, true);
        

    }
}

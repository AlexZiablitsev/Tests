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
        browsersService.getDriver().switchTo().frame("mce_0_ifr");
        iFramePage.getInputText().clear();
        iFramePage.getInputText().sendKeys("Некоторый текст");
        browsersService.getDriver().switchTo().defaultContent();
        iFramePage.getAlignCenterButton().click();
    }

    public String getCheck() {
        IFramePage iFramePage = new IFramePage(browsersService, false);
        browsersService.getDriver().switchTo().frame("mce_0_ifr");
        return iFramePage.getCheck().getAttribute("data-mce-style");
    }

}

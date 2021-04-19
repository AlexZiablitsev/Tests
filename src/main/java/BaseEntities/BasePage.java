package BaseEntities;

import core.BrowserService;
import core.ReadProperties;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected static final int WAIT_FOR_PAGE_LOAD_IN_SECOND = 5;
    protected WebDriver driver;
    private BrowserService browserService;
    public String baseUrl;

    protected abstract void openPage();
    public abstract boolean isPageOpen();

    public BasePage(BrowserService browserService,boolean openPageByUrl) {
        this.browserService = browserService;
        this.driver = browserService.getDriver();
        this.baseUrl = new ReadProperties().getURL();

        if(openPageByUrl){
            openPage();
        }
        waitForOpen();
    }
protected void waitForOpen(){
    int secondsCount = 0;
    boolean isPageOpenIndicator = isPageOpen();

    while (!isPageOpenIndicator && secondsCount < WAIT_FOR_PAGE_LOAD_IN_SECOND){
        browserService.sleep(1000);
        secondsCount++;
        isPageOpenIndicator = isPageOpen();
    }
    if(!isPageOpenIndicator){
        throw new AssertionError("Page was not opened.");
    }
}

}

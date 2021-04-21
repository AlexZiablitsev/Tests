package baseEntities;

import core.BrowsersService;
import core.ReadProperties;
import org.testng.annotations.*;
import utils.Waits;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    public BrowsersService browsersService;
    protected ReadProperties readProperties;
    protected Waits waits;

    @BeforeMethod
    public void setupMethod() {
        readProperties = new ReadProperties();
        browsersService = new BrowsersService();
        browsersService.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        browsersService.getDriver().get(readProperties.getURL());
        waits = browsersService.getWaits();
    }

    @AfterMethod
    public void tearDownMethod() {
        browsersService.getDriver().quit();
        browsersService = null;
    }
}

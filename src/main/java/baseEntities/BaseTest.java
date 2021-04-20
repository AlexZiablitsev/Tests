package baseEntities;

import core.BrowsersService;
import core.ReadProperties;
import org.testng.annotations.*;
import utils.Waits;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected BrowsersService browsersService;
    protected ReadProperties readProperties;
    protected Waits waits;

    @BeforeSuite
    public void setupSuite() {
    }

    @AfterSuite
    public void tearDownSuite() {
    }

    @BeforeGroups
    public void setupGroups() {
        readProperties = new ReadProperties();
        browsersService = new BrowsersService();
        browsersService.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        browsersService.getDriver().get(readProperties.getURL());
        waits = browsersService.getWaits();
    }

    @AfterGroups
    public void tearDownGroups() {
        browsersService.getDriver().quit();
        browsersService = null;
    }

    @BeforeTest
    public void setupTest() {
    }

    @AfterTest
    public void tearDownTest() {
    }

    @BeforeClass
    public void setupClass() {
    }

    @AfterClass
    public void tearDownClass() {
    }

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

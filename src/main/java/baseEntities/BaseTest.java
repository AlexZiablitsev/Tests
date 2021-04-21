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

    @BeforeSuite
    public void setupSuite() {
        System.out.println("BeforeSuite: ");
    }

    public void setupGroups() {
        readProperties = new ReadProperties();
        browsersService = new BrowsersService();
        browsersService.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        browsersService.getDriver().get(readProperties.getURL());
        waits = browsersService.getWaits();
    }

    @BeforeTest
    public void setupTest() {
    }

    @BeforeClass
    public void setupClass() {
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

    @AfterClass
    public void tearDownClass() {
    }

    @AfterTest
    public void tearDownTest() {
    }

    @AfterGroups
    public void tearDownGroups() {
        browsersService.getDriver().quit();
        browsersService = null;
    }

    @AfterSuite
    public void tearDownSuite() {
    }
}

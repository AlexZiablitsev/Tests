package baseEntities;

import core.BrowsersService;
import core.ReadProperties;
import org.testng.annotations.*;
import utils.Listener;
import utils.Waits;

import java.util.concurrent.TimeUnit;

@Listeners(Listener.class)
public abstract class BaseTest {
    public BrowsersService browsersService;
    protected ReadProperties readProperties;
    protected Waits waits;

    @BeforeSuite
    public void setupSuite() {
        System.out.println("BeforeSuite: ");
    }

    @BeforeGroups(groups = {"regression", "smoke"})
    public void setupGroups() {
        System.out.println("BeforeGroups: ");
        browsersService = new BrowsersService();
        browsersService.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        browsersService.getDriver().get(readProperties.getURL());
        waits = browsersService.getWaits();
    }

    @BeforeTest
    public void setupTest() {
        System.out.println("BeforeTest: ");
    }

    @BeforeClass
    public void setupClass() {
        System.out.println("BeforeClass: ");
    }

    @BeforeMethod
    public void setupMethod() {
        System.out.println("BeforeMethod: ");
        browsersService = new BrowsersService();
        browsersService.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        browsersService.getDriver().get(readProperties.getURL());
        waits = browsersService.getWaits();
    }

    @AfterMethod
    public void tearDownMethod() {
        System.out.println("AfterMethod: ");
        browsersService.getDriver().quit();
        browsersService = null;
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("AfterClass: ");
    }

    @AfterTest
    public void tearDownTest() {
        System.out.println("AfterTest: ");
    }

    @AfterGroups(groups = {"regression", "smoke"})
    public void tearDownGroups() {
        System.out.println("AfterGroups: ");
        browsersService.getDriver().quit();
        browsersService = null;
    }

    @AfterSuite
    public void tearDownSuite() {
        System.out.println("AfterSuite: ");
    }
}

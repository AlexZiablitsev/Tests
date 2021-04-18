package BaseEntities;

import core.BrowserService;
import core.ReadProperties;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected BrowserService browserService;
    protected ReadProperties readProperties;


    @BeforeSuite
    public void setupSuite() {
    }

    @AfterSuite
    public void tearDownSuite() {
    }

    @BeforeGroups
    public void setupGroup() {
        browserService = new BrowserService();
        readProperties = new ReadProperties();
        browserService.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        browserService.getDriver().get(readProperties.getURL());
    }

    @AfterGroups
    public void tearDownGroups() {
        browserService.getDriver().quit();
        browserService = null;
    }

    @BeforeTest
    public void setupTest() {
        readProperties = new ReadProperties();
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
        browserService = new BrowserService();
        readProperties = new ReadProperties();
        browserService.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        browserService.getDriver().get(readProperties.getURL());
    }

    @AfterMethod
    public void tearDownMethod() {
        browserService.getDriver().quit();
        browserService = null;
    }
}

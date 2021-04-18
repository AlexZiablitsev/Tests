package core;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;


public class BrowserService {
    private WebDriver driver = null;
    private  DriverManagerType driverManagerType;

    public BrowserService() {
        ReadProperties readProperties = new ReadProperties();

        switch (readProperties.getBrowser().toLowerCase()) {
            case "chrome":
                driverManagerType = DriverManagerType.CHROME;
                WebDriverManager.getInstance(driverManagerType).setup();
                driver = new ChromeDriver();
                break;
            case " firefox":
                driverManagerType = DriverManagerType.FIREFOX;
                WebDriverManager.getInstance(driverManagerType).setup();
                driver = new FirefoxDriver();
                break;
            case " ie":
                driverManagerType = DriverManagerType.IEXPLORER;
                WebDriverManager.getInstance(driverManagerType).setup();
                driver = new InternetExplorerDriver();
                break;
            case "safari":
                driverManagerType = DriverManagerType.SAFARI;
                WebDriverManager.getInstance(driverManagerType).setup();
                driver = new SafariDriver();
                break;
//            case "remote":
//                driverManagerType = DriverManagerType.;
//                break;
            case "edge":
                driverManagerType = DriverManagerType.EDGE;
                WebDriverManager.getInstance(driverManagerType).setup();
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Browser "+ readProperties.getBrowser()+"is not supported.");
                //ToDo: Надо ли выбрасывать Exception?
                break;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void sleep(int milliseconds){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

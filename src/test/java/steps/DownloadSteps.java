package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import core.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import pages.DownloadPage;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public class DownloadSteps extends BaseStep {
    String path = System.getProperty("user.dir") + new ReadProperties().getUserDirectory();
    private File downloaded_report;

    public DownloadSteps(BrowsersService browsersService) {
        super(browsersService);
    }


    public void downLoadFile(String name) {

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", path);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        BrowsersService browsersService = new BrowsersService(options);
        DownloadPage downloadPage = new DownloadPage(browsersService, true, options);

        WebElement el = downloadPage.getDownloadFile(name);
        el.click();

        downloaded_report = new File(path + "/" + name);
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(browsersService.getDriver());
        wait.pollingEvery(1, TimeUnit.SECONDS);
        wait.withTimeout(15, TimeUnit.SECONDS);
        wait.until(x -> downloaded_report.exists());

        browsersService.getDriver().quit();
    }

    public boolean getFile(String name) {

        File folder = new File(path);

        File[] listOfFiles = folder.listFiles();

        boolean found = false;
        File file = null;

        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                if (fileName.matches(name)) {
                    file = new File(name);
                    found = true;
                }

            }
        }
        return found;
    }

    public void deleteFile(String name) {
        File file = new File(path + "/"+ name);
        file.delete();
    }
}

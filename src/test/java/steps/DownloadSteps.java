package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import core.ReadProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.DownloadPage;

import java.io.File;
import java.util.HashMap;


public class DownloadSteps extends BaseStep {

    public DownloadSteps(BrowsersService browsersService) {
        super(browsersService);
    }


    public void downLoadFile() {

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", new ReadProperties().getUserDirectory());
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        BrowsersService browsersService = new BrowsersService(options);
        DownloadPage downloadPage = new DownloadPage(browsersService, true,options);

        WebElement el = downloadPage.getDownloadFile();
        el.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        browsersService.getDriver().quit();
    }

    public boolean getFile() {

        File folder = new File(new ReadProperties().getUserDirectory());

        File[] listOfFiles = folder.listFiles();

        boolean found = false;
        File file = null;

        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                if (fileName.matches("Landscape-Color.jpg")) {
                    file = new File(fileName);
                    found = true;
                }

            }
        }
        return found;
    }

    public void deleteFile() {
        File file = new File(new ReadProperties().getUserDirectory() + "/Landscape-Color.jpg");
        file.delete();
    }
}

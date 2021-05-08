package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.FileUploaderPage;
import utils.Waits;

import java.io.File;


public class FileUploaderSteps extends BaseStep {
    String path = System.getProperty("user.dir") + new ReadProperties().getUserDirectory();

    public FileUploaderSteps(BrowsersService browsersService) {
        super(browsersService);
    }

    public void uploadFile() {
        FileUploaderPage fileUploaderPage = new FileUploaderPage(browsersService, true);

        JavascriptExecutor js = (JavascriptExecutor) browsersService.getDriver();
        WebElement element = fileUploaderPage.fileUpload();
        js.executeScript("var s=window.document.createElement('input');"
                + "s.type = 'file';"
                + "s.id = 'uploadFile';"
                + "arguments[0].appendChild(s);", element);

        String file = path + File.separator + "picture.jpg";
        String file1 = path + File.separator + "picture1.jpg";
        fileUploaderPage.getInputFile().sendKeys(file);
        fileUploaderPage.getUploadFile().sendKeys(file1);
        fileUploaderPage.getUploadFileButton().click();
        Waits waits = new Waits(browsersService.getDriver());
        WebElement webElement = waits.waitForVisibility(fileUploaderPage.getMessage());
    }

    public WebElement getMessage1() {
        FileUploaderPage fileUploaderPage = new FileUploaderPage(browsersService, false);
        return browsersService.getDriver().findElement(fileUploaderPage.getMessage());
    }
}

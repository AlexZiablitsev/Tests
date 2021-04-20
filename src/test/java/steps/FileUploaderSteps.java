package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import core.ReadProperties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.FileUploaderPage;
import utils.Waits;


public class FileUploaderSteps extends BaseStep {
    public FileUploaderSteps(BrowsersService browsersService) {
        super(browsersService);
    }

    public void uploadFile() {
        FileUploaderPage fileUploaderPage = new FileUploaderPage(browsersService, true);

        JavascriptExecutor js = (JavascriptExecutor) browsersService.getDriver();
        WebElement element = browsersService.getDriver().findElement(fileUploaderPage.fileUpload());
        js.executeScript("var s=window.document.createElement('input');"
                + "s.type = 'file';"
                + "s.id = 'uploadFile';"
                + "arguments[0].appendChild(s);", element);

        String file = (new ReadProperties().getUserDirectory()) + "/picture.jpg";
        String file1 = "E:/Tests/src/test/resources/picture1.jpg";
        browsersService.getDriver().findElement(fileUploaderPage.getInputFile()).sendKeys(file);
        browsersService.getDriver().findElement(fileUploaderPage.getUploadFile()).sendKeys(file1);
        fileUploaderPage.getUploadFileButton().click();
        Waits waits = new Waits(browsersService.getDriver());
        WebElement webElement = waits.waitForVisibility(fileUploaderPage.getMessage());


        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public WebElement getMessageBy() {
        FileUploaderPage fileUploaderPage = new FileUploaderPage(browsersService, false);
        return fileUploaderPage.getMessage();
    }
}

package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FileUploaderPage extends BasePage {
    private static final String END_POINT = "upload";
    private static final By tittleBy = By.xpath("//*[contains(text(),'Powered by')]");
    private static final By inputFileBy = By.id("file-upload");
    private static final By uploadFileButtonBy = By.id("file-submit");
    private static final By fileUploadBy = By.xpath("//*[@method='POST']");
    private static final By uploadFileBy = By.id("uploadFile");
    private static final By messageBy = By.xpath("//*[contains(text(),'picture.jpg')]");

    public FileUploaderPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    public WebElement getTittle() {
        return driver.findElement(tittleBy);
    }

    public By getInputFile() {
        return inputFileBy;
    }

    public By fileUpload() {
        return fileUploadBy;
    }

    public By getUploadFile() {
        return uploadFileBy;
    }

    public WebElement getUploadFileButton() {
        return driver.findElement(uploadFileButtonBy);
    }

    public By getMessage() {
        return messageBy;
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl + END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getTittle().isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }
}

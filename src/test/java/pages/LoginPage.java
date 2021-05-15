package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "name")
    public WebElement emailInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "button_primary")
    public WebElement logInButton;

    @FindBy(id = "error-text")
    public WebElement errorLabel;

    public LoginPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return logInButton.isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }
}
package pages;

import BaseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {


    //Описание селекторов

    protected static final By emailInputBy = By.id("name");
    protected static final By passwordInputBy = By.id("password");
    protected static final By loginButtonBy = By.id("button_primary");
    protected static final By errorLabelBy = By.className("error-text");


    //Инициализация классов
    public LoginPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl);
    }

    @Override
    public boolean isPageOpen() {
        try {
            return getLoginButton().isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    //Методы для WebElement-ов

    public WebElement getEmailInput() {
        return driver.findElement(emailInputBy);
    }

    public WebElement getPasswordInput() {
        return driver.findElement(passwordInputBy);
    }

    public WebElement getLoginButton() {
        return driver.findElement(loginButtonBy);
    }

    public String getErrorText() {
        return driver.findElement(errorLabelBy).getText();
    }
}

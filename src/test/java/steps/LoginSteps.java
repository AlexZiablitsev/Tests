package steps;

import BaseEntities.BaseSteps;
import core.BrowserService;
import org.testng.annotations.Optional;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginSteps extends BaseSteps {
        public LoginSteps(BrowserService browserService) {
        super(browserService);
    }

    public DashboardPage loginWithCorrectCredentials(String email, String password) {
        LoginPage loginPage = new LoginPage(browserService, true);
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();
        return new DashboardPage(browserService, false );
    }

    public LoginPage loginWithIncorrectCredentials(String email, String password) {
        LoginPage loginPage = new LoginPage(browserService, true);
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();
        return new LoginPage(browserService, false);
    }
}

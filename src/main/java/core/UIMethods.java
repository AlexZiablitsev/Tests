package core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UIMethods {

    public static void Click(WebDriver driver, WebElement webElement) {
        try {
            webElement.click();
        } catch (Exception ex) {
            try {
                new Actions(driver)
                        .moveToElement(webElement)
                        .click()
                        .build()
                        .perform();
            } catch (Exception ex1) {
                ((JavascriptExecutor)driver).executeScript("arguments[0].click();", webElement);
            }
        }
    }
}

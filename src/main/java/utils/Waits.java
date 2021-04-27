package utils;

import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Waits {
    private WebDriverWait wait;

    public Waits(WebDriver driver, int timeOut) {
        wait = new WebDriverWait(driver, timeOut);
    }

    public Waits(WebDriver driver) {
        wait = new WebDriverWait(driver, new ReadProperties().getTimeout());
    }


    public WebElement waitForVisibility(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForVisibility(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public List<WebElement> waitForVisibilityOfElements(By by) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public List<WebElement> waitForPresentsElements(By by) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by) );
    }

    public boolean waitForAttributeContains(By by, String attributeName, String attributeValue) {
        return wait.until(ExpectedConditions.attributeContains(by, attributeName, attributeValue));
    }
}

package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RowsCell {
    private UIElement element;
    private WebDriver driver;
    private Actions actions;
    private JavascriptExecutor jsExecutor;


    public RowsCell(WebDriver webDriver, By by) {
        this.driver = webDriver;
        this.element = new UIElement(webDriver, by);
    }


    public RowsCell(WebDriver webDriver, WebElement webElement) {
        this.driver = webDriver;
        this.element = new UIElement(webDriver, webElement);
        this.actions = new Actions(driver);
        this.jsExecutor = (JavascriptExecutor) driver;
    }


    public void click() {
        element.click();
    }

}



package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RowsCell {
    private UIElement webElement;
    private WebDriver webDriver;

    public RowsCell(WebDriver webDriver, By by) {
        this.webDriver = webDriver;
        this.webElement = new UIElement(webDriver, by);
    }

    public RowsCell(WebDriver webDriver, WebElement webElement) {
        this.webDriver = webDriver;
        this.webElement = new UIElement(webDriver, (By) webElement);
    }

    public UIElement getElementFromCell(By by) {
        return new UIElement(webDriver, by);
    }
}

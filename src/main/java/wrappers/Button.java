package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Button {
    private UIElement element;

    public Button(WebDriver webDriver, By by) {
        this.element = new UIElement(webDriver,by);
    }

    public Button(WebDriver webDriver, WebElement element) {
        this.element = new UIElement(webDriver,element);
    }

    public void click() {
        element.click();
    }

    public void submit() {
        element.submit();
    }

    public boolean isDisplayed() {
        return element.isDisplayed();
    }
}
package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button {
    private UIElement element;

    public Button(WebDriver webDriver, By by) {
    this.element = new UIElement(webDriver,by);
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

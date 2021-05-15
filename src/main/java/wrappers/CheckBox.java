package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox {
    UIElement element;

    public CheckBox(WebDriver driver, By by) {
        this.element = new UIElement(driver, by);
    }

    public CheckBox(WebDriver driver, WebElement element) {
        this.element = new UIElement(driver, element);
    }

    public void click() {
        element.click();
    }

    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    public boolean checkboxOnOrOff() {
        if (element.getAttribute("checked") != null) {
            return true;
        } else {
            return false;
        }
    }

    public void selectCheckbox() {
        switch (Boolean.toString(checkboxOnOrOff())) {
            case "true":
            case "false":
                element.click();
                break;
        }
    }

    public String getAttribute(String s) {
        return element.getAttribute(s);
    }
}
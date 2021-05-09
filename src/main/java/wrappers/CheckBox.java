package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBox {
    UIElement element;

    public CheckBox(WebDriver driver, By by) {
        this.element = new UIElement(driver, by);
    }

    public void click() {
        element.click();
    }

    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    public String checkboxOnOrOff() {
        if (element.getAttribute("checked") != null) {
            return "true";
        } else {
            return "false";
        }
    }

    public void selectCheckbox() {
        switch (checkboxOnOrOff()) {
            case "true":
                element.click();
                break;
            case "false":
                element.click();
                break;
        }
    }

    public String getAttribute(String s) {
        return element.getAttribute(s);
    }
}
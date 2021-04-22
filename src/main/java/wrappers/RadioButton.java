package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class RadioButton {
    private UIElement webElement;
    private List<UIElement> optionsList = new ArrayList<>();

    public RadioButton(WebDriver webDriver, By by) {
        webDriver.findElements(by);
        this.webElement = new UIElement(webDriver, by);
    }

    public List<String> getOptions() {
        return null;
    }
}

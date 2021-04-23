package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class RadioButton {
    UIElement element;
    private List<UIElement> radioButtonList = new ArrayList<>();

    public RadioButton(WebDriver driver, By by) {
        this.element = new UIElement(driver, by);

        for (WebElement webElement : driver.findElements(by)) {
            radioButtonList.add(new UIElement(driver, webElement));
        }
    }

    public RadioButton(WebDriver driver, WebElement element) {
        this.element = new UIElement(driver, element);
    }


    public void click() {
        element.click();
    }

    public void chooseValue(int value) {
        for (int i = 0; i < radioButtonList.size(); i++) {
            if (i == value - 1) {
                radioButtonList.get(i).click();
            }
        }
    }
}

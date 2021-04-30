package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class RadioButton {
    UIElement element;
    private List<UIElement> radioButtonList = new ArrayList<>();
    private List<String> textList = new ArrayList<>();
    private WebDriver driver;

    public RadioButton(WebDriver driver, By by) {
        this.element = new UIElement(driver, by);
        this.driver = driver;
        for (WebElement webElement : driver.findElements(by)) {
            radioButtonList.add(new UIElement(driver, webElement));
        }
        textList = getRadioButtonText(radioButtonList);
    }

    public void click() {
        element.click();
    }

    public void selectByValue(int value) {
        for (int i = 0; i < radioButtonList.size(); i++) {
            if (i == value - 1) {
                radioButtonList.get(i).click();
            }
        }
    }

    private List<String> getRadioButtonText(List<UIElement> radioList) {
        List<String> result = new ArrayList<>();
        for (UIElement element : radioList) {
            result.add(element.getParent().findElement(By.tagName("strong")).getText());
        }
        return result;
    }

    public void selectByText(String name){
        int index = textList.indexOf(name);
        radioButtonList.get(index).click();
    }
}

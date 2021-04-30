package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TableRow {
    private UIElement element;
    private final List<RowsCell> cellsList = new ArrayList<>();
    private WebDriver driver;

    public TableRow(WebDriver driver, By by) {
        this.driver = driver;
        this.element = new UIElement(driver, by);
        for (WebElement webElement : element.findElements(By.tagName("td"))) {
            cellsList.add(new RowsCell(driver, webElement));
        }
    }

    public TableRow(WebDriver driver, WebElement webElement) {
        this.driver = driver;
        this.element = new UIElement(driver, webElement);
        for (WebElement element : webElement.findElements(By.tagName("td"))) {
            cellsList.add(new RowsCell(driver, element));
        }
    }

    public void click() {
        element.click();
    }

    public UIElement getParent() {
        WebElement parent = (WebElement) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].parentNode;", element);
        return new UIElement(driver, parent);
    }

    public String getText() {
        return element.getText();
    }
}

package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TableRow {
    private UIElement webElement;
    private final List<RowsCell> cellsList = new ArrayList<>();
    private WebDriver driver;

    public TableRow(WebDriver driver, By by) {
        this.driver = driver;
        this.webElement = new UIElement(driver, by);
        for (WebElement webElement : webElement.findElements(By.tagName("td"))) {
            cellsList.add(new RowsCell(driver, webElement));
        }
    }

    public TableRow(WebDriver driver, WebElement webElement) {
        this.driver = driver;
        this.webElement = new UIElement(driver, webElement);
        for (WebElement element : webElement.findElements(By.tagName("td"))) {
            cellsList.add(new RowsCell(driver, element));
        }
    }
}

package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.text.TableView;
import java.util.ArrayList;
import java.util.List;

public class Table {
    private UIElement element;
    private List<TableRow> rowsList = new ArrayList<>();

    public Table(WebDriver webDriver, By by) {
        this.element = new UIElement(webDriver, by);

        for (WebElement webElement : element.findElements(By.tagName("tr"))) {
            TableRow tableRow = new TableRow(webDriver, webElement);
            rowsList.add(tableRow);
        }
    }

    public TableView.TableRow getRowByTextInColumn(String text, String columnName) {
        return null;
    }
}

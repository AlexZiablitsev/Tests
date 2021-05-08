package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DropDownMenu {
    private UIElement element;
    private List<TableRow> rowsList = new ArrayList<>();
    private List<String> textList = new ArrayList<>();
    private WebDriver driver;
    private JavascriptExecutor jsExecutor;

    public DropDownMenu(WebDriver driver, By by) {
        this.driver = driver;
        this.element = new UIElement(driver, by);
        this.jsExecutor = (JavascriptExecutor) driver;
        for (WebElement webElement : element.findElements(By.tagName("a"))) {
            TableRow tableRow = new TableRow(driver, webElement);
            rowsList.add(tableRow);
        }
    }

    private List<String> getDropDownMenuText(List<TableRow> dropList) {
        List<String> result = new ArrayList<>();
        for (TableRow element : dropList) {
            result.add(element.getText());
        }
        return result;
    }

    public void selectByName(String name) {
        jsExecutor.executeScript("document.getElementById('helpDropdown').style.display='block';");
        textList = getDropDownMenuText(rowsList);
        int index = textList.indexOf(name);
        rowsList.get(index).click();
    }

    public void selectByNumber(int number) {
        rowsList.get(number - 1).click();
    }
}

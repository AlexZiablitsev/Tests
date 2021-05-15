package wrappers;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utils.Waits;

import java.util.List;

public class UIElement implements WebElement {
    private final WebDriver driver;
    private By by;
    private final WebElement element;
    private Actions actions;
    private JavascriptExecutor jsExecutor;
    private Waits waits;

    public UIElement(WebDriver driver, By by) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.jsExecutor = (JavascriptExecutor) driver;
        this.waits = new Waits(driver);
        this.by = by;
        element = driver.findElement(by);
    }

    public UIElement(WebDriver driver, WebElement element) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.jsExecutor = (JavascriptExecutor) driver;
        this.waits = new Waits(driver);
        this.element = element;
    }

    @Override
    public void click() {
        try {
            element.click();
        } catch (Exception ex) {
            try {
                actions
                        .moveToElement(element)
                        .click()
                        .build()
                        .perform();
            } catch (Exception ex1) {
                jsExecutor.executeScript("argument[0].click();", element);
            }
        }
    }

    @Override
    public void submit() {
        element.submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        element.sendKeys(charSequences);
    }

    @Override
    public void clear() {
        element.clear();
    }

    @Override
    public String getTagName() {
        return element.getTagName();
    }

    @Override
    public String getAttribute(String s) {
        return element.getAttribute(s);
    }

    @Override
    public boolean isSelected() {
        return element.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return element.isEnabled();
    }

    @Override
    public String getText() {
        return element.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return element.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return element.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return waits.waitForVisibility(element).isDisplayed();
    }

    @Override
    public Point getLocation() {
        return element.getLocation();
    }

    @Override
    public Dimension getSize() {
        return element.getSize();
    }

    @Override
    public Rectangle getRect() {
        return element.getRect();
    }

    @Override
    public String getCssValue(String s) {
        return element.getCssValue(s);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return element.getScreenshotAs(outputType);
    }

    public void hover() {
        actions
                .moveToElement(element)
                .build()
                .perform();
    }

    public void dragAndDrop(UIElement target) {
        actions
                .dragAndDrop(element, target.element)
                .build()
                .perform();
    }

    public UIElement getParent() {
        WebElement parent = (WebElement) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].parentNode;", element);
        return new UIElement(driver, parent);
    }
}
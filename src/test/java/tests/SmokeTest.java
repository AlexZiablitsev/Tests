package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.ContextMenuSteps;
import steps.DynamicControlsSteps;

public class SmokeTest extends BaseTest {

    @Test
    public void ContextMenuTest() {

        ContextMenuSteps contextMenuSteps = new ContextMenuSteps(browsersService);
        contextMenuSteps.clickHotSpot();

        Alert alert = browsersService.getDriver().switchTo().alert();
        alert.accept();

        Assert.assertTrue(contextMenuSteps.hotSpot().isDisplayed());

    }

    @Test
    public void DynamicControlsTest() {

        DynamicControlsSteps dynamicControlsSteps = new DynamicControlsSteps(browsersService);
        dynamicControlsSteps.workWithCheckbox();

        Assert.assertTrue(dynamicControlsSteps.getCheckboxMessage().isDisplayed());
        Assert.assertEquals(dynamicControlsSteps.getCountCheckbox().size(),0,"Checkbox is in a page");

        Assert.assertFalse(dynamicControlsSteps.getInput().isEnabled());
        dynamicControlsSteps.workWithEnableButton();
        Assert.assertTrue(dynamicControlsSteps.getEnableMessage().isDisplayed());
        Assert.assertTrue(dynamicControlsSteps.getInput().isEnabled());
    }
}

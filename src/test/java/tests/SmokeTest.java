package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.AlertSteps;

public class SmokeTest extends BaseTest {

    @Test
    public void AlertTest() {
        AlertSteps alertSteps = new AlertSteps(browsersService);
        alertSteps.clickForAlertButton();
        Assert.assertEquals(alertSteps.getResult().getText(), "You successfully clicked an alert");

        alertSteps.clickForConfirmButton();
        Assert.assertEquals(alertSteps.getResult().getText(), "You clicked: Cancel");

        alertSteps.clickForPromptButton();
        Assert.assertEquals(alertSteps.getResult().getText(), "You entered: Alert");
    }

}



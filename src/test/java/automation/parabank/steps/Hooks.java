package automation.parabank.steps;

import automation.core.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @After
    public static void after_all() {
        Driver.quitDriver();
    }

    @AfterStep
    public void takeAndAttachScreenshot(Scenario scenario) {
       final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
       scenario.attach(screenshot, "image/png", "screenshot");
    }
}
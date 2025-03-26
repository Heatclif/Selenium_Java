package automation.core;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

    private final WebDriver driver;
    private final int defaultWait = 10;

    public Base() {
        driver = Driver.createDriver("chrome");
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        Driver.quitDriver();
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void debug() {
        // Set debug pointer below
        System.out.println("Debugging");
    }

    /**
     * Wait for an element to exist
     * 
     * @param locator        xpath of the element
     * @param timeoutSeconds seconds to wait for the element to exist
     */
    public void waitForElementToExist(String locator, int timeoutSeconds) {
        By by = By.xpath(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 0));
    }

    /**
     * Wait for an element to be visible
     * 
     * @param locator        xpath of the element
     * @param timeoutSeconds seconds to wait for the element to be visible
     */
    public void waitForElementToBeVisible(String locator, int timeoutSeconds) {
        By by = By.xpath(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * Wait for an element to be clickable
     * 
     * @param locator        xpath of the element
     * @param timeoutSeconds seconds to wait for the element to be clickable
     */
    public void waitForElementToBeClickable(String locator, int timeoutSeconds) {
        By by = By.xpath(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    /**
     * Wait for an element to be invisible
     * 
     * @param locator        xpath of the element
     * @param timeoutSeconds seconds to wait for the element to be invisible
     */
    public void waitForElementToBeInvisible(String locator, int timeoutSeconds) {
        By by = By.xpath(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    /**
     * Wait for an element to have attribute
     * 
     * @param locator        xpath of the element
     * @param attribute      attribute of the element
     * @param value          desired value of the attribute
     * @param timeoutSeconds seconds to wait for the element to have text
     */
    public void waitForElementToHaveAttribute(String locator, String attribute, String value, int timeoutSeconds) {
        By by = By.xpath(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.attributeToBe(by, attribute, value));
    }

    /**
     * Wait for an alert to be present
     */
    public void waitForAlertToBePresent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(defaultWait));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    /**
     * Execute a script on an element
     * 
     * @param script  script to execute
     * @param locator xpath of the element
     */
    public void executeScript(String script, String locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        waitForElementToExist(locator, defaultWait);
        js.executeScript(script, driver.findElement(By.xpath(locator)));
    }

    /**
     * Execute a script on an element
     * 
     * @param script  script to execute
     */
    public void executeScript(String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(script);
    }

    /**
     * Click an element using JavaScript
     * Note: Use this method when the element is not clickable
     * 
     * @param locator xpath of the element
     */
    public void jsClick(String locator) {
        executeScript("arguments[0].click();", locator);
    }

    /**
     * Scroll into view an element
     * 
     * @param locator xpath of the element
     */
    public void jsScrollIntoView(String locator) {
        executeScript("arguments[0].scrollIntoView();", locator);
    }

    /**
     * Reloads the context of the page that driver is currently on
     */
    public void reloadContext() {
        executeScript("window.location.reload();");
    }

    /**
     * Click an element
     * 
     * @param locator xpath of the element
     */
    public void click(
            String locator
    ) {
        waitForElementToBeClickable(locator, defaultWait);
        driver.findElement(By.xpath(locator)).click();
    }

    /**
     * Double-click an element
     * 
     * @param locator xpath of the element
     */
    public void doubleClickElement(
            String locator
    ) {
        waitForElementToBeClickable(locator, defaultWait);
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(By.xpath(locator))).perform();
    }

    /**
     * Hover over an element
     * 
     * @param locator xpath of the element
     */
    public void hoverOverElement(
            String locator
    ) {
        waitForElementToBeVisible(locator, defaultWait);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(locator))).perform();
    }

    /**
     * Type text into an element
     * 
     * @param locator xpath of the element
     * @param text    text to type
     */
    public void setValue(
            String locator,
            String text
    ) {
        By textField = By.xpath(locator);
        waitForElementToBeVisible(locator, defaultWait);
        driver.findElement(textField).clear();
        driver.findElement(textField).sendKeys(text);
    }

    /**
     * Select from dropdown by text
     * @param locator xpath locator of the dropdown
     * @param option text value of the option
     */
    public void selectFromDropdown(
            String locator,
            String option
    ) {
        By dropDown = By.xpath(locator);
        Select dropDownElement = new Select(driver.findElement(dropDown));
        dropDownElement.selectByVisibleText(option);
    }

    /**
     * Select from dropdown by text
     * @param locator xpath locator of the dropdown
     * @param option index of the option
     */
    public void selectFromDropdown(
            String locator,
            int option
    ) {
        By dropDown = By.xpath(locator);
        Select dropDownElement = new Select(driver.findElement(dropDown));
        dropDownElement.selectByIndex(option);
    }

    /**
     * Get the text of an element
     * 
     * @param locator xpath of the element
     */
    public void switchToFrame(
            String locator
    ) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(defaultWait));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

    /**
     * Accept an alert
     */
    public void acceptAlert() {
        waitForAlertToBePresent();
        driver.switchTo().alert().accept();
    }

    /**
     * Dismiss an alert
     */
    public void dismissAlert() {
        waitForAlertToBePresent();
        driver.switchTo().alert().dismiss();
    }

    /**
     * Get the text of an alert
     * 
     * @return text of the alert
     */
    public String getAlertText() {
        waitForAlertToBePresent();
        return driver.switchTo().alert().getText();
    }
}

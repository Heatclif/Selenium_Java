package automation.core;

import java.time.Duration;

import com.titusfortner.logging.SeleniumLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private Driver() {
        // Private constructor to prevent instantiation
    }

    public static WebDriver createDriver(String browser) {
        if (driver.get() == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--start-maximized");
                    options.addArguments("--disable-notifications");
                    // options.setCapability("webSocketUrl", true);    //Enable BiDi
                    // options.addArguments("--headless");

                    driver.set(new ChromeDriver(options));
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

            // Implicit wait to allow elements to load
            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            SeleniumLogger.enable("RemoteWebDriver");
        }
        return getDriver();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}

package com.automation.base;

import com.automation.driver.WebDriverFactory;
import com.automation.utils.Browser;
import com.automation.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseTest {

    private Browser browser = Browser.CHROME;
    protected WebDriver driver;
    protected WebDriverWait wait;
    private static WebDriver sharedDriver;
    private final PropertiesReader propertiesReader = PropertiesReader.getInstance();

    public void initializeTest() {
        if (propertiesReader.getProperty("browser").equalsIgnoreCase("firefox")) {
            browser = Browser.FIREFOX;
        }

        if (sharedDriver == null) {
            try {
                sharedDriver = WebDriverFactory.getDriver(browser);  // Initialize the shared WebDriver
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        driver = sharedDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(propertiesReader.getProperty("timeout"))));

        // Navigate to the base URL only if it's the first time
        if (driver.getCurrentUrl().equals("data:,")) {
            driver.get(propertiesReader.getProperty("baseUrl"));
        }
    }

    public void cleanUpTest() {
        // Ensure the shared WebDriver is closed when all tests finish
        if (driver != null) {
            driver.quit();
            sharedDriver = null;  // Reset shared driver after quitting
        }
    }
}
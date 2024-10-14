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
    private final PropertiesReader propertiesReader = PropertiesReader.getInstance();

    public void initializeTest() {

        if (propertiesReader.getProperty("browser").equals("firefox")) {
            browser = Browser.FIREFOX;
        }

        try {
            driver = WebDriverFactory.getDriver(browser);
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(propertiesReader.getProperty("timeout"))));
        driver.get(propertiesReader.getProperty("baseUrl"));
    }

    public void cleanUpTest() {
        if (driver != null) {
            driver.quit();
        }
    }
}
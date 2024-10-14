package com.automation.driver;

import com.automation.utils.Browser;
import org.openqa.selenium.WebDriver;

/**
 * Factory class to create WebDriver instances.
 */
public class WebDriverFactory {

    public static WebDriver getDriver(Browser browser) throws Exception {
        switch (browser) {
            case FIREFOX:
                FirefoxDriverCreator firefoxDriverCreator = new FirefoxDriverCreator();
                return firefoxDriverCreator.createWebDriver();
            case CHROME:
                ChromeDriverCreator chromeDriverCreator = new ChromeDriverCreator();
                return chromeDriverCreator.createWebDriver();
            default:
                throw new Exception("Not supported Browser");
        }
    }
}
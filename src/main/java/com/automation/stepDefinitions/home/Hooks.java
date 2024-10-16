package com.automation.stepDefinitions.home;

import com.automation.driver.CurrentWebDriverManager;
import com.automation.driver.factory.WebDriverFactory;
import com.automation.utils.Browser;
import com.automation.utils.PropertiesReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Hooks {

    private Browser browser = Browser.CHROME;
    private final PropertiesReader propertiesReader = PropertiesReader.getInstance();

    private static final ThreadLocal<WebDriverWait> waitThreadLocal = new ThreadLocal<>();

    @Before
    public void initializeTest() {
        if (propertiesReader.getProperty("browser").equalsIgnoreCase("firefox")) {
            browser = Browser.FIREFOX;
        }

        try {
            CurrentWebDriverManager.getInstance().setWebDriver(WebDriverFactory.getDriver(browser));
            waitThreadLocal.set(new WebDriverWait(CurrentWebDriverManager.getInstance().getWebDriver(),
                    Duration.ofSeconds(Long.parseLong(propertiesReader.getProperty("timeout")))));
            CurrentWebDriverManager.getInstance().getWebDriver().manage().window().maximize();
            CurrentWebDriverManager.getInstance().getWebDriver().get(propertiesReader.getProperty("baseUrl"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void cleanUpTest() {
        if (CurrentWebDriverManager.getInstance().getWebDriver() != null) {
            CurrentWebDriverManager.getInstance().getWebDriver().quit();
            CurrentWebDriverManager.getInstance().removeWebDriver();
        }
    }

    public static WebDriverWait getWait() {
        return waitThreadLocal.get();
    }
}
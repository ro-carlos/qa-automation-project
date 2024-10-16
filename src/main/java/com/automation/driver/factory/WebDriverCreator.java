package com.automation.driver.factory;

import com.automation.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;

/**
 * Abstract class extended by driver creators.
 */
public abstract class WebDriverCreator {

    protected final PropertiesReader propertiesReader = PropertiesReader.getInstance();

    public abstract WebDriver createWebDriver();
}
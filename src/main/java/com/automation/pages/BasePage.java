package com.automation.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.utils.BrowserActions;


/**
 * Base class that contains common configuration for another pages.
 *
 * @author Carlos Rodríguez
 */
public class BasePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final BrowserActions browserActions;
    private static final Logger logger = LogManager.getLogger();

    @FindBy(css = "body")
    private WebElement bodyElement;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.browserActions = new BrowserActions(driver, wait);
        PageFactory.initElements(this.driver, this);
        waitPageLoaded();
        pageLoadedElement();
    }

    public String getUrl(){
        String url = getDriver().getCurrentUrl();
        getLogger().info("Returning page url: " + url);
        return url;
    }

    /**
     * Waits until page is loaded by checking page state using javascript
     *
     */
    protected void waitPageLoaded(){
        getActions().waitPageLoaded();
    }

    /**
     * Waits until page is loaded by checking expected element
     *
     */
    protected void pageLoadedElement(){
        getActions().waitElementForVisibility(bodyElement);
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait() {
        return wait;
    }

    protected BrowserActions getActions(){
        return browserActions;
    }

    protected Logger getLogger(){
        return logger;
    }

}
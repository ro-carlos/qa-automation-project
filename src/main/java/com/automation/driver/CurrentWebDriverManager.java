package com.automation.driver;

import org.openqa.selenium.WebDriver;

public class CurrentWebDriverManager {
    private static CurrentWebDriverManager instance;
    private static ThreadLocal<WebDriver> webDriverThreadLocal;

    private CurrentWebDriverManager() {
        webDriverThreadLocal = new ThreadLocal<>();
    }

    public static CurrentWebDriverManager getInstance(){
        if (instance == null){
            synchronized (CurrentWebDriverManager.class){
                if (instance == null){
                    instance = new CurrentWebDriverManager();
                }
            }
        }
        return instance;
    }

    public WebDriver getWebDriver(){
        return webDriverThreadLocal.get();
    }

    public void setWebDriver(WebDriver webDriver){
        webDriverThreadLocal.set(webDriver);
    }

    public void removeWebDriver(){
        webDriverThreadLocal.remove();
    }

}
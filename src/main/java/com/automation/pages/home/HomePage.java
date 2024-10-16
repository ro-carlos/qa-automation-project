package com.automation.pages.home;

import com.automation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private By cookiesBannerLocator = By.cssSelector("#onetrust-group-container");
    private By loadingSpinnerLocator =  By.cssSelector( ".overlay__spinner");

    @FindBy(xpath = "//a[text()='Ver otros productos']")
    private WebElement viewOtherProductsButton;

    @FindBy(css = "#onetrust-accept-btn-handler")
    private WebElement acceptCookiesButton;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    protected void pageLoadedElement(){
        getActions().waitElementForVisibility(viewOtherProductsButton);
    }

    public void navigateToCalculatorPage() {
        getActions().waitAndClick(viewOtherProductsButton);
    }

    public void acceptCookiesIfPresent() {
        if (getActions().isLocatorPresent(cookiesBannerLocator)) {
            getActions().waitAndClick(acceptCookiesButton);
            getActions().waitLocatorForInvisibility(cookiesBannerLocator);
        }
    }

    public boolean isLoadingSpinnerVisible() {
        return getActions().isLocatorPresent(loadingSpinnerLocator);
    }

    public void waitForLoadingSpinnerToDisappear(){
        if(isLoadingSpinnerVisible()){
            getActions().waitLocatorForInvisibility(loadingSpinnerLocator);
        }
    }
}

package com.automation.pages.quotation;

import com.automation.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage {

    @FindBy(css = ".v2-travel__checkout")
    private WebElement checkoutContainer;

    @FindBy(css = ".v2-travel__details")
    private WebElement travelersDetailsContainer;

    public CheckoutPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    protected void pageLoadedElement(){
        getActions().waitElementForVisibility(checkoutContainer);
    }

    public boolean isTravelersDetailsVisible() {
        return getActions().isElementPresent(travelersDetailsContainer);
    }
}

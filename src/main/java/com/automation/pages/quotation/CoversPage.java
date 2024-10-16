package com.automation.pages.quotation;

import com.automation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoversPage extends BasePage {

    private String CHOOSE_INSURANCE_PLAN_BY_INDEX_TEMPLATE = ".card-v2:nth-child(%s) .footer__button > button";

    @FindBy(css = ".quoting__summary")
    private WebElement quotingSummaryContainer;

    public CoversPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    protected void pageLoadedElement(){
        getActions().waitElementForVisibility(quotingSummaryContainer);
    }

    public void selectInsurancePlan(int index) {
        getActions().waitAndClick(By.cssSelector(String.format(CHOOSE_INSURANCE_PLAN_BY_INDEX_TEMPLATE, index)));
    }

}

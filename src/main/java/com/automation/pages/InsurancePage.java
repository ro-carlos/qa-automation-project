package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsurancePage extends BasePage{

    @FindBy(xpath = "//button[text()='Calcula tu seguro']")
    private WebElement calculateInsuranceButton;

    public InsurancePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    protected void pageLoadedElement(){
        getActions().waitElementForVisibility(calculateInsuranceButton);
    }

    public WebElement getCalculateInsuranceButton() {
        return calculateInsuranceButton;
    }
}

package com.automation.pages.quotation;

import com.automation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelersPage extends BasePage {

    @FindBy(css = ".page.travelers")
    private WebElement travelersContainer;

    @FindBy(id = "policyHolder.first_name")
    private WebElement firstNameInput;

    @FindBy(id = "policyHolder.last_name")
    private WebElement lastNameInput;

    @FindBy(id = "policyHolder.birth_date")
    private WebElement dateOfBirth;

    @FindBy(id = "policyHolder.national_identification_number")
    private WebElement dniNieInput;

    @FindBy(id = "policyHolder.address.street_address")
    private WebElement addressInput;

    @FindBy(id = "policyHolder.address.city")
    private WebElement cityInput;

    @FindBy(id = "policyHolder.address.postal_code")
    private WebElement postCodeInput;

    @FindBy(id = "policyHolder.phone.number")
    private WebElement phoneInput;

    @FindBy(id = "policyHolder.email")
    private WebElement emailInput;

    @FindBy(xpath = "//input[starts-with(@id, 'consents.DISCLAIMER_')]")
    private WebElement policyholderCheckbox;

    @FindBy(xpath = "//button[contains(@class, 'buttonSubmit')]")
    private WebElement continueButton;

    public TravelersPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    protected void pageLoadedElement(){
        getActions().waitElementForVisibility(travelersContainer);
    }

    public void enterTreatment(String treatment){
        getActions().waitAndClick(By.xpath("//input[@value='" + treatment + "']"));
    }

    public void enterFirstName(String name){
        getActions().enterText(firstNameInput, name);
    }

    public void enterLastName(String lastName){
        getActions().enterText(lastNameInput, lastName);
    }

    public void enterDateOfBirth(String birthDay){
        getActions().enterText(dateOfBirth, birthDay);
    }

    public void enterDniNie(String dniNie){
        getActions().enterText(dniNieInput, dniNie);
    }

    public void enterAddress(String address){
        getActions().enterText(addressInput, address);
    }

    public void enterCity(String city){
        getActions().enterText(cityInput, city);
    }

    public void enterPostCode(String postCode){
        getActions().enterText(postCodeInput, postCode);
    }

    public void enterPhone(String phone){
        getActions().enterText(phoneInput, phone);
    }

    public void enterEmail(String email){
        getActions().enterText(emailInput, email);
    }

    public void confirmPolicyholderIsTraveler(){
        getActions().waitAndClick(policyholderCheckbox);
    }

    public void navigateToCheckout(){
        getActions().waitAndClick(continueButton);
    }
}
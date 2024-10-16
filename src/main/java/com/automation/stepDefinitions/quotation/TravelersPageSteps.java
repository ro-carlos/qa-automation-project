package com.automation.stepDefinitions.quotation;

import com.automation.driver.CurrentWebDriverManager;
import com.automation.pages.quotation.TravelersPage;
import com.automation.stepDefinitions.home.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

import java.util.Map;

public class TravelersPageSteps {

    private TravelersPage travelersPage;

    @And("I fill out the form with the following traveler details:")
    public void iFillOutTheFormWithTheFollowingTravelerDetails(DataTable dataTable) {
        travelersPage = new TravelersPage(CurrentWebDriverManager.getInstance().getWebDriver(), Hooks.getWait());

        Map<String, String> travelerDetails = dataTable.asMap(String.class, String.class);

        travelersPage.enterTreatment(travelerDetails.get("Treatment"));
        travelersPage.enterFirstName(travelerDetails.get("Name"));
        travelersPage.enterLastName(travelerDetails.get("Last Name"));
        travelersPage.enterDateOfBirth(travelerDetails.get("Date of Birth"));
        travelersPage.enterDniNie(travelerDetails.get("DNI/NIE"));
        travelersPage.enterAddress(travelerDetails.get("Address"));
        travelersPage.enterCity(travelerDetails.get("City"));
        travelersPage.enterPostCode(travelerDetails.get("Post Code"));
        travelersPage.enterPhone(travelerDetails.get("Phone"));
        travelersPage.enterEmail(travelerDetails.get("Email"));
    }

    @And("I confirm that the policyholder is the traveler")
    public void iConfirmThatThePolicyholderIsTheTraveler() {
        travelersPage.confirmPolicyholderIsTraveler();
    }

    @And("I continue to checkout page")
    public void iContinueToCheckout() {
        travelersPage.navigateToCheckout();
    }

}
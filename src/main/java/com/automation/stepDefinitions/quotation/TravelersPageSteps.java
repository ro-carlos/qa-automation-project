package com.automation.stepDefinitions.quotation;

import com.automation.base.BaseTest;
import com.automation.pages.quotation.TravelersPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.Map;

public class TravelersPageSteps extends BaseTest {

    private TravelersPage travelersPage;

    @Before
    public void setUp() {
        initializeTest();
    }

    @And("I fill out the form with the following traveler details:")
    public void iFillOutTheFormWithTheFollowingTravelerDetails(DataTable dataTable) {
        travelersPage = new TravelersPage(driver, wait);

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

    @After
    public void tearDown() {
        cleanUpTest();
    }
}
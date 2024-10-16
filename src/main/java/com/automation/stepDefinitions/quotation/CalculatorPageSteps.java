package com.automation.stepDefinitions.quotation;

import com.automation.base.BaseTest;
import com.automation.pages.quotation.CalculatorPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;

public class CalculatorPageSteps extends BaseTest {

    private CalculatorPage calculatorPage;

    @Before
    public void setUp() {
        // Initialize driver and browser in Cucumber's Before hook
        initializeTest();
        calculatorPage = new CalculatorPage(driver, wait);
    }

    @And("I select the travel type {string}")
    public void iSelectTheTravelType(String travelType) {
        calculatorPage.selectTravelType(travelType);
    }

    @And("I choose the destination {string}")
    public void iChooseTheDestination(String destination) {
        calculatorPage.selectDestination(destination);
    }

    @And("I select the current date and 2 weeks later")
    public void iSelectStartDateAndEndDate() {
        calculatorPage.enterDateRange(0, 15);
    }


    @And("I click on Ver Presupuesto")
    public void iClickOnViewBudget() {
        calculatorPage.clickOnViewBudget();
    }

    @After
    public void tearDown() {
        cleanUpTest();
    }
}
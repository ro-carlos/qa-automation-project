package com.automation.stepDefinitions.quotation;

import com.automation.driver.CurrentWebDriverManager;
import com.automation.pages.quotation.CalculatorPage;
import com.automation.stepDefinitions.home.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CalculatorPageSteps {

    private CalculatorPage calculatorPage;

    @And("I select the travel type {string}")
    public void iSelectTheTravelType(String travelType) {
        calculatorPage = new CalculatorPage(CurrentWebDriverManager.getInstance().getWebDriver(), Hooks.getWait());
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

    @And("I select dates range {string} {string}")
    public void iEnterDate(String startDate, String endDate) {
        calculatorPage.enterDateRange(startDate+" - "+endDate);
    }

    @And("I click on Ver Presupuesto")
    public void iClickOnViewBudget() {
        calculatorPage.clickOnViewBudget();
    }

    @Then("I view the error modal")
    public void iViewTheErrorMessage() {
        Assert.assertTrue("Popup error should be visible",
                calculatorPage.isErrorMessageVisible());
    }

}
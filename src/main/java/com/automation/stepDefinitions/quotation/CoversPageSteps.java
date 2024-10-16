package com.automation.stepDefinitions.quotation;

import com.automation.driver.CurrentWebDriverManager;
import com.automation.pages.quotation.CoversPage;
import com.automation.stepDefinitions.home.Hooks;
import io.cucumber.java.en.Then;

public class CoversPageSteps {

    private CoversPage coversPage;


    @Then("I select the first insurance option")
    public void iSelectTheFirstInsuranceOption() {
        coversPage = new CoversPage(CurrentWebDriverManager.getInstance().getWebDriver(), Hooks.getWait());
        coversPage.selectInsurancePlan(1);
    }


}
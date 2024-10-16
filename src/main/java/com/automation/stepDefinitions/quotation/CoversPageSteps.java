package com.automation.stepDefinitions.quotation;

import com.automation.base.BaseTest;
import com.automation.pages.quotation.CoversPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;

public class CoversPageSteps extends BaseTest {

    private CoversPage coversPage;

    @Before
    public void setUp() {
        // Initialize driver and browser in Cucumber's Before hook
        initializeTest();
    }

    @Then("I select the first insurance option")
    public void iSelectTheFirstInsuranceOption() {
        coversPage = new CoversPage(driver, wait);
        coversPage.selectInsurancePlan(1);
    }

    @After
    public void tearDown() {
        cleanUpTest();
    }

}
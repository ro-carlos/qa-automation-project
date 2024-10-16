package com.automation.stepDefinitions.quotation;

import com.automation.base.BaseTest;
import com.automation.pages.quotation.CheckoutPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CheckoutPageSteps extends BaseTest {

    private CheckoutPage checkoutPage;

    @Before
    public void setUp() {
        // Initialize driver and browser in Cucumber's Before hook
        initializeTest();
    }

    @Then("I should be on the \"Pago\" page")
    public void iSelectTheFirstInsuranceOption() {
        checkoutPage = new CheckoutPage(driver, wait);

        boolean isTravelersDetailsVisible = checkoutPage.isTravelersDetailsVisible();
        Assert.assertTrue("The travelers details should be visible", isTravelersDetailsVisible);
    }

    @After
    public void tearDown() {
        cleanUpTest();
    }

}
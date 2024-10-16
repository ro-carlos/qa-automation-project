package com.automation.stepDefinitions.quotation;

import com.automation.driver.CurrentWebDriverManager;
import com.automation.pages.quotation.CheckoutPage;
import com.automation.stepDefinitions.home.Hooks;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CheckoutPageSteps {

    private CheckoutPage checkoutPage;


    @Then("I should be on the \"Pago\" page")
    public void iSelectTheFirstInsuranceOption() {
        checkoutPage = new CheckoutPage(CurrentWebDriverManager.getInstance().getWebDriver(), Hooks.getWait());

        boolean isTravelersDetailsVisible = checkoutPage.isTravelersDetailsVisible();
        Assert.assertTrue("The travelers details should be visible", isTravelersDetailsVisible);
    }

}
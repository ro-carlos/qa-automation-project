package com.automation.stepDefinitions.home;

import com.automation.base.BaseTest;
import com.automation.pages.home.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomePageSteps extends BaseTest {

    private HomePage homePage;

    @Before
    public void setUp() {
        // Initialize driver and browser in Cucumber's Before hook
        initializeTest();
    }

    @Given("I am on the home page")
    public void iAmOnTheHomePage()  {
        homePage = new HomePage(driver, wait);
    }

    @Given("I accept all cookies if available")
    public void iAcceptAllCookiesIfAvailable() {
        homePage.acceptCookiesIfPresent();
    }

    @When("I navigate to the calculator page")
    public void iClickOnViewOtherProducts() {
        homePage.navigateToCalculatorPage();
    }

    @Then("I should see the loading spinner")
    public void iShouldSeeTheLoadingSpinner() {
        boolean isSpinnerVisible = homePage.isLoadingSpinnerVisible();
        Assert.assertTrue("The loading spinner should be visible", isSpinnerVisible);
    }

    @When("the spinner disappears")
    public void iShouldSeeTheLoadingSpinnerDisappears() {
        homePage.waitForLoadingSpinnerToDisappear();
    }

    @After
    public void tearDown() {
        cleanUpTest();
    }

}
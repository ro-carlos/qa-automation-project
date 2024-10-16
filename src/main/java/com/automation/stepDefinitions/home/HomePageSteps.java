package com.automation.stepDefinitions.home;

import com.automation.driver.CurrentWebDriverManager;
import com.automation.pages.home.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomePageSteps {

    private HomePage homePage;

    @Given("I am on the home page")
    public void iAmOnTheHomePage()  {
        homePage = new HomePage(CurrentWebDriverManager.getInstance().getWebDriver(), Hooks.getWait());
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

}
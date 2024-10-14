package com.automation.stepDefinitions;

import com.automation.base.BaseTest;
import com.automation.pages.InsurancePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class QuoteInsuranceSteps extends BaseTest {

    private InsurancePage insurancePage;

    @Before
    public void setUp() {
        // Initialize driver and browser in Cucumber's Before hook
        initializeTest();
    }

    @Given("I am on the insurance page")
    public void iAmOnTheInsurancePage()  {
        insurancePage = new InsurancePage(driver, wait);
    }

    @When("I enter a start date")
    public void iEnterAValidStartDate() {
        //loginPage.login("username", "password");
    }

    @When("I enter a start date 2")
    public void iEnterAValidStartDate2() {
        //loginPage.login("username", "password");
        driver.get("https://www.google.com");
    }

    @Then("I should be on the results page")
    public void iShouldBeOnTheResultsPage() {
        //Assert.assertTrue(loginPage.getDriver().getCurrentUrl().contains("/dashboard"));
        long num = Math.round( Math.random() )  % 2;
        Assert.assertEquals(0, num % 2);
    }

    @After
    public void tearDown() {
        cleanUpTest();
    }

}
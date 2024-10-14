package com.automation.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",    // Correct path to your feature files
        glue = "com.automation.stepDefinitions",     // Step definitions package
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" // Updated plugin for Allure and Cucumber 7
        },
        monochrome = true
)
public class TestRunner {
}
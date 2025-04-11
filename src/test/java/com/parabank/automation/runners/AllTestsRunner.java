package com.parabank.automation.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber-reports/AllTestsReport.html",
                "json:target/cucumber-reports/AllTestsReport.json"
        },
        features = "src/test/resources/features", // All features
        glue = {
                "com.parabank.automation.stepdefinitions",
                "com.parabank.automation.hooks"
        },
        tags = "@BillPayment", // optional: run all or filter by tags
        publish = true,
        monochrome = true
)
public class AllTestsRunner {
}
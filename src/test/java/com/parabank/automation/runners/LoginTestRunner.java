package com.parabank.automation.runners;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/login", // or "classpath:features/login"
        glue = "com.parabank.automation.stepdefinitions",
        plugin = {"pretty"}
)
public class LoginTestRunner {}

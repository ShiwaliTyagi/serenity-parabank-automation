package com.parabank.automation.stepdefinitions;

import com.parabank.automation.context.TestContext;
import io.cucumber.java.en.Given;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.By;

public class ResetBankStepDefinitions {

    @Given("an admin resets the application to its initial state")
    public void resetApplication() {
        Actor actor = TestContext.getInstance().getActor();
        actor.attemptsTo(Open.url("https://parabank.parasoft.com/parabank/admin.htm"));

        actor.attemptsTo(
                Click.on(By.xpath("//input[@value='Clean']"))  // Adjust locator as needed
        );

        Serenity.recordReportData()
                .withTitle("Admin Action")
                .andContents("Application state reset via Admin page");
    }
}

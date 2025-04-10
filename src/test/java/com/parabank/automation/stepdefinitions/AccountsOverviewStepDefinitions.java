package com.parabank.automation.stepdefinitions;

import com.parabank.automation.context.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.parabank.automation.tasks.NavigateToAccountsOverview;
import com.parabank.automation.questions.AccountOverviewVisible;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class AccountsOverviewStepDefinitions {

    @When("he navigates to the Accounts Overview page")
    public void navigateToAccountsOverview() {
        TestContext.getInstance().getActor().attemptsTo(
                NavigateToAccountsOverview.page()
        );
    }

    @Then("he should see a list of accounts with balances")
    public void shouldSeeAccountList() {
        TestContext.getInstance().getActor().should(
                seeThat("Accounts are visible", AccountOverviewVisible.onPage())
        );
    }
}

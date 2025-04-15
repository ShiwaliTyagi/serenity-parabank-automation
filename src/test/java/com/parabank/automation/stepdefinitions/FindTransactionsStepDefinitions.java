package com.parabank.automation.stepdefinitions;

import com.parabank.automation.questions.TransactionVisible;
import com.parabank.automation.tasks.FindTransaction;
import com.parabank.automation.context.TestContext;
import com.parabank.automation.tasks.NavigateToFundTransfer;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class FindTransactionsStepDefinitions {

    @When("he searches for transactions with amount {string}")
    public void searchTransactions(String amount) {
        TestContext.getInstance().getActor().attemptsTo(
                FindTransaction.withAmount(amount)
        );
    }

    @Then("he should see the transaction listed in the results")
    public void verifyTransactionFound() {
        TestContext.getInstance().getActor().should(
                seeThat(TransactionVisible.inResults(), is(true))
        );
    }
}

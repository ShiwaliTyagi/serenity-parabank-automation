package com.parabank.automation.stepdefinitions;

import com.parabank.automation.context.TestContext;
import com.parabank.automation.questions.FundTransferConfirmationMessage;
import com.parabank.automation.tasks.NavigateToFundTransfer;
import com.parabank.automation.tasks.TransferFund;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.StringContains.containsString;

public class FundTransferStepDefinitions {

    public FundTransferStepDefinitions() {
        TestContext.getInstance().getActor().attemptsTo(NavigateToFundTransfer.page());
    }
    @And("he has transferred {string} to a new savings account")
    public void heTransfersFunds(String amount) {
        String toAccount = TestContext.getInstance().get("newAccountId");
        Actor actor = TestContext.getInstance().getActor();

        actor.attemptsTo(
                TransferFund.ofAmountToAccount(amount,toAccount)
        );
        TestContext.getInstance().set("fundTransferAmount", amount);
    }


    @Then("he should see a confirmation message for the fund transfer")
    public void heShouldSeeAConfirmationMessageForTheFundTransfer() {
        Actor actor = TestContext.getInstance().getActor();
        String expectedAmount = TestContext.getInstance().get("fundTransferAmount");
        actor.should(
                seeThat(FundTransferConfirmationMessage.displayedMessage(), containsString(expectedAmount))
        );
    }

}

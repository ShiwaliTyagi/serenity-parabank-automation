package com.parabank.automation.stepdefinitions;

import com.parabank.automation.questions.BillPaymentSuccessMessage;
import com.parabank.automation.tasks.NavigateToAccountsOverview;
import com.parabank.automation.tasks.NavigateToBillPayment;
import com.parabank.automation.tasks.PayBill;
import com.parabank.automation.context.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import com.parabank.automation.util.AccountOverviewUtils;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class BillPaymentStepDefinitions {

    @And("he navigates to the Bill Payment page")
    public void navigateToBillPaymentPage() {
        TestContext.getInstance().getActor().attemptsTo(NavigateToBillPayment.page());
    }


    @When("user pays bill with payee {string}, address {string}, city {string}, state {string}, zip {string}, phone {string}, account {string}, verifyAccount {string} with amount {string} from account {string}")
    public void userPaysBill(String payee, String address, String city, String state, String zip, String phone, String account, String verifyAccount, String amount, String fromAccountId) {
        if (fromAccountId.equalsIgnoreCase("dynamic")) {
            fromAccountId = TestContext.getInstance().get("defaultAccountId");
        }
        TestContext.getInstance().getActor().attemptsTo(
                PayBill.withDetails(payee, address, city, state, zip, phone, account, verifyAccount, amount, fromAccountId)
        );
    }



    @Then("user should see a success message with payee {string}, amount {string}, and account {string}")

    public void userShouldSeeSuccessMessage(String payee, String amount, String account) {
        if (account.equalsIgnoreCase("dynamic")) {
            account = TestContext.getInstance().get("defaultAccountId");
        }
        String expectedMessage = String.format("Bill Payment to %s in the amount of $%s.00 from account %s was successful.",
                payee, amount, account);

        TestContext.getInstance().getActor().should(
                seeThat("Displayed success message", BillPaymentSuccessMessage.text(), equalTo(expectedMessage))
        );
    }


    @And("he checks and saves the current balance of account {string}")
    public void saveInitialBalance(String accountId) {
        if (accountId.equalsIgnoreCase("dynamic")) {
            accountId = TestContext.getInstance().get("defaultAccountId");
        }
        // Log it in Serenity report
        Serenity.recordReportData()
                .withTitle("Initial accountid")
                .andContents(accountId);
        String balance = AccountOverviewUtils.getBalanceForAccount(accountId);
        TestContext.getInstance().set("initialBalance", balance);
        TestContext.getInstance().set("balanceAccountId", accountId);
        // Log it in Serenity report
        Serenity.recordReportData()
                .withTitle("Initial Balance")
                .andContents(balance);
    }

    @Then("the balance of account {string} should be reduced by {string}")
    public void verifyBalanceIsReduced(String accountId, String deductionAmount) {
        String initialBalance = TestContext.getInstance().get("initialBalance");
        if (accountId.equalsIgnoreCase("dynamic")) {
            accountId = TestContext.getInstance().get("defaultAccountId");
        }
        TestContext.getInstance().getActor().attemptsTo(NavigateToAccountsOverview.page());
        String finalBalance = AccountOverviewUtils.getBalanceForAccount(accountId);
        // Log it in Serenity report
        Serenity.recordReportData()
                .withTitle("Final Balance")
                .andContents(finalBalance);
        double initial = Double.parseDouble(initialBalance.replace("$", "").replace(",", ""));
        double finalBal = Double.parseDouble(finalBalance.replace("$", "").replace(",", ""));
        double expected = initial - Double.parseDouble(deductionAmount);

        Assert.assertEquals("Balance is not correctly deducted", expected, finalBal, 0.01);
    }



}

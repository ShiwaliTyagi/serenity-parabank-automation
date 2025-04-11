package com.parabank.automation.stepdefinitions;

import com.parabank.automation.questions.BillPaymentSuccessMessage;
import com.parabank.automation.tasks.NavigateToBillPayment;
import com.parabank.automation.tasks.PayBill;
import com.parabank.automation.context.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class BillPaymentStepDefinitions {

    @And("he navigates to the Bill Payment page")
    public void navigateToBillPaymentPage() {
        TestContext.getInstance().getActor().attemptsTo(NavigateToBillPayment.page());
    }


    @When("user pays bill with payee {string}, address {string}, city {string}, state {string}, zip {string}, phone {string}, account {string}, verifyAccount {string} with amount {string} from account {string}")
    public void userPaysBill(String payee, String address, String city, String state, String zip, String phone,
                             String account, String verifyAccount, String amount, String fromAccount) {

        TestContext.getInstance().getActor().attemptsTo(
                PayBill.withDetails(payee, address, city, state, zip, phone, account, verifyAccount, amount, fromAccount)
        );
    }



    @Then("user should see a success message with payee {string}, amount {string}, and account {string}")

    public void userShouldSeeSuccessMessage(String payee, String amount, String account) {
        String expectedMessage = String.format("Bill Payment to %s in the amount of $%s.00 from account %s was successful.",
                payee, amount, account);

        TestContext.getInstance().getActor().should(
                seeThat("Displayed success message", BillPaymentSuccessMessage.text(), equalTo(expectedMessage))
        );
    }


}

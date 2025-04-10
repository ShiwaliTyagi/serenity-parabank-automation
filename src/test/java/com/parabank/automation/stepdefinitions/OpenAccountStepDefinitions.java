package com.parabank.automation.stepdefinitions;
import com.parabank.automation.tasks.Login;
import com.parabank.automation.tasks.OpenNewAccount;
import com.parabank.automation.userinterfaces.OpenAccountPage;
import io.cucumber.java.en.*;
import com.parabank.automation.context.TestContext;
import static org.assertj.core.api.Assertions.assertThat;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actions.Open;


public class OpenAccountStepDefinitions {

    @Given("John is logged into the ParaBank application")
    public void johnIsLoggedIn() {
        TestContext context = TestContext.getInstance();
        context.getActor().wasAbleTo(
                Open.url("https://parabank.parasoft.com/parabank/index.htm"),
                Login.withCredentials("shiwi", "India@123")
        );
    }

    @When("he opens a new Savings account with a source account")
    public void heOpensNewAccount() {
        TestContext.getInstance().getActor().attemptsTo(OpenNewAccount.successfully());
    }

    @Then("he should see a confirmation message with the new account ID")
    public void heShouldSeeConfirmation() {
        String confirmation = OpenAccountPage.CONFIRMATION_TEXT
                .resolveFor(TestContext.getInstance().getActor()).getText();
        assertThat(confirmation).contains("Congratulations");
        String accountID = OpenAccountPage.NEW_ACCOUNT_ID.resolveFor(TestContext.getInstance().getActor()).getText();
        assertThat(accountID).isNotBlank();
        Serenity.recordReportData()
                .withTitle("New Account ID")
                .andContents(accountID);
    }
}

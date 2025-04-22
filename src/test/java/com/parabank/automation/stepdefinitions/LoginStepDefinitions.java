package com.parabank.automation.stepdefinitions;

import com.parabank.automation.questions.AccountOverviewVisible;
import com.parabank.automation.tasks.Login;
import com.parabank.automation.tasks.RegisterNewUser;
import io.cucumber.java.en.*;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import com.parabank.automation.context.TestContext;
import com.parabank.automation.userinterfaces.AccountOverviewPage;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class LoginStepDefinitions {

    @Given("the user is on the ParaBank login page")
    public void theUserIsOnTheParaBankLoginPage() {
        TestContext.getInstance().getActor().attemptsTo(
                Open.url("https://parabank.parasoft.com/parabank/index.htm")
        );
    }

    @When("the user logs in with username {string} and password {string}")
    public void theUserLogsInWithCredentials(String username, String password) {
        TestContext.getInstance().getActor().attemptsTo(
                Login.withCredentials(username, password)
        );
        // Wait and extract the first account number dynamically
        String accountId = AccountOverviewPage.FIRST_ACCOUNT_LINK
                .resolveFor(TestContext.getInstance().getActor())
                .getText();
        TestContext.getInstance().set("defaultAccountId", accountId);
        // Log it in Serenity report
        Serenity.recordReportData()
                .withTitle("Default Account ID")
                .andContents(accountId);
    }

    @Then("the user should see the account overview page")
    public void theUserShouldSeeTheAccountOverviewPage() {
        TestContext context = TestContext.getInstance();
        context.getActor().should(
                seeThat(AccountOverviewVisible.displayed(), is(true))
        );
    }

    @Given("a new user is registered and logged in")
    public void registerAndLoginUser() {
        Actor actor = TestContext.getInstance().getActor();
        actor.attemptsTo(RegisterNewUser.dynamically());

        String username = TestContext.getInstance().get("username");
        String password = TestContext.getInstance().get("password");

        actor.attemptsTo(Login.withCredentials(username, password));
    }

}

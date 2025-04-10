package com.parabank.automation.stepdefinitions;

import com.parabank.automation.questions.AccountOverviewVisible;
import com.parabank.automation.tasks.Login;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Open;
import com.parabank.automation.context.TestContext;


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

    }

    @Then("the user should see the account overview page")
    public void theUserShouldSeeTheAccountOverviewPage() {
        TestContext context = TestContext.getInstance();
        context.getActor().should(
                seeThat(AccountOverviewVisible.displayed(), is(true))
        );
    }

}

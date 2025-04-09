package com.parabank.automation.stepdefinitions;

import com.parabank.automation.questions.AccountOverviewVisible;
import com.parabank.automation.tasks.Login;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.core.Serenity.getDriver;
import com.parabank.automation.util.DriverFactory;
import org.openqa.selenium.WebDriver;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class LoginStepDefinitions {
    private WebDriver driver;
    private DriverFactory driverFactory;

    @Before
    public void set_the_stage() {
        // Initialize DriverFactory and get the WebDriver instance
        driverFactory = new DriverFactory();
        driver = driverFactory.getDriver();  // Get the driver from DriverFactory

        // Set the actor's ability to browse the web with the WebDriver instance
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("the user is on the ParaBank login page")
    public void theUserIsOnTheParaBankLoginPage() {
        // Create an actor and give them the ability to browse the web with the driver
        theActorCalled("User").can(BrowseTheWeb.with(driver));
        theActorInTheSpotlight().wasAbleTo(Open.url("https://parabank.parasoft.com/parabank/index.htm"));
    }

    @When("the user logs in with username {string} and password {string}")
    public void theUserLogsInWithCredentials(String username, String password) {
        // The actor attempts to execute the Login task using the provided credentials
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withCredentials(username, password)
        );
    }

    @Then("the user should see the account overview page")
    public void theUserShouldSeeTheAccountOverviewPage() {
        // The actor verifies that the account overview is visible
        OnStage.theActorInTheSpotlight().should(
                seeThat(AccountOverviewVisible.displayed(), is(true))
        );
    }

    @After
    public void tearDown() {
        driver.quit();  // Quit the driver after each test
    }
}

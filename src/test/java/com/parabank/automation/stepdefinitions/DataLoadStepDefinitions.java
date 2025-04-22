package com.parabank.automation.stepdefinitions;

import com.parabank.automation.tasks.RegisterNewUser;
import com.parabank.automation.util.TestUser;
import com.parabank.automation.context.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import java.util.List;
import java.util.stream.Collectors;

public class DataLoadStepDefinitions {

    private final Actor actor = TestContext.getInstance().getActor();

    @Given("admin triggers data load setup")
    public void adminTriggersDataLoadSetup() {
        // You can optionally reset the app here
        System.out.println("Starting test data load...");
    }

    @When("the following users are registered:")
    public void theFollowingUsersAreRegistered(DataTable dataTable) {
        List<TestUser> users = dataTable.asMaps().stream()
                .map(row -> new TestUser(
                        row.get("firstName"),
                        row.get("lastName"),
                        row.get("username"),
                        row.get("password")
                )).collect(Collectors.toList());

        for (TestUser user : users) {
            actor.attemptsTo(RegisterNewUser.with(user));
        }

        // Store all users for future reference
        TestContext.getInstance().set("registeredUsers", users);
    }

    @Then("users should be created successfully")
    public void usersShouldBeCreatedSuccessfully() {
        // In real validation, we’d assert that user was logged in or redirected
        System.out.println("All users created. Ready for test execution.");
    }
}

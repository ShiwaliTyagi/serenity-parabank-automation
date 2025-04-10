package com.parabank.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import com.parabank.automation.userinterfaces.NavigationBar;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavigateToAccountsOverview implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(NavigationBar.ACCOUNTS_OVERVIEW)
        );
    }

    // Create a static method to instantiate this Task via instrumented
    public static NavigateToAccountsOverview page() {
        return instrumented(NavigateToAccountsOverview.class);
    }
}

package com.parabank.automation.tasks;

import com.parabank.automation.userinterfaces.OpenAccountPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenNewAccount implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(OpenAccountPage.OPEN_ACCOUNT_LINK),
                SelectFromOptions.byVisibleText("SAVINGS").from(OpenAccountPage.ACCOUNT_TYPE_DROPDOWN),
                SelectFromOptions.byIndex(0).from(OpenAccountPage.SOURCE_ACCOUNT_DROPDOWN),
                Click.on(OpenAccountPage.OPEN_NEW_ACCOUNT_BUTTON)
        );
    }

    public static OpenNewAccount successfully() {
        return instrumented(OpenNewAccount.class);
    }
}

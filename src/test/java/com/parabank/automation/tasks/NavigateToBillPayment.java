package com.parabank.automation.tasks;

import com.parabank.automation.userinterfaces.NavigationBar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavigateToBillPayment implements Task{

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(NavigationBar.BILL_PAYMENT)
        );
    }
    // Create a static method to instantiate this Task via instrumented
    public static NavigateToBillPayment page() {
        return instrumented(NavigateToBillPayment.class);
    }
}

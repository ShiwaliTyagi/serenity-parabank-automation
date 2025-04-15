package com.parabank.automation.tasks;

import com.parabank.automation.userinterfaces.FindTransactionsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actions.Click.on;
import static net.serenitybdd.screenplay.actions.Enter.theValue;

public class FindTransaction implements Task {

    private final String amount;

    public FindTransaction(String amount) {
        this.amount = amount;
    }

    public static FindTransaction withAmount(String amount) {
        return instrumented(FindTransaction.class, amount);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                on(FindTransactionsPage.SIDE_NAV_FIND_TRANSACTIONS),
                theValue(amount).into(FindTransactionsPage.AMOUNT_INPUT),
                on(FindTransactionsPage.AMOUNT_SEARCH_BUTTON)
        );
    }
}

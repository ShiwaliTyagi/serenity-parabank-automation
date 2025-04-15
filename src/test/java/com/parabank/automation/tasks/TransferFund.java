package com.parabank.automation.tasks;


import com.parabank.automation.userinterfaces.TransferFundsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class TransferFund implements Task {
    private final String amount;
    private final String toAccount;

    public TransferFund(String amount, String toAccount) {
        this.amount = amount;
        this.toAccount = toAccount;
    }

    public static TransferFund ofAmountToAccount(String amount, String toAccount) {
        return instrumented(TransferFund.class, amount, toAccount);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(amount).into(TransferFundsPage.AMOUNT_INPUT),
                SelectFromOptions.byIndex(0).from(TransferFundsPage.FROM_ACCOUNT_DROPDOWN),
                SelectFromOptions.byValue(toAccount).from(TransferFundsPage.TO_ACCOUNT_DROPDOWN),
                Click.on(TransferFundsPage.TRANSFER_BUTTON)
        );
    }

}

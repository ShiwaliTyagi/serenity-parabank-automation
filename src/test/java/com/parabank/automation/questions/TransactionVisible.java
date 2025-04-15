package com.parabank.automation.questions;

import com.parabank.automation.userinterfaces.FindTransactionsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TransactionVisible implements Question<Boolean> {

    public static TransactionVisible inResults() {
        return new TransactionVisible();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return FindTransactionsPage.RESULTS_TABLE.resolveFor(actor).isVisible();
    }
}

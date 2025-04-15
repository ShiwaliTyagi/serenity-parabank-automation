package com.parabank.automation.questions;

import com.parabank.automation.userinterfaces.TransferFundsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class FundTransferConfirmationMessage {

    public static Question<String> displayedMessage() {
        return new Question<String>() {
            @Override
            public String answeredBy(Actor actor) {
                return TransferFundsPage.CONFIRMATION_MESSAGE.resolveFor(actor).getText();
            }
        };
    }
}

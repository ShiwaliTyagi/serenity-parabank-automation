package com.parabank.automation.questions;

import com.parabank.automation.userinterfaces.OpenAccountPage;
import net.serenitybdd.screenplay.Question;

public class NewlyOpenedAccount {

    public static Question<String> id() {
        return actor -> OpenAccountPage.NEW_ACCOUNT_ID.resolveFor(actor).getText();
    }
}


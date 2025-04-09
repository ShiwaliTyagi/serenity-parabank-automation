package com.parabank.automation.questions;

import com.parabank.automation.userinterfaces.AccountOverviewPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class AccountOverviewVisible {

    public static Question<Boolean> displayed() {
        return Visibility.of(AccountOverviewPage.OVERVIEW_TITLE).asBoolean();
    }
}
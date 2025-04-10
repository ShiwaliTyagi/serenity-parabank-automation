package com.parabank.automation.questions;

import com.parabank.automation.context.TestContext;
import com.parabank.automation.userinterfaces.AccountOverviewPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class AccountOverviewVisible {

    public static Question<Boolean> displayed() {
        return Visibility.of(AccountOverviewPage.OVERVIEW_TITLE).asBoolean();
    }
    public static Question<Boolean> onPage() {
        return actor -> {
            // Get the singleton actor from TestContext
            actor = TestContext.getInstance().getActor();

            // Explicit wait for the element to become visible
            actor.attemptsTo(
                    WaitUntil.the(AccountOverviewPage.OVERVIEW_TABLE, isVisible()).forNoMoreThan(10).seconds()
            );

            // Check visibility after waiting
            return Visibility.of(AccountOverviewPage.OVERVIEW_TABLE).answeredBy(actor);
        };
    }

}
package com.parabank.automation.util;

import com.parabank.automation.context.TestContext;
import com.parabank.automation.userinterfaces.AdminPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

public class AdminResetUtil extends UIInteractions {

    private static final String ADMIN_URL = "https://parabank.parasoft.com/parabank/admin.htm";

    public static void resetApplicationState() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.attemptsTo(
                Click.on(AdminPage.ADMIN_PAGE_LINK),
                Click.on(AdminPage.RESET_BUTTON)
        );

        Serenity.recordReportData()
                .withTitle("Admin Action")
                .andContents("Application reset using Admin page before test execution");
    }
}

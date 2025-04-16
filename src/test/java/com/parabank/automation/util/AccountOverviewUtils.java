package com.parabank.automation.util;

import com.google.common.base.Preconditions;
import com.parabank.automation.context.TestContext;
import com.parabank.automation.userinterfaces.AccountOverviewPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class AccountOverviewUtils {

    public static String getBalanceForAccount(String accountId) {
        Preconditions.checkNotNull(accountId, "Account ID must not be null");

        Actor actor = TestContext.getInstance().getActor();
        Target balanceLocator = AccountOverviewPage.BALANCE_FOR_ACCOUNT(accountId);

        String balance = actor.asksFor(Text.of(balanceLocator));

        // Log in serenity report
        Serenity.recordReportData().withTitle("Fetched Balance for " + accountId).andContents(balance);

        return balance;
    }
}

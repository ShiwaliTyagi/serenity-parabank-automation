package com.parabank.automation.questions;

import com.parabank.automation.userinterfaces.AccountOverviewPage;
import com.parabank.automation.context.TestContext;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountRowsAreComplete {
    public static Question<Boolean> check() {
        return actor -> {
            List<WebElementFacade> rows = AccountOverviewPage.ACCOUNT_ROWS.resolveAllFor(TestContext.getInstance().getActor());

            for (WebElementFacade row : rows) {
                List<WebElement> columns = row.findElements(By.tagName("td"));
                for (WebElement col : columns) {
                    if (col.getText().trim().isEmpty()) {
                        return false;
                    }
                }
            }
            return true;
        };
    }
}

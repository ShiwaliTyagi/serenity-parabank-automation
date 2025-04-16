package com.parabank.automation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AccountOverviewPage {
    public static final Target OVERVIEW_TITLE = Target.the("Account Overview title")
            .located(By.xpath("(//h1[@class='title'])[1]"));

    public static final Target OVERVIEW_TABLE = Target.the("Account Overview TABLE")
            .located(By.xpath("table[id='accountTable']"));

    public static final Target ACCOUNT_ROWS = Target.the("account table rows")
            .located(By.cssSelector("#accountTable tbody tr"));

    public static final Target FIRST_ACCOUNT_LINK = Target
            .the("First account number on account overview")
            .located(By.cssSelector("#accountTable tbody tr:first-child td a"));

    public static Target BALANCE_FOR_ACCOUNT(String accountId) {
        return Target.the("Balance for account " + accountId)
                .located(By.xpath("//a[text()='" + accountId + "']/parent::td/following-sibling::td[1]"));
    }

}
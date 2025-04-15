package com.parabank.automation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FindTransactionsPage {
    public static final Target SIDE_NAV_FIND_TRANSACTIONS = Target.the("Find Transactions navigation link")
            .located(By.linkText("Find Transactions"));

    public static final Target AMOUNT_INPUT = Target.the("Amount input field")
            .located(By.id("amount"));

    public static final Target AMOUNT_SEARCH_BUTTON = Target.the("Amount Find Transactions button")
            .located(By.xpath("//button[@id='findByAmount']"));

    public static final Target RESULTS_TABLE = Target.the("Transaction results table")
            .located(By.id("transactionTable"));
}

package com.parabank.automation.userinterfaces;
import net.serenitybdd.screenplay.targets.Target;

public class NavigationBar {
    public static final Target ACCOUNTS_OVERVIEW = Target.the("Accounts Overview link")
            .locatedBy("//a[text()='Accounts Overview']");
    public static final Target BILL_PAYMENT = Target.the("Bill Payment link")
            .locatedBy("//a[text()='Bill Pay']");
    public static final Target FUND_TRANSFER = Target.the("Fund Transfer link")
            .locatedBy("//a[text()='Transfer Funds']");
    public static final Target FIND_TRANSACTIONS = Target.the("Find Transactions link")
            .locatedBy("//a[text()='Find Transactions']");
}

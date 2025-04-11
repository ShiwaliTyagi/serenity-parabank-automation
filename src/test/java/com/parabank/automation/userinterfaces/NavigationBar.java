package com.parabank.automation.userinterfaces;
import net.serenitybdd.screenplay.targets.Target;

public class NavigationBar {
    public static final Target ACCOUNTS_OVERVIEW = Target.the("Accounts Overview link")
            .locatedBy("//a[text()='Accounts Overview']");
    public static final Target BILL_PAYMENT = Target.the("Bill Payment link")
            .locatedBy("//a[text()='Bill Pay']");
}

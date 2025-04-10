package com.parabank.automation.userinterfaces;
import net.serenitybdd.screenplay.targets.Target;

public class NavigationBar {
    public static final Target ACCOUNTS_OVERVIEW = Target.the("Accounts Overview link")
            .locatedBy("//a[text()='Accounts Overview']");
}

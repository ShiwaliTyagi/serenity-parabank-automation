package com.parabank.automation.userinterfaces;
import net.serenitybdd.screenplay.targets.Target;


public class OpenAccountPage {
    public static final Target OPEN_ACCOUNT_LINK = Target.the("Open New Account Link")
            .locatedBy("//a[@href='openaccount.htm']");

    public static final Target ACCOUNT_TYPE_DROPDOWN = Target.the("Account type dropdown")
            .locatedBy("#type");

    public static final Target SOURCE_ACCOUNT_DROPDOWN = Target.the("Source account dropdown")
            .locatedBy("#fromAccountId");

    public static final Target OPEN_NEW_ACCOUNT_BUTTON = Target.the("Open New Account button")
            .locatedBy("//input[@value='Open New Account']");

    public static final Target CONFIRMATION_TEXT = Target.the("Confirmation message")
            .locatedBy("(//h1[@class='title' and text()='Account Opened!']/following::p)[1]");

    public static final Target NEW_ACCOUNT_ID = Target.the("New Account ID")
            .locatedBy("a[href*='activity.htm?id=']");
}

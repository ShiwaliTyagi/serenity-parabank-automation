package com.parabank.automation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TransferFundsPage {

    public static final Target SIDE_NAV_TRANSFER_FUNDS = Target.the("Transfer Funds navigation link")
            .located(By.linkText("Transfer Funds"));

    public static final Target AMOUNT_INPUT = Target.the("Amount input field")
            .located(By.id("amount"));

    public static final Target FROM_ACCOUNT_DROPDOWN = Target.the("From Account dropdown")
            .located(By.id("fromAccountId"));

    public static final Target TO_ACCOUNT_DROPDOWN = Target.the("To Account dropdown")
            .located(By.id("toAccountId"));

    public static final Target TRANSFER_BUTTON = Target.the("Transfer button")
            .located(By.xpath("//input[@value='Transfer']"));

    public static final Target CONFIRMATION_MESSAGE = Target.the("confirmation message")
            .located(By.xpath("//span[@id='amountResult']"));

}

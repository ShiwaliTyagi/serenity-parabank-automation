package com.parabank.automation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BillPaymentPage {
    public static final Target PAYEE_NAME = Target.the("Payee Name").located(By.name("payee.name"));
    public static final Target PAYEE_ADDRESS = Target.the("Address").located(By.name("payee.address.street"));
    public static final Target PAYEE_CITY = Target.the("City").located(By.name("payee.address.city"));
    public static final Target PAYEE_STATE = Target.the("State").located(By.name("payee.address.state"));
    public static final Target PAYEE_ZIP = Target.the("Zip Code").located(By.name("payee.address.zipCode"));
    public static final Target PAYEE_PHONE = Target.the("Phone Number").located(By.name("payee.phoneNumber"));
    public static final Target ACCOUNT_NUMBER = Target.the("Account Number").located(By.name("payee.accountNumber"));
    public static final Target VERIFY_ACCOUNT = Target.the("Verify Account").located(By.name("verifyAccount"));
    public static final Target AMOUNT = Target.the("Amount").located(By.name("amount"));
    public static final Target FROM_ACCOUNT = Target.the("From Account").located(By.name("fromAccountId"));
    public static final Target SEND_PAYMENT = Target.the("Send Payment").located(By.xpath("//input[@value='Send Payment']"));
    public static final Target CONFIRMATION_MESSAGE = Target.the("bill payment success message")
            .located(By.xpath("(//div[@id='billpayResult']/p)[1]")); // or use XPath if needed

}


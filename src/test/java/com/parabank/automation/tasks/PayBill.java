package com.parabank.automation.tasks;

import com.parabank.automation.userinterfaces.BillPaymentPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class PayBill implements Task {

    private final String payee, address, city, state, zip, phone;
    private final String account, verifyAccount, amount, fromAccount;

    public PayBill(String payee, String address, String city, String state, String zip, String phone,
                   String account, String verifyAccount, String amount, String fromAccount) {
        this.payee = payee;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.account = account;
        this.verifyAccount = verifyAccount;
        this.amount = amount;
        this.fromAccount = fromAccount;
    }

    public static PayBill withDetails(String payee, String address, String city, String state, String zip, String phone,
                                      String account, String verifyAccount, String amount, String fromAccount) {
        return Tasks.instrumented(PayBill.class, payee, address, city, state, zip, phone, account, verifyAccount, amount, fromAccount);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(payee).into(BillPaymentPage.PAYEE_NAME),
                Enter.theValue(address).into(BillPaymentPage.PAYEE_ADDRESS),
                Enter.theValue(city).into(BillPaymentPage.PAYEE_CITY),
                Enter.theValue(state).into(BillPaymentPage.PAYEE_STATE),
                Enter.theValue(zip).into(BillPaymentPage.PAYEE_ZIP),
                Enter.theValue(phone).into(BillPaymentPage.PAYEE_PHONE),
                Enter.theValue(account).into(BillPaymentPage.ACCOUNT_NUMBER),
                Enter.theValue(verifyAccount).into(BillPaymentPage.VERIFY_ACCOUNT),
                Enter.theValue(amount).into(BillPaymentPage.AMOUNT),
                SelectFromOptions.byValue(fromAccount).from(BillPaymentPage.FROM_ACCOUNT),
                Click.on(BillPaymentPage.SEND_PAYMENT)
        );
    }
}
package com.parabank.automation.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import com.parabank.automation.userinterfaces.BillPaymentPage;

public class BillPaymentSuccessMessage{

    public static Question<String> text() {
        return actor -> BillPaymentPage.CONFIRMATION_MESSAGE.resolveFor(actor).getText();
    }

}

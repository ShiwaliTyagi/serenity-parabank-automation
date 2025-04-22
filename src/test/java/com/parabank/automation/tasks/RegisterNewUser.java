package com.parabank.automation.tasks;

import com.parabank.automation.userinterfaces.RegistrationPage;
import com.parabank.automation.util.TestUser;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegisterNewUser implements Task {
    private final TestUser user;

    public RegisterNewUser(TestUser user) {
        this.user = user;
    }

    public static RegisterNewUser with(TestUser user) {
        return instrumented(RegisterNewUser.class, user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(RegistrationPage.REGISTER_LINK),
                Enter.theValue(user.firstName()).into(RegistrationPage.FIRST_NAME),
                Enter.theValue(user.lastName()).into(RegistrationPage.LAST_NAME),
                Enter.theValue(user.username()).into(RegistrationPage.USERNAME),
                Enter.theValue(user.password()).into(RegistrationPage.PASSWORD),
                Enter.theValue(user.password()).into(RegistrationPage.CONFIRM_PASSWORD),
                Click.on(RegistrationPage.REGISTER_BUTTON)
        );
    }
}

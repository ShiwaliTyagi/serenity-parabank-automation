package com.parabank.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.Tasks;
import static com.parabank.automation.userinterfaces.LoginPage.*;

public class Login implements Task {

    private final String username;
    private final String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Login withCredentials(String username, String password) {
        return Tasks.instrumented(Login.class, username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(USERNAME_FIELD),
                Enter.theValue(password).into(PASSWORD_FIELD),
                Click.on(LOGIN_BUTTON)
        );
    }
}

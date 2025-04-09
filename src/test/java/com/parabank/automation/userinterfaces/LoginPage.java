package com.parabank.automation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static final Target USERNAME_FIELD = Target.the("username field")
            .located(By.name("username"));
    public static final Target PASSWORD_FIELD = Target.the("password field")
            .located(By.name("password"));
    public static final Target LOGIN_BUTTON = Target.the("login button")
            .located(By.cssSelector("input[type='submit']"));
}

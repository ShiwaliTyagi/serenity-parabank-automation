package com.parabank.automation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegistrationPage {
    public static final Target REGISTER_LINK = Target.the("Register link")
            .located(By.linkText("Register"));

    public static final Target FIRST_NAME = Target.the("First Name").located(By.id("customer.firstName"));
    public static final Target LAST_NAME = Target.the("Last Name").located(By.id("customer.lastName"));
    public static final Target ADDRESS = Target.the("Address").located(By.id("customer.address.street"));
    public static final Target CITY = Target.the("City").located(By.id("customer.address.city"));
    public static final Target STATE = Target.the("State").located(By.id("customer.address.state"));
    public static final Target ZIPCODE = Target.the("Zip").located(By.id("customer.address.zipCode"));
    public static final Target PHONE = Target.the("Phone").located(By.id("customer.phoneNumber"));
    public static final Target USERNAME = Target.the("Username").located(By.id("customer.username"));
    public static final Target PASSWORD = Target.the("Password").located(By.id("customer.password"));
    public static final Target CONFIRM_PASSWORD = Target.the("Confirm Password").located(By.id("repeatedPassword"));
    public static final Target REGISTER_BUTTON = Target.the("Register Button").located(By.cssSelector("input[type='submit']"));
}


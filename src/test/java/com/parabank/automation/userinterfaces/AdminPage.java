package com.parabank.automation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AdminPage {
    public static final Target ADMIN_PAGE_LINK = Target.the("Admin Page Link")
            .located(By.linkText("Admin Page"));

    public static final Target RESET_BUTTON = Target.the("Reset Button")
            .located(By.xpath("//input[@value='Reset']"));
}

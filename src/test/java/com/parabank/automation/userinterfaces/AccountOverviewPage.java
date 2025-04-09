package com.parabank.automation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AccountOverviewPage {
    public static final Target OVERVIEW_TITLE = Target.the("Account Overview title")
            .located(By.xpath("(//h1[@class='title'])[1]"));
}
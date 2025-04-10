package com.parabank.automation.context;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;
import com.parabank.automation.util.DriverFactory;

public class TestContext {

    private static TestContext instance;
    private WebDriver driver;
    private Actor actor;

    private TestContext() {
        driver = new DriverFactory().getDriver();
        actor = Actor.named("John");
        actor.can(BrowseTheWeb.with(driver));
        OnStage.setTheStage(new OnlineCast());
    }

    public static TestContext getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Actor getActor() {
        return actor;
    }

    public void cleanup() {
        if (driver != null) {
            driver.quit();
            driver = null;  // Or reset to initial state if needed
        }
        instance = null;
    }
}

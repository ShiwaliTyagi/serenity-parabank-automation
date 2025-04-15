package com.parabank.automation.context;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;
import com.parabank.automation.util.DriverFactory;

import java.util.HashMap;
import java.util.Map;

public class TestContext {

    private static TestContext instance;
    private WebDriver driver;
    private Actor actor;
    private Map<String, Object> data = new HashMap<>(); // 🔥 Add this map

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

    // 🔥 Add these methods to get/set data
    public void set(String key, Object value) {
        data.put(key, value);
    }

    public <T> T get(String key) {
        return (T) data.get(key);
    }

    public void cleanup() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        instance = null;
    }
}

package com.parabank.automation.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Before;

public class DriverFactory {

    private WebDriver driver;

    // Method to initialize the ChromeDriver
    public WebDriver getDriver() {
        if (driver == null) {
            // Set up ChromeDriver using WebDriverManager
            WebDriverManager.chromedriver().setup();  // This will automatically manage the driver
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");  // Optional: Maximize the browser window
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    // Method to quit the driver after test execution
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Optionally, you can initialize WebDriver in a @Before method if needed for JUnit
    @Before
    public void setup() {
        getDriver();  // Initializes the driver before tests
    }
}

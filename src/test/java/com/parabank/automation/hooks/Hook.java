package com.parabank.automation.hooks;

import com.parabank.automation.context.TestContext;
import io.cucumber.java.After;

public class Hook {
    private TestContext testContext = TestContext.getInstance();

    @After
    public void tearDown() {
        // Call cleanup to handle both driver and TestContext reset
        testContext.cleanup();
        System.out.println("In hook");
    }
}

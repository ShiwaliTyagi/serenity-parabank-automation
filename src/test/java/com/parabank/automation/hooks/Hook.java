package com.parabank.automation.hooks;

import com.parabank.automation.context.TestContext;
import com.parabank.automation.util.AdminResetUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hook {
    private TestContext testContext = TestContext.getInstance();

    @Before(order = 0)
    public void beforeEachScenario() {
        AdminResetUtil.resetApplicationState();
    }

    @After
    public void tearDown() {
        // Call cleanup to handle both driver and TestContext reset
        testContext.cleanup();
        System.out.println("In hook");
    }
}

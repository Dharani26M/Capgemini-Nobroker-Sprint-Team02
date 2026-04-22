package com.nobroker.sprint.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"./src/test/java/com/nobroker/sprint/features/RentalAndUserflow.feature" },
		dryRun = false,
		plugin = {"pretty", "html:Reports/Rental-Report.html","com.nobroker.sprint.stepdefinitions.StepEventListener"  },
		glue = "com.nobroker.sprint.stepdefinitions")
public class RunnerIO extends AbstractTestNGCucumberTests {
//	parallel execution
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}




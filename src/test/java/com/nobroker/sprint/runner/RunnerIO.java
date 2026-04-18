package com.nobroker.sprint.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/java/com/nobroker/sprint/features/RentReceipts.feature" },
		dryRun = false,
		glue = "com.nobroker.sprint.stepdefinitions")
public class RunnerIO extends AbstractTestNGCucumberTests {
//	
//	@Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }

}

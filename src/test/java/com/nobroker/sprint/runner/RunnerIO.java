package com.nobroker.sprint.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/com/nobroker/sprint/features" }, 
				 dryRun = false,
				 plugin = {"pretty", "html:Reports/Buy-Module-Report.html","com.nobroker.sprint.stepDefinition.StepEventListener"  },
				 glue = "com.nobroker.sprint.stepDefinition")
	public class RunnerIO extends AbstractTestNGCucumberTests {
		//parallel execution
		@Override
		@DataProvider(parallel = true)
			public Object[][] scenarios() {
				return super.scenarios();
		}
}

package com.nobroker.sprint.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/featureFile/Buy.feature" ,"src/test/java/com/nobroker/sprint/features/PackageAndMover.feature","src/test/java/com/nobroker/sprint/features/NegativeProfile.feature" }, dryRun = false, glue = "com.nobroker.sprint.stepdefinitions")

public class RunnerIO extends AbstractTestNGCucumberTests {

}

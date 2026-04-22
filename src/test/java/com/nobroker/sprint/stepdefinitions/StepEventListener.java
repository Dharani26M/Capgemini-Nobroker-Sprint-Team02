package com.nobroker.sprint.stepdefinitions;

import com.nobroker.sprint.utils.AllUtilities;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.Status;
import io.cucumber.plugin.event.TestStepFinished;
import io.cucumber.plugin.event.TestStepStarted;

public class StepEventListener implements ConcurrentEventListener {

	@Override
	public void setEventPublisher(EventPublisher publisher) {

		publisher.registerHandlerFor(TestStepStarted.class, event -> {
			if (event.getTestStep() instanceof PickleStepTestStep) {
				PickleStepTestStep step = (PickleStepTestStep) event.getTestStep();

				// getStep() returns io.cucumber.plugin.event.Step (public API)
				String keyword = step.getStep().getKeyword().trim();
				String stepText = step.getStep().getText().trim();

				// Creates a child node under the current scenario in Extent Report
				AllUtilities.createStepNode(keyword, stepText);
			}
		});

		publisher.registerHandlerFor(TestStepFinished.class, event -> {
			if (event.getTestStep() instanceof PickleStepTestStep) {
				PickleStepTestStep step = (PickleStepTestStep) event.getTestStep();

				String keyword = step.getStep().getKeyword().trim();
				String stepText = step.getStep().getText().trim();
				String label = keyword + " " + stepText;
				Status status = event.getResult().getStatus();

				if (status == Status.PASSED) {
					AllUtilities.pass("✅ PASSED: " + label);
				} else if (status == Status.FAILED) {
					AllUtilities.fail("❌ FAILED: " + label);
				} else {
					// SKIPPED, PENDING, UNDEFINED
					AllUtilities.info("⏭️ " + status.name() + ": " + label);
				}
			}
		});
	}
}

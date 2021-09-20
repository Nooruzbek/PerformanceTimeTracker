package com.aop.timetracker.trackerMetricRegistry;

import com.aop.timetracker.TimeTrackerReporter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
public class Scheduler {
	private final TimeTrackerReporter timeTrackerReporter;
	private final MeterRegistry meterRegistry;

	public Scheduler(MeterRegistry meterRegistry, TimeTrackerReporter timeTrackerReporter) {
		this.timeTrackerReporter = timeTrackerReporter;
		this.meterRegistry = meterRegistry;
		Gauge.builder("timeTracker", timeTrackerReporter.getAllCurrentTimeTrackerReports(), Collection::size)
				.description("Time of methods")
				.register(meterRegistry);
	}
}
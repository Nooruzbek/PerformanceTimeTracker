package com.aop.timetracker;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TimeTrackerReporter {
	List<TimeTrackerReport> getAllCurrentTimeTrackerReports();
}

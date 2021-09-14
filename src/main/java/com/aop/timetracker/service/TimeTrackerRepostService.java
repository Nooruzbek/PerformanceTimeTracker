package com.aop.timetracker.service;

import com.aop.timetracker.TimeTrackerReport;
import com.aop.timetracker.TimeTrackerReporter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TimeTrackerRepostService {

	private final TimeTrackerReporter timeTrackerReporter;

	@Autowired
	public TimeTrackerRepostService(TimeTrackerReporter timeTrackerReporter) {
		this.timeTrackerReporter = timeTrackerReporter;
	}

	public List<TimeTrackerReport> getCurrentTimeTrackerReports(){
		return timeTrackerReporter.getAllCurrentTimeTrackerReports();
	}
}

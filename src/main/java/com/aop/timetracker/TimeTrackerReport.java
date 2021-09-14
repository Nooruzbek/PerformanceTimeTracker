package com.aop.timetracker;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class TimeTrackerReport {
	private String classPath;
	private String methodName;
	private Long timeDuration;
}

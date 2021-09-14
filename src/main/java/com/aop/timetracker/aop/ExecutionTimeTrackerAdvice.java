package com.aop.timetracker.aop;

import com.aop.timetracker.TimeTrackerReport;
import com.aop.timetracker.TimeTrackerReporter;
import com.aop.timetracker.utility.RingBuffer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class ExecutionTimeTrackerAdvice implements TimeTrackerReporter {

	private final RingBuffer<TimeTrackerReport> timeTrackerReportRingBuffer = new RingBuffer<>(50);
	@Around("@annotation(com.aop.timetracker.aop.TrackExecutionTime)")
	public Object executionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object object = joinPoint.proceed();
		long endTime = System.currentTimeMillis();
		TimeTrackerReport trackerReport = TimeTrackerReport
				.builder()
				.classPath(joinPoint.getSignature().getName())
				.methodName(joinPoint.getSignature().getDeclaringTypeName())
				.timeDuration(endTime-startTime)
				.build();
		timeTrackerReportRingBuffer.insert(trackerReport);
		return  object;
	}

	@Override
	public List<TimeTrackerReport> getAllCurrentTimeTrackerReports() {
		return timeTrackerReportRingBuffer.getBufferElements();
	}
}

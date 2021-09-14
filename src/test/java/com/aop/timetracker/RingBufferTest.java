package com.aop.timetracker;

import com.aop.timetracker.utility.RingBuffer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class RingBufferTest {

	private final RingBuffer<TimeTrackerReport> ringBuffer = new RingBuffer<>(5);

	@Test
	public void testRingBuffer(){
		for (int i= 0; i <5; i++){
			ringBuffer.insert(buildTimeTrackerReport(i));
		}
		List<TimeTrackerReport> timeTrackerReports = ringBuffer.getBufferElements();
		for (int i= 0; i <3; i++){
			ringBuffer.insert(buildTimeTrackerReport(i));
		}
		timeTrackerReports.forEach(timeTrackerReport -> {
			System.out.println(timeTrackerReport.getMethodName());
		});
	}

	private TimeTrackerReport buildTimeTrackerReport(Integer index){
		return TimeTrackerReport
				.builder()
				.classPath("class path " + index)
				.methodName("method name " + index)
				.timeDuration(25l)
				.build();
	}
}

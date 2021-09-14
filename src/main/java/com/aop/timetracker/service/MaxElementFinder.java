package com.aop.timetracker.service;

import com.aop.timetracker.aop.ExecutionTimeTrackerAdvice;
import com.aop.timetracker.aop.TrackExecutionTime;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MaxElementFinder {

	@TrackExecutionTime
	public Integer findMaxElementInList(List<Integer> listOfElements){
		if (listOfElements == null || listOfElements.size() <2){
			return null;
		}
		Integer max = listOfElements
				.stream()
				.mapToInt(v -> v)
				.max()
				.orElseThrow(NoSuchElementException::new);
		return max;
	}
}

package com.aop.timetracker;

import com.aop.timetracker.service.MaxElementFinder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootTest
public class MaxELementFinderTest {

	private final MaxElementFinder maxElementFinder;

	@Autowired
	public MaxELementFinderTest(MaxElementFinder maxElementFinder) {
		this.maxElementFinder = maxElementFinder;
	}

	@Test
	public void testWith100ELements(){
		maxElementFinder.findMaxElementInList(fillRandomListWith(100));
	}

	private List<Integer> fillRandomListWith(Integer maxSize){
		List<Integer> integerList = new ArrayList<>();
		Random random = new Random();
		for (int i =0; i<maxSize; i++){
			integerList.add(random.nextInt());
		}
		return integerList;
	}

}

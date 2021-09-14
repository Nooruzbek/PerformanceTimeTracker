package com.aop.timetracker.api;

import com.aop.timetracker.service.MaxElementFinder;
import jdk.internal.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class MaxElementFinderController {

	private final MaxElementFinder maxElementFinder;

	@Autowired
	public MaxElementFinderController(MaxElementFinder maxElementFinder) {
		this.maxElementFinder = maxElementFinder;
	}

	@RequestMapping(value = "api/v1/maxElement", method = RequestMethod.GET)
	public Integer maxElement(){
		return maxElementFinder.findMaxElementInList(fillRandomListWith(10000000));
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

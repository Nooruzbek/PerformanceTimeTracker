package com.aop.timetracker.utility;

import java.util.ArrayList;
import java.util.List;

public class RingBuffer<T> {

	private int currentSize;
	private T[] ringBufferElements;
	private int tail;
	private int head;

	public RingBuffer(int maxSize){
		ringBufferElements = (T[]) new Object[maxSize];
		currentSize = 0;
		tail = -1;
		head = -1;
	}

	/**
	 * Insert elements into the end
	 */
	public void insert(T item){
		if (isFull()){
			headToNextStepAndDeleteCurrentHeadElement();
		}

		tail = (tail + 1) % ringBufferElements.length;
		ringBufferElements[tail] = item;
		currentSize++;

		if (head == -1){
			head = tail;
		}
		System.out.println("inset new element in " + tail);
	}

	/**
	 * Delete head element from buffer and jump head to next step in buffer
	 */
	public void headToNextStepAndDeleteCurrentHeadElement(){
		if (!isEmpty()){
			System.out.println("delete element in " + head);
			ringBufferElements[head] = null;
			head = (head + 1) % ringBufferElements.length;
			currentSize--;
		}
	}

	/**
	 * Return all elements from head to tail
	 */
	public List<T> getBufferElements(){
		List<T> unreadElements = new ArrayList<>();
		while (head!=tail){
			unreadElements.add(ringBufferElements[head]);
			headToNextStepAndDeleteCurrentHeadElement();
		}
		return unreadElements;
	}

	/**
	 * check if buffer is full
	 */
	private boolean isFull(){
		return currentSize == ringBufferElements.length;
	}

	/**
	 * check if buffer is empty
	 */
	private boolean isEmpty(){
		return currentSize == 0;
	}
}

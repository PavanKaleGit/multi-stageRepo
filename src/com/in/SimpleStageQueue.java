package com.in;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimpleStageQueue {
	 private Deque<Item> queue;

	    public SimpleStageQueue() {
	        this.queue = new ArrayDeque<>();
	    }

	    public void addItem(Item item) {
	        queue.add(item);
	    }

	    public Item getNextItem() {
	        return queue.poll();
	    }

	    public boolean isEmpty() {
	        return queue.isEmpty();
	    }
}

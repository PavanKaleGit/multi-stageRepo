package com.in;

import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentStageQueue {
	  private ConcurrentLinkedDeque<Item> queue;

	    public ConcurrentStageQueue() {
	        this.queue = new ConcurrentLinkedDeque<>();
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

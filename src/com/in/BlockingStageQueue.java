package com.in;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingStageQueue {

	private BlockingDeque<Item> queue;

    public BlockingStageQueue() {
        this.queue = new LinkedBlockingDeque<>();
    }

    public void addItem(Item item) throws InterruptedException {
        queue.put(item);
    }

    public Item getNextItem() throws InterruptedException {
        return queue.take();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

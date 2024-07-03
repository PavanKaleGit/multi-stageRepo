package com.in;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiStageProcessing {
	
	
	 private ConcurrentStageQueue[] stages;
	    private ExecutorService executor;

	    public MultiStageProcessing(int numStages, int numThreads) {
	        stages = new ConcurrentStageQueue[numStages];
	        for (int i = 0; i < numStages; i++) {
	            stages[i] = new ConcurrentStageQueue();
	        }
	        executor = Executors.newFixedThreadPool(numThreads);
	    }

	    public void addItemToStage(Item item, int stage) {
	        stages[stage].addItem(item);
	    }

	    public void startProcessing() {
	        for (int i = 0; i < stages.length; i++) {
	            final int stageIndex = i;
	            executor.submit(() -> processStage(stageIndex));
	        }
	    }

	    private void processStage(int stageIndex) {
	        ConcurrentStageQueue stageQueue = stages[stageIndex];
	        while (true) {
	            Item item = stageQueue.getNextItem();
	            if (item != null) {
	                System.out.println("Processing item " + item.getItem() + " at stage " + stageIndex);
	                item.setStage(stageIndex + 1);
	                if (stageIndex + 1 < stages.length) {
	                    stages[stageIndex + 1].addItem(item);
	                }
	            }
	        }
	    }

	    public void shutdown() {
	        executor.shutdown();
	    }

	    public static void main(String[] args) {
	        MultiStageProcessing processing = new MultiStageProcessing(3, 3);

	        // Add items to the initial stage
	        processing.addItemToStage(new Item("item1", 0, 1, "description1"), 0);
	        processing.addItemToStage(new Item("item2", 0, 2, "description2"), 0);
	        processing.addItemToStage(new Item("item3", 0, 1, "description3"), 0);

	        // Start processing
	        processing.startProcessing();

}
}

package com.in;

public class Item {
	
	private   String item;
	private int stage;
	private int priority;
	private String description;
	
	
	public Item(String item, int stage, int priority, String description) {
	    this.item = item;
	    this.stage = stage;
	    this.priority = priority;
	    this.description= description;
	}
	    
	    
		public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}


	public int getStage() {
		return stage;
	}



	public void setStage(int stage) {
		this.stage = stage;
	}


	public int getPriority() {
		return priority;
	}


	public void setPriority(int priority) {
		this.priority = priority;
	}


	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}


		@Override
		public String toString() {
			return "Item [item=" + item+ ", stage=" + stage + ", priority=" + priority + ", description="
					+ description + "]";
		}

}

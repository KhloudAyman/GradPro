package com.task.utils;

import java.util.Date;

public class Task {
	
	private int id;
	private float taskLoad;
	private int startX;
	private int startY;
	private int endX;
	private int endY;
	private String taskName;
//	private String taskDescription;

	private boolean taskAvailability;
	
//	private Date taskDuration = new Date();
//	private Date taskStartDate = new Date();
	
	public int getStartX() {
		return startX;
	}


	public void setStartX(int startX) {
		this.startX = startX;
	}


	public int getStartY() {
		return startY;
	}


	public void setStartY(int startY) {
		this.startY = startY;
	}


	public int getEndX() {
		return endX;
	}


	public void setEndX(int endX) {
		this.endX = endX;
	}


	public int getEndY() {
		return endY;
	}


	public void setEndY(int endY) {
		this.endY = endY;
	}


	public Task(){
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
//	public String getTaskDescription() {
//		return taskDescription;
//	}
//	public void setTaskDescription(String taskDescription) {
//		this.taskDescription = taskDescription;
//	}
	public float getTaskLoad() {
		return taskLoad;
	}
	public void setTaskLoad(float taskLoad) {
		this.taskLoad = taskLoad;
	}
	public boolean isTaskAvailability() {
		return taskAvailability;
	}
	public void setTaskAvailability(boolean taskAvailability) {
		this.taskAvailability = taskAvailability;
	}
//	public Date getTaskDuration() {
//		return taskDuration;
//	}
//	public void setTaskDuration(Date taskDuration) {
//		this.taskDuration = taskDuration;
//	}
//	public Date getTaskStartDate() {
//		return taskStartDate;
//	}
//	public void setTaskStartDate(Date taskStartDate) {
//		this.taskStartDate = taskStartDate;
//	}
	
	
	
}

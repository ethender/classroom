package org.hawks.cr.service;

import org.hawks.cr.models.Task;
import java.util.*;

public interface TaskService {
	
	
	public Task createTask(Task task);
	
	//only updates isCompleted flag
	public Task updateTask(Task task);
	
	/**
	 * 
	 * Gets All Tasks which have only incomplete Tasks
	 */
	public Task readTask(String ref);
	
	public List<Task> readTaskThroughUser(String user);
	
	public List<Task> readTaskThroughUserAndLecRef(String user, String lecRef);
	
	public List<Task> readTaskThroughUserAndClassRef(String User, String classRef);
	
	public Task deleteTask(Task task);
	
	//gets all tasks even completed
	public List<Task> getAllTasksFromUser(String user);
	
	
}

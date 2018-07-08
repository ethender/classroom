package org.hawks.cr.serviceimpl;

import java.util.List;

import org.hawks.cr.models.Task;
import org.hawks.cr.service.TaskService;
import org.springframework.stereotype.Service;

@Service("taskservice")
public class TaskServiceImpl implements TaskService{

	@Override
	public Task createTask(Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task updateTask(Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task readTask(String ref) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> readTaskThroughUser(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> readTaskThroughUserAndLecRef(String user, String lecRef) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> readTaskThroughUserAndClassRef(String User, String classRef) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task deleteTask(Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getAllTasksFromUser(String user) {
		// TODO Auto-generated method stub
		return null;
	}

}

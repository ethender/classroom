package org.hawks.cr.serviceimpl;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.hawks.cr.daoimpl.DAOImpl;
import org.hawks.cr.models.Task;
import org.hawks.cr.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service("taskservice")
@SuppressWarnings("unchecked")
public class TaskServiceImpl implements TaskService{

	@Autowired
	private DAOImpl dao;
	
	public Task createTask(Task task) {
		Task result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<Task> runnable  = service.submit(()->{
				dao.create(task);
				return task;
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	
	public Task updateTask(Task task) {
		Task result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<Task> runnable  = service.submit(()->{
				Query query = new Query(Criteria.where("_id").is(task.get_id()));
				Update update = new Update();
				update.set("isTaskComplete", task.isTaskComplete());
				dao.update(query, update, Task.class);
				return task;
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	
	public Task readTask(String ref) {
		Task result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<Task> runnable  = service.submit(()->{
				Query query = new Query(Criteria.where("_id").is(ref));
				return ((List<Task>) dao.readWithQuery(query, Task.class)).get(0);
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	
	public List<Task> readTaskThroughUser(String user) {
		List<Task> result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<List<Task>> runnable  = service.submit(()->{
				Query query = new Query(Criteria.where("user").is(user)
						.and("isTaskComplete").is((new Boolean(true))));
				return ((List<Task>) dao.readWithQuery(query, Task.class));
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	
	public List<Task> readTaskThroughUserAndLecRef(String user, String lecRef) {
		List<Task> result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<List<Task>> runnable  = service.submit(()->{
				Query query = new Query(Criteria.where("user").is(user).and("lecRef").is(lecRef));
				return ((List<Task>) dao.readWithQuery(query, Task.class));
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	
	public List<Task> readTaskThroughUserAndClassRef(String user, String classRef) {
		List<Task> result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<List<Task>> runnable  = service.submit(()->{
				Query query = new Query(Criteria.where("user").is(user).and("classRef").is(classRef));
				return ((List<Task>) dao.readWithQuery(query, Task.class));
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	
	public Task deleteTask(Task task) {
		Task result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<Task> runnable  = service.submit(()->{
				dao.delete(task);
				return task;
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	
	public List<Task> getAllTasksFromUser(String user) {
		List<Task> result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<List<Task>> runnable  = service.submit(()->{
				Query query = new Query(Criteria.where("user").is(user));
				return ((List<Task>) dao.readWithQuery(query, Task.class));
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

}

package org.hawks.cr.serviceimpl;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.hawks.cr.daoimpl.DAOImpl;
import org.hawks.cr.models.Project;
import org.hawks.cr.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;


@Service("projectservice")
@SuppressWarnings("unchecked")
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private DAOImpl dao;
	
	public Project createProject(Project project) {
		Project result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<Project> runnable = service.submit(()->{
				dao.create(project);
				return project;
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	
	public Project updateProject(Project project) {
		Project result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<Project> runnable = service.submit(()->{
				Query query = new Query(Criteria.where("_id").is(project.get_id()));
				Update update = new Update();
				update.set("projectRef", project.getProjectRef());
				update.set("lastModified", org.hawks.utils.util.getDateNow());
				dao.update(query, update, Project.class);
				return project;
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	
	public Project readProject(String ref) {
		Project result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<Project> runnable = service.submit(()->{
				Query query = new Query(Criteria.where("_id").is(ref));
				return ((List<Project>) dao.readWithQuery(query, Project.class)).get(0);
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	
	public List<Project> readProjectThroughUser(String user) {
		List<Project> result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<List<Project>> runnable = service.submit(()->{
				Query query = new Query(Criteria.where("user").is(user));
				return (List<Project>) dao.readWithQuery(query, Project.class);
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	
	public List<Project> readProjectThroughUserAndLec(String user, String lecRef) {
		List<Project> result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<List<Project>> runnable = service.submit(()->{
				Query query = new Query(Criteria.where("user").is(user).and("lecRef").is(lecRef));
				return (List<Project>) dao.readWithQuery(query, Project.class);
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	
	public List<Project> readProjectThroughUserAndClass(String user, String classRef) {
		List<Project> result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<List<Project>> runnable = service.submit(()->{
				Query query = new Query(Criteria.where("user").is(user).and("classRef").is(classRef));
				return (List<Project>) dao.readWithQuery(query, Project.class);
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	
	public Project deleteProject(Project project) {
		Project result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<Project> runnable = service.submit(()->{
				dao.delete(project);
				return project;
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

}

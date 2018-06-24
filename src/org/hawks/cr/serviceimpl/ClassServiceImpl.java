package org.hawks.cr.serviceimpl;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.hawks.cr.daoimpl.DAOImpl;
import org.hawks.cr.models.CRClass;
import org.hawks.cr.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service("classservice")
@SuppressWarnings("unchecked")
public class ClassServiceImpl implements ClassService {

	@Autowired
	private DAOImpl dao;

	/**
	 * It Will create the CRClass in object
	 */
	public CRClass createClass(CRClass classObj) {
		CRClass temp = null;
		try {
			ExecutorService executor = org.hawks.utils.util.getExecutor();
			Future<CRClass> runnable = executor.submit(() -> {
				dao.create(classObj);
				return classObj;
			});
			temp = runnable.get();
			executor.shutdown();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return temp;
	}

	/**
	 * Updates the crclass 
	 */
	public CRClass updateClass(CRClass classObj) {
		CRClass temp = null;
		try {
			ExecutorService executor = org.hawks.utils.util.getExecutor();
			Future<CRClass> runnable = executor.submit(() -> {
				Query query = new Query(Criteria.where("_id").is(classObj.get_id()));
				Update update = new Update();
				update.set("enrollers", classObj.getEnrollers());
				update.set("lastModified", classObj.getLastModified());
				dao.update(query, update, CRClass.class);
				return classObj;
			});
			temp = runnable.get();
			executor.shutdown();
		} catch (InterruptedException | ExecutionException ex) {
			System.err.println(ex.getMessage());
		}
		
		return temp;
	}

	/**
	 * searches class through classname
	 */
	public CRClass searchClassThroughName(String name) {
		CRClass result = null;
		try {
			ExecutorService executor = org.hawks.utils.util.getExecutor();
			Future<CRClass> runnable = executor.submit(()->{
				Query query = new Query(Criteria.where("name").is(name));
				
				List<CRClass> list =(List<CRClass>) dao.readWithQuery(query, CRClass.class);
				return list.get(0);
			});
			result = runnable.get();
			executor.shutdown();
		}catch (InterruptedException | ExecutionException ex) {
			System.err.println(ex.getMessage());
		}
		return result;
	}

	/**
	 * searches class through instructor name
	 */

	public List<CRClass> searchClassThroughUsername(String username) {
		List<CRClass> result = null;
		try {
			ExecutorService executor = org.hawks.utils.util.getExecutor();
			Future<List<CRClass>> runnable = executor.submit(()->{
				Query query = new Query(Criteria.where("creator").is(username));
				return (List<CRClass>) dao.readWithQuery(query, CRClass.class);
			});
			result = runnable.get();
			executor.shutdown();
		}catch (InterruptedException | ExecutionException ex) {
			System.err.println(ex.getMessage());
		}
		return result;
	}

	/**
	 * Gets all classes
	 */
	
	public List<CRClass> allClasses() {
		List<CRClass> result = null;
		try {
			ExecutorService executor = org.hawks.utils.util.getExecutor();
			Future<List<CRClass>> runnable = executor.submit(()->{
				return (List<CRClass>) dao.read(CRClass.class);
			});
			result = runnable.get();
			executor.shutdown();
		}catch (InterruptedException | ExecutionException ex) {
			System.err.println(ex.getMessage());
		}
		return result;
	}


	/**
	 * delete all classes.
	 * Note:
	 * But There is no implementation for delete reference documents in same or different collection.
	 *  May Be We implement in later versions. But as of now only deletes particular document.
	 */
	public CRClass deleteClass(CRClass classObj) {
		CRClass result = null;
		try {
			ExecutorService executor = org.hawks.utils.util.getExecutor();
			Future<CRClass> runnable = executor.submit(()->{
				dao.delete(classObj);
				return classObj;
			});
			result = runnable.get();
			executor.shutdown();
		}catch (InterruptedException | ExecutionException ex) {
			System.err.println(ex.getMessage());
		}
		return result;
	}

}

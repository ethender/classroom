package org.hawks.cr.serviceimpl;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.hawks.cr.daoimpl.DAOImpl;
import org.hawks.cr.models.Lecture;
import org.hawks.cr.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;



@Service("lectureservice")
@SuppressWarnings("unchecked")
public class LectureServiceImpl implements LectureService{

	@Autowired
	private DAOImpl dao;
	
	/**
	 * creates the lecture
	 */
	public Lecture createLecture(Lecture lecture) {
		Lecture result = null;
		try {
			ExecutorService executor = org.hawks.utils.util.getExecutor();
			Future<Lecture> runnable  = executor.submit(()->{
				dao.create(lecture);
				return lecture;
			});
			result = runnable.get();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	/**
	 * update the lecture
	 * Note: Only update the description
	 */
	public Lecture updateLecture(Lecture lecture) {
		Lecture result = null;
		try {
			ExecutorService executor = org.hawks.utils.util.getExecutor();
			Future<Lecture> runnable = executor.submit(()->{
				Query query = new Query(Criteria.where("_id").is(lecture.get_id()));
				Update update = new Update();
				update.set("desc", lecture.getDesc());
				dao.update(query, update, Lecture.class);
				return lecture;
			});
			result = runnable.get();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}
	

	/**
	 * update the lecture the views
	 */
	public Lecture updateLectureView(Lecture lecture) {
		Lecture result = null;
		try {
			ExecutorService executor = org.hawks.utils.util.getExecutor();
			Future<Lecture> runnable = executor.submit(()->{
				Query query = new Query(Criteria.where("_id").is(lecture.get_id()));
				Update update = new Update();
				update.set("views", lecture.getViews());
				dao.update(query, update, Lecture.class);
				return lecture;
			});
			result = runnable.get();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	/**
	 * Search the lecture by name
	 * @param String :  name
	 */
	public Lecture searchLectureByName(String name) {
		Lecture result = null;
		try {
			ExecutorService executor = org.hawks.utils.util.getExecutor();
			Future<Lecture>  runnable = executor.submit(()->{
				Query query = new Query(Criteria.where("letureName").is(name));
				List<Lecture> lect = (List<Lecture>) dao.readWithQuery(query, Lecture.class);
				return lect.get(0);
			});
			result = runnable.get();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	/**
	 * search lecture by class
	 * @param String class ref
	 */
	public List<Lecture> searchLecturesByClass(String classRef) {
		List<Lecture> result = null;
		try {
			ExecutorService executor = org.hawks.utils.util.getExecutor();
			Future<List<Lecture>>  runnable = executor.submit(()->{
				Query query = new Query(Criteria.where("classRef").is(classRef));
				 return ((List<Lecture>) dao.readWithQuery(query, Lecture.class));
				
			});
			result = runnable.get();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	/**
	 * searches all lectures
	 */
	public List<Lecture> searchAllLectures() {
		List<Lecture> result = null;
		try {
			ExecutorService executor = org.hawks.utils.util.getExecutor();
			Future<List<Lecture>>  runnable = executor.submit(()->{
			
				 return ((List<Lecture>) dao.read(Lecture.class));
				
			});
			result = runnable.get();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	/**
	 * delete lecture 
	 * Note : only deletes particular lecture
	 */
	public Lecture deleteLecture(Lecture lecture) {
		Lecture result = null;
		try {
			ExecutorService executor = org.hawks.utils.util.getExecutor();
			Future<Lecture> runnable =  executor.submit(()->{
				dao.delete(lecture);
				return lecture;
			});
			result = runnable.get();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}



}

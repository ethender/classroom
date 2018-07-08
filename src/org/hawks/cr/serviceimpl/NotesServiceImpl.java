package org.hawks.cr.serviceimpl;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.hawks.cr.daoimpl.DAOImpl;
import org.hawks.cr.models.Notes;
import org.hawks.cr.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service("notesservice")
@SuppressWarnings("unchecked")
public class NotesServiceImpl implements NotesService{
	
	@Autowired
	private DAOImpl dao;

	
	public Notes createNotes(Notes notes) {
		Notes result = null;
		try {
			ExecutorService service  = org.hawks.utils.util.getExecutor();
			Future<Notes> runnable =  service.submit(()->{
				dao.create(notes);
				return notes;
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		
		return result;
	}

	
	public Notes updateNotes(Notes notes) {
		Notes result = null;
		try {
			ExecutorService service  = org.hawks.utils.util.getExecutor();
			Future<Notes> runnable =  service.submit(()->{
				Query query = new Query(Criteria.where("_id").is(notes.get_id()));
				Update update = new Update();
				update.set("notes", notes.getNotes());
				update.set("lastmodified", org.hawks.utils.util.getDateNow());
				dao.update(query, update, Notes.class);
				return notes;
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		
		return result;
	}

	
	public Notes readNote(String ref) {
		Notes result = null;
		try {
			ExecutorService service  = org.hawks.utils.util.getExecutor();
			Future<Notes> runnable =  service.submit(()->{
				Query query = new Query(Criteria.where("_id").is(ref));
				return ((List<Notes>)dao.readWithQuery(query, Notes.class)).get(0);
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		
		return result;
	}

	
	public List<Notes> readNotesThroughUser(String user) {
		List<Notes> result = null;
		try {
			ExecutorService service  = org.hawks.utils.util.getExecutor();
			Future<List<Notes>> runnable =  service.submit(()->{
				Query query = new Query(Criteria.where("user").is(user));
				return (List<Notes>) dao.readWithQuery(query, Notes.class);
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		
		return result;
	}

	
	public List<Notes> readNotesThroughUserAndClass(String user, String classRef) {
		List<Notes> result = null;
		try {
			ExecutorService service  = org.hawks.utils.util.getExecutor();
			Future<List<Notes>> runnable =  service.submit(()->{
				Query query = new Query(Criteria.where("user").is(user).and("classRef").is(classRef));
				return (List<Notes>) dao.readWithQuery(query, Notes.class);
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		
		return result;
	}

	
	public List<Notes> readNotesThroughUserAndLec(String user, String lecRef) {
		List<Notes> result = null;
		try {
			ExecutorService service  = org.hawks.utils.util.getExecutor();
			Future<List<Notes>> runnable =  service.submit(()->{
				Query query = new Query(Criteria.where("user").is(user).and("lecRef").is(lecRef));
				return (List<Notes>) dao.readWithQuery(query, Notes.class);
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		
		return result;
	}

	
	public Notes deleteNote(Notes note) {
		Notes result = null;
		try {
			ExecutorService service  = org.hawks.utils.util.getExecutor();
			Future<Notes> runnable =  service.submit(()->{
				dao.delete(note);
				return note;
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		
		return result;
	}

}

package org.hawks.cr.serviceimpl;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.*;

import org.hawks.cr.daoimpl.DAOImpl;
import org.hawks.cr.models.Upload;
import org.hawks.cr.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service("uploadservice")
@SuppressWarnings("unchecked")
public class UploadServiceimpl implements UploadService{

	
	@Autowired
	private DAOImpl dao;
	
	
	/**
	 * creates the upload
	 */
	public Upload createUpload(Upload upload) {
		Upload result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<Upload> runnable = service.submit(()->{
				dao.create(upload);
				return upload;
			});
			
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	/**
	 * reads the upload
	 */
	public Upload readUpload(String ref) {
		Upload result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<Upload> runnable = service.submit(()->{
				Query query = new Query(Criteria.where("_id").is(ref));
				return ((List<Upload>) dao.readWithQuery(query, Upload.class)).get(0);
			});
			
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	/**
	 * Delete the upload
	 */
	public Upload deleteUpload(Upload upload) {
		Upload result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<Upload> runnable = service.submit(()->{
				dao.delete(upload);
				return upload;
			});
			
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

}

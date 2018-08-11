package org.hawks.cr.serviceimpl;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import org.hawks.cr.daoimpl.DAOImpl;
import org.hawks.cr.models.Upload;
import org.hawks.cr.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service("uploadservice")
@SuppressWarnings("unchecked")
public class UploadServiceimpl implements UploadService{

	
	@Autowired
	private DAOImpl dao;
	
	
	@Value("${UPLOADFOLDER}")
	private String FOLDERPATH;
	
	@Value("${DATABASEFOLDER}")
	private String DATABASEPATH;
	
	
	
	
	
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
	
	
	/**
	 * Gets the upload file and return the upload object
	 */
	public Upload uploadFile(MultipartFile file) {
		try {
			Upload result = new Upload();
			File f = uploadFileToFileSystem(file);
			result.setFileLocation(DATABASEPATH);
			String path = f.getAbsolutePath();
			result.setFileOriginalPath(f.getAbsolutePath());
			result.setMediaType(path.substring(path.lastIndexOf('.')+1));
			return result;
		}catch(Exception ex) {
			System.out.println("Error Occurred: "+ex.getMessage());
			return null;
		}
	}
	
	
	/**
	 * Uploads The File 
	 * @param mul
	 * @return File
	 */
	private  File uploadFileToFileSystem(MultipartFile mul) {
		try {
			String originalFileName = mul.getOriginalFilename();
			String extension = originalFileName.substring(originalFileName.lastIndexOf('.'));
			String fileName = org.hawks.utils.util.removeSpecialChars(originalFileName.substring(0, originalFileName.lastIndexOf('.')));
			String finalFileName = fileName+System.nanoTime();
			File file = new File(FOLDERPATH+"/"+finalFileName+extension);
			BufferedOutputStream buff = new BufferedOutputStream(new FileOutputStream(file));
			buff.write(mul.getBytes());
			buff.close();
			return file;
		} catch (IOException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
			return null;
		}
		
	}
	

}

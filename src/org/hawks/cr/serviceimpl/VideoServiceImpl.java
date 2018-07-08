package org.hawks.cr.serviceimpl;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.hawks.cr.daoimpl.DAOImpl;
import org.hawks.cr.models.Upload;
import org.hawks.cr.models.Video;
import org.hawks.cr.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service("videoservice")
@SuppressWarnings("unchecked")
public class VideoServiceImpl implements VideoService{
	
	@Autowired
	private DAOImpl dao;
	private String FILELOCATION = "/Users/ethender/Sites/uploads";
	private String DATABASEUPLOAD = "http://localhost/~ethender/uploads/";
	
	
	/**
	 * Create the video  record
	 */
	public Video createVideo(Video request) {
		Video result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<Video> runnable = service.submit(()->{
				dao.create(request);
				return request;
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	
	
	
	/**
	 * Update the video record 
	 * Only Updates videoref
	 */
	public Video updateVideo(Video rquest) {
		Video result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<Video> runnable = service.submit(()->{
				Query query  = new Query(Criteria.where("_id").is(rquest.get_id()));
				Update update  =  new Update();
				update.set("videoRef", rquest.getVideoRef());
				update.set("lastModified", org.hawks.utils.util.getDateNow());
				dao.update(query, update, Video.class);
				return rquest;
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	/**
	 * Gets the video by reference name
	 */
	public Video readVideoByRef(String ref) {
		Video result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<Video> runnable = service.submit(()->{
				Query query = new Query(Criteria.where("_id").is(ref));
				return ((List<Video>) dao.readWithQuery(query, Video.class)).get(0);
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	/**
	 * Gets the Video List by lecture ref
	 */
	public List<Video> readVideoByLectures(Video video) {
		List<Video> result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<List<Video>> runnable = service.submit(()->{
				Query query = new Query(Criteria.where("lecRef").is(video.getLecRef()));
				return (List<Video>) dao.readWithQuery(query, Video.class);
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	/**
	 * Gets the Video by Class ref 
	 */
	public List<Video> readVideoByClass(Video video) {
		List<Video> result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<List<Video>> runnable = service.submit(()->{
				Query query = new Query(Criteria.where("classRef").is(video.getClassRef()));
				return (List<Video>) dao.readWithQuery(query, Video.class);
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	
	/**
	 * Deletes the video ref
	 */
	public Video deleteVideo(Video video) {
		Video result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<Video> runnable = service.submit(()->{
				dao.delete(video);
				return video;
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}
	
	

	/**
	 * Uploads the video In FileSystem and Database
	 * Create : Upload Document
	 */
	public String uploadVideo(MultipartFile multiple) {
		return uploadFile(multiple);
	}




	/**
	 * Removes the video In FileSystem and Database : 
	 * Remove UPLOAD Document
	 */
	public String removeVideo(String ref) {
		return removeUpload(ref);
	}


	/**
	 * Uploads the  file and database system
	 */
	private String uploadFile(MultipartFile multiple) {
		String result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<Upload> runnable = service.submit(()->{
				File f  = uploadFileToFileSystem(multiple);
				Upload upload  = new Upload();
				String filePath = f.getAbsolutePath();
				upload.setFileLocation(DATABASEUPLOAD+filePath.substring(filePath.lastIndexOf('/')+1));
				upload.setFileOriginalPath(filePath);
				upload.setMediaType(filePath.substring(filePath.lastIndexOf('.')+1));
				dao.create(upload);
				return upload;
			});
			Upload up = runnable.get();
			result = up.get_id();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	/**
	 * Remove Files in file system and database 
	 */
	public String removeUpload(String ref) {
		String result = null;
		try {
			
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<String> runnable = service.submit(()->{
				Query query = new Query(Criteria.where("_id").is(ref));
				Upload upload = (Upload) dao.readWithQuery(query, Upload.class);
				File f  = new File(upload.getFileOriginalPath());
				if(f.exists()) System.out.println("file is deleted: "+f.delete());
				dao.delete(upload);
				return ref;
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}


	
	/**
	 * Uploads The File 
	 * @param mul
	 * @return File
	 */
	private File uploadFileToFileSystem(MultipartFile mul) {
		try {
			String originalFileName = mul.getOriginalFilename();
			String extension = originalFileName.substring(originalFileName.lastIndexOf('.'));
			String fileName = org.hawks.utils.util.removeSpecialChars(originalFileName.substring(0, originalFileName.lastIndexOf('.')));
			String finalFileName = fileName+System.nanoTime();
			File file = new File(FILELOCATION+"/"+finalFileName+extension);
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

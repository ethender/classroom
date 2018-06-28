package org.hawks.cr.serviceimpl;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.hawks.cr.daoimpl.DAOImpl;
import org.hawks.cr.models.Upload;
import org.hawks.cr.models.Video;
import org.hawks.cr.models.VideoRequest;
import org.hawks.cr.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service("videoservice")
public class VideoServiceImpl implements VideoService{
	
	@Autowired
	private DAOImpl dao;
	private String FILELOCATION = "/Users/ethender/Sites/uploads";
	private String DATABASEUPLOAD = "http://localhost/~ethender/uploads/";
	
	public Video createVideo(Video request) {
		Video result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<Video> runnable = service.submit(()->{
				return null;
			});
			result = runnable.get();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	
	
	
	@Override
	public Video updateVideo(Video rquest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Video readVideoByRef(String ref) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Video> readVideoByLectures(Video video) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Video> readVideoByClass(Video video) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Video deleteVideo(Video video) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String uploadVideo(MultipartFile multiple) {
		String result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<Upload> runnable = service.submit(()->{
				File f  = uploadFile(multiple);
				Upload upload  = new Upload();
				String filePath = f.getAbsolutePath();
				upload.setFileLocation(DATABASEUPLOAD+filePath.substring(filePath.lastIndexOf('/')+1));
				dao.create(upload);
				return upload;
			});
			Upload up = runnable.get();
			result = up.get_id();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	@Override
	public String removeVideo(String ref) {
		String result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<String> runnable = service.submit(()->{
				Upload up = new Upload();
				up.set_id(ref);
				dao.delete(up);
				return ref;
			});
			result = runnable.get();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}


	
	
	private File uploadFile(MultipartFile mul) {
		try {
			String fileName = org.hawks.utils.util.removeSpecialChars(mul.getOriginalFilename());
			String finalFileName = fileName+System.nanoTime();
			File file = new File(FILELOCATION+"/"+finalFileName);
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

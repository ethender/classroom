package org.hawks.cr.serviceimpl;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.hawks.cr.daoimpl.DAOImpl;
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
	private String FILELOCATION = "/Users/ethender/Developer/eclipseworkspace/classroom/WebContent/WEB-INF/view";
	
	public Video createVideo(VideoRequest request) {
		Video result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<Video> runnable = service.submit(()->{
				File f = uploadFile(request.getFile());
				System.out.println("File Uploaded: "+f.getName());
				Video vid = new Video();
				vid.setClassRef(request.getClassRef());
				vid.setLecRef(request.getLecref());
				vid.setOwner(request.getOwner());
				vid.setVideoLoc(f.getAbsolutePath());
				vid.setViews(0);
				//dao.create(vid);
				return vid;
			});
			result = runnable.get();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	private File uploadFile(MultipartFile mul) {
		try {
			File file = new File(FILELOCATION+"/"+mul.getOriginalFilename());
			BufferedOutputStream buff = new BufferedOutputStream(new FileOutputStream(file));
			buff.write(mul.getBytes());
			buff.close();
			return file;
		} catch (IOException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
			return null;
		}
		
	}
	
	
	@Override
	public Video updateVideo(VideoRequest rquest) {
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

}

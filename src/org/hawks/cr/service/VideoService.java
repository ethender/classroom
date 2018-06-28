package org.hawks.cr.service;

import org.hawks.cr.models.Video;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

public interface VideoService {
	
	
	public Video createVideo(Video request);
	
	public Video updateVideo(Video rquest);
	
	public Video readVideoByRef(String ref);
	
	public List<Video> readVideoByLectures(Video video);
	
	public List<Video> readVideoByClass(Video video);
	
	public Video deleteVideo(Video video);
	
	public String  uploadVideo(MultipartFile multiple);
	
	public String removeVideo(String ref);
	
}
